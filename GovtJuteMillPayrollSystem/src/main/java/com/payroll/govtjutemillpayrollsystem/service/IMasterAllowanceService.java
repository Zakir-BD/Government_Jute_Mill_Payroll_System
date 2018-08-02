
package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.MasterAllowance;
import java.util.List;

public interface IMasterAllowanceService {
    List<MasterAllowance> getAllObject();

    MasterAllowance getObjectById(int id);

    boolean addObject(MasterAllowance obj);

    void updateObject(MasterAllowance obj);

    void deleteObject(int id);
}
