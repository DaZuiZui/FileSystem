import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/Login.vue'
import Reg from '../views/Reg.vue'
import mainPage from '@/components/mainPage.vue'
const routes = [
  {
    path: '/',
    name: 'mainPage',
    component: mainPage
  },
  //登录面板
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  //注册面板
  {
    path: '/reg',
    name: 'Reg',
    component: Reg
  },

  {
    path: '/about',
    name: 'about',
    // route level code-splitting34
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
