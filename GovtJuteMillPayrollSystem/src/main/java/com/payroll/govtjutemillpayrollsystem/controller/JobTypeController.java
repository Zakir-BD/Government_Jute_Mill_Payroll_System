package com.payroll.govtjutemillpayrollsystem.controller;

import com.payroll.govtjutemillpayrollsystem.domain.JobType;
import com.payroll.govtjutemillpayrollsystem.service.IJobTypeService;
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
@RequestMapping("/jobType")
public class JobTypeController {

    @Autowired
    private IJobTypeService jobTypeService;

    @RequestMapping("/home")
    public String home() {
        return "jobType";
    }

    @RequestMapping(value = "/jobType/{id}", method = RequestMethod.GET)
    public ResponseEntity<JobType> getObjectById(@PathVariable("id") Integer id) {
        JobType jobType = jobTypeService.getObjectById(id);
        return new ResponseEntity<JobType>(jobType, HttpStatus.OK);
    }

    @RequestMapping(value = "/jobType", method = RequestMethod.GET)
    public ResponseEntity<List<JobType>> getAllObject() {
        List<JobType> list = jobTypeService.getAllObject();
        return new ResponseEntity<List<JobType>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/jobType", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody JobType jobType, UriComponentsBuilder builder) {
        boolean flag = jobTypeService.addObject(jobType);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/jobType/{id}").buildAndExpand(jobType.getJobTypeId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/jobType/{id}", method = RequestMethod.PUT)
    public ResponseEntity<JobType> updateObject(@RequestBody JobType jobType) {
        jobTypeService.updateObject(jobType);
        return new ResponseEntity<JobType>(jobType, HttpStatus.OK);
    }

    @RequestMapping(value = "/jobType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        jobTypeService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
