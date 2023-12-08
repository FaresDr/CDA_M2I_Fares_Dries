<script setup>
import { ref, watchEffect } from 'vue';
let data = ref(null);
let name = ref('Xiao')

watchEffect(async () => {
  const response = await fetch("https://genshin.jmp.blue/characters/"+name.value)
  data.value = await response.json()
  console.log(data.value);
})


</script>

<template>
  <section >
  <input @keyup.enter="name = $event.target.value">
  </section>
  <section v-if=data>
    <h1>{{ data.name }}</h1>
    <h1>{{ data.title }}</h1>
    <h1>{{ data.weapon }}</h1>
    <h1>{{ data.gender }}</h1>
    <h1>{{ data.rarity }}*</h1>
  </section>
</template>

<style scoped>
h1{
  display: block;
  background-color: white;  
}

</style>
