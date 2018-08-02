
package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.SalaryTranAllowance;
import java.util.List;

public interface ISalaryTranAllowanceDAO {
    List<SalaryTranAllowance> getAllObject();

    SalaryTranAllowance getObjectById(int id);

    void addObject(SalaryTranAllowance obj);

    void updateObject(SalaryTranAllowance obj);

    void deleteObject(int id);

//    boolean objectExists(String jobTypeName);
}
