import { useAuthStore } from '@/stores/auth'
// import AboutView from '@/views/AboutView.vue'
import AdminView from '@/views/AdminView.vue'
import CarsView from '@/views/CarsView.vue'
import DashboardView from '@/views/DashboardView.vue'
import LoginView from '@/views/LoginView.vue'
import SelectedView from '@/views/SelectedView.vue'
// import MealsView from '@/views/MealsView.vue'
// import MenagementView from '@/views/MenagementView.vue'
// import ProductsView from '@/views/ProductsView.vue'
import CarManagerView from '@/views/CarManagerView.vue'
import RegisterView from '@/views/RegisterView.vue'
import RegulaminView from '@/views/RegulaminView.vue'
import UserManagerView from '@/views/UserManagerView.vue'
import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Dashboard',
      component: DashboardView
    },
    {
      path: '/admin',
      name: 'Admin',
      component: AdminView
    },
    {
      path: '/cars',
      name: 'Cars',
      component: CarsView
    },
    {
      path: '/managecars',
      name: 'ManageCars',
      component: CarManagerView
    },
    {
      path: '/manageusers',
      name: 'ManageUsers',
      component: UserManagerView
    },
    {
      path: '/regulamin',
      name: 'Regulamin',
      component: RegulaminView
    },
    // {
    //   path: '/products',
    //   name: 'Products',
    //   component: ProductsView
    // },
    {
      path: '/selected',
      name: 'SelectedView',
      component: SelectedView
    },
     {
       path: '/login',
       name: 'Login',
       component: LoginView
     },
    {
      path: '/logout',
      name: 'Logout',
      component: LoginView
    },
     {
       path: '/register',
       name: 'Register',
       component: RegisterView
     }
  ]
})

router.beforeEach(async (to) => {
  const publicPages = ['/login','/register', '/', '/selected', '/admin', '/managecars', '/manageusers', '/regulamin']
  const authPages = ['/login','/register']
  const authRequired = !publicPages.includes(to.path);
  const authNotRequired = !authPages.includes(to.path);
  const auth = useAuthStore();

  if (authRequired && !auth.user) {
    return '/login';
  } else if (!authNotRequired && auth.user) {
    const previousRoute = router.currentRoute.value; // Accessing current route
    if (previousRoute && previousRoute.path !== to.path) {
      return previousRoute.path;
    } else {
      return '/';
    }
  }
})

export default router