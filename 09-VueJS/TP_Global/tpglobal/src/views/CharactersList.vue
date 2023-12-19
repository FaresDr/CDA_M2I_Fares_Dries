<script setup>
import { ref,onMounted} from 'vue';

import {useCharactersStore} from '../stores/characters'
import Card from '../components/CardComponent.vue';
let data = ref();
let nbPage = ref(1);

const personnageStore = useCharactersStore();
const { getCharacterByPage } = personnageStore

onMounted(() => {
  getCharacterByPage(nbPage);
  console.log(data);
});




 

</script>

<template>

  <div class="d-flex flex-wrap justify-content-evenly row-cols-4">
      <Card v-if="personnageStore.data"
        v-for="character in personnageStore.data.results" 
        :key="character.id"
        :character-list="character"
        :id="character.id"
      /> 
    </div>

    <div class="naviguation">
    <button @click="nbPage=1 , getCharacterByPage(nbPage)">FIRST</button>
    <button @click="nbPage > 1 ? nbPage-- : '', getCharacterByPage(nbPage)"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left-circle" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0m-4.5-.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5z"/>
</svg></button>
    <input type="number" placeholder=nbPage v-model="nbPage"  @keyup.enter="nbPage = $event.target.value,getCharacterByPage(nbPage)">
    
  <button @click="nbPage < 41 ? nbPage++:'', getCharacterByPage(nbPage)"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-circle" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5z"/>
</svg></button>
  <button @click="nbPage=42 , getCharacterByPage(nbPage)">LAST</button>
</div>
  
</template>



<style scoped>




.naviguation{
  display: flex;
  justify-content: center;

}
*{
  background-image: url("../src/assets/kisspng-grey-pattern-continental-light-gray-background-shading-5a9cfd9b941b12.9390720115202379796067.jpg");
  
}
button{
  
}

</style>
