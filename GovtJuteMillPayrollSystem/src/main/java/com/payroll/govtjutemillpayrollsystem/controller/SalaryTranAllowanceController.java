
package com.payroll.govtjutemillpayrollsystem.controller;

import com.payroll.govtjutemillpayrollsystem.domain.SalaryTranAllowance;
import com.payroll.govtjutemillpayrollsystem.service.ISalaryTranAllowanceService;
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
@RequestMapping("/salaryTranAllowance")
public class SalaryTranAllowanceController {
    @Autowired
    private ISalaryTranAllowanceService salaryTranAllowanceService;

    @RequestMapping("/home")
    public String home() {
        return "salaryTranAllowance";
    }

    @RequestMapping(value = "/salaryTranAllowance/{id}", method = RequestMethod.GET)
    public ResponseEntity<SalaryTranAllowance> getObjectById(@PathVariable("id") Integer id) {
        SalaryTranAllowance salaryTranAllowance = salaryTranAllowanceService.getObjectById(id);
        return new ResponseEntity<SalaryTranAllowance>(salaryTranAllowance, HttpStatus.OK);
    }

    @RequestMapping(value = "/salaryTranAllowance", method = RequestMethod.GET)
    public ResponseEntity<List<SalaryTranAllowance>> getAllObject() {
        List<SalaryTranAllowance> list = salaryTranAllowanceService.getAllObject();
        return new ResponseEntity<List<SalaryTranAllowance>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/salaryTranAllowance", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody SalaryTranAllowance salaryTranAllowance, UriComponentsBuilder builder) {
        boolean flag = salaryTranAllowanceService.addObject(salaryTranAllowance);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/salaryTranAllowance/{id}").buildAndExpand(salaryTranAllowance.getSalaryTranAllowId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/salaryTranAllowance/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SalaryTranAllowance> updateObject(@RequestBody SalaryTranAllowance salaryTranAllowance) {
        salaryTranAllowanceService.updateObject(salaryTranAllowance);
        return new ResponseEntity<SalaryTranAllowance>(salaryTranAllowance, HttpStatus.OK);
    }

    @RequestMapping(value = "/salaryTranAllowance/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        salaryTranAllowanceService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
