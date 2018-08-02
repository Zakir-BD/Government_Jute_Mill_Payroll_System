
package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.MasterData;
import com.payroll.govtjutemillpayrollsystem.domain.MasterDeduction;
import java.util.List;

public interface IMasterDeductionDAO {
    List<MasterDeduction> getAllObject();

    MasterDeduction getObjectById(int id);

    void addObject(MasterDeduction obj);

    void updateObject(MasterDeduction obj);

    void deleteObject(int id);

    boolean objectExists(MasterData masterData);
}
