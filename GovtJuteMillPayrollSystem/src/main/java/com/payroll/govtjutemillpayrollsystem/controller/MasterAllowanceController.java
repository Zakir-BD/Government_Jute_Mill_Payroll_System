package com.payroll.govtjutemillpayrollsystem.controller;

import com.payroll.govtjutemillpayrollsystem.domain.MasterAllowance;
import com.payroll.govtjutemillpayrollsystem.service.IMasterAllowanceService;
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
@RequestMapping("/masterAllowance")
public class MasterAllowanceController {

    @Autowired
    private IMasterAllowanceService masterAllowanceService;

    @RequestMapping("/home")
    public String home() {
        return "masterAllowance";
    }

    @RequestMapping(value = "/masterAllowance/{id}", method = RequestMethod.GET)
    public ResponseEntity<MasterAllowance> getObjectById(@PathVariable("id") Integer id) {
        MasterAllowance masterAllowance = masterAllowanceService.getObjectById(id);
        return new ResponseEntity<MasterAllowance>(masterAllowance, HttpStatus.OK);
    }

    @RequestMapping(value = "/masterAllowance", method = RequestMethod.GET)
    public ResponseEntity<List<MasterAllowance>> getAllObject() {
        List<MasterAllowance> list = masterAllowanceService.getAllObject();
        return new ResponseEntity<List<MasterAllowance>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/masterAllowance", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody MasterAllowance masterAllowance, UriComponentsBuilder builder) {
        boolean flag = masterAllowanceService.addObject(masterAllowance);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/masterAllowance/{id}").buildAndExpand(masterAllowance.getMasterAllowanceId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/masterAllowance/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MasterAllowance> updateObject(@RequestBody MasterAllowance masterAllowance) {
        masterAllowanceService.updateObject(masterAllowance);
        return new ResponseEntity<MasterAllowance>(masterAllowance, HttpStatus.OK);
    }

    @RequestMapping(value = "/masterAllowance/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        masterAllowanceService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
