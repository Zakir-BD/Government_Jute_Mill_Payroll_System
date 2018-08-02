package com.payroll.govtjutemillpayrollsystem.controller;

import com.payroll.govtjutemillpayrollsystem.domain.JobStatus;
import com.payroll.govtjutemillpayrollsystem.service.IJobStatusService;
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
@RequestMapping("/jobStatus")
public class JobStatusController {

    @Autowired
    private IJobStatusService jobStatusService;

    @RequestMapping("/home")
    public String home() {
        return "jobStatus";
    }
    
    @RequestMapping(value = "/jobStatus/{id}", method = RequestMethod.GET)
    public ResponseEntity<JobStatus> getObjectById(@PathVariable("id") Integer id) {
        JobStatus jobStatus = jobStatusService.getObjectById(id);
        return new ResponseEntity<JobStatus>(jobStatus, HttpStatus.OK);
    }

    @RequestMapping(value = "/jobStatus", method = RequestMethod.GET)
    public ResponseEntity<List<JobStatus>> getAllObject() {
        List<JobStatus> list = jobStatusService.getAllObject();
        return new ResponseEntity<List<JobStatus>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/jobStatus", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody JobStatus jobStatus, UriComponentsBuilder builder) {
        boolean flag = jobStatusService.addObject(jobStatus);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/jobStatus/{id}").buildAndExpand(jobStatus.getJobStatusId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/jobStatus/{id}", method = RequestMethod.PUT)
    public ResponseEntity<JobStatus> updateObject(@RequestBody JobStatus jobStatus) {
        jobStatusService.updateObject(jobStatus);
        return new ResponseEntity<JobStatus>(jobStatus, HttpStatus.OK);
    }

    @RequestMapping(value = "/jobStatus/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        jobStatusService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    
}
