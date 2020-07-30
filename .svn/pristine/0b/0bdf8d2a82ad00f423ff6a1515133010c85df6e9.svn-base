// components/classic/classic.js
const fetch = require('../../utils/fetch.js')
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    cityName:String
  },

  /**
   * 组件的初始数据
   */
  data: {
    current: 0,
    newslist: [{
      id:1,
      hot:[
        {
        id:1,
        imgUrl:'../images/hot1.png',
          title:'全棉大豆纤维被子薄被芯单双人被褥春秋被夏被四季空调被 ',
        current:600,
        original:3400,
        num: 56,
        nums:102
      },
        {
          id: 2,
          imgUrl: '../images/hot2.png',
          title: '麻辣掌中宝鸡脆骨 ',
          current: 34,
          original: 76,
          num: 134,
          nums: 54
        },
        {
          id: 3,
          imgUrl: '../images/hot3.png',
          title: 'Sewame/雪完美PXE祛痘修护面膜10片淡痘印控油祛痘面膜贴男女通用',
          current: 65,
          original: 122,
          num: 64,
          nums: 533
        },
        {
          id: 4,
          imgUrl: '../images/hot4.png',
          title: '荣事达无叶风扇家用电扇',
          current: 109,
          original: 355,
          num: 64,
          nums:58
        },
        {
          id: 5,
          imgUrl: '../images/hot5.png',
          title: '新茶铁观音茶叶铁观音清香型',
          current: 112,
          original: 342,
          num: 341,
          nums: 234
        },
        {
          id: 6,
          imgUrl: '../images/hot6.png',
          title: '2020花片摆件现货配线新款 ',
          current: 42,
          original: 312,
          num: 314,
          nums: 49
        },
        {
          id: 7,
          imgUrl: '../images/hot7.png',
          title: '百雀羚三生花青春紧弹套装水乳护肤品补水保湿提拉紧致抗皱 ',
          current: 230,
          original: 532,
          num: 14,
          nums: 304
        },
        {
          id: 8,
          imgUrl: '../images/hot8.png',
          title: '加量送VC！养生堂牌天然维生素C咀嚼片',
          current: 12,
          original: 44,
          num: 134,
          nums: 34
        }
      ]
    }, {
        id: 2,
        hot: [
          {
            id: 1,
            imgUrl: '../images/hot9.png',
            title: '全自动智能多功能4L电饭锅5L大容量',
            current: 100,
            original: 400,
            num: 516,
            nums: 103
          },
          {
            id: 2,
            imgUrl: '../images/hot10.png',
            title: '映趣剃须刀电动全身水洗款刮胡刀智能充电式男胡须刀剃须  ',
            current: 32,
            original: 75,
            num: 132,
            nums: 51
          },
          {
            id: 3,
            imgUrl: '../images/hot11.png',
            title: '充电宝超薄小巧便携快充闪充移动电源适用于苹果华为小米vivo',
            current: 95,
            original: 132,
            num: 34,
            nums: 133
          },
          {
            id: 4,
            imgUrl: '../images/hot12.png',
            title: '3D刮胡刀男刀头水洗智能充电式胡须刀男士',
            current: 129,
            original: 355,
            num: 62,
            nums: 58
          }
        ]
    }, {
        id: 1,
        hot: [
          {
            id: 3,
            imgUrl: '../images/hot3.png',
            title: 'Sewame/雪完美PXE祛痘修护面膜10片淡痘印控油祛痘面膜贴',
            current: 65,
            original: 122,
            num: 64,
            nums: 533
          },
          {
            id: 5,
            imgUrl: '../images/hot5.png',
            title: '新茶铁观音茶叶铁观音清香型',
            current: 112,
            original: 342,
            num: 341,
            nums: 234
          },
          {
            id: 7,
            imgUrl: '../images/hot7.png',
            title: '百雀羚三生花青春紧弹套装水乳护肤品补水保湿提拉紧致抗皱 ',
            current: 230,
            original: 532,
            num: 14,
            nums: 304
          },
          {
            id: 8,
            imgUrl: '../images/hot8.png',
            title: '加量送VC！养生堂牌天然维生素C咀嚼片',
            current: 12,
            original: 44,
            num: 134,
            nums: 34
          }
        ]
    }, {
        id: 1,
        hot: [
          {
            id: 3,
            imgUrl: '../images/hot13.png',
            title: '本矿物盐热敷包盐敷包艾盐包粗盐袋香薰护腰颈部关节全身热疗包',
            current: 65,
            original: 122,
            num: 64,
            nums: 533
          },
          {
            id: 5,
            imgUrl: '../images/hot14.png',
            title: '菜板家用抗菌防霉切水果砧板塑料粘板不锈钢和面案板擀面刀板占板 型',
            current: 112,
            original: 342,
            num: 341,
            nums: 234
          },
          {
            id: 7,
            imgUrl: '../images/hot15.png',
            title: '鑫爱家无线吸尘器家用大吸力手持式强力小型静音除螨吸拖地 ',
            current: 230,
            original: 532,
            num: 14,
            nums: 304
          },
          {
            id: 8,
            imgUrl: '../images/hot16.png',
            title: 'Peskoe/半球 HY-60D电压力锅家用双胆高压电饭煲小型电高压锅2L5L ',
            current: 12,
            original: 44,
            num: 134,
            nums: 34
          },
          {
            id: 8,
            imgUrl: '../images/hot9.png',
            title: '全自动智能多功能4L电饭锅5L大容量',
            current: 12,
            original: 44,
            num: 134,
            nums: 34
          },
        ]
    }, {
        id: 1,
        hot: [
          {
            id: 8,
            imgUrl: '../images/hot17.png',
            title: '大连特级现摘现发当季新鲜大樱桃孕妇水果2斤顺丰包邮 ',
            current: 12,
            original: 44,
            num: 134,
            nums: 34
          },
          {
            id: 8,
            imgUrl: '../images/hot18.png',
            title: '网红新鲜罐装水果儿童孕妇零食整箱烘焙专用 ',
            current: 12,
            original: 44,
            num: 134,
            nums: 34
          },
          {
            id: 8,
            imgUrl: '../images/hot8.png',
            title: '加量送VC！养生堂牌天然维生素C咀嚼片',
            current: 12,
            original: 44,
            num: 134,
            nums: 34
          }
        ]
    },
      {
        id: 1,
        hot: [
          {
            id: 8,
            imgUrl: '../images/hot21.png',
            title: '999纯银项链女简约心形吊坠首饰网红潮生日老婆情人节礼物送女友 ',
            current: 1020,
            original: 404,
            num: 134,
            nums: 304
          },
          {
            id: 8,
            imgUrl: '../images/hot22.png',
            title: '进口莫桑石牛头铂金项链四爪白金纯银12克拉',
            current: 320,
            original: 3334,
            num: 13,
            nums: 334
          },
          {
            id: 8,
            imgUrl: '../images/hot19.png',
            title: '悟空有货ins原宿风扎染短tee潮牌雏菊满印宽松情侣休闲短袖T恤男 ',
            current: 72,
            original: 44,
            num: 134,
            nums: 34
          },
          {
            id: 8,
            imgUrl: '../images/hot23.png',
            title: '夏季新款男士圆领桑蚕丝短袖t恤宽松休闲男装冰丝上衣服潮流半袖 ',
            current: 112,
            original: 444,
            num: 134,
            nums: 324
          },
          {
            id: 8,
            imgUrl: '../images/hot20.png',
            title: '潮街区夏新款ins潮牌暗黑丧系卡通印花短袖T恤男嘻哈宽松情侣体恤 ',
            current: 112,
            original: 444,
            num: 134,
            nums: 334
          }
        ]
      },
    ],
    currentId:0,
    nav_list:[
      {
        imgUrl:"../images/nav1.png",
        brand_name:"今日爆款",
        id:0
      },
      {
        imgUrl: "../images/nav2.png",
        brand_name: "精选家电",
        id: 1
      },
      {
        imgUrl: "../images/nav3.png",
        brand_name: "美妆护理",
        id: 2
      },
      {
        imgUrl: "../images/nav4.png",
        brand_name: "百货电器",
        id: 3
      },
      {
        imgUrl: "../images/nav5.png",
        brand_name: "食品饮料",
        id: 4
      },
      {
        imgUrl: "../images/nav6.png",
        brand_name: "服饰箱包",
        id: 5
      }
    ]
  },
  ready() {
    // let url = 'nav.php'
    // fetch(url).then(res => {
    //   console.log(res)
    //   this.setData({
    //     classic: res.data
    //   })
    // })
  },
  /**
   * 组件的方法列表
   */
  methods: {
    switchTap(e) { //更换资讯大类
      var indexs = e.currentTarget.dataset.id;
      this.setData({
        current: indexs
      })

      let screenWidth = wx.getSystemInfoSync().windowWidth;

      let itemWidth = screenWidth / 5;

      let { index, type } = e.currentTarget.dataset;

      const { nav_list } = this.data;

      let scrollX = itemWidth * index - itemWidth * 2;

      let maxScrollX = (nav_list.length + 1) * itemWidth;

      if (scrollX < 0) {
        scrollX = 0;
      } else if (scrollX >= maxScrollX) {
        scrollX = maxScrollX;
      }

      this.setData({
        x: scrollX
      })
    },
  }
})
