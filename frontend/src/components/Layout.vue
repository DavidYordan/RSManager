<template>
    <div class="layout">
      <Header />
      <div class="layout-content">
        <Sidebar />
        <div class="layout-main">
          <Breadcrumb />
          <router-view />
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import Header from './Header.vue';
  import Sidebar from './Sidebar.vue';
  import Breadcrumb from './Breadcrumb.vue';
  
  export default {
    name: 'Layout',
    components: {
      Header,
      Sidebar,
      Breadcrumb,
    },
  };
  </script>
  
  <style scoped>
  .layout {
    display: flex;
    flex-direction: column;
    height: 100vh;
  }
  
  .layout-content {
    display: flex;
    flex: 1;
  }
  
  .layout-main {
    flex: 1;
    padding: 20px;
    overflow-y: auto;
  }
  </style>
  