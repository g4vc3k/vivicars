<script lang="ts" setup>
import router from '@/router';
import axios from 'axios';
import { reactive } from 'vue';

const user = reactive({
  email: '',
  haslo: ''
});


const onSubmit = async () => {
  try {
    const response = await axios.post('http://localhost:8080/register', {
      email: user.email,
      haslo: user.haslo
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
  <br><br>
    <div id="main">
						<div class="inner">
							<h1>Wybrany samochód</h1>
              <table><tr>
            <td style="width:50%;">
							<span class="image main" style="width:100%"><img src="/assets/images/1.jpg" alt=""/></span>
              <p>Super piekna honda szybsza niz wyglonda</p>
            </td>
            <td style="text-align: center;">
							<!-- <p>Donec eget ex magna. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque venenatis dolor imperdiet dolor mattis sagittis. Praesent rutrum sem diam, vitae egestas enim auctor sit amet. Pellentesque leo mauris, consectetur id ipsum sit amet, fergiat. Pellentesque in mi eu massa lacinia malesuada et a elit. Donec urna ex, lacinia in purus ac, pretium pulvinar mauris. Curabitur sapien risus, commodo eget turpis at, elementum convallis elit. Pellentesque enim turpis, hendrerit tristique.</p>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis dapibus rutrum facilisis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Etiam tristique libero eu nibh porttitor fermentum. Nullam venenatis erat id vehicula viverra. Nunc ultrices eros ut ultricies condimentum. Mauris risus lacus, blandit sit amet venenatis non, bibendum vitae dolor. Nunc lorem mauris, fringilla in aliquam at, euismod in lectus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In non lorem sit amet elit placerat maximus. Pellentesque aliquam maximus risus, vel venenatis mauris vehicula hendrerit.</p>
							<p>Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque venenatis dolor imperdiet dolor mattis sagittis. Praesent rutrum sem diam, vitae egestas enim auctor sit amet. Pellentesque leo mauris, consectetur id ipsum sit amet, fersapien risus, commodo eget turpis at, elementum convallis elit. Pellentesque enim turpis, hendrerit tristique lorem ipsum dolor.</p> -->
              <a>Od</a><input type="date" id="grid-date" class="od"> <br><br>
              <a>Do</a><input type="date" id="grid-date" class="do"> <br><br> 
              <a>Przed wypożyczeniem należy zapoznać się z naszym <a href="/regulamin"><u><b>regulaminem</b></u></a>.</a> 
              <input type="radio" value="Zaakceptuj regulamin" id="accept">
              <label for="accept" style="color:white">Akceptuje regulamin</label><br>
              <button type="submit">Wypożycz</button>
            </td></tr>
            
            </table>
            
            

            </div>
					</div>

</template>
