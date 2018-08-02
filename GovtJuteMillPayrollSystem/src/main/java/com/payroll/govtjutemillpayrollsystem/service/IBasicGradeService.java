
package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.BasicGrade;
import java.util.List;


public interface IBasicGradeService {
    List<BasicGrade> getAllObject();

    BasicGrade getObjectById(int id);

    boolean addObject(BasicGrade obj);

    void updateObject(BasicGrade obj);

    void deleteObject(int id);
}
