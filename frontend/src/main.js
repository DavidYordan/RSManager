// src/main.js

import { createApp, watch } from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';

import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';

import i18n from './i18n';

// 导入 Element Plus 的语言包
import enLocale from 'element-plus/es/locale/lang/en';
import zhCNLocale from 'element-plus/es/locale/lang/zh-cn';
import zhTWLocale from 'element-plus/es/locale/lang/zh-tw';

const app = createApp(App);

app.use(store);
app.use(router);
app.use(i18n);

// 获取 Element Plus 对应的语言包
function getElementPlusLocale(lang) {
  switch (lang) {
    case 'zh-cn':
      return zhCNLocale;
    case 'zh-tw':
      return zhTWLocale;
    default:
      return enLocale;
  }
}

// 设置 Element Plus 的国际化
app.use(ElementPlus, { locale: getElementPlusLocale(i18n.global.locale.value) });

// 监听语言变化，动态更新 Element Plus 的语言
watch(
  () => i18n.global.locale.value,
  (newLocale) => {
    app.use(ElementPlus, { locale: getElementPlusLocale(newLocale) });
  }
);

app.mount('#app');
