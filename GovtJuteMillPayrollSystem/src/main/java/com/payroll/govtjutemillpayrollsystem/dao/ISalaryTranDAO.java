
package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.SalaryTran;
import java.util.List;

public interface ISalaryTranDAO {
    List<SalaryTran> getAllObject();

    SalaryTran getObjectById(int id);

    void addObject(SalaryTran obj);

    void updateObject(SalaryTran obj);

    void deleteObject(int id);

//    boolean objectExists(Double basicMain);
}
