
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

import VueCookies from 'vue3-cookies'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

const app = createApp(App).use(router).use(VueCookies).use(ElementPlus).mount('#app');
