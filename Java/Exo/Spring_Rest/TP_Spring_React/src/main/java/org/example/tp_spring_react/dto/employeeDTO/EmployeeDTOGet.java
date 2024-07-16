package org.example.tp_spring_react.dto.employeeDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tp_spring_react.entity.Absence;
import org.example.tp_spring_react.entity.Employee;
import org.example.tp_spring_react.entity.Vacances;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTOGet {
    private int id;
    private String name;
    private int identificationNumber;
    private String address;
    private String phone;
    private String email;
    private LocalDate birthDate;
    private LocalDate contractStart;
    private LocalDate contractEnd;
    private String occupation;
    private boolean admin;
    private double salary;
    private String observation;
    private List<Absence> absenceList;
    private List<Vacances> vacancesList;

}
