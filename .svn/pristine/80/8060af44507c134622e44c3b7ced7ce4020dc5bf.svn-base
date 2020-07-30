//app.js

let header = {
  'content-type': 'application/json',
  'source': 1,
  'token':  wx.getStorageSync('token')
}
App({
  config:{
    url:'https://runvp.com',
    // url:'http://localhost:8070',
    successCode : '1000',
    source: 1
  },
  header:{
    'content-type': 'application/json',
    'source': 1,
    'token':  wx.getStorageSync('token')
  },
  onLaunch: function () {

    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)
 
    wx.setStorageSync('userEntity', {'name':'adc'})
    wx.setStorageSync('loginstate', 'success')
    wx.setStorageSync('source', 1)
    wx.setStorageSync('userName', '小明')

    //购物车缓存
    // this.list();
    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        wx.request({
          url: getApp().config.url+'/shop/auth/getOpenId', 
          data: {
            code: res.code
          },
          method: "POST",
          header: {
            'content-type': 'application/json' // 默认值
          },
          success(res) {
            // console.log(1111111111111,res.data)
            if (res.data.code == "1000") {
              // console.log(res.data)
              wx.setStorage({
                key: "openId",
                data: res.data.data.openid
              })
              wx.setStorage({
                key: "session_key",
                data: res.data.data.session_key
              })  
              console.log('openid',wx.getStorageSync('openId'))
              wx.setStorageSync("session_key", res.data.data.session_key);
            //   //检查本地缓存是否存有手机号，如果没有跳转到手机号登录页面
              var phone = wx.getStorageSync('phone');
              if(null == phone || "" == phone){
                console.log(phone,"ddddddd")
                wx.navigateTo({
                  url: '../main/index'
                })
                return;
              }
              //如果token不存在则跳转到登录页面
              var token = wx.getStorageSync('token');
              // console.log("token",token)
              if(null == token || "" == token){
                wx.navigateTo({
                  url: '../register/index'
                })
                return;
              }
              //token不为空则调用调用去后台检验token是否过期
              wx.request({
                url: getApp().config.url+'/shop/auth/check/'+token,  
                method: "GET",
                header: {
                  'content-type': 'application/json' // 默认值
                },
                success(res) {
                  if (res.data.code == "1000") {
                    //如果token无效，则需要重新认证,否则跳转首页
                    if(res.data.data == true){
                      console.log("跳转首页")
                      //跳转首页
                      wx.switchTab({
                        url: '../index/index'
                      })
                      return;
                    }
                    console.log("跳转注册认证页面")
                    //跳转注册认证页面
                    wx.navigateTo({ 
                      url: '../register/index'
                    })
                    return;
                    
                  }
                }
              })
            }
          }
        })
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
            
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo
              console.log(res.openid)
              console.log(res.userInfo)
     
              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })
    //收货地址缓存
    this.loadAddress();
  },

//   list:function(){
//     wx.request({
//       url: this.config.url+'/shop/car/list/'+ wx.getStorageSync('userId'), 
//       method: "GET",
//       header: {
//         'content-type': 'application/json',
//         'source':  wx.getStorageSync('source'),
//         'token':  wx.getStorageSync('token')
//       },
//       success: function (res) {
//         // console.log(1,res.data.data)
//         wx.setStorageSync('cart', res.data.data )
//       }
//     })
// },
/**
 * 错误提示
 */
errorTips(msg){
  wx.showToast({
    title: msg,
    duration: 2000
   })
},
loadingTips:function(){
    wx.showToast({
      title: '加载中',
      icon: 'loading',
      duration: 9000000
     })
  },
/**
 * 加载收获地址
 */
loadAddress:function(){
  wx.request({
    url: this.config.url+'/shop/address/list', 
    method: "GET",
    header: {
      'content-type': 'application/json',
      'source':  wx.getStorageSync('source'),
      'token':  wx.getStorageSync('token')
    },
    success: function (res) {
      console.log(1,res.data.data)
      var arr = res.data.data;
      //地址列表缓存起来，备用
      wx.setStorageSync('addressList', arr);
      for (var a in arr) {
        //等于1 设为默认地址
        if(arr[a].defaultFlag == 1){
          wx.setStorageSync('address', arr[a].receiveAddress);
          wx.setStorageSync('receiveName', arr[a].receiveName);
          wx.setStorageSync('receivePhone', arr[a].receivePhone);
          return;
        }
      }
    }
  })
},
  globalData: {
    userInfo: null
  }
})