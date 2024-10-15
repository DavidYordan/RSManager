import { createI18n } from 'vue-i18n';
import en from './locales/en.json';
import zhCN from './locales/zh-cn.json';
import zhTW from './locales/zh-tw.json';

// 导入 Element Plus 的语言包
import enLocale from 'element-plus/es/locale/lang/en';
import zhCNLocale from 'element-plus/es/locale/lang/zh-cn';
import zhTWLocale from 'element-plus/es/locale/lang/zh-tw';

const messages = {
  en: {
    ...en,
    ...enLocale,
  },
  'zh-cn': {
    ...zhCN,
    ...zhCNLocale,
  },
  'zh-tw': {
    ...zhTW,
    ...zhTWLocale,
  },
};

const locale = localStorage.getItem('locale') || 'en';

const i18n = createI18n({
  legacy: false,
  locale,
  fallbackLocale: 'en',
  messages,
});

export default i18n;
