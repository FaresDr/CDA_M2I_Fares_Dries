<script setup>
import CharactersList from "./views/CharactersList.vue"
import FooterComponent from "./components/FooterComponent.vue"



 

</script>

<template>
  <header>
        <h1>
            TP Rick & Morty
        </h1>
    </header>
  


  <CharactersList/>

  <footer>
  <FooterComponent/>
  </footer>
</template>



<style scoped>


header {
  background-color: rgb(105, 170, 252);
  color: white;
  text-align: center;
}


</style>
