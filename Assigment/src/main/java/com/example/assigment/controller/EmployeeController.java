package com.example.assigment.controller;

import com.example.assigment.entity.Employee;
import com.example.assigment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getAll(){
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,path = "{name}")
    public Employee findByName(@PathVariable String name){
        return repository.findByName(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee save(@RequestBody Employee emp){
        return repository.save(emp);
    }

    @RequestMapping(method = RequestMethod.PUT,path = "{id}")
    public Employee edit(@PathVariable int id,@RequestBody Employee emp){
        Employee employee = repository.getById(id);
        if (employee == null){
            return null;
        }
        employee.setName(emp.getName());
        employee.setAge(emp.getAge());
        employee.setSalary(emp.getSalary());
        return repository.save(employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public boolean delete(@PathVariable int id){
        Employee exist = repository.getById(id);
        if (exist == null){
            return false;
        }
        repository.delete(exist);
        return true;
    }
}
