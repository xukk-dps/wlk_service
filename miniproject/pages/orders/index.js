// pages/shopcar/car/car.js
const app = getApp()
var token ;
var source ;
var address ;
var addressList ;

Page({

  /**
   * 页面的初始数据
   */
  data: {
    Allprice:0,
    orders: [], //数据 
    iscart: false,
    hidden: null,
    no_data_hidden:true,
    isAllSelect: false,
    totalMoney: 0,
    arr:[],
    counts:1
  },
  onLoad: function (options) {
   token = wx.getStorageSync('token')
   source = wx.getStorageSync('source')
   address = wx.getStorageSync('address')
   addressList = wx.getStorageSync('addressList')
 
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onShow: function (options) {
    const that = this;
    var status = wx.getStorageSync('orderStatus')
    console.log("show   .......",status)
    wx.request({
      url: app.config.url+'/shop/order/list',
      method: "POST",
      data:{pageNo:1,pageSize:1000,status:status},
      header: {
        'content-type': 'application/json',
        'source': source,
        'token': token
      },
      success: function (res) {
        //加载数据
        var data = res.data;
          if(data.code == app.config.successCode){
            var orderArr = data.data.list  || [];
            // console.log("orderArr",orderArr)
            if (orderArr.length > 0) {
              // 更新数据  
              that.setData({
                orders: orderArr,
                iscart: true,
                hidden: false,
                no_data_hidden:true
              });
            } else {
              that.setData({
                iscart: false,
                hidden: true,
                no_data_hidden:false
              });
            }
            var totalMoney=0
            for (var i = 0; i < that.data.orders.length; i++) {
              if (that.data.orders[i].isSelect) {
                totalMoney = totalMoney+ (that.data.orders[i].current * that.data.orders[i].count);
              } 
            }
            // console.log(totalMoney)
            var Allprice = 0
            for (var i = 0; i < that.data.orders.length; i++) {
              Allprice += (that.data.orders[i].current * that.data.orders[i].count);
            }
            // console.log(Allprice)
            if (Allprice == totalMoney) {
              that.setData({
                isAllSelect: true
              })
            } else {
              that.setData({
                isAllSelect: false
              })
            }
            that.setData({
              Allprice: Allprice,
              totalMoney: totalMoney
            })
          }
      }
    })
 
    
  },
  onText: function (e) {
    // console.log("订单详情",e.currentTarget.dataset.info)
    var order = e.currentTarget.dataset.info;
    wx.setStorageSync('orderId', order.id)
    wx.setStorageSync('orderArr', order.productVOS)
    wx.navigateTo({
      url: '../history/index',
    })
  },


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
