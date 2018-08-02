package com.payroll.govtjutemillpayrollsystem.controller;

import com.payroll.govtjutemillpayrollsystem.domain.BasicMaster;
import com.payroll.govtjutemillpayrollsystem.service.IBasicMasterService;
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
@RequestMapping("/basicMaster")
public class BasicMasterController {

    @Autowired
    private IBasicMasterService basicMasterService;

    @RequestMapping("/home")
    public String home() {
        return "basicMaster";
    }

    @RequestMapping(value = "/basicMaster/{id}", method = RequestMethod.GET)
    public ResponseEntity<BasicMaster> getObjectById(@PathVariable("id") Integer id) {
        BasicMaster basicMaster = basicMasterService.getObjectById(id);
        return new ResponseEntity<BasicMaster>(basicMaster, HttpStatus.OK);
    }

    @RequestMapping(value = "/basicMaster", method = RequestMethod.GET)
    public ResponseEntity<List<BasicMaster>> getAllObject() {
        List<BasicMaster> list = basicMasterService.getAllObject();
        return new ResponseEntity<List<BasicMaster>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/basicMaster", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody BasicMaster basicMaster, UriComponentsBuilder builder) {
        boolean flag = basicMasterService.addObject(basicMaster);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/basicMaster/{id}").buildAndExpand(basicMaster.getBasicId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/basicMaster/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BasicMaster> updateObject(@RequestBody BasicMaster basicMaster) {
        basicMasterService.updateObject(basicMaster);
        return new ResponseEntity<BasicMaster>(basicMaster, HttpStatus.OK);
    }

    @RequestMapping(value = "/basicMaster/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        basicMasterService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
