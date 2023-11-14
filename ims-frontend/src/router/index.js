import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '',
      name: 'login',
      component: () => import('@/views/login/LoginVue.vue')
    },
    {
      path: '/index',
      name: 'index',
      component: () => import('@/views/home/IndexVue.vue'),
      children: [
        {
          path: '',
          name: 'dashboard',
          component: () => import('@/views/home/components/DashboardPage.vue'),
        },
        {
          path: '/user-info',
          name: 'user-info',
          component: () => import('@/views/home/components/UserInfoPage.vue'),
        },
        {
          path: '/course',
          name: 'course',
          component: () => import('@/views/home/components/CoursePage.vue'),
        }
      ]
    }
  ]
})

export default router
