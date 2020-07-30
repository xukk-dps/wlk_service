// pages/shopcar/car/car.js
const app = getApp()
var token = wx.getStorageSync('token')
var source = wx.getStorageSync('source')
var userId = wx.getStorageSync('userId')
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
 
  },
  data :{
 
    animate: 'myfirst',
    yesorno: 'none',
    flag: true,
    test:'test1'
 
},
 
fabiao: function () {
 
    this.setData({
      yesorno: 'block'
    })
 
    this.setData({
      test: 'test1'
    })
 
    this.setData({
      flag: false
    })
 
  },
  laqi: function (e) {
    console.log(e.currentTarget.dataset.gid)
    this.setData({
      test: 'test2',
    })
    this.setData({
      flag: true
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onShow: function (options) {

    var arr = wx.getStorageSync('cart')  || [];
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
  onText: function (e) {
    wx.navigateTo({
      url: '../login/index',
    })
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
