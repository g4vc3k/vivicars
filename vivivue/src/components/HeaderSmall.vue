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
<!-- <a href="/register" class="login">Rejestracja</a><br>
<a href="/login" class="login">Logowanie</a><br>
<a href="/selected" class="login">Wybrany samochód</a> -->
<header id="header" class="header-small">
						

							<!-- Logo -->
								<a href="/" class="logo"><p class="logo">
									<span class="symbol"><img src="/assets/images/logo.svg " alt="" /></span><span class="title" >VIVICARS</span></p></a>
									<!-- <span class="title" ><a href="/register" class="login">Rejestracja</a></span>
<a href="/login" class="login">Logowanie</a>
<a href="/selected" class="login">Wybrany samochód</a> -->
<ul id="navbarek">
  <li id="navbarek"><a href="/login" id="navbarek">Zaloguj</a></li>
  <li id="navbarek"><a href="/logout" @click="logout" id="navbarek">Wyloguj</a></li>
  <li id="navbarek"><a href="/register" id="navbarek">Zarejestruj</a></li>
  <li id="navbarek"><a href="/selected" id="navbarek">Wybrany samochód</a></li>
  <li id="navbarek"><a href="/cars" id="navbarek">Wypożyczone samochody</a></li>
  
</ul>
<nav>
									<ul>
										<li><a href="/admin">Panel administratora</a></li>
									</ul>
								</nav>				<!-- Nav -->
								

						
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