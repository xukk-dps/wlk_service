// components/swiper/swiper.js
const fetch = require('../../utils/fetch.js')
Component({
  /**
   * 组件的属性列表
   */
  properties: {
 
  },

  /**
   * 组件的初始数据
   */
  data: {
    swiper: [
      {
        id: '1',
        text: 'xx',
        imgUrl: '../images/swiper1.png'
      },
      {
        id: '2',
        text: 'xx',
        imgUrl: '../images/swiper2.png'
      },
    ]
  },

  /**
   * 组件的方法列表
   */
  methods: {
    onText: function (e) {
      wx.navigateTo({
        url: '../text/text'
      })
    },
  }
})
