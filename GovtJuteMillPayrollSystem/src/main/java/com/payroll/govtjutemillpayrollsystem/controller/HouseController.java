package com.payroll.govtjutemillpayrollsystem.controller;

import com.payroll.govtjutemillpayrollsystem.domain.House;
import com.payroll.govtjutemillpayrollsystem.service.IHouseService;
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
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private IHouseService houseService;

    @RequestMapping("/home")
    public String home() {
        return "house";
    }

    @RequestMapping(value = "/house/{id}", method = RequestMethod.GET)
    public ResponseEntity<House> getObjectById(@PathVariable("id") Integer id) {
        House house = houseService.getObjectById(id);
        return new ResponseEntity<House>(house, HttpStatus.OK);
    }

    @RequestMapping(value = "/house", method = RequestMethod.GET)
    public ResponseEntity<List<House>> getAllObject() {
        List<House> list = houseService.getAllObject();
        return new ResponseEntity<List<House>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/house", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody House house, UriComponentsBuilder builder) {
        boolean flag = houseService.addObject(house);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/house/{id}").buildAndExpand(house.getHouseId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/house/{id}", method = RequestMethod.PUT)
    public ResponseEntity<House> updateObject(@RequestBody House house) {
        houseService.updateObject(house);
        return new ResponseEntity<House>(house, HttpStatus.OK);
    }

    @RequestMapping(value = "/house/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        houseService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
