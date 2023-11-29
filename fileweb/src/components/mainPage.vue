<template>
  <div class="box">
    <!-- 头栏目 -->
    <header>
      <div class="navbor">
        <div class="logo"><a href="#">Web Creative</a></div>
        <ul class="links">
          <li><a href="Home">Home</a></li>
          <li><a href="About">About</a></li>
          <li><a href="Services">Services</a></li>
          <li><a href="Countact">Countact</a></li>
        </ul>
        <a href="#" class="action_btn">Get Started</a>
        <div class="toggle_btn">
          <i class="fa-solid fa-bars fa-beat fa-xl"></i>
        </div>
      </div>
      <!-- 点击面包屑后的展示 -->
      <div class="dropdown_menu">
        <li><a href="Home">Home</a></li>
        <li><a href="About">About</a></li>
        <li><a href="Services">Services</a></li>
        <li><a href="Countact">Countact</a></li>
        <a href="#" class="action_btn">Get Started</a>
      </div>
    </header>
    <div class="content">
      <div class="left_block">
        <div class="left_navbor">
          <div class="left_logo">
            <div class="left_toggle_btn">
              <i class="fa-solid fa-bars fa-beat fa-lg"></i>
            </div>
          </div>
          <ul class="left_links">
            <li><a href="Home">Home</a></li>
            <li><a href="About">About</a></li>
            <li><a href="Services">Services</a></li>
            <li><a href="Countact">Countact</a></li>
            <a href="#" class="action_btn">Get Started</a>
          </ul>
        </div>
      </div>
      <div class="right">
        <div class="hello">
          <h1>首页</h1>
          <router-link to="/login"><h2>登录</h2></router-link>
          <router-link to="/reg"><h2>注册</h2></router-link>
        </div>
      </div>
    </div>
    <!-- 侧边栏 -->

    <!-- 按钮 -->
  </div>
</template>

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

<!-- 以下是导航栏样式 -->
<style scoped lang="less">
/* ======================================== */
/* 侧边栏 */

.left_navbor {
  /* display: none; */
  width: 60px;
  height: 500px;
  margin-left: 47px;
}

.left_navbor.open {
  /* display: none; */
  width: 200px !important;
  height: 500px;
  background-color: rgb(244, 247, 51);
  /* margin-left: 47px; */
}

/* 侧边框的头栏目 */
.left_navbor .left_logo {
  text-align: left;
  background-color: rgb(244, 247, 51);
  height: 59px;
}

/* 面包屑修饰 */
.left_navbor .left_logo .left_toggle_btn {
  /* margin-right: 10px;
     padding: 10px;  */
  position: fixed;
  top: 79px;
  left: 70px;
  cursor: pointer;
}

.left_toggle_btn.open {
  left: 137px !important;
}

/* Web Creative修饰 */
.left_navbor .left_logo a {
  display: none;
  line-height: 59px;
  padding-left: 22px;
}

/* ul列表 */
.left_navbor ul {
  display: none;
}

.left_navbor ul li {
  text-align: center;
  margin-top: 50px;
}

/* 修饰侧边框的Get Started */
.left_navbor .action_btn {
  position: fixed;
  top: 500px;
  left: 92px;
}

/* 实现按钮功能js */
.left_links.open {
  display: block;
  height: 439px;
}
</style>

<!-- 头部导航栏 -->

<style lang="less" scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  /* font-family: 'Open Sans',sans-serif; */
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
  display: none;
  position: absolute;
  right: 2rem;
  top: 60px;
  height: 0;
  width: 300px;
  background: rgba(155, 235, 198, 0.977);
  border-radius: 10px;
  overflow: hidden;
  transition: height 0.2s cubic-bezier(0.175, 0.885, 0.32, 1.275);
}

.dropdown_menu.open {
  height: 240px;
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
