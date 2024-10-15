import { createStore } from 'vuex';
import { login, getUserInfo } from '../api/index';
import { getToken, setToken, removeToken } from '../utils/auth';

export default createStore({
  state: {
    token: getToken() || '',
    userInfo: {},
  },
  mutations: {
    SET_TOKEN(state, token) {
      state.token = token;
      setToken(token);
    },
    SET_USER_INFO(state, info) {
      state.userInfo = info;
    },
    LOGOUT(state) {
      state.token = '';
      state.userInfo = {};
      removeToken();
    },
  },
  actions: {
    async login({ commit }, payload) {
      try {
        const response = await login(payload);
        commit('SET_TOKEN', response.data.token);
        // 获取用户信息
        const userInfoResponse = await getUserInfo();
        commit('SET_USER_INFO', userInfoResponse.data);
      } catch (error) {
        // 处理错误
        throw error;
      }
    },
    logout({ commit }) {
      commit('LOGOUT');
    },
  },
  getters: {
    isAuthenticated: (state) => !!state.token,
    userRole: (state) => state.userInfo.role,
  },
});
