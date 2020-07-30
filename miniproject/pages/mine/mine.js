// pages/mine/mine.js
import Dialog from '@vant/weapp/dialog/dialog';
const fetch = require('../../utils/fetch.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    value: '',
    content: [
      {
        id: '1',
        text: "收货地址",
        img:'./images/a.png'
      },
      {
        id: '2',
        text: "优惠价",
        img: './images/b.png'
      },
      {
        id: '3',
        text: "推广码",
        img: './images/c.png'
      },
      {
        id: '4',
        text: "资质规则",
        img: './images/d.png'
      },
      {
        id: '5',
        text: "常见问题",
        img: './images/e.png'
      },
      {
        id: '6',
        text: "联系客服",
        img: './images/f.png'
      },
      {
        id: '7',
        text: "团长加盟",
        img: './images/g.png'
      },
      {
        id: '8',
        text: "推荐产品",
        img: './images/h.png'
      },
      {
        id: '9',
        text: "历史订单",
        img: './images/i.png'
      },
    ],
    order: [
      {
        id: '0',
        text: "待付款",
        img: './images/j.png'
      },
      // {
      //   id: '1',
      //   text: "待发货",
      //   img: './images/k.png'
      // },
      // {
      //   id: '2',
      //   text: "待收货",
      //   img: './images/l.png'
      // },
      // {
      //   id: '3',
      //   text: "已收货",
      //   img: './images/m.png'
      // },
      {
        id: '4',
        text: "已完成",
        img: './images/m.png'
      }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  },
  onContent(e){
    // let fid = e.currentTarget.dataset.id
    // if (fid == 1) {
    //   wx.navigateTo({
    //     url: '../store/store'
    //   })
    // } else if (fid == 2) {
    //   // 拨打电话  
    //     wx.makePhoneCall({
    //       // phoneNumber: 需要拨打的电话，若固定-可写死；若变化-从后台获取
    //       phoneNumber: '18391857599'
    //     })
    // } else {
    //   // 拨打电话  
    //   wx.makePhoneCall({
    //     phoneNumber: '18391857599'
    //   })
    // } 
  },
  onText:function(e){
    var status = e.currentTarget.dataset.id;
    // console.log("status",status)
    wx.setStorageSync('orderStatus', status)
    //订单列表页面
    wx.navigateTo({
      url: '../orders/index'
    })
  },
  /**
   * 我的服务路由
   */
  myService:function(e){
    var servicetype = e.currentTarget.dataset.id;
    // console.log("servicetype",servicetype)
    //跳转收货地址
    if(servicetype == '1'){
      wx.navigateTo({
        url: '../addressList/index'
      })
      return;
    }
    //跳转历史订单
    if(servicetype == '9'){
      wx.navigateTo({
        url: '../orders/index'
      })
      return;
    }
    wx.showToast({
      title: '敬请期待',
      icon: 'none',
      duration: 1000
    });
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

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
  onReachBottom: function (e) {
     
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})