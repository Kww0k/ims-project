<script setup>
import {reactive} from "vue";
import request from "@/utils/request";

const loginForm = reactive({
  username: '',
  password: ''
})

const login = () => {
  request.post("/login", loginForm).then(res => {
    console.log(res)
  })
}
</script>

<template>
  <div class="login-main">
    <div style="width: 450px; height: 300px; background-color: rgba(255, 255, 255, 0.7); border-radius: 8px;">
      <div style="width: 100%; font-size: 40px; height: 80px;  display: flex;justify-content: center;font-weight: bold;align-items: center;">
        登录
      </div>
      <div style="height: 60px;display: flex;justify-content: center;align-items: center;">
        <el-input v-model="loginForm.username" style="width: 300px" placeholder="用户名"/>
      </div>
      <div style="height: 60px;display: flex;justify-content: center;align-items: center;">
        <el-input v-model="loginForm.password" style="width: 300px" placeholder="密码" type="password"/>
      </div>
      <div style="height: 100px;display: flex;justify-content: center;align-items: center;">
        <el-button plain type="success" style="width: 300px" @click="login">登录</el-button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.login-main {
  width: 100%;
  height: 100vh;
  background-image: url('@/assets/login-bg.jpeg');
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
