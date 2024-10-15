<template>
  <!-- 语言切换按钮 -->
  <el-dropdown>
    <span class="el-dropdown-link">
      {{ currentLanguageLabel }}<i class="el-icon-arrow-down el-icon--right"></i>
    </span>
    <el-dropdown-menu slot="dropdown">
      <el-dropdown-item @click.native="switchLanguage('en')">English</el-dropdown-item>
      <el-dropdown-item @click.native="switchLanguage('zh-cn')">简体中文</el-dropdown-item>
      <el-dropdown-item @click.native="switchLanguage('zh-tw')">繁體中文</el-dropdown-item>
    </el-dropdown-menu>
  </el-dropdown>
</template>

<script>
import { computed } from 'vue';
import { useI18n } from 'vue-i18n';

export default {
  setup() {
    const { locale, t } = useI18n();

    const currentLanguageLabel = computed(() => {
      switch (locale.value) {
        case 'zh-cn':
          return '简体中文';
        case 'zh-tw':
          return '繁體中文';
        default:
          return 'English';
      }
    });

    const switchLanguage = (lang) => {
      locale.value = lang;
      localStorage.setItem('locale', lang);
    };

    return {
      currentLanguageLabel,
      switchLanguage,
    };
  },
};
</script>
