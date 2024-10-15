<template>
  <div class="dashboard">
    <Header />
    <div class="content">
      <Sidebar />
      <div class="main">
        <Breadcrumb />
        <!-- 内容区域 -->
        <el-card>
          <h2>{{ $t('dashboard.welcome', { name: userInfo.username }) }}</h2>
          <!-- 根据角色显示不同内容 -->
          <div v-if="userRole === 'admin'">
            <p>{{ $t('dashboard.adminDashboard') }}</p>
          </div>
          <!-- 其他角色的内容 -->
        </el-card>
      </div>
    </div>
  </div>
</template>

<script>
import Header from '../components/Header.vue';
import Sidebar from '../components/Sidebar.vue';
import Breadcrumb from '../components/Breadcrumb.vue';
import { computed } from 'vue';
import { useStore } from 'vuex';

export default {
  name: 'Dashboard',
  components: {
    Header,
    Sidebar,
    Breadcrumb,
  },
  setup() {
    const store = useStore();
    const userInfo = computed(() => store.state.userInfo);
    const userRole = computed(() => store.getters.userRole);

    return {
      userInfo,
      userRole,
    };
  },
};
</script>

<style scoped>
/* 样式 */
</style>
