import{configureStore } from "@reduxjs/toolkit"
import entrepriseReducer from "./components/entrepriseSlice"

export default configureStore({
    reducer:{
        entreprise : entrepriseReducer
    }
})
