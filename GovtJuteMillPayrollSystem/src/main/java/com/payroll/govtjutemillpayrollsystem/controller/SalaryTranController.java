package com.payroll.govtjutemillpayrollsystem.controller;

import com.payroll.govtjutemillpayrollsystem.domain.SalaryTran;
import com.payroll.govtjutemillpayrollsystem.service.ISalaryTranService;
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
@RequestMapping("/salaryTran")
public class SalaryTranController {

    @Autowired
    private ISalaryTranService salaryTranService;

    @RequestMapping("/home")
    public String home() {
        return "salaryTran";
    }

    @RequestMapping(value = "/salaryTran/{id}", method = RequestMethod.GET)
    public ResponseEntity<SalaryTran> getObjectById(@PathVariable("id") Integer id) {
        SalaryTran salaryTran = salaryTranService.getObjectById(id);
        return new ResponseEntity<SalaryTran>(salaryTran, HttpStatus.OK);
    }

    @RequestMapping(value = "/salaryTran", method = RequestMethod.GET)
    public ResponseEntity<List<SalaryTran>> getAllObject() {
        List<SalaryTran> list = salaryTranService.getAllObject();
        return new ResponseEntity<List<SalaryTran>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/salaryTran", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody SalaryTran salaryTran, UriComponentsBuilder builder) {
        boolean flag = salaryTranService.addObject(salaryTran);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/salaryTran/{id}").buildAndExpand(salaryTran.getSalaryTranId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/salaryTran/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SalaryTran> updateObject(@RequestBody SalaryTran salaryTran) {
        salaryTranService.updateObject(salaryTran);
        return new ResponseEntity<SalaryTran>(salaryTran, HttpStatus.OK);
    }

    @RequestMapping(value = "/salaryTran/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        salaryTranService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
