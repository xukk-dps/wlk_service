// pages/shopcar/car/car.js
const app = getApp()
var token ;
var source = wx.getStorageSync('source')
 
var receiveName ;
var address ;
var receivePhone ;
Page({

  /**
   * 页面的初始数据
   */
  data: {
    Allprice:0,
    carts: [], //数据 
    iscart: false,
    hidden: null,
    isAllSelect: false,
    totalMoney: 0,
    arr:[],
    counts:1
  },
  onLoad: function (options) {
    token = wx.getStorageSync('token');
    receiveName = wx.getStorageSync('receiveName')
    address = wx.getStorageSync('address')
    receivePhone = wx.getStorageSync('receivePhone')
  },
  list:function(){
    const that = this;
    // console.log("执行了")
    wx.request({
      url: app.config.url+'/shop/car/list', 
      method: "GET",
      header: {
        'content-type': 'application/json',
        'source': source,
        'token': token
      },
      success: function (res) {
        // console.log(1,res.data.data)
        wx.setStorageSync('cart', res.data.data );
        that.initData();
      }
    })

},
initData:function(){
  var arr = wx.getStorageSync('cart')  || [];
  console.log("onShow :",arr)
  if (arr.length > 0) {
    // 更新数据  
    this.setData({
      carts: arr,
      iscart: true,
      hidden: false
    });
  } else {
    this.setData({
      iscart: false,
      hidden: true,
    });
  }
  var totalMoney=0
  for (var i = 0; i < this.data.carts.length; i++) {
    if (this.data.carts[i].isSelect) {
      totalMoney = totalMoney+ (this.data.carts[i].current * this.data.carts[i].count);
    } 
  }
  // console.log(totalMoney)
  var Allprice = 0
  for (var i = 0; i < this.data.carts.length; i++) {
    Allprice += (this.data.carts[i].current * this.data.carts[i].count);
  }
  // console.log(Allprice)
  if (Allprice == totalMoney) {
    this.setData({
      isAllSelect: true
    })
  } else {
    this.setData({
      isAllSelect: false
    })
  }
  this.setData({
    Allprice: Allprice,
    totalMoney: totalMoney
  })
},
  /**
   * 生命周期函数--监听页面加载
   */
  onShow: function (options) {
    this.list();
  },
  /**
   * 清除已经下单的购物车产品
   */
  clearCarProduct: function(orderArr){
    var arr = wx.getStorageSync('cart')
    for(var a in orderArr){
      for(var b in arr){
          if(arr[b].id == orderArr[a].id){
            arr.splice(b,1);
          }
      }
    }
    wx.setStorageSync('cart', arr);
  },
  saveOrder:function(orderArr){
    //在请求外面
    const that = this
    //页面不跳转，一直显示加载中
    app.loadingTips();
    //订单入库
    wx.request({
      url: app.config.url+'/shop/order/add',
      method: "POST",
      data:{
        receiveName: receiveName,
        receivePhone: receivePhone,
        receiveAddress: address,
        itemRequestList: orderArr
      },
      header: {
        'content-type': 'application/json',
        'source': source,
        'token': token
      },
      success: function (res) {
          if(res.data.code != '1000'){
            app.errorTips(res.data.message);
            return;
          };
          //把下单的商品在购物车列表中清除
          that.clearCarProduct(orderArr);
          //把返回的订单加入缓存，在订单详情页面使用
          wx.setStorageSync('orderInfo', res.data.data);
          wx.setStorageSync('payMoney', res.data.data.payable)
          wx.setStorageSync('orderId', res.data.data.id)
          //把下单的商品缓存起来,结算的时候用
          wx.setStorageSync('orderArr', orderArr);
          //跳转订单页面
          wx.navigateTo({
            url: '../order/index',
          })
          //关闭提示框，防止回退时候瞎提示
          wx.hideToast();
      }
    })
  },
  
  /**
   * 处理组装订单数据
   */
  handleOrder:function(){
    var arr = this.data.carts;
    var orderArr = [];
    for(var a in arr){
      if(arr[a].isSelect == true){
        orderArr.push(arr[a]);
      }
    }
    return orderArr;
  },
  goShop:function(e){
    wx.switchTab({
      url: '../index/index'
    })
  },
  onText: function (e) {
    //下单
    var orderArr = this.handleOrder();
    if(orderArr.length == 0){
      wx.showToast({
        title: '您没有选择商品',
        icon: 'success',
        duration: 2000
      });
      return;
    }
    //订单入库
    this.saveOrder(orderArr);
  },
  //勾选事件处理函数  
  switchSelect: function (e) {
    // 获取item项的id，和数组的下标值  
    let id = e.target.dataset.id;
    let index = parseInt(e.target.dataset.index);
    this.data.carts[index].isSelect = !this.data.carts[index].isSelect;    //价钱统计
    if (this.data.carts[index].isSelect) {
      this.data.totalMoney = this.data.totalMoney + (this.data.carts[index].current * this.data.carts[index].count);
      // console.log(this.data.carts[index].count)
    } else {
      this.data.totalMoney = this.data.totalMoney - (this.data.carts[index].current * this.data.carts[index].count);
    }
    //是否全选判断
    // console.log(this.data.Allprice)
    // console.log(this.data.totalMoney)
    if (this.data.Allprice == this.data.totalMoney) {
      this.data.isAllSelect = true;
    } else {
      this.data.isAllSelect = false;
    }
    this.setData({
      carts: this.data.carts,
      totalMoney: this.data.totalMoney,
      isAllSelect: this.data.isAllSelect,
    })
  //  console.log(this.data.totalMoney)
  },
  //全选
  allSelect: function (e) {
    //处理全选逻辑
    let i = 0;
    // console.log(this.data.isAllSelect)
    if (!this.data.isAllSelect) {
      this.data.totalMoney = 0;
      for (i = 0; i < this.data.carts.length; i++) {
        // console.log(this.data.carts[i])
        this.data.carts[i].isSelect = true;
        this.data.totalMoney = this.data.totalMoney + (this.data.carts[i].current * this.data.carts[i].count);
      }
    } else {
      for (i = 0; i < this.data.carts.length; i++) {
        this.data.carts[i].isSelect = false;
      }
      this.data.totalMoney = 0;
    }
    this.setData({
      carts: this.data.carts,
      isAllSelect: !this.data.isAllSelect,
      totalMoney: this.data.totalMoney,
    })
  },  // 去结算
  toBuy() {
    wx.showToast({
      title: '去结算',
      icon: 'success',
      duration: 3000
    });
    this.setData({
      showDialog: !this.data.showDialog
    });
  },  //数量变化处理
  handleQuantityChange(e) {
    var componentId = e.componentId;
    var quantity = e.quantity;
    this.data.carts[componentId].count.quantity = quantity;
    this.setData({
      carts: this.data.carts,
    });
  },
  /* 减数 */
  delCount: function (e) {
    var index = e.target.dataset.index;
    // console.log(e.target.dataset)
    this.del(e.target.dataset.id);
    var count = this.data.carts[index].count;    // 商品总数量-1
    // console.log(count);//ok
    if (count > 1) {
      this.data.carts[index].count--;
      // 将数值与状态写回  
      this.setData({
        carts: this.data.carts
      });
      try {
        wx.setStorageSync('cart', this.data.carts)
      } catch (e) {
        console.log(e)
      }
      this.priceCount();
    } else if(count <= 1){
      this.data.carts.splice(index,1);
      if (this.data.carts.length > 0) {
        this.setData({
          carts: this.data.carts
        })
        wx.setStorageSync('cart', this.data.carts);
        this.priceCount();
      } else {
        this.setData({
          cart: this.data.carts,
          iscart: false,
          hidden: true,
        })
        wx.setStorageSync('cart', []);
      }
    }
  },
  /* 加数 */
  addCount: function (e) {
    var index = e.target.dataset.index;
    this.add(this.data.carts[index])
    // console.log("刚刚您点击了加+");
    var count = this.data.carts[index].count;    // 商品总数量+1  
      this.data.carts[index].count++;
    // 将数值与状态写回  
    this.setData({
      carts: this.data.carts
    });
    try {
      wx.setStorageSync('cart', this.data.carts);
    } catch (e) {
      console.log(e)
    }
    this.priceCount();
  },
  add:function(car){
    wx.request({
      url: app.config.url+'/shop/car/add', 
      method: "POST",
      data:{
        "proName":  car.title,
        "proId": car.id,
        "proLogo": car.imgUrl,
        "proPrice":  car.original,
      },
      header: {
        'content-type': 'application/json',
        'source': source,
        'token': token
      },
      success: function (res) {
        console.log(res.data)
      }
    })

},
del:function(productId){
  var proIds = [];
  proIds.push(productId);
  wx.request({
    url: app.config.url+'/shop/car/del', 
    method: "POST",
    data:{
      "proIds": proIds
    },
    header: {
      'content-type': 'application/json',
      'source': source,
      'token': token
    },
    success: function (res) {
      console.log(res.data)
    }
  })

},
  priceCount: function (e) {
    this.data.totalMoney = 0;
    for (var i = 0; i < this.data.carts.length; i++) {
      if (this.data.carts[i].isSelect == true) {
        this.data.totalMoney = this.data.totalMoney + (this.data.carts[i].current * this.data.carts[i].count);
      }

    }
    this.setData({
      totalMoney: this.data.totalMoney,
    })
  },
  /* 删除item */
  delGoods: function (e) {
    this.data.carts.splice(e.target.id.substring(3), 1);    // 更新data数据对象  
    if (this.data.carts.length > 0) {
      this.setData({
        carts: this.data.carts
      })
      wx.setStorageSync('cart', this.data.carts);
      this.priceCount();
    } else {
      this.setData({
        cart: this.data.carts,
        iscart: false,
        hidden: true,
      })
      wx.setStorageSync('cart', []);
    }
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */


  /**
   * 生命周期函数--监听页面显示
   */


  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})
