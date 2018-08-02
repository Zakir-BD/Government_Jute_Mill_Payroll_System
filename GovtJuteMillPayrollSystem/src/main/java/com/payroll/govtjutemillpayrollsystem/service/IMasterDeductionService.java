package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.MasterDeduction;
import java.util.List;

public interface IMasterDeductionService {

    List<MasterDeduction> getAllObject();

    MasterDeduction getObjectById(int id);

    boolean addObject(MasterDeduction obj);

    void updateObject(MasterDeduction obj);

    void deleteObject(int id);
}
