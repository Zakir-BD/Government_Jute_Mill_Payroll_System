package com.payroll.govtjutemillpayrollsystem.controller;

import com.payroll.govtjutemillpayrollsystem.domain.Designation;
import com.payroll.govtjutemillpayrollsystem.service.IDesignationService;
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
@RequestMapping("/designation")
public class DesignationController {

    @Autowired
    private IDesignationService designationService;

    @RequestMapping("/home")
    public String home() {
        return "designation";
    }
    
    @RequestMapping(value = "/designation/{id}", method = RequestMethod.GET)
    public ResponseEntity<Designation> getObjectById(@PathVariable("id") Integer id) {
        Designation designation = designationService.getObjectById(id);
        return new ResponseEntity<Designation>(designation, HttpStatus.OK);
    }

    @RequestMapping(value = "/designation", method = RequestMethod.GET)
    public ResponseEntity<List<Designation>> getAllObject() {
        List<Designation> list = designationService.getAllObject();
        return new ResponseEntity<List<Designation>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/designation", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody Designation designation, UriComponentsBuilder builder) {
        boolean flag = designationService.addObject(designation);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/designation/{id}").buildAndExpand(designation.getDesignationId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/designation/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Designation> updateObject(@RequestBody Designation designation) {
        designationService.updateObject(designation);
        return new ResponseEntity<Designation>(designation, HttpStatus.OK);
    }

    @RequestMapping(value = "/designation/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        designationService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    
}
