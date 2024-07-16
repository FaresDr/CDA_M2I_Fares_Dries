package org.example.tp_spring_react.service;

import org.example.tp_spring_react.dto.employeeDTO.EmployeeDTOGet;
import org.example.tp_spring_react.dto.employeeDTO.EmployeeDTOPost;
import org.example.tp_spring_react.entity.Employee;
import org.example.tp_spring_react.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDTOGet NormalToDTO(Employee employee) {
        EmployeeDTOGet employeeGet =
                EmployeeDTOGet.builder()
                        .id(employee.getId())
                        .name(employee.getName())
                        .identificationNumber(employee.getIdentificationNumber())
                        .address(employee.getAddress())
                        .phone(employee.getPhone())
                        .email(employee.getEmail())
                        .birthDate(employee.getBirthDate())
                        .contractStart(employee.getContractStart())
                        .contractEnd(employee.getContractEnd())
                        .occupation(employee.getOccupation())
                        .admin(employee.isAdmin())
                        .salary(employee.getSalary())
                        .observation(employee.getObservation())
                        .absenceList(employee.getAbsenceList())
                        .vacancesList(employee.getVacancesList())
                        .build();

        return employeeGet;
    }
    public EmployeeDTOGet getEmployeeByiD(int id) {
        return NormalToDTO(employeeRepository.findById(id).orElse(null));
    }

    public Employee getNormalEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployeeByiD(int id) {
        employeeRepository.deleteById(id);
    }

    public Employee saveEmployee(EmployeeDTOPost employee) {
        Employee e = Employee.builder()
                .name(employee.getName())
                .identificationNumber(employee.getIdentificationNumber())
                .address(employee.getAddress())
                .phone(employee.getPhone())
                .email(employee.getEmail())
                .birthDate(LocalDate.parse(employee.getBirthDate()))
                .contractStart(LocalDate.parse(employee.getContractStart()))
                .contractEnd(LocalDate.parse(employee.getContractEnd()))
                .occupation(employee.getOccupation())
                .password(employee.getPassword())
                .admin(employee.isAdmin())
                .salary(employee.getSalary())
                .observation(employee.getObservation())
                .build();
        return employeeRepository.save(e);
    }

    private List<EmployeeDTOGet> employeeListToEmployeeDTOList(List<Employee> employees){
        return employees.stream().map(this::NormalToDTO).collect(Collectors.toList());
    }

    public List<EmployeeDTOGet> getAllEmployees() {
        return employeeListToEmployeeDTOList((List<Employee>) employeeRepository.findAll());

    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDTOGet updateEmployee(int id ,EmployeeDTOPost employee) {
        Employee employee1 = getNormalEmployeeById(id);
        employee1.setName(employee.getName());
        employee1.setIdentificationNumber(employee.getIdentificationNumber());
        employee1.setAddress(employee.getAddress());
        employee1.setPhone(employee.getPhone());
        employee1.setEmail(employee.getEmail());
        employee1.setBirthDate(LocalDate.parse(employee.getBirthDate()));
        employee1.setContractStart(LocalDate.parse(employee.getContractStart()));
        employee1.setContractEnd(LocalDate.parse(employee.getContractEnd()));
        employee1.setOccupation(employee.getOccupation());
        employee1.setAdmin(employee.isAdmin());
        employee1.setSalary(employee.getSalary());
        employee1.setObservation(employee.getObservation());
        employee1.setPassword(employee.getPassword());
        employeeRepository.save(employee1);
        return NormalToDTO(employee1);
    }


}
