import logo from './logo.svg';
import './App.css';
import FormComponent from './components/FormComponent/FormComponent';
import ListingComponent from './components/TableComponent/TableComponent';
import { useState } from 'react';


function App() {
  const [liste,setList] = useState([])

  const addElementToListing = (person) => {   
    console.log(person); 
    console.log(liste);    
   setList([...liste,person]) 
  }

 
  return (
    <div className="App">
      <header className="App-header">
        <FormComponent addToList={addElementToListing}/>
        <ListingComponent liste = {liste}/>
        
      </header>
    </div>
  );
}


export default App;
