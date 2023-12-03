<template>
    <div class="box">
      <!-- 头栏目 -->
      <header>
        <div class="navbor">
          <div class="logo"><a href="#">Web Creative</a></div>
          <ul class="links">
            <li><a href="Home">Home</a></li>
            <li><router-link to="/login">Login</router-link></li>
            <li><router-link to="/register">Register</router-link></li>
            <li><a href="Countact">Countact</a></li>
          </ul>
          <a href="#" class="action_btn">Get Started</a>
          <div class="toggle_btn" @click="updateTopMenu">
            <i class="fa-solid fa-bars fa-beat fa-xl"></i>
          </div>
        </div>
        <!-- 点击面包屑后的展示 -->
        <div class="dropdown_menu" v-if="top_btn">
          <li><a href="Home">Home</a></li>
          <li><router-link to="/login">Login</router-link></li>
            <li><router-link to="/register">Register</router-link></li>
          <li><a href="Countact">Countact</a></li>
          <li><a href="#" class="action_btn">Get Started</a></li>
        </div>
      </header>

      <!-- 按钮 -->
    </div>
  </template>
  <script setup>
  import router from '@/router';
  import { ref, reactive, onMounted, toRefs, computed } from 'vue';
  // 控制头部导航栏
  const top_btn = ref(false);
  function updateTopMenu(){
    top_btn.value = !top_btn.value
    console.log(top_btn);
  }
  
  const left_btn = ref(false);
  function updateLeftMenu(){
    left_btn.value = !left_btn.value
    console.log(left_btn);
  }
  
  
  
  </script>
  
  <!-- 头部导航栏 -->
  <style lang="less" scoped>
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }
  
  li {
    list-style: none;
  }
  
  a {
    text-decoration: none;
    color: rgb(0, 195, 255);
    font-style: 1rem;
  }
  
  a:hover {
    color: orange;
  }
  
  header {
    position: relative;
    padding: 0 2rem;
    height: 70px;
  }
  
  .navbor {
    width: 100%;
    height: 100%;
    max-width: 1200px;
    margin: 0 auto;
    display: flex;
    align-items: center;
    justify-content: space-between;
  }
  
  /* 修饰Web Creative */
  .navbor .logo a {
    font-size: 1.5rem;
    font-weight: bold;
  }
  
  /* 修饰ul */
  .navbor .links {
    display: flex;
    gap: 2rem;
  }
  
  /* 修饰Get started */
  .navbor .toggle_btn {
    /* color: #fff; */
    font-style: 1.5rem;
    /* 光标cursor */
    cursor: pointer;
    display: none;
  }
  
  /* 修饰面包版 */
  .action_btn {
    background-color: orange;
    color: #fff;
    padding: 0.5rem 1rem;
    border: none;
    outline: none;
    overflow: none;
    border-radius: 30px;
    font-size: 0.8rem;
    font-weight: bold;
    cursor: pointer;
    transition: scale 0.2 ease;
  }
  
  .action_btn:hover {
    scale: 1.05;
    color: #fff;
  }
  
  .action_btn:active {
    scale: 0.95;
  }
  
  /* 面包屑的展示框 */
  .dropdown_menu {
    position: absolute;
    right: 2rem;
    top: 60px;
    width: 300px;
    background: rgba(155, 235, 198, 0.977);
    border-radius: 10px;
    overflow: hidden;
    transition: height 0.2s cubic-bezier(0.175, 0.885, 0.32, 1.275);
  }
  
  
  .dropdown_menu li {
    padding: 0.7rem;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  
  .dropdown_menu .action_btn {
    width: 100%;
    display: flex;
    justify-content: center;
  }
  
  /* 随页面的大小缩放显示面包板 */
  @media (max-width: 992px) {
    .navbor .links,
    .navbor .action_btn {
      display: none;
    }
  
    .navbor .toggle_btn {
      display: block;
    }
  
    .dropdown_menu {
      display: block;
    }
  }
  
  /* 面包屑展示框背景 */
  @media (max-width: 576px) {
    .dropdown_menu {
      width: 90%;
    }
  
    /* .dropdown_menu {
          left: 2rem;
          width: unset;
      } */
  }
  </style>
  

  
  <style scoped lang="less">
  .box {
    width: 100%;
    height: 100%;
  
    header {
      width: 100%;
      .navbor {
        width: 100%;
  
        .logo {
          a {
          }
        }
  
        .links {
          li {
            a {
            }
          }
  
          li {
            a {
            }
          }
  
          li {
            a {
            }
          }
  
          li {
            a {
            }
          }
        }
  
        .action_btn {
        }
  
        .toggle_btn {
          .fa-solid {
          }
  
          .fa-bars {
          }
  
          .fa-beat {
          }
  
          .fa-xl {
          }
        }
      }
  
      .dropdown_menu {
        li {
          a {
          }
        }
  
        li {
          a {
          }
        }
  
        li {
          a {
          }
        }
  
        li {
          a {
          }
        }
  
        .action_btn {
        }
      }
    }
  
    .content {
      display: flex;
      width: 100%;
      .left_block {
        width: 30%;
        .left_navbor {
          .left_logo {
            .left_toggle_btn {
              .fa-solid {
              }
  
              .fa-bars {
              }
  
              .fa-beat {
              }
  
              .fa-lg {
              }
            }
          }
  
          .left_links {
            li {
              a {
              }
            }
  
            li {
              a {
              }
            }
  
            li {
              a {
              }
            }
  
            li {
              a {
              }
            }
  
            .action_btn {
            }
          }
        }
      }
  
      .right {
        width: 70%;
      }
    }
  }
  </style>
  
  
  
  
  