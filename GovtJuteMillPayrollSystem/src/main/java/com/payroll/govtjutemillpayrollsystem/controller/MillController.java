package com.payroll.govtjutemillpayrollsystem.controller;

import com.payroll.govtjutemillpayrollsystem.domain.Mill;
import com.payroll.govtjutemillpayrollsystem.service.IMillService;
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
@RequestMapping("/mill")
public class MillController {

    @Autowired
    private IMillService millService;

    @RequestMapping("/home")
    public String home() {
        return "mill";
    }

    @RequestMapping(value = "/mill/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mill> getObjectById(@PathVariable("id") Integer id) {
        Mill mill = millService.getObjectById(id);
        return new ResponseEntity<Mill>(mill, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/mill", method = RequestMethod.GET)
    public ResponseEntity<List<Mill>> getAllObject() {
        List<Mill> list = millService.getAllObject();
        return new ResponseEntity<List<Mill>>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/mill", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody Mill mill, UriComponentsBuilder builder) {
        boolean flag = millService.addObject(mill);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/mill/{id}").buildAndExpand(mill.getMillId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/mill/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Mill> updateObject(@RequestBody Mill mill) {
        millService.updateObject(mill);
        return new ResponseEntity<Mill>(mill, HttpStatus.OK);
    }

    @RequestMapping(value = "/mill/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        millService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
