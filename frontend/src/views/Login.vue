<template>
  <div class="login-container">
    <el-card class="login-card">
      <h2 class="login-title">{{ t('app.title') }}</h2>
      <el-form :model="loginForm" @submit.prevent="handleLogin">
        <el-form-item>
          <el-input v-model="loginForm.username" :placeholder="t('login.username')"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="password" v-model="loginForm.password" :placeholder="t('login.password')"></el-input>
        </el-form-item>
        <el-button type="primary" @click="handleLogin">{{ t('login.login') }}</el-button>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';
import { reactive } from 'vue';
import { useI18n } from 'vue-i18n'; // 引入 useI18n

export default {
  name: 'Login',
  setup() {
    const store = useStore();
    const router = useRouter();
    const { t } = useI18n(); // 解构出 t 函数

    const loginForm = reactive({
      username: '',
      password: '',
    });

    const handleLogin = async () => {
      try {
        await store.dispatch('login', loginForm);
        router.push('/');
      } catch (error) {
        // 处理登录错误
        console.error(t('login.loginFailed'), error);
      }
    };

    return {
      loginForm,
      handleLogin,
      t, // 将 t 返回，供模板使用
    };
  },
};
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.login-card {
  width: 400px;
  padding: 20px;
}

.login-title {
  text-align: center;
  margin-bottom: 20px;
}
</style>
