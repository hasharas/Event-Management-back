package com.codeWithProject.employee.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.codeWithProject.employee.entity.Employee;
import com.codeWithProject.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeService {

      private final EmployeeRepository employeeRepository;

      public Employee postEmployee(Employee employee) {

            return employeeRepository.save(employee);

      }
      public List<Employee> getAllEmployees(){
            return employeeRepository.findAll();
      }

      public void deleteEmployee(Long id){
            if(!employeeRepository.existsById(id)){
                  throw new EntityNotFoundException("employee with  ID " + id + " not found");
            }
            employeeRepository.deleteById(id);
      }
}
