package org.example.tp_spring_react.dto.employeeDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDTOPost {
    private String name;
    private int identificationNumber;
    private String address;
    private String phone;
    private String email;
    private String birthDate;
    private String contractStart;
    private String contractEnd;
    private String occupation;
    private String password;
    private boolean admin;
    private double salary;
    private String observation;
}
