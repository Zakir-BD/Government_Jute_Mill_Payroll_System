
package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.Designation;
import java.util.List;


public interface IDesignationDAO {
    List<Designation> getAllObject();

    Designation getObjectById(int id);

    void addObject(Designation obj);

    void updateObject(Designation obj);

    void deleteObject(int id);

    boolean objectExists(String designationName);
}
