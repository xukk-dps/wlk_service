
var app=getApp();
Page({
  /**
   * 页面的初始数据
   */
  data: {
 
    loginstate: "0",
    openid: "",
    osVersion: "",
    showModal: false,//定义登录弹窗
  },
  //在页面加载的时候，判断缓存中是否有内容，如果有，存入到对应的字段里
  onLoad: function () {

  },
  onGotUserInfo: function (e) {
    var that = this;
    if (e.detail.errMsg == "getUserInfo:ok") {
      wx.setStorage({
        key: "userinfo",
        data: e.detail.userInfo
      })
      this.setData({ userInfo: e.detail.userInfo });
      that.showDialogBtn();//调用一键获取手机号弹窗（自己写的）
    }
  },
 
  // 显示一键获取手机号弹窗
  showDialogBtn: function () {
    this.setData({
      showModal: true//修改弹窗状态为true，即显示
    })
  },
  // 隐藏一键获取手机号弹窗
  hideModal: function () {
    this.setData({
      showModal: false//修改弹窗状态为false,即隐藏
    });
  },
 

  //绑定手机
  getPhoneNumber: function (e) {
    // console.log(111,app.config.url)
    var that = this;
    that.hideModal();
    wx.checkSession({
      success: function () {
        wx.login({  
          success: res => {
            wx.request({
              url: app.config.url+'/shop/auth/getPhone',//自己的解密地址
              data: {
                encryptedData: e.detail.encryptedData,
                iv: e.detail.iv,
                session_key: wx.getStorageSync("session_key")
              },
              method: "post",
              header: {
                'content-type': 'application/json'
              },
              success: function (res) {
                if (res.data.code == "1000") {
                  var phone = res.data.data.phoneNumber;
                  // console.log(phone)//成功后打印微信手机号
                  wx.setStorageSync("phone",phone);
                  //手机号获取成功后先去后台检测是否注册过，如果没有则把数据入库
                  that.confirmPhone(phone);
           
                }
                else {
                  console.log(res);
                }
              }
            })
           
          }
        })
      },
      fail: function () {
          console.log("登录失败")
      }
    })
  },
  confirmPhone:function(phone){ 
    wx.request({
      url: app.config.url+'/shop/auth/confirm',
      data: {
        "phone": phone,
        "unionId": wx.getStorageSync('unionId'),
        "openId": wx.getStorageSync('openId')
      },
      method: "post",
      header: {
        "source":wx.getStorageSync('source'),
        'content-type': 'application/json'
      },
      success: function (res) {
        if (res.data.code == "1000") {
            //手机号获取成功后跳转到认证页面
            wx.navigateTo({
              url: '../register/index'
            })
            return;
        }
        else {
          console.log(res);
        }
      }
    })
  }
})