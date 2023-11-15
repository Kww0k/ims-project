<script setup>

import {Loading, Plus, Search} from "@element-plus/icons-vue";
import {onMounted, ref} from "vue";
import request from "@/utils/request";
import {ElMessage} from "element-plus";
const total = ref(0)
const pageNum = ref(1)
const name = ref('')
const courseList = ref([])

const getCourseList = () => {
  request.get('/course/listCourse?pageNum=' + pageNum.value + '&pageSize=5&name=' + name.value).then(res => {
    if (res.code === 200) {
      courseList.value = res.data.courseVOS
      total.value = res.data.total
    } else
      ElMessage.error(res.message)
  })
}

onMounted(() => {
  getCourseList()
})

const handleCurrentChange = (val) => {
  pageNum.value = val
  getCourseList()
}

const reset = () => {
  name.value = ''
  pageNum.value = 1
  getCourseList()
}
</script>

<template>
  <div style="width: 100%; height: 100%; background-color: white; border-radius: 8px;box-sizing: border-box; padding: 20px">
    <div style="height: 15%; width: 100%;">
      <div style="height: 50%; display: flex">
        <el-input  placeholder="课程名" v-model="name"
                  style="width: 200px; height: 30px;margin-right: 10px"/>
      </div>
      <div style="height: 50%; display: flex">
        <el-button type="success" plain @click="getCourseList">
          <el-icon style="margin-right: 3px">
            <Search/>
          </el-icon>
          搜索
        </el-button>
        <el-button type="warning" plain @click="reset">
          <el-icon style="margin-right: 3px">
            <Loading/>
          </el-icon>
          重置
        </el-button>
        <el-button type="primary" plain>
          <el-icon style="margin-right: 3px">
            <Plus/>
          </el-icon>
          新增
        </el-button>
      </div>
    </div>
    <div style="width: 100%; height: 340px">
        <el-table :data="courseList" border stripe style="width: 100%;"
                  :header-cell-style="{textAlign: 'center',height: '40px'}"
                  :row-style="{height: '60px'}">
          <el-table-column prop="id" label="id"/>
          <el-table-column prop="name" label="课程名"/>
          <el-table-column prop="startTime" label="开始时间"/>
          <el-table-column prop="endTime" label="结束时间"/>
          <el-table-column prop="credit" label="学分"/>
          <el-table-column prop="period" label="课时"/>
          <el-table-column prop="number" label="最大人数"/>
          <el-table-column prop="openedBy" label="主讲人"/>
          <el-table-column label="操作" width="160">
            <template v-slot="scope">
              <el-button type="info" plain>修改</el-button>
              <el-popconfirm confirm-button-text="确认" cancel-button-text="取消" title="你确定要删除这个用户吗?">
                <template #reference>
                  <el-button type="danger" plain>删除</el-button>
                </template>
              </el-popconfirm>
            </template>
          </el-table-column>
        </el-table>
    </div>
    <div style="height: 10%; width: 100%; display: flex; justify-content: center; align-items: center">
      <el-pagination :page-size="5" layout="prev, pager, next" :total="total" @current-change="handleCurrentChange"/>
    </div>
  </div>
</template>

<style scoped>
</style>