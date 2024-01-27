<script lang="ts" setup>
import Footer from '@/components/Footer.vue';
import HeaderSmall from '@/components/HeaderSmall.vue';
import Cars from '@/components/Cars.vue';


</script>

<!-- <script>
import axios from 'axios';

export default {
  data() {
    return {
      samochod: []
    };
  },
  mounted() {
    axios.get('http://localhost:8080/cars')
      .then(response => {
        this.samochod = response.data;
      })
      .catch(error => {
        console.error('Error fetching car data:', error);
      });
  }
};
</script> -->

<template>
<!-- Wrapper -->

    
<!-- Header -->
<HeaderSmall />  
   

<!-- Main -->
<Cars />
<Footer />
    



</template>