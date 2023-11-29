<template>
      <div class="box">
        <h2>Login</h2>
        <div class="input-box">
            <label>账号</label>
            <input type="text"/>
        </div>
        <div class="input-box">
            <label>密码</label>
            <input type="password"/>
        </div>
        <div class="btn-box">
            <div>
                <button>登录</button>
                <button>注册</button>
            </div>
        </div>
    </div>
</template> 

<script setup>
import {ref} from "vue"
      const username= ref("")
      const password= ref("")
    
   function submitForm() {
      // 处理表单提交逻辑
      console.log('Username:', this.username);
      console.log('Password:', this.password);
      // 可以在这里添加表单提交的逻辑
    }
  
</script>

<style scoped lang="less">

.Login {
  /* 实现水平垂直居中 */
  /* **display：flex**布局 justify-content定义水平方向的元素位置,align-items定义垂直方向的元素位置 */
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
}


.box {
    margin: auto;
    flex-direction: column;
            
    border-radius: 20px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 350px;
    height: 380px;
    border-top: 1px solid rgba(255,255,255,0.5);
    border-left: 1px solid rgba(255,255,255,0.5);
    border-bottom: 1px solid rgba(255,255,255,0.2);
    border-right: 1px solid rgba(255,255,255,0.2);
    backdrop-filter: blur(10px);
    background: rgba(50,50,50,0.2);
}

.box > h2 {
    color: rgba(77, 72, 72, 0.9);
    margin-bottom: 20px;
}

.box .input-box {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: flex-start;
    margin-bottom: 10px;
}

.box .input-box > label {
    margin-bottom: 5px;
    color:  rgba(77, 72, 72, 0.9);
    font-size: 14px;
}

.box .input-box > input {
    box-sizing: border-box;
    color: rgba(77, 72, 72, 0.9);
    font-size: 14px;
    height: 35px;
    width: 250px;
    background: rgba(255,255,255,0.3);
    border: 1px solid rgba(255,255,255,0.5);
    border-radius: 5px;
    transition: 0.2s;
    outline: none;
    padding: 0 10px;
    letter-spacing: 1px;
}

.box .input-box > input:focus {
    border: 1px solid rgba(255,255,255,0.8);
}

.box .btn-box {
    width: 250px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: flex-start;
}

.box .btn-box > a {
    font-size: 14px;
    text-decoration: none;
    color: rgba(255,255,255,0.9);
    transition: 0.2s;
    width: 250px;
    text-align: end;
}

.box .btn-box > a:hover {
    color: rgba(255,255,255,1);
}

.box .btn-box > div {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: flex-start;
    margin-top: 20px;
}

.box .btn-box > div > button {
    width: 120px;
    height: 35px;
    border: 1px solid rgba(197, 81, 58,0.8);
    background: rgba(197, 81, 58,0.5);
    color: rgba(255,255,255,0.9);
    border-radius: 5px;
    transition: 0.2s;
}

.box .btn-box > div > button:nth-of-type(2) {
    margin-left: 10px;
}

.box .btn-box > div > button:hover {
    border: 1px solid rgba(248, 108, 76,0.8);
    background: rgba(248, 108, 76,0.5);
}

</style>
