package com.payroll.govtjutemillpayrollsystem.controller;

import com.payroll.govtjutemillpayrollsystem.domain.BasicIncrement;
import com.payroll.govtjutemillpayrollsystem.service.IBasicIncrementService;
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
@RequestMapping("/basicIncrement")
public class BasicIncrementController {

    @Autowired
    private IBasicIncrementService basicIncrementService;

    @RequestMapping("/home")
    public String home() {
        return "basicIncrement";
    }

    @RequestMapping(value = "/basicIncrement/{id}", method = RequestMethod.GET)
    public ResponseEntity<BasicIncrement> getObjectById(@PathVariable("id") Integer id) {
        BasicIncrement basicIncrement = basicIncrementService.getObjectById(id);
        return new ResponseEntity<BasicIncrement>(basicIncrement, HttpStatus.OK);
    }

    @RequestMapping(value = "/basicIncrement", method = RequestMethod.GET)
    public ResponseEntity<List<BasicIncrement>> getAllObject() {
        List<BasicIncrement> list = basicIncrementService.getAllObject();
        return new ResponseEntity<List<BasicIncrement>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/basicIncrement", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody BasicIncrement basicIncrement, UriComponentsBuilder builder) {
        boolean flag = basicIncrementService.addObject(basicIncrement);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/basicIncrement/{id}").buildAndExpand(basicIncrement.getIncrementId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/basicIncrement/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BasicIncrement> updateObject(@RequestBody BasicIncrement basicIncrement) {
        basicIncrementService.updateObject(basicIncrement);
        return new ResponseEntity<BasicIncrement>(basicIncrement, HttpStatus.OK);
    }

    @RequestMapping(value = "/basicIncrement/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        basicIncrementService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
