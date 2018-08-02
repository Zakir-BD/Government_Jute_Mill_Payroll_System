package com.payroll.govtjutemillpayrollsystem.controller;

import com.payroll.govtjutemillpayrollsystem.domain.MasterData;
import com.payroll.govtjutemillpayrollsystem.service.IMasterDataService;
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
@RequestMapping("/masterData")
public class MasterDataController {

    @Autowired
    private IMasterDataService masterDataService;

    @RequestMapping("/home")
    public String home() {
        return "masterData";
    }
    
    @RequestMapping(value = "/masterData/{id}", method = RequestMethod.GET)
    public ResponseEntity<MasterData> getObjectById(@PathVariable("id") Integer id) {
        MasterData masterData = masterDataService.getObjectById(id);
        return new ResponseEntity<MasterData>(masterData, HttpStatus.OK);
    }

    @RequestMapping(value = "/masterData", method = RequestMethod.GET)
    public ResponseEntity<List<MasterData>> getAllObject() {
        List<MasterData> list = masterDataService.getAllObject();
        return new ResponseEntity<List<MasterData>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/masterData", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody MasterData masterData, UriComponentsBuilder builder) {
        boolean flag = masterDataService.addObject(masterData);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/masterData/{id}").buildAndExpand(masterData.getEmployeeId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/masterData/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MasterData> updateObject(@RequestBody MasterData masterData) {
        masterDataService.updateObject(masterData);
        return new ResponseEntity<MasterData>(masterData, HttpStatus.OK);
    }

    @RequestMapping(value = "/masterData/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        masterDataService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    
    
}
