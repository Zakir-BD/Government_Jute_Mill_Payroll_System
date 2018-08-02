
package com.payroll.govtjutemillpayrollsystem.controller;

import com.payroll.govtjutemillpayrollsystem.domain.BasicGrade;
import com.payroll.govtjutemillpayrollsystem.service.IBasicGradeService;
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
@RequestMapping("/basicGrade")
public class BasicGradeController {
    @Autowired
    private IBasicGradeService basicGradeService;
    
    @RequestMapping("/home")
    public String home() {
        return "basicGrade";
    }

    @RequestMapping(value = "/basicGrade/{id}", method = RequestMethod.GET)
    public ResponseEntity<BasicGrade> getObjectById(@PathVariable("id") Integer id) {
        BasicGrade basicGrade = basicGradeService.getObjectById(id);
        return new ResponseEntity<BasicGrade>(basicGrade, HttpStatus.OK);
    }

    @RequestMapping(value = "/basicGrade", method = RequestMethod.GET)
    public ResponseEntity<List<BasicGrade>> getAllObject() {
        List<BasicGrade> list = basicGradeService.getAllObject();
        return new ResponseEntity<List<BasicGrade>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/basicGrade", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody BasicGrade basicGrade, UriComponentsBuilder builder) {
        boolean flag = basicGradeService.addObject(basicGrade);
        
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
//        System.out.println("addBasicGrade.....................");
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/basicGrade/{id}").buildAndExpand(basicGrade.getGradeId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        
    }

    @RequestMapping(value = "/basicGrade/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BasicGrade> updateObject(@RequestBody BasicGrade basicGrade) {
        basicGradeService.updateObject(basicGrade);
        return new ResponseEntity<BasicGrade>(basicGrade, HttpStatus.OK);
    }

    @RequestMapping(value = "/basicGrade/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        basicGradeService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
