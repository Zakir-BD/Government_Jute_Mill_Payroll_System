
package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.MasterAllowance;
import com.payroll.govtjutemillpayrollsystem.domain.MasterData;
import java.util.List;

public interface IMasterAllowanceDAO {
    List<MasterAllowance> getAllObject();

    MasterAllowance getObjectById(int id);

    void addObject(MasterAllowance obj);

    void updateObject(MasterAllowance obj);

    void deleteObject(int id);

    boolean objectExists(MasterData masterData);
}
