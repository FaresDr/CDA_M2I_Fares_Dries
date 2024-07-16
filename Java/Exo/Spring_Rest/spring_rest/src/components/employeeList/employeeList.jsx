import { useRef } from "react";
import {useDispatch, useSelector} from "react-redux"
import { useState, useEffect } from "react";
import { fetchEmployee, setEmployee } from "../entrepriseSlice";
import 'bootstrap/dist/css/bootstrap.css';
import './employeeList.css'
import axios from "axios";

const EmployeeList = () =>{

  const sup = (id) =>{
      axios.get("http://localhost:8080/api/Employee/delete/"+id)
      window.location.reload();
  }
    const dispatch = useDispatch()
    const [employees, setEmployees] = useState(null);

    console.log(employees)
    useEffect(() => {
        dispatch(fetchEmployee()).then(
          (response) => {
            setEmployees(response.payload);
          }
        );
      }, []);
      console.log(employees)
      dispatch(setEmployee(employees) )
      console.log(useSelector ((state) => state.entreprise.employee))

      return (
        <>
          
          <table class="table table-dark" >
                <thead>
                  <tr >
                    <th scope="col" >Id</th>
                    <th scope="col" >Identification Number</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Email</th>
                    <th scope="col" colSpan={3}>Addresse</th>
                    <th scope="col">Birthdate</th>
                    <th scope="col">ContarctStart</th>
                    <th scope="col">ContractEnd</th>
                    <th scope="col">Salary</th>
                    <th scope="col">Observation</th>
                  
                    <th>Action</th>
                  </tr>
                </thead>
            {employees?.map((employee, key) => (
                
                <tbody>
                  <tr key={key}>
                    <th scope="row">{employee.id}</th>
                    <th scope="row">{employee.identificationNumber}</th>
                    <td scope="row">{employee.name}</td>
                    <td scope="row">{employee.phone}</td>
                    <td scope="row">{employee.email}</td>
                    <td scope="row" colSpan={3}>{employee.address}</td>
                    <td scope="row">{employee.birthDate}</td>
                    <td scope="row">{employee.contractStart}</td>
                    <td scope="row">{employee.contractEnd}</td>
                    <td scope="row">{employee.salary}</td>
                    <td scope="row">{employee.observation}</td>
                    <td>
                      <button class="btn btn-danger" onClick={() => sup(employee.id)}>Delete</button>
                      <button class="btn btn-warning">Update</button>
                    </td>
                  </tr>
                 
                </tbody>
              
            ))}
            </table>
          
        </>
      );
      
}

export default EmployeeList;