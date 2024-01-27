<script setup lang="ts">
import { useAuthStore } from '@/stores/auth';

//const username = localStorage.getItem('user') ? localStorage.getItem('user').slice(1, -1) : null;
//const role = localStorage.getItem('role') ? localStorage.getItem('role').slice(1, -1) : null;
const auth = useAuthStore();

function logout() {
  auth.logout();
}

</script>

<template>
<header id="header">
						<div class="inner">

							<!-- Logo -->
							<br><br><br><br><a href="/" class="logo"><h1 class="logo">
									<span class="symbol"><img src="/assets/images/logo.svg " alt="" /></span><span class="title" >VIVICARS</span></h1></a>
									

							<!-- Nav -->
								

						</div>
					</header>

				<!-- Menu -->
					<nav id="menu">
						<h2>Menu</h2>
						<ul>
							<li><a href="/login" class="login">Logowanie</a></li>
							<li><a href="generic.html">Ipsum veroeros</a></li>
							<li><a href="generic.html">Tempus etiam</a></li>
							<li><a href="generic.html">Consequat dolor</a></li>
							<li><a href="elements.html">Elements</a></li>
						</ul>
					</nav>
</template>