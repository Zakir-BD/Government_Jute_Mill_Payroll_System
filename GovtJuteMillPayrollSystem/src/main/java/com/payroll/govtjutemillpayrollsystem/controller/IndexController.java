/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payroll.govtjutemillpayrollsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Faculty
 */
//@RestController
@Controller
public class IndexController {
//@RequestMapping("/")
//    public String welcome() {//Welcome page, non-rest
//        //        return "Welcome to RestTemplate Example.";
//        return "index";
//    }
    @RequestMapping(value="/")
    public ModelAndView mHome() {
        ModelAndView mv = new ModelAndView("mHome");
        return mv;
    }
    
    @RequestMapping(value="/mFile")
    public ModelAndView mFile() {
        ModelAndView mv = new ModelAndView("mFile");
        return mv;
    }
    
    @RequestMapping(value="/mMaintain")
    public ModelAndView mMaintain() {
        ModelAndView mv = new ModelAndView("mMaintain");
        return mv;
    }
    
    @RequestMapping(value="/mSalaryTransaction")
    public ModelAndView mSalaryTransaction() {
        ModelAndView mv = new ModelAndView("mSalaryTransaction");
        return mv;
    }
    
    @RequestMapping(value="/mReports")
    public ModelAndView mReports() {
        ModelAndView mv = new ModelAndView("mReports");
        return mv;
    }
    
   
    
    
    
}
