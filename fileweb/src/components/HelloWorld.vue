<!--
 * @Author: tianleiyu 
 * @Date: 2023-11-27 13:31:36
 * @LastEditTime: 2023-11-27 16:09:22
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /fileweb/src/components/HelloWorld.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
  <div class="hello">
    <h1>首页</h1>
    <router-link to="/login"><h2>登录</h2></router-link>
    <router-link to="/reg"><h2>注册</h2></router-link>
</div> 
</template>

<script setup>
defineProps({
  msg: String
})

</script>

import login from '../views/Login'
import reg from '../views/Reg'

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.hello {
  text-align: center;
}


// h3 {
//   margin: 40px 0 0;
// }

// ul {
//   list-style-type: none;
//   padding: 0;
// }

// li {
//   display: inline-block;
//   margin: 0 10px;
// }

// a {
//   color: #42b983;
// }
</style>
