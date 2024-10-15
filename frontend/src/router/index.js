import { createRouter, createWebHistory } from 'vue-router';
import store from '../store';
import Login from '../views/Login.vue';
import Layout from '../components/Layout.vue';

const routes = [
  {
    path: '/login',
    name: 'Login',
    component: Login,
    meta: { titleKey: 'pageTitle.login' }, // 添加 titleKey
  },
  {
    path: '/',
    component: Layout,
    meta: { requiresAuth: true },
    children: [
      {
        path: '',
        name: 'Dashboard',
        component: () => import('../views/Dashboard.vue'),
        meta: { requiresAuth: true, titleKey: 'pageTitle.dashboard' }, // 添加 titleKey
      },
      {
        path: 'user-management',
        name: 'UserManagement',
        component: () => import('../views/UserManagement.vue'),
        meta: { requiresAuth: true, role: 'admin', titleKey: 'pageTitle.userManagement' }, // 添加 titleKey
      },
      // 其他路由，同样添加 meta.titleKey
    ],
  },
  {
    path: '/unauthorized',
    name: 'Unauthorized',
    component: () => import('../views/Unauthorized.vue'),
    meta: { titleKey: 'pageTitle.unauthorized' }, // 添加 titleKey
  },
  // 处理未匹配的路由
  { path: '/:pathMatch(.*)*', redirect: '/' },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
