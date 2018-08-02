
package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.Designation;
import java.util.List;


public interface IDesignationService {
    List<Designation> getAllObject();

    Designation getObjectById(int id);

    boolean addObject(Designation obj);

    void updateObject(Designation obj);

    void deleteObject(int id);
}
