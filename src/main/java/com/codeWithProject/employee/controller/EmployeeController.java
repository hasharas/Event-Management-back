package com.codeWithProject.employee.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

      @DeleteMapping("/employee/{id}")
      public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
            try{
                  employeeService.deleteEmployee(id);
                  return new ResponseEntity<>("Employee with ID " + id + " delete successfully", HttpStatus.OK);
            }catch (EntityNotFoundException e){
                  return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
            }
      }

      public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
            Employee employee = employeeService.getEmployeeById(id);
            if(employee == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(employee);
      }
}