<script setup>
import {Loading, Plus, Search} from "@element-plus/icons-vue";
import {onMounted, reactive, ref} from "vue";
import request from "@/utils/request";
import {ElMessage} from "element-plus";

const userList = ref([])
const addUserDialog = ref(false)
const updateUserDialog = ref(false)
const ruleForm = ref()
const selectForm = reactive({
  username: '',
  address: ''
})
const addUserForm = reactive({
  username: '',
  password: '',
  address: '',
  code: '',
  identificationCard: '',
  birthday: '',
  sex: '',
  enterTime: '',
  finishTime: ''
})
const updateUserForm = reactive({
  id: '',
  username: '',
  address: '',
  code: '',
  identificationCard: '',
  birthday: '',
  sex: '',
  enterTime: '',
  finishTime: ''
})

const rules = reactive({
  username: [
    {required: true, message: '请输入用户名', trigger: 'blur'},
    {min: 3, max: 30, message: '用户名的长度必须在3-30之间', trigger: 'blur'},
  ],
  password: [
    {required: true, message: '请输入密码', trigger: 'blur'},
    {min: 6, max: 18, message: '密码的长度必须在6-18之间', trigger: 'blur'},
  ],
  address: [
    {required: true, message: '请输入用户地址', trigger: 'blur'}
  ],
  code: [
    {required: true, message: '请输入身份码', trigger: 'blur'}
  ],
  identificationCard: [
    {required: true, message: '请输入身份证', trigger: 'blur'},
    {min: 18, max: 18, message: '身份证的长度必须是18位', trigger: 'blur'},
  ],
  sex: [
    {required: true, message: '请选择性别', trigger: 'blur'}
  ],
  birthday: [
    {required: true, message: '请选择生日', trigger: 'blur'}
  ],
  enterTime: [
    {required: true, message: '请选择入学时间', trigger: 'blur'}
  ],
  finishTime: [
    {required: true, message: '请选择离开时间', trigger: 'blur'},
  ]
})

const closeAddDialog = () => {
  addUserDialog.value = false
  addUserForm.username = ''
  addUserForm.password = ''
  addUserForm.address = ''
  addUserForm.code = ''
  addUserForm.identificationCard = ''
  addUserForm.birthday = ''
  addUserForm.sex = ''
  addUserForm.enterTime = ''
  addUserForm.finishTime = ''
}

const closeUpdateDialog = () => {
  updateUserDialog.value = false
  updateUserForm.id = ''
  updateUserForm.username = ''
  addUserForm.address = ''
  addUserForm.code = ''
  addUserForm.identificationCard = ''
  addUserForm.birthday = ''
  addUserForm.sex = ''
  addUserForm.enterTime = ''
  addUserForm.finishTime = ''
}

const getList = () => {
  request.get('/user/listUser?username=' + selectForm.username + '&address=' + selectForm.address).then(res => {
    if (res.code === 200) {
      userList.value = res.data
    } else
      ElMessage.error(res.message)
  })
}

const reset = () => {
  selectForm.username = ''
  selectForm.address = ''
  getList()
}

const submitForm = async (formEl) => {
  if (!formEl) return
  await formEl.validate((valid) => {
    if (valid) {
      request.post('/user/insertUser', addUserForm).then(res => {
        if (res.code === 200) {
          ElMessage.success("新增成功")
          closeAddDialog()
          reset()
        }
      })
    } else {
      ElMessage.error("请检查填入的信息是否合法")
    }
  })
}


const removeUser = (id) => {
  request.delete('/user/deleteUserById/' + id).then(res => {
    if (res.code === 200) {
      ElMessage.success("删除成功")
      reset()
    } else
      ElMessage.error(res.message)
  })
}

const openUpdateDialog = (row) => {
  console.log(row)
  updateUserForm.id = row.id
  updateUserForm.username = row.username
  updateUserForm.address = row.address
  updateUserForm.code = row.code
  updateUserForm.identificationCard = row.identificationCard
  updateUserForm.birthday = row.birthday
  updateUserForm.sex = row.sex
  updateUserForm.enterTime = row.enterTime
  updateUserForm.finishTime = row.finishTime
  updateUserDialog.value = true
}

const updateForm = async (formEl) => {
  if (!formEl) return
  await formEl.validate((valid) => {
    if (valid) {
      request.post('/user/updateUserById', updateUserForm).then(res => {
        console.log(res)
        if (res.code === 200) {
          ElMessage.success("更新成功")
          closeUpdateDialog()
          reset()
        }
      })
    } else {
      ElMessage.error("请检查填入的信息是否合法")
    }
  })
}

onMounted(() => {
  getList()
})
</script>

