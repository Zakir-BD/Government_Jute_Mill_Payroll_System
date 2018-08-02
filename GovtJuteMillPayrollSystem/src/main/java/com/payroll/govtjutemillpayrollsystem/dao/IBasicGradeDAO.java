/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.BasicGrade;
import java.util.List;


public interface IBasicGradeDAO {

    List<BasicGrade> getAllObject();

    BasicGrade getObjectById(int id);

    void addObject(BasicGrade obj);

    void updateObject(BasicGrade obj);

    void deleteObject(int id);

    boolean objectExists(Double scaleStart);
}
