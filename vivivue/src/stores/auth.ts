import router from '@/router';
import { defineStore } from 'pinia';

export const useAuthStore = defineStore({
  id: 'auth',
  state: () => {
    return {
      role: localStorage.getItem('role') ? JSON.parse(localStorage.getItem('role')!) : null,
      user: localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')!) : null,
      token: localStorage.getItem('token') ? JSON.parse(localStorage.getItem('token')!) : null,
      returnUrl: '/'
    }
  },
  actions: {
    async login(username: string, password: string) {
      console.log("In login function for user: ", username, " and password: ", password);
      const response = await fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
      });
      if (response.ok) {
        console.log("TEST");
        const token = await response.text();
        const rolesResponse = await fetch(`http://localhost:8080/role/` + JSON.stringify(username).slice(1,-1), {
          method: 'GET',
          headers: {
            'Authorization': `Bearer ${token}`
          }
        });
        console.log("Response: ",rolesResponse);
        
        if (rolesResponse.ok) {
          const roles = await rolesResponse.json();
          console.log("Roles: ",roles);
          const role = roles.authorities[0].authority;
          console.log(role);
          // console.log(token);

          localStorage.setItem('user', JSON.stringify(username));
          localStorage.setItem('role', JSON.stringify(role));
          localStorage.setItem('token', JSON.stringify(token));
          this.user = username;
          this.role = role;
          this.token = token;
          
          const isTokenExpired = () => Date.now() >= (JSON.parse(atob(token.split('.')[1]))).exp * 1000;
          if (!isTokenExpired()) {
            router.push(this.returnUrl || '/');
            
          } else {
            this.logout();
          }
        } else {
          throw new Error('Failed to fetch authority');
        }
      } else {
        throw new Error('Invalid credentials');
      }
    },
    logout() {
      this.user = '';
      this.role = '';
      this.token = '';
      localStorage.removeItem('user');
      localStorage.removeItem('role');
      localStorage.removeItem('token');
      router.push('/login');
      window.location.reload;
    },
    isTokenExpired() {
      const expired = () => Date.now() >= (JSON.parse(atob(this.token.split('.')[1]))).exp * 1000;
      console.log("Is token expired? ", expired());
      if (expired()) {
        this.logout();
      }
    }
  }
});
