package com.payroll.govtjutemillpayrollsystem.controller;

import com.payroll.govtjutemillpayrollsystem.domain.SalaryTranDeduction;
import com.payroll.govtjutemillpayrollsystem.service.ISalaryTranDeductionService;
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
@RequestMapping("/salaryTranDeduction")
public class SalaryTranDeductionController {

    @Autowired
    private ISalaryTranDeductionService salaryTranDeductionService;

    @RequestMapping("/home")
    public String home() {
        return "salaryTranDeduction";
    }

    @RequestMapping(value = "/salaryTranDeduction/{id}", method = RequestMethod.GET)
    public ResponseEntity<SalaryTranDeduction> getObjectById(@PathVariable("id") Integer id) {
        SalaryTranDeduction salaryTranDeduction = salaryTranDeductionService.getObjectById(id);
        return new ResponseEntity<SalaryTranDeduction>(salaryTranDeduction, HttpStatus.OK);
    }

    @RequestMapping(value = "/salaryTranDeduction", method = RequestMethod.GET)
    public ResponseEntity<List<SalaryTranDeduction>> getAllObject() {
        List<SalaryTranDeduction> list = salaryTranDeductionService.getAllObject();
        return new ResponseEntity<List<SalaryTranDeduction>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/salaryTranDeduction", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody SalaryTranDeduction salaryTranDeduction, UriComponentsBuilder builder) {
        boolean flag = salaryTranDeductionService.addObject(salaryTranDeduction);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/salaryTranDeduction/{id}").buildAndExpand(salaryTranDeduction.getSalaryTranDedId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/salaryTranDeduction/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SalaryTranDeduction> updateObject(@RequestBody SalaryTranDeduction salaryTranDeduction) {
        salaryTranDeductionService.updateObject(salaryTranDeduction);
        return new ResponseEntity<SalaryTranDeduction>(salaryTranDeduction, HttpStatus.OK);
    }

    @RequestMapping(value = "/salaryTranDeduction/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        salaryTranDeductionService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
