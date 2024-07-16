import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";

const BASE_URL = "http://localhost:8080/";

export const fetchEmployee = createAsyncThunk(
    "api/employee/all",
    async () => {
      const response = await axios.get(BASE_URL + "api/Employee/all");
      const data = await response.data
  
      
  
    const employee = data
  console.log(data)
      return employee;
    }
  );

  const entrepriseSlice = createSlice({
    name:"entreprise",
    initialState:{
        employee: [],
        candidate : []
    },
    reducers:{
        addEmployee:(state,action) =>{
            state.employee.push(action.payload)
        },
        addCandidate:(state,action)=>{
            state.candidate.push(action.payload)
        },
        setEmployee:(state,action)=>{
            state.employee = action.payload
        }
    }
  });

  export const{
    addEmployee,
    addCandidate,
    setEmployee
  }=entrepriseSlice.actions;
  export default entrepriseSlice.reducer;