
package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.SalaryTranAllowance;
import java.util.List;

public interface ISalaryTranAllowanceService {
    List<SalaryTranAllowance> getAllObject();

    SalaryTranAllowance getObjectById(int id);

    boolean addObject(SalaryTranAllowance obj);

    void updateObject(SalaryTranAllowance obj);

    void deleteObject(int id);
}
