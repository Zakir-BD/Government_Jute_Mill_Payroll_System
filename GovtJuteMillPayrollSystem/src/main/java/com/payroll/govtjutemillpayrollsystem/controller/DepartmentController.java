package com.payroll.govtjutemillpayrollsystem.controller;

import com.payroll.govtjutemillpayrollsystem.domain.Department;
import com.payroll.govtjutemillpayrollsystem.service.IDepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/home")
    public String home() {
        return "department";
    }

    @RequestMapping(value = "/department/{id}", method = RequestMethod.GET)
    public ResponseEntity<Department> getObjectById(@PathVariable("id") Integer id) {
        Department department = departmentService.getObjectById(id);
        return new ResponseEntity<Department>(department, HttpStatus.OK);
    }

    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public ResponseEntity<List<Department>> getAllObject() {
        List<Department> list = departmentService.getAllObject();
        return new ResponseEntity<List<Department>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody Department department, UriComponentsBuilder builder) {
        boolean flag = departmentService.addObject(department);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/department/{id}").buildAndExpand(department.getDepartmentId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/department/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Department> updateObject(@RequestBody Department department) {
        departmentService.updateObject(department);
        return new ResponseEntity<Department>(department, HttpStatus.OK);
    }

    @RequestMapping(value = "/department/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        departmentService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
