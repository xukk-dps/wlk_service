var token;
var source;
const app = getApp()
Page({
  /**页面的初始数据 */
  	data: {
    addressList:[]
  },
  /*生命周期函数--监听页面加载*/
  onLoad: function (options) {
    token = wx.getStorageSync('token');
    source = wx.getStorageSync('source');
    var arr = wx.getStorageSync('addressList') || [];
    // console.info("缓存数据：" , arr);
    // 更新数据  
    this.setData({
	    addressList: arr
    });

  },

   saveAddress: function(e) {
      var consignee = e.detail.value.consignee;
      var mobile = e.detail.value.mobile;
      var address = e.detail.value.address;
      if(consignee == ''){
        wx.showToast({
            title: '收货人不能为空',
            icon: 'none',
            duration: 1000
        });
        return;
      }
      if(consignee == ''){
        wx.showToast({
            title: '收货人不能为空',
            icon: 'none',
            duration: 1000
        });
        return;
      }
      if(consignee.length > 20){
        wx.showToast({
            title: '收货人长度超出限制',
            icon: 'none',
            duration: 1000
        });
        return;
      }
      if(mobile == ''){
        wx.showToast({
            title: '收货人手机号不能为空',
            icon: 'none',
            duration: 1000
        });
        return;
      }
      if(mobile.length > 11){
        wx.showToast({
            title: '收货人手机号长度超出限制',
            icon: 'none',
            duration: 1000
        });
      }
      if (!/^1[3|4|5|6|7|8|9]\d{9}$/.test(mobile)) {
          wx.showToast({
              title: '收货人手机号格式有误',
              icon: 'none',
              duration: 1000
          });
          return;
      }
      if(address == ''){
        wx.showToast({
            title: '收货地址不能为空',
            icon: 'none',
            duration: 1000
        });
        return;
      }
      if(address.length > 200){
        wx.showToast({
            title: '收货地址长度超出限制',
            icon: 'none',
            duration: 1000
        });
        return;
      }
      //执行入库
      wx.request({
        url: app.config.url+'/shop/address/add',
        method: "POST",
        data:{
          receiveName: consignee,
          receivePhone: mobile,
          receiveAddress: address
        },
        header: {
          'content-type': 'application/json',
          'source': source,
          'token': token
        },
        success: function (res) {
            if(res.data.code == '1000'){
              //更新收货地址缓存
              app.loadAddress();
              wx.showToast({
                  title: res.data.message,
                  icon: 'success',
                  duration: 1000
              });
              //跳转收获地址首页
              wx.navigateTo({
                url: '../addressList/index',
              })
            };
            wx.showToast({
                title: res.data.message,
                icon: 'none',
                duration: 1000
            });
     
        }
      })

   },

  /**生命周期函数--监听页面显示 */
	  onShow: function () {
      this.onLoad();

  },

  addAddress:function(){

    wx.navigateTo({ url: '../address/address' });

  },

  /* 删除item */

  delAddress: function (e) {

  
  }
})