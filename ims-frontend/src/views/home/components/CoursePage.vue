<script setup>

import {Loading, Plus, Search} from "@element-plus/icons-vue";

const tableData = [
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-02',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-04',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
]
</script>

<template>
  <div style="width: 100%; height: 100%; background-color: white; border-radius: 8px;box-sizing: border-box; padding: 20px">
    <div style="height: 15%; width: 100%;">
      <div style="height: 50%; display: flex">
        <el-input  placeholder="课程名"
                  style="width: 200px; height: 30px;margin-right: 10px"/>
      </div>
      <div style="height: 50%; display: flex">
        <el-button type="success" plain >
          <el-icon style="margin-right: 3px">
            <Search/>
          </el-icon>
          搜索
        </el-button>
        <el-button type="warning" plain >
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
    <div style="width: 100%; height: 75%">
        <el-table :data="tableData" border stripe style="width: 100%; height: 100%">
          <el-table-column style="height: 100px;" prop="date" label="Date" width="180" />
          <el-table-column prop="name" label="Name" width="180" />
          <el-table-column prop="address" label="Address" />
        </el-table>
    </div>
    <div style="height: 10%; width: 100%; display: flex; justify-content: center; align-items: center">
      <el-pagination layout="prev, pager, next" :total="1000" />
    </div>
  </div>
</template>

<style scoped>

</style>