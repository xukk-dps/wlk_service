// pages/more/more.js
const fetch = require('../../utils/fetch.js')
const good = require('../../utils/good.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    nid:''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
   // console.log(options.cid)
    let cityName = options.cityName
    let cid = options.cid
    let data = {
      cityName: options.cityName,
      cid: options.cid
    }
    let type="post"
    let url = `classic.php`
   // console.log(cityName)
    good(url,type,data).then(res => {
        this.setData({
          more: res.data
        })
      console.log(res)
    })
  },
  onContent(e){
    let bid=e.currentTarget.dataset.id
   console.log(e.currentTarget.dataset.id)
    wx.navigateTo({
      url: `/pages/text/text?id=${bid}`,
    })
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
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})