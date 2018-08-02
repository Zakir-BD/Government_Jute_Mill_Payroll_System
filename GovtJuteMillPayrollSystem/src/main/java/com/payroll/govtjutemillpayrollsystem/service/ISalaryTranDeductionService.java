package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.SalaryTranDeduction;
import java.util.List;

public interface ISalaryTranDeductionService {

    List<SalaryTranDeduction> getAllObject();

    SalaryTranDeduction getObjectById(int id);

    boolean addObject(SalaryTranDeduction obj);

    void updateObject(SalaryTranDeduction obj);

    void deleteObject(int id);
}
