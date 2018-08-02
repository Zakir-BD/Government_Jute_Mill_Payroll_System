package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.SalaryTranDeduction;
import java.util.List;

public interface ISalaryTranDeductionDAO {

    List<SalaryTranDeduction> getAllObject();

    SalaryTranDeduction getObjectById(int id);

    void addObject(SalaryTranDeduction obj);

    void updateObject(SalaryTranDeduction obj);

    void deleteObject(int id);

//    boolean objectExists(String jobTypeName);
}
