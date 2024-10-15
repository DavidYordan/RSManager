import router from './router';
import store from './store';
import i18n from './i18n';

router.beforeEach((to, from, next) => {
  const isAuthenticated = store.getters.isAuthenticated;
  const userRole = store.getters.userRole;
  const { t } = i18n.global;

  // 设置页面标题
  if (to.meta && to.meta.titleKey) {
    document.title = t(to.meta.titleKey);
  } else {
    document.title = t('app.title');
  }

  if (to.meta.requiresAuth) {
    if (isAuthenticated) {
      if (to.meta.role && to.meta.role !== userRole) {
        next({ name: 'Unauthorized' });
      } else {
        next();
      }
    } else {
      next({ name: 'Login' });
    }
  } else {
    next();
  }
});
