
package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.BasicIncrement;
import java.util.List;

public interface IBasicIncrementService {
    List<BasicIncrement> getAllObject();

    BasicIncrement getObjectById(int id);

    boolean addObject(BasicIncrement obj);

    void updateObject(BasicIncrement obj);

    void deleteObject(int id);
}
