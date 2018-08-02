
package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.BasicMaster;
import java.util.List;


public interface IBasicMasterDAO {
    List<BasicMaster> getAllObject();

    BasicMaster getObjectById(int id);

    void addObject(BasicMaster obj);

    void updateObject(BasicMaster obj);

    void deleteObject(int id);

    boolean objectExists(Double basicMain);
}
