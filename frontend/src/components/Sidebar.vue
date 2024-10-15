<template>
  <el-aside width="200px">
    <el-menu :default-active="activeMenu" class="el-menu-vertical-demo" router>
      <el-menu-item index="/">
        <i class="el-icon-menu"></i>
        <span slot="title">{{ $t('sidebar.dashboard') }}</span>
      </el-menu-item>
      <el-menu-item v-if="userRole === 'admin'" index="/user-management">
        <i class="el-icon-user"></i>
        <span slot="title">{{ $t('sidebar.userManagement') }}</span>
      </el-menu-item>
      <!-- 根据角色显示其他菜单项 -->
    </el-menu>
  </el-aside>
</template>

<script>
import { computed } from 'vue';
import { useStore } from 'vuex';
import { useRoute } from 'vue-router';

export default {
  name: 'Sidebar',
  setup() {
    const store = useStore();
    const route = useRoute();
    const activeMenu = computed(() => route.path);
    const userRole = computed(() => store.getters.userRole);

    return {
      activeMenu,
      userRole,
    };
  },
};
</script>

<style scoped>
/* 样式 */
</style>
