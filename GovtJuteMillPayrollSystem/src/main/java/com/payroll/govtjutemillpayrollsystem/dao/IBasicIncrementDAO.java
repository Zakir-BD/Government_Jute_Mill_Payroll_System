
package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.BasicIncrement;
import java.util.List;


public interface IBasicIncrementDAO {
    List<BasicIncrement> getAllObject();

    BasicIncrement getObjectById(int id);

    void addObject(BasicIncrement obj);

    void updateObject(BasicIncrement obj);

    void deleteObject(int id);

    boolean objectExists(int incrementName);
}
