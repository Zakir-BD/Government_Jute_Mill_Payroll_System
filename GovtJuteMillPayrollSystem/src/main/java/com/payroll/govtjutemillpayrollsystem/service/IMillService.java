
package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.Mill;
import java.util.List;


public interface IMillService {
    List<Mill> getAllObject();

    Mill getObjectById(int id);

    boolean addObject(Mill obj);

    void updateObject(Mill obj);

    void deleteObject(int id);
}
