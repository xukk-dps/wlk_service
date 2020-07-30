var token;
var source;
var app =getApp();
Page({
  /**页面的初始数据 */
  	data: {
    addressList:[]
  },

  /*生命周期函数--监听页面加载*/
  onLoad: function (options) {
    token = wx.getStorageSync('token');
    source = wx.getStorageSync('source');


  },

  

  /**生命周期函数--监听页面显示 */
	  onShow: function () {
      var arr = wx.getStorageSync('addressList') || [];
      // 更新数据  
      this.setData({
        addressList: arr
      });
      // console.info("缓存数据：", arr);
      this.onLoad();

  },

  addAddress:function(){
    wx.navigateTo({ url: '../addressAdd/index' });
  },
  remove:function(id){
    var list = this.data.addressList;
    for(let a in list){
      if(list[a].id == id){
        list.splice(a,1);
        continue;
      }
    }
    this.setData({
      addressList: list
    })
    wx.setStorageSync('addressList', list);
    //请求后台接口删除数据
    wx.request({
      url: app.config.url+'/shop/address/del/'+id,
      method: "POST",
      header: {
        'content-type': 'application/json',
        'source': source,
        'token': token
      },
      success: function (res) {
          if(res.data.code == '1000'){
            wx.showToast({
                title: res.data.message,
                icon: 'success',
                duration: 1000
            });
            return;
          };
          wx.showToast({
              title: res.data.message,
              icon: 'none',
              duration: 1000
          });
   
      }
    })
  },
  /* 删除item */
  delAddress: function (e) {
    var id = e.currentTarget.dataset.aid;
    console.log("id:",id)
    this.remove(id)
  }
})