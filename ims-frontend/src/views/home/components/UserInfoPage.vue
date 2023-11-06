<script setup>
import {Loading, Plus, Search} from "@element-plus/icons-vue";
import {onMounted, ref} from "vue";
import request from "@/utils/request";
import {ElMessage} from "element-plus";

const userList = ref([])

const getList = () => {
  request.get('/user/listUser').then(res => {
    if (res.code === 200) {
      userList.value = res.data
    } else
      ElMessage.error(res.message)
  })
}

onMounted(() => {
  getList()
})
</script>

<template>
  <div style="width: 100%; height: 100%; background-color: white; border-radius: 8px;box-sizing: border-box; padding: 20px">
    <div style="height: 15%; width: 100%;">
      <div style="height: 50%; display: flex">
        <el-input placeholder="用户名" style="width: 200px; height: 30px;margin-right: 10px"/>
        <el-input placeholder="地址" style="width: 200px; height: 30px"/>
      </div>
      <div style="height: 50%; display: flex">
        <el-button type="success" plain><el-icon style="margin-right: 3px"><Search /></el-icon>搜索</el-button>
        <el-button type="danger" plain> <el-icon style="margin-right: 3px"><Loading /></el-icon>重置</el-button>
        <el-button type="primary" plain> <el-icon style="margin-right: 3px"><Plus /></el-icon>新增</el-button>
      </div>
    </div>
    <el-scrollbar style="height: 85%; width: 100%">
      <el-table :data="userList" stripe style="width: 100%" border>
        <el-table-column prop="id" label="id" width="80" />
        <el-table-column prop="username" label="用户名" />
        <el-table-column prop="address" label="地址" />
        <el-table-column prop="code" label="身份码" />
        <el-table-column prop="sex" label="性别" />
        <el-table-column prop="birthday" label="生日" />
        <el-table-column label="操作">
          <el-button type="info" plain>修改</el-button>
          <el-button type="warning" plain>删除</el-button>
        </el-table-column>
      </el-table>
    </el-scrollbar>

  </div>
</template>

<style scoped>

</style>