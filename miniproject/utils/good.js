module.exports=(url,type,data)=>{
  return new Promise((resolve,reject) => {
    wx.request({
      url: `http://localhost:88/lv/goods/${url}`,
      header:{
        'content-type': 'application/x-www-form-urlencoded;charset=utf-8'
      },
      method:type,
      data:data,
      success:resolve,
      fail:reject
    })
  })
}