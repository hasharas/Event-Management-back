package com.codeWithProject.employee.controller;

import org.springframework.web.bind.annotation.*;

import com.codeWithProject.employee.entity.Employee;
import com.codeWithProject.employee.service.EmployeeService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

      private final EmployeeService employeeService;

      @PostMapping("/employee")

      public Employee postEmployee(@RequestBody Employee employee) {

            return employeeService.postEmployee(employee);
      }

      @GetMapping("/employees")
      public List<Employee> getAllEmployees(){
            return employeeService.getAllEmployees();
      }
}