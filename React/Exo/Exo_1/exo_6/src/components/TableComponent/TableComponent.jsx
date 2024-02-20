import React from 'react';
import { useState } from 'react';

const ListingComponent = (props) => {
const {liste} = props
console.log(liste);

  return ( 
    <div>
        
     
  <div>
    <h1>Mon tableau </h1>
    <table className="table table-dark">
      <thead>
        <tr>
          <th>#</th>
          <th>Firstname</th>
          <th>Lastname</th>
          <th>Email</th>
        </tr>
      </thead>
      <tbody>
        {
          liste.map((e, index) => (
            <tr key={index}>
              <td>{index+1}</td>
              <td>{e.firstname}</td>
              <td>{e.lastname}</td>
              <td>{e.email}</td>
            </tr>
          ))
        }
      </tbody>
    </table>
  </div>
    </div>
   );
}
 
export default ListingComponent;