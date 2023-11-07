<script setup>

import {EditPen, House, Notebook, Setting, User, Van} from "@element-plus/icons-vue";
import router from "@/router";
</script>

<template>
  <div class="common-layout">
    <el-container style="height: 100vh">
      <el-aside width="200px" style="border-right: 1px solid #ccc">
        <div
            style="height: 55px;display: flex; justify-content: center; align-items: center;font-weight: bold; font-size: 24px">
          <el-icon style="margin-right: 3px"><Van /></el-icon>
          后台管理系统
        </div>
        <el-scrollbar class="menu" style="width: 100%; height: calc(100vh - 55px)">
          <el-menu
              default-active="0"
              class="el-menu-vertical-demo"
          >
            <el-menu-item index="0" @click="router.push('/')">
              <template #title>
                <el-icon>
                  <House/>
                </el-icon>
                <span>首页</span>
              </template>
            </el-menu-item>
            <el-sub-menu index="1">
              <template #title>
                <el-icon>
                  <User/>
                </el-icon>
                <span>学生管理</span>
              </template>
              <el-menu-item index="1-1" @click="router.push('/user-info')">学生信息</el-menu-item>
              <el-menu-item index="1-2">学生选课</el-menu-item>
              <el-menu-item index="1-3">学生成绩</el-menu-item>
              <el-menu-item index="1-4">学生课表</el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="2">
              <template #title>
                <el-icon>
                  <Notebook/>
                </el-icon>
                <span>教师管理</span>
              </template>
              <el-menu-item index="2-1">教师信息</el-menu-item>
              <el-menu-item index="2-2">教师课表</el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="3">
              <template #title>
                <el-icon>
                  <EditPen/>
                </el-icon>
                <span>考试管理</span>
              </template>
              <el-menu-item index="3-1">考试信息</el-menu-item>
              <el-menu-item index="3-2">考试学生</el-menu-item>
              <el-menu-item index="3-3">监考老师</el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="4">
              <template #title>
                <el-icon>
                  <setting/>
                </el-icon>
                <span>课程管理</span>
              </template>
              <el-menu-item index="4-1">课程信息</el-menu-item>
              <el-menu-item index="4-2">任课老师</el-menu-item>
              <el-menu-item index="4-3">选课情况</el-menu-item>
            </el-sub-menu>
          </el-menu>
        </el-scrollbar>
      </el-aside>
      <el-container>
        <el-header style="height: 55px; border-bottom: 1px solid #ccc">
          <div style="width: 100%; text-align: right;">
            <el-dropdown>
              <el-avatar style="width: 35px; height: 35px; margin-top: 10px"
                         src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
              />
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item>个人中心</el-dropdown-item>
                  <el-dropdown-item @click="router.push('/')">退出登录</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </div>
        </el-header>
        <el-main style="background-color: rgba(246, 249, 248)">
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style scoped>
.menu :deep(.el-menu) {
  border-right: 0;
}
</style>