const fetch = require('fetch.js')
const good = require('good.js')
module.exports={
  getDetail(id,sCallBack){
       let url=`text.php`
       let type='post'
       let data={
         id:id
       }
       good(url,type,data).then(res=>{
         sCallBack(res.data)
       })
  }
}