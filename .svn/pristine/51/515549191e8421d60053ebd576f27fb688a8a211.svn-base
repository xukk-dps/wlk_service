//index.js

const app = getApp()
var token ;
var userId ;
var source = wx.getStorageSync('source')
Page({

  data: {
    count: 0,
    keyWord: '',
    num:1,
    loading:false,
    hasMore: false,
    arr:[],
    current: 0,
    newslist: [],
    currentId: 1,
    nav_list: [
      {
        imgUrl: "../images/nav2.png",
        brand_name: "精选家电",
        id: 1
      },
      {
        imgUrl: "../images/nav3.png",
        brand_name: "美妆护理",
        id: 2
      },
      {
        imgUrl: "../images/nav4.png",
        brand_name: "百货电器",
        id: 3
      },
      {
        imgUrl: "../images/nav5.png",
        brand_name: "食品饮料",
        id: 4
      },
      {
        imgUrl: "../images/nav6.png",
        brand_name: "服饰箱包",
        id: 5
      }
    ]
  },
  onLoad: function (options) {
    token = wx.getStorageSync('token');
    userId = wx.getStorageSync('userId');
    // console.log(token,"dddddddddddsdsdsd")
  },
  laodType:function(){
    var that = this;
    wx.request({
      url: app.config.url+'/shop/product/nav', 
      method: "GET",
      header: {
        'content-type': 'application/json',
        'source': source,
        'token': token
      },
      success: function (res) {
        that.setData({
          nav_list: res.data.data
        })
        //加载产品列表
        that.laodList(1);
      }
    })
  },
  laodList:function(type){
    var that = this;
    wx.request({
      url: app.config.url+'/shop/product/pages', 
      method: "POST",
      data:{
        "pageNo": 1,
        "pageSize": 50,
        "proName":"",
        "proType":type
      },
      header: {
        'content-type': 'application/json',
        'source': source,
        'token': token
      },
      success: function (res) {
     
        that.setData({
            newslist: [
              {
                id:0,
                hot:res.data.data.list
              }
            ]
        })
      }
    })
  },
  onReady(){
  
  },
  onTextText: function (e) {
    // wx.navigateTo({
    //   url: '../text/text'
    // })
  },
  onShow: function (options) {
    //产品分类
    this.laodType();
    var arr = wx.getStorageSync('cart') || [];
    // console.log(arr);
    if (arr.length>0){
      this.setData({
        hasMore:true,
        arr: arr
      })
    }else{
      this.setData({
        hasMore: false
      })
    }
  },
  checkCar:function(goodsId ,arr){
    // 遍历购物车数组  
    for (var j in arr) {
      // 判断购物车内的item的id，和事件传递过来的id，是否相等  
      if (arr[j].id == goodsId) {
        return j;
      }
    }
    return null;
  },
  addCount(e) {  //点击详情页加减
    let con = e.currentTarget.dataset.cell;
    this.add(con);
    var goodsId = e.currentTarget.dataset.goodid
    for (var i in this.data.newslist){
      var goodsList = this.data.newslist[i].hot
      for (var j in goodsList) {
        var id = goodsList[j].id
        if (id == goodsId){
          goodsList[j].count++;
          this.setData({
            newslist: this.data.newslist
          })
        }
      }
    }
    let goods = e.currentTarget.dataset.cell
      // // 获取购物车的缓存数组（没有数据，则赋予一个空数组）  
    var arr = (wx.getStorageSync('cart')) || [];
      // console.log("arr,{1}", arr);
      //如果商品不再购物车，则新增
      if (arr.length == 0) {
        arr.push(goods);
        this.setStore(arr);
        return;
      }
      // console.log("goodsId,{}", goodsId);
      // 校验数组中是否存在改商品 
      var goodsIndex = this.checkCar(goodsId,arr);
      if(null == goodsIndex){
        //如果商品不再购物车，则新增
        arr.push(goods);
      }else{
        //如果商品已经存在购物车，数量+1
        arr[goodsIndex].count += 1;
      }
      this.setStore(arr);
     
  },
  setStore(arr){
   // 最后，把购物车数据，存放入缓存  
   try {
      // console.log("arr {2}",arr)
      wx.setStorageSync('cart', arr)
      // 返回（在if内使用return，跳出循环节约运算，节约性能） 
      //关闭窗口
      wx.showToast({
        title: '加入购物车成功！',
        icon: 'success',
        duration: 1000
      });
        // this.closeDialog();
    } catch (e) {
      console.log(e)
    }
  },
  add:function(car){
      wx.request({
        url: app.config.url+'/shop/car/add', 
        method: "POST",
        data:{
          "userId": userId,
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
          if(res.data.code == app.config.successCode){
            wx.showToast({
              title: '加入购物车成功！',
              icon: 'success',
              duration: 1000
            });
          }
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
        "userId": userId,
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
  deleteCount(e) {  //点击详情页加减
    var goodsId = e.currentTarget.dataset.goodid;
    this.del(goodsId);
    for (var i in this.data.newslist) {
      var goodsList = this.data.newslist[i].hot
      for (var j in goodsList) {
        var id = goodsList[j].id
        if (id == goodsId) {
          if (goodsList[j].count>1){
            goodsList[j].count--;
          }else{
            return
          }
          this.setData({
            newslist: this.data.newslist
          })
        } 
      }
    }
    let goods = e.currentTarget.dataset.cell

    // // 获取购物车的缓存数组（没有数据，则赋予一个空数组）  
    var arr = (wx.getStorageSync('cart')) || [];
    // console.log("arr,{}", arr);
    if (arr.length > 0) {
      var googsIndex = this.checkCar(goodsId,arr);
      // console.log("del googsIndex",googsIndex)
      if(null == googsIndex){
        return;
      }
      if(1 == googsIndex){
         arr.splice(googsIndex, 1);
         return;
      }
      arr[googsIndex].count -= 1;
      arr.splice(googsIndex, 1);
      this.delStore(arr);
    } 
  },
  delStore(arr){
    // 最后，把购物车数据，存放入缓存  
    try {
      //  console.log("arr {del}",arr)
       wx.setStorageSync('cart', arr)
       // 返回（在if内使用return，跳出循环节约运算，节约性能） 
       //关闭窗口
       wx.showToast({
         title: '删除成功！',
         icon: 'success',
         duration: 2000
       });
         // this.closeDialog();
     } catch (e) {
       console.log(e)
     }
   },
  onSearch(e) {
    wx.navigateTo({
      url: `../search/search?value=${e.detail.value}`
    })
  },
  switchTap(e) { //更换资讯大类
    var indexs = e.currentTarget.dataset.id;
    this.laodList(indexs)
    this.setData({
      current: 0
    })
   
    let screenWidth = wx.getSystemInfoSync().windowWidth;

    let itemWidth = screenWidth / 5;

    let { index, type } = e.currentTarget.dataset;

    const { nav_list } = this.data;

    let scrollX = itemWidth * index - itemWidth * 2;

    let maxScrollX = (nav_list.length + 1) * itemWidth;

    if (scrollX < 0) {
      scrollX = 0;
    } else if (scrollX >= maxScrollX) {
      scrollX = maxScrollX;
    }

    this.setData({
      x: scrollX
    })
  }
  
})