<template>
  <div
      style="width: 100%; height: 100%; background-color: white; border-radius: 8px;box-sizing: border-box; padding: 20px">
    <div style="height: 15%; width: 100%;">
      <div style="height: 50%; display: flex">
        <el-input v-model="selectForm.username" placeholder="用户名"
                  style="width: 200px; height: 30px;margin-right: 10px"/>
        <el-input v-model="selectForm.address" placeholder="地址" style="width: 200px; height: 30px"/>
      </div>
      <div style="height: 50%; display: flex">
        <el-button type="success" plain @click="getList">
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
        <el-button type="primary" plain @click="addUserDialog = true">
          <el-icon style="margin-right: 3px">
            <Plus/>
          </el-icon>
          新增
        </el-button>
      </div>
    </div>
    <el-scrollbar style="height: 85%; width: 100%">
      <el-table :data="userList" stripe style="width: 100%" border>
        <el-table-column prop="id" label="id" width="80"/>
        <el-table-column prop="username" label="用户名"/>
        <el-table-column prop="address" label="地址"/>
        <el-table-column prop="code" label="身份码"/>
        <el-table-column prop="sex" label="性别"/>
        <el-table-column prop="birthday" label="生日"/>
        <el-table-column prop="identificationCard" label="身份证"/>
        <el-table-column prop="enterTime" label="入学时间"/>
        <el-table-column prop="finishTime" label="离开时间"/>
        <el-table-column label="操作" width="160">
          <template v-slot="scope">
            <el-button type="info" plain @click="openUpdateDialog(scope.row)">修改</el-button>
            <el-popconfirm confirm-button-text="确认" cancel-button-text="取消" title="你确定要删除这个用户吗?"
                           @confirm="removeUser(scope.row.id)">
              <template #reference>
                <el-button type="danger" plain>删除</el-button>
              </template>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>
    </el-scrollbar>

  </div>

  <el-dialog
      v-model="addUserDialog"
      width="30%"
      title="新增用户信息"
      :before-close="closeAddDialog"
  >
    <div style="margin-right: 20%">
      <el-form :model="addUserForm" label-width="120" :rules="rules" ref="ruleForm">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="addUserForm.username"/>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="addUserForm.password"  type="password"/>
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="addUserForm.address"/>
        </el-form-item>
        <el-form-item label="身份码" prop="code">
          <el-input v-model="addUserForm.code"/>
        </el-form-item>
        <el-form-item label="身份证" prop="identificationCard">
          <el-input v-model="addUserForm.identificationCard"/>
        </el-form-item>
        <el-form-item label="生日" prop="birthday">
          <el-date-picker
              v-model="addUserForm.birthday"
              type="date"
              placeholder="请选择用户的生日"
          />
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-radio-group v-model="addUserForm.sex">
            <el-radio label="男">男</el-radio>
            <el-radio label="女">女</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="入学时间" prop="enterTime">
          <el-date-picker
              v-model="addUserForm.enterTime"
              type="date"
              placeholder="请选择入学的时间"
          />
        </el-form-item>
        <el-form-item label="结束时间" prop="finishTime">
          <el-date-picker
              v-model="addUserForm.finishTime"
              type="date"
              placeholder="请选择离开学校的时间"
          />
        </el-form-item>
        <el-form-item>
          <el-button @click="closeAddDialog">取消</el-button>
          <el-button type="primary" @click="submitForm(ruleForm)">
            确认
          </el-button>
        </el-form-item>
      </el-form>
    </div>
  </el-dialog>

  <el-dialog
      v-model="updateUserDialog"
      width="30%"
      title="更新用户信息"
      :before-close="closeUpdateDialog"
  >
    <div style="margin-right: 20%">
      <el-form :model="updateUserForm" label-width="120" :rules="rules" ref="ruleForm">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="updateUserForm.username"/>
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="updateUserForm.address"/>
        </el-form-item>
        <el-form-item label="身份码" prop="code">
          <el-input v-model="updateUserForm.code"/>
        </el-form-item>
        <el-form-item label="身份证" prop="identificationCard">
          <el-input v-model="updateUserForm.identificationCard"/>
        </el-form-item>
        <el-form-item label="生日" prop="birthday">
          <el-date-picker
              v-model="updateUserForm.birthday"
              type="date"
              placeholder="请选择用户的生日"
          />
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-radio-group v-model="updateUserForm.sex">
            <el-radio label="男">男</el-radio>
            <el-radio label="女">女</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="入学时间" prop="enterTime">
          <el-date-picker
              v-model="updateUserForm.enterTime"
              type="date"
              placeholder="请选择入学的时间"
          />
        </el-form-item>
        <el-form-item label="结束时间" prop="finishTime">
          <el-date-picker
              v-model="updateUserForm.finishTime"
              type="date"
              placeholder="请选择离开学校的时间"
          />
        </el-form-item>
        <el-form-item>
          <el-button @click="closeUpdateDialog">取消</el-button>
          <el-button type="primary" @click="updateForm(ruleForm)">
            确认
          </el-button>
        </el-form-item>
      </el-form>
    </div>
  </el-dialog>
</template>

<style scoped>

</style>