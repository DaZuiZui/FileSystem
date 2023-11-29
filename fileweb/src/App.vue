<template>
  <div class="login-container">
    <div class="ball" v-for="(item, index) in ['', '', '', '', '', '', '']" :style="`--x:${index}`"></div>
    <div class="login-box">
      <router-view />
        <svg width="50%" height="100%">
        </svg>
    </div>
  </div>
</template>

<style lang="less">

.ball {
  position: absolute;
  background: rgba(255, 255, 255, 10);
  backdrop-filter: blur(5px);
  filter: hue-rotate(calc(var(--x) * 70deg));
  animation: animate 10s linear infinite;
  animation-delay: calc(var(--x) * -1s);
  border-radius: 50%;
}

@keyframes animate {

  0%,
  100% {
    transform: translateY(-100px);
  }

  25% {
    transform: translateX(100px);
  }

  50% {
    transform: translateY(100px);
  }

  75% {
    transform: translateX(-100px);
  }
}
.center{
  float: top;
}
/* 每一个child都是一个气泡，当鼠标悬停时气泡会发生变化 */
.ball:nth-child(1) {
  background-color: #fffaaa30;
  top: 300px;
  right: 460px;
  width: 100px;
  height: 100px;
  z-index: 1;
  box-shadow: 3px 3px 1px #e566ce40;
  transition: linear 200ms;
}

.ball:nth-child(1):hover {
  background-color: #58e0f050;
  top: 300px;
  right: 460px;
  width: 120px;
  height: 120px;
  box-shadow: 10px 10px 1px #e566ce40;
  z-index: 1;
}

.ball:nth-child(2) {
  background-color: #3df09a40;
  top: 100px;
  left: 100px;
  width: 100px;
  height: 100px;
  z-index: 2;
  box-shadow: 3px 3px 1px #e566ce40;
  transition: linear 200ms;
}

.ball:nth-child(2):hover {
  background-color: rgba(61, 97, 240, 0.25);
  top: 100px;
  left: 100px;
  width: 120px;
  height: 120px;
  box-shadow: 10px 10px 1px #e566ce40;
  z-index: 2;
}

.ball:nth-child(3) {
  background-color: #1de59e70;
  bottom: 100px;
  right: 100px;
  width: 130px;
  height: 130px;
  z-index: 3;
  box-shadow: 3px 3px 1px #e566ce40;
  transition: linear 200ms;
}

.ball:nth-child(3):hover {
  background-color: rgba(43, 201, 32, 0.44);
  bottom: 100px;
  right: 100px;
  width: 150px;
  height: 150px;
  box-shadow: 10px 10px 1px #e566ce40;
  z-index: 3;
}

.ball:nth-child(4) {
  background-color: #e58c3c30;
  top: 100px;
  left: 540px;
  width: 60px;
  height: 60px;
  box-shadow: 3px 3px 1px #e566ce40;
  transition: linear 200ms;
}

.ball:nth-child(4):hover {
  background-color: rgba(60, 229, 108, 0.30);
  top: 100px;
  left: 540px;
  width: 80px;
  height: 80px;
  box-shadow: 10px 10px 1px #e566ce40;
}

.ball:nth-child(5) {
  background-color: #e5d64830;
  top: 480px;
  left: 340px;
  width: 120px;
  height: 120px;
  box-shadow: 3px 3px 1px #e566ce40;
  transition: linear 200ms;
}

.ball:nth-child(5):hover {
  background-color: rgba(204, 38, 53, 0.19);
  top: 480px;
  left: 340px;
  width: 140px;
  height: 140px;
  box-shadow: 10px 10px 1px #e566ce40;
}

.ball:nth-child(6) {
  background-color: #42b8f030;
  top: 100px;
  right: 100px;
  width: 80px;
  height: 80px;
  box-shadow: 3px 3px 1px #e566ce40;
  transition: linear 200ms;
}

.ball:nth-child(6):hover {
  background-color: #77e55d40;
  top: 100px;
  right: 100px;
  width: 100px;
  height: 100px;
  box-shadow: 10px 10px 1px #e566ce40;
}</style>
