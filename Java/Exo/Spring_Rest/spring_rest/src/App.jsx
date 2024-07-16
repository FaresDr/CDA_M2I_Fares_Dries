import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import EmployeeList from './components/employeeList/employeeList.jsx'
import './App.css'
import EmployeeForm from './components/employeeForm/employeeForm.jsx'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <EmployeeList />
      <EmployeeForm/>
    </>
  )
}

export default App
