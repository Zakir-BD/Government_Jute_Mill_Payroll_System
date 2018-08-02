package com.payroll.govtjutemillpayrollsystem.controller;

import com.payroll.govtjutemillpayrollsystem.domain.SalaryStatus;
import com.payroll.govtjutemillpayrollsystem.service.ISalaryStatusService;
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
@RequestMapping("/salaryStatus")
public class SalaryStatusController {

    @Autowired
    private ISalaryStatusService salaryStatusService;

    @RequestMapping("/home")
    public String home() {
        return "salaryStatus";
    }
    
    @RequestMapping(value = "/salaryStatus/{id}", method = RequestMethod.GET)
    public ResponseEntity<SalaryStatus> getObjectById(@PathVariable("id") Integer id) {
        SalaryStatus salaryStatus = salaryStatusService.getObjectById(id);
        return new ResponseEntity<SalaryStatus>(salaryStatus, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/salaryStatus", method = RequestMethod.GET)
    public ResponseEntity<List<SalaryStatus>> getAllObject() {
        List<SalaryStatus> list = salaryStatusService.getAllObject();
        return new ResponseEntity<List<SalaryStatus>>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/salaryStatus", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody SalaryStatus salaryStatus, UriComponentsBuilder builder) {
        boolean flag = salaryStatusService.addObject(salaryStatus);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/salaryStatus/{id}").buildAndExpand(salaryStatus.getSalaryStatusId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/salaryStatus/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SalaryStatus> updateObject(@RequestBody SalaryStatus salaryStatus) {
        salaryStatusService.updateObject(salaryStatus);
        return new ResponseEntity<SalaryStatus>(salaryStatus, HttpStatus.OK);
    }

    @RequestMapping(value = "/salaryStatus/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        salaryStatusService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    
    
}
