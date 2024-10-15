import request from '../utils/request';

export function login(data) {
  return request({
    url: '/auth/login',
    method: 'post',
    data,
  });
}

export function getUserInfo() {
  return request({
    url: '/user/info',
    method: 'get',
  });
}

// 导出用户相关的 API 接口
export * from './user';
