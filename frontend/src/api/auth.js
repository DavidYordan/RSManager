import axios from 'axios';

// 获取验证码图片
export function getCaptcha() {
  return axios.get('/captcha', {
    responseType: 'blob', // 确保获取的是二进制数据
  });
}

// 登录
export function login(data) {
  return axios.post('/login', data);
}
