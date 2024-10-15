import axios from 'axios';
import store from '../store';

const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API, // API 基础路径
  timeout: 5000,
});

service.interceptors.request.use(
  (config) => {
    const token = store.state.token;
    if (token) {
      config.headers['Authorization'] = `Bearer ${token}`; // 请求头添加 token
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

service.interceptors.response.use(
  (response) => {
    const res = response.data;
    if (res.code !== 200) {
      // 处理错误
      return Promise.reject(new Error(res.message || 'Error'));
    } else {
      return res;
    }
  },
  (error) => {
    return Promise.reject(error);
  }
);

export default service;
