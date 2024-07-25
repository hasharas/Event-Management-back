package com.codeWithProject.employee.service;

import org.springframework.stereotype.Service;

import com.codeWithProject.employee.entity.Employee;
import com.codeWithProject.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class EmployeeService {

      private final EmployeeRepository employeeRepository;

      public Employee postEmployee(Employee employee) {

            return employeeRepository.save(employee);
      }
}
