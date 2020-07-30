// pages/shopcar/car/car.js
const app = getApp()
var token ;
var source ;
var address ;

Page({

  /**
   * 页面的初始数据
   */
  data: {
    Allprice:0,
    carts: [], //数据 
    iscart: false,
    hidden: null,
    hidden_pay:true,
    isAllSelect: false,
    totalMoney: 0,
    arr:[],
    counts:1
  },
  onLoad: function (options) {
    token = wx.getStorageSync('token')
    source = wx.getStorageSync('source')
    address = wx.getStorageSync('address')
    //加载订单信息
    this.loadOrderInfo();
  },
  
  /**
 * 加载订单信息
 */
loadOrderInfo:function(){
  var orderId = wx.getStorageSync('orderId')
  const that = this;
  wx.request({
    url: app.config.url+'/shop/order/info/'+orderId,
    method: "GET",
    data:{
      id:orderId
    },
    header: {
      'content-type': 'application/json',
      'source': source,
      'token': token
    },
    success: function (res) {
      //加载数据
        if(res.data.code == app.config.successCode){
          var data = res.data.data;
          wx.setStorageSync('cart', data.productVOS);
          wx.setStorageSync('orderInfo', data);
          that.setOrderInfo(data);
          //未支付订单显示支付按钮
          if(data.proSalePrice == 0 || data.proSalePrice == null){
            that.setData({
              hidden_pay: false
            })
          }
        }
    }
  })
},
setOrderInfo:function(orderInfo){
  // console.log("orderInfo",orderInfo)
  this.setData({
    address: orderInfo.receiveAddress,
    timeStart: orderInfo.timeStart,
    timeExpire: orderInfo.timeExpire,
    orderNo: orderInfo.orderNo ,
    totalMoney:orderInfo.payable
  })
},




  /**
   * 生命周期函数--监听页面加载
   */
  onShow: function (options) {

    var arr = wx.getStorageSync('orderArr')  || [];
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
  toPay() {
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
