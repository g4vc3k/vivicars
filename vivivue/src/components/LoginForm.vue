<script lang="ts" setup>
import { useAuthStore } from '@/stores/auth';
import { reactive } from 'vue';

const user = reactive({
  username: '',
  password: '',
});

async function onSubmit() {
  if(user.username !== '' && user.password !== '') {
    try {
      console.log("form submitted for user: ", user.username, "Password: ", user.password);
      await useAuthStore().login(user.username, user.password);
    } catch (error: any) {
      console.error(error.message || 'An error occurred during login.');
    }
  }
}
</script>

<!-- <input type="text" id="username" placeholder="Username" v-model="user.username"-->

<template>
  <div class="inner">
   <form class="w-full max-w-lg" @submit.prevent="onSubmit">
  
    <div class="flex flex-wrap -mx-3 mb-6">
    <div class="w-full px-3">
      <b>
        Login
      </b>
      <input v-model="user.username" id="grid-login" type="text" placeholder="login">
    </div>
  </div><br>
    <div class="flex flex-wrap -mx-3 mb-6">
    <div class="w-full px-3">
      <b>
        Hasło
      </b>
      <input v-model="user.password" id="grid-password" type="password" placeholder="******************">
    </div>
  </div><br>
  

  <button type="submit">Zaloguj</button>
</form> 
</div>

</template>
