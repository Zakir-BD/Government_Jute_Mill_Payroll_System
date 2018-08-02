package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.SalaryTran;
import java.util.List;

public interface ISalaryTranService {

    List<SalaryTran> getAllObject();

    SalaryTran getObjectById(int id);

    boolean addObject(SalaryTran obj);

    void updateObject(SalaryTran obj);

    void deleteObject(int id);
}
