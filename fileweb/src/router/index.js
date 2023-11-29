
import { createRouter, createWebHistory } from 'vue-router'
import Login from '../components/login.vue'
import Register from '../components/register.vue'
import Home from '@/views/Home.vue'
const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    // 子
    // children: [
    // ]
    
  },
  //登录面板
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  //注册面板
  {
    path: '/register',
    name: 'Register',
    component: Register
  },
  
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
