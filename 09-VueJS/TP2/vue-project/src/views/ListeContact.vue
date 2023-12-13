<script setup>
import { ref } from 'vue';
import { inject } from 'vue';
const {contact} = inject('contacts') 
console.log(contact);
</script>

<template>
    <h3 v-if="contact.length" class="mt-4"> Liste des tâches : </h3>
    <ul>
        <div class="card" width="150px" v-for="(name, id) in contact">
           
           <h2 card-title>{{ name.name }}</h2>
            <h2 card-title>{{ name.email }}</h2>
            <h2 card-title>{{ name.phone }}</h2>
            
                <RouterLink :to="`/contact/${name.id-1}`">
                <button type="button" class="btn btn-primary">Primary</button>
            </RouterLink>
        </div>
    </ul>
</template>
<style scoped>
.card{
    text-align: center;
    border: 2px solid lightgrey;
    margin: 25px;
}
h2{
    margin: 25px;
}
</style>

