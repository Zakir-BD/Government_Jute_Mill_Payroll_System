package com.payroll.govtjutemillpayrollsystem.controller;

import com.payroll.govtjutemillpayrollsystem.domain.MasterDeduction;
import com.payroll.govtjutemillpayrollsystem.service.IMasterDeductionService;
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
@RequestMapping("/masterDeduction")
public class MasterDeductionController {

    @Autowired
    private IMasterDeductionService masterDeductionService;

    @RequestMapping("/home")
    public String home() {
        return "masterDeduction";
    }
    
    
    @RequestMapping(value = "/masterDeduction/{id}", method = RequestMethod.GET)
    public ResponseEntity<MasterDeduction> getObjectById(@PathVariable("id") Integer id) {
        MasterDeduction masterDeduction = masterDeductionService.getObjectById(id);
        return new ResponseEntity<MasterDeduction>(masterDeduction, HttpStatus.OK);
    }

    @RequestMapping(value = "/masterDeduction", method = RequestMethod.GET)
    public ResponseEntity<List<MasterDeduction>> getAllObject() {
        List<MasterDeduction> list = masterDeductionService.getAllObject();
        return new ResponseEntity<List<MasterDeduction>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/masterDeduction", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody MasterDeduction masterDeduction, UriComponentsBuilder builder) {
        boolean flag = masterDeductionService.addObject(masterDeduction);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/masterDeduction/{id}").buildAndExpand(masterDeduction.getMasterDeductionId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/masterDeduction/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MasterDeduction> updateObject(@RequestBody MasterDeduction masterDeduction) {
        masterDeductionService.updateObject(masterDeduction);
        return new ResponseEntity<MasterDeduction>(masterDeduction, HttpStatus.OK);
    }

    @RequestMapping(value = "/masterDeduction/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        masterDeductionService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}
