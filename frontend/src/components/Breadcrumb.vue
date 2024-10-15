<template>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item to="/">首页</el-breadcrumb-item>
      <el-breadcrumb-item>{{ currentRoute.meta.title || currentRoute.name }}</el-breadcrumb-item>
    </el-breadcrumb>
  </template>
  
  <script>
  import { computed } from 'vue';
  import { useRoute } from 'vue-router';
  
  export default {
    name: 'Breadcrumb',
    setup() {
      const route = useRoute();
      const currentRoute = computed(() => route);
  
      return {
        currentRoute,
      };
    },
  };
  </script>
  
  <style scoped>
  /* 样式 */
  </style>
  