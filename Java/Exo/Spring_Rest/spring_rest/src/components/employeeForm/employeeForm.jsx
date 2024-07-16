import { useState, useEffect } from "react";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.css';
const EmployeeForm = () => {
    const [name, setName] = useState("");
    const [idNum, setIdNum] = useState(0)
    const [address, setAddress] = useState("")
    const [phone, setPhone] = useState("")
    const [email, setEmail] = useState("")
    const [birthdate, setBirth] = useState("")
    const [contractStart, setContractStart] = useState("")
    const [contractEnd, setContractEnd] = useState("")
    const [occup, setOccup] = useState("")
    const [pwd, setPwd] = useState("")
    const [admin, setAdmin] = useState(false)
    const [salary, setSalary] = useState(0)
    const [obs, setObs] = useState("")

    const createEmployee = () => {
        axios.post('http://localhost:8080/api/Employee/add', {
            name: name,
            identificationNumber: idNum,
            address: address,
            phone: phone,
            email: email,
            birthDate: birthdate,
            contractStart: contractStart,
            contractEnd: contractEnd,
            occupation: occup,
            password: pwd,
            admin: admin,
            salary: salary,
            observation: obs
        }, {
            headers: {
                'Content-Type': 'application/json'
            }
        }
        )
    }

    return (
        
            <div class="p-3 mb-2  text-white">
                <form class="bg-dark text-white form-inline">
                    <div class="form-group">
                        <label>Enter your name:
                            <input class="form-control"
                                type="text"
                                value={name}
                                onChange={(e) => setName(e.target.value)}
                            />

                        </label>
                    </div>
                    <div class="form-group">
                        <label>Enter your id:
                            <input class="form-control"
                                type="number"
                                value={idNum}
                                onChange={(e) => setIdNum(e.target.value)}
                            />

                        </label>
                    </div>
                    <div class="form-group">
                        <label>Enter your address:
                            <input class="form-control"
                                type="text"
                                value={address}
                                onChange={(e) => setAddress(e.target.value)}
                            />

                        </label>
                    </div>
                    <div class="form-group">
                        <label>Enter your phone:
                            <input class="form-control"
                                type="text"
                                value={phone}
                                onChange={(e) => setPhone(e.target.value)}
                            />

                        </label>
                    </div>
                    <div class="form-group">
                        <label>Enter your email:
                            <input class="form-control"
                                type="text"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                            />

                        </label>
                    </div>
                    <div class="form-group">
                        <label>Enter your birthdate:
                            <input class="form-control"
                                type="text"
                                value={birthdate}
                                onChange={(e) => setBirth(e.target.value)}
                            />

                        </label>
                    </div>
                    <div class="form-group">
                        <label>Enter your contractStart:
                            <input class="form-control"
                                type="text"
                                value={contractStart}
                                onChange={(e) => setContractStart(e.target.value)}
                            />

                        </label>
                    </div>
                    <div class="form-group">
                        <label>Enter your contractEnd:
                            <input class="form-control"
                                type="text"
                                value={contractEnd}
                                onChange={(e) => setContractEnd(e.target.value)}
                            />

                        </label>
                    </div>
                    <div class="form-group">
                        <label>Enter your occupation:
                            <input class="form-control"
                                type="text"
                                value={occup}
                                onChange={(e) => setOccup(e.target.value)}
                            />

                        </label>
                    </div>
                    <div class="form-group">
                        <label>Enter your password:
                            <input class="form-control"
                                type="text"
                                value={pwd}
                                onChange={(e) => setPwd(e.target.value)}
                            />

                        </label>
                    </div>
                    <div class="form-group">
                        <label>Enter your admin:<br />
                            <input class="form-check-input"
                                type="checkbox"
                                value={admin}
                                onChange={(e) => setAdmin(e.target.checked)}
                            />

                        </label>
                    </div>
                    <div class="form-group">
                        <label>Enter your salary:
                            <input class="form-control"
                                type="number" step={0.01}
                                value={salary}
                                onChange={(e) => setSalary(e.target.value)}
                            />

                        </label>
                    </div>
                    <div class="form-group">
                        <label>Enter your observations:
                            <input class="form-control"
                                type="text"
                                value={obs}
                                onChange={(e) => setObs(e.target.value)}
                            />

                        </label>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-info" onClick={() => createEmployee()}> Valider </button>
                    </div>
                </form>
            </div>
       
    )

}

export default EmployeeForm;