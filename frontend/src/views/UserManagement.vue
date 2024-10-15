<template>
  <div class="user-management">
    <el-card>
      <el-button type="primary" @click="handleAddUser">添加用户</el-button>
      <el-table :data="userList">
        <el-table-column prop="username" label="用户名" />
        <el-table-column prop="role" label="角色" />
        <el-table-column label="操作">
          <template #default="scope">
            <el-button size="small" @click="handleEditUser(scope.row)">编辑</el-button>
            <el-button size="small" type="danger" @click="handleDeleteUser(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
    <!-- 添加/编辑用户的对话框 -->
    <el-dialog :visible.sync="dialogVisible" title="用户信息">
      <el-form :model="currentUser">
        <el-form-item label="用户名">
          <el-input v-model="currentUser.username" />
        </el-form-item>
        <el-form-item label="角色">
          <el-select v-model="currentUser.role">
            <el-option label="管理员" value="admin" />
            <!-- 其他角色选项 -->
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="handleSaveUser">保存</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue';
import { getUsers, addUser, updateUser, deleteUser } from '../api/user';

export default {
  name: 'UserManagement',
  setup() {
    const userList = ref([]);
    const dialogVisible = ref(false);
    const currentUser = ref({});

    const fetchUsers = async () => {
      const response = await getUsers();
      userList.value = response.data;
    };

    const handleAddUser = () => {
      currentUser.value = {};
      dialogVisible.value = true;
    };

    const handleEditUser = (user) => {
      currentUser.value = { ...user };
      dialogVisible.value = true;
    };

    const handleSaveUser = async () => {
      if (currentUser.value.id) {
        await updateUser(currentUser.value);
      } else {
        await addUser(currentUser.value);
      }
      dialogVisible.value = false;
      fetchUsers();
    };

    const handleDeleteUser = async (user) => {
      await deleteUser(user.id);
      fetchUsers();
    };

    onMounted(() => {
      fetchUsers();
    });

    return {
      userList,
      dialogVisible,
      currentUser,
      handleAddUser,
      handleEditUser,
      handleSaveUser,
      handleDeleteUser,
    };
  },
};
</script>

<style scoped>
/* 样式 */
</style>
