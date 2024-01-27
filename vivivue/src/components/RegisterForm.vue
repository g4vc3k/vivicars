<script lang="ts" setup>
import router from '@/router';
import axios from 'axios';
import { reactive } from 'vue';

const user = reactive({
  imie: '',
  nazwisko: '',
  data_urodzenia: '',
  telefon: '',
  miejscowosc: '',
  ulica: '',
  nr_lokalu: '',
  username: '',
  password: ''
});


const onSubmit = async () => {
  try {
    const response = await axios.post('http://localhost:8080/register', {
      imie: user.imie,
      nazwisko: user.nazwisko,
      data_urodzenia: user.data_urodzenia,
      telefon: user.telefon,
      miejscowosc: user.miejscowosc,
      ulica: user.ulica,
      nr_lokalu: user.nr_lokalu,
      username: user.username,
      password: user.password,
      enabled: 1,
      authorities: [{
        authority: "USER",
        username: user.username,
      }],
    });

    if (response.status === 201) {
      console.log('Successful registration');
      router.push('/login');
      window.location.reload;
    } else {
      throw new Error('Invalid credentials');
    }
  } catch (error) {
    console.error('Error during registration:', error);
  }
};
</script>

<!-- <input type="text" id="username" placeholder="Username" v-model="user.username"-->

<template>
  <div class="inner">
   <form class="w-full max-w-lg" @submit.prevent="onSubmit">
  <div class="flex flex-wrap -mx-3 mb-6">
    <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
      <b>
        Imię
      </b>
      <input v-model="user.imie" id="grid-first-name" type="text" placeholder="Jan">
    </div><br>
    <div class="w-full md:w-1/2 px-3">
      <b>
        Nazwisko
      </b>
      <input v-model="user.nazwisko" id="grid-last-name" type="text" placeholder="Kowalski">
    </div>
  </div><br>
  <div class="flex flex-wrap -mx-3 mb-6">
    <div class="w-full px-3">
      <b>
        Data urodzenia
      </b>
      <input v-model="user.data_urodzenia" id="grid-date" type="date" placeholder="123123123">
    </div>
  </div><br>
  <div class="flex flex-wrap -mx-3 mb-6">
    <div class="w-full px-3">
      <b>
        Telefon
      </b>
      <input v-model="user.telefon" id="grid-phone" type="text" placeholder="123123123">
    </div>
  </div><br>
  <div class="flex flex-wrap -mx-3 mb-2">
    <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
      <b>
        Miejscowość
      </b>
      <input v-model="user.miejscowosc" id="grid-city" type="text" placeholder="Sosnowiec">
    </div><br>
    <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
      <label for="grid-zip">
        Ulica
      </label>
      <input v-model="user.ulica" id="grid-street" type="text" placeholder="Sosnowiecka">
    </div><br>
    <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
      <label for="grid-zip">
        Numer lokalu
      </label>
      <input v-model="user.nr_lokalu" id="grid-zip" type="text" placeholder="12">
    </div><br>
    <div class="flex flex-wrap -mx-3 mb-6">
    <div class="w-full px-3">
      <b>
        Login
      </b>
      <input v-model="user.username" id="grid-login" type="text" placeholder="login">
      <a style="color:rgba(255,250,50,0.6);">To będzie twój login</a>
    </div>
  </div><br>
    <div class="flex flex-wrap -mx-3 mb-6">
    <div class="w-full px-3">
      <b>
        Hasło
      </b>
      <input v-model="user.password" id="grid-password" type="password" placeholder="******************">
      <a style="color:rgba(255,250,50,0.6);">To będzie twoje hasło</a>
    </div>
  </div><br>
  </div>
  <button type="submit">Zatwierdź</button>
</form> 
</div>
</template>
