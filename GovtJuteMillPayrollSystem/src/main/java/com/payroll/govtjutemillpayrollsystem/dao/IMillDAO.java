
package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.Mill;
import java.util.List;


public interface IMillDAO {
    List<Mill> getAllObject();

    Mill getObjectById(int id);

    void addObject(Mill obj);

    void updateObject(Mill obj);

    void deleteObject(int id);

    boolean objectExists(String millName);
}
