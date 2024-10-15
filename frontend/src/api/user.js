import request from '../utils/request';

// 获取用户列表
export function getUsers(params) {
  return request({
    url: '/users',
    method: 'get',
    params,
  });
}

// 添加用户
export function addUser(data) {
  return request({
    url: '/users',
    method: 'post',
    data,
  });
}

// 更新用户信息
export function updateUser(data) {
  return request({
    url: `/users/${data.id}`,
    method: 'put',
    data,
  });
}

// 删除用户
export function deleteUser(id) {
  return request({
    url: `/users/${id}`,
    method: 'delete',
  });
}
