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
        <el-form-item>
          <div class="captcha-container">
            <el-input
              v-model="loginForm.captchaCode"
              :placeholder="t('login.captcha')"
            ></el-input>
            <img
              :src="captchaImageUrl"
              @click="refreshCaptcha"
              alt="captcha"
              class="captcha-image"
            />
          </div>
        </el-form-item>
        <el-button type="primary" @click="handleLogin">{{ t('login.login') }}</el-button>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';
import { reactive, ref, onMounted } from 'vue';
import { useI18n } from 'vue-i18n';
import { getCaptcha } from '../api/auth';

export default {
  name: 'Login',
  setup() {
    const store = useStore();
    const router = useRouter();
    const { t } = useI18n();

    const loginForm = reactive({
      username: '',
      password: '',
      captchaCode: '',
    });

    const captchaImageUrl = ref('');

    const loadCaptcha = async () => {
      try {
        const response = await getCaptcha();
        const blob = response.data;
        captchaImageUrl.value = URL.createObjectURL(blob);
      } catch (error) {
        console.error('获取验证码失败', error);
      }
    };

    const refreshCaptcha = () => {
      loadCaptcha();
    };

    onMounted(() => {
      loadCaptcha();
    });

    const handleLogin = async () => {
      try {
        await store.dispatch('login', loginForm);
        router.push('/');
      } catch (error) {
        // 处理登录错误
        console.error(t('login.loginFailed'), error);
        // 刷新验证码，防止恶意尝试
        refreshCaptcha();
      }
    };

    return {
      loginForm,
      handleLogin,
      t,
      captchaImageUrl,
      refreshCaptcha,
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

.captcha-container {
  display: flex;
  align-items: center;
}

.captcha-image {
  margin-left: 10px;
  cursor: pointer;
  height: 40px;
}
</style>
