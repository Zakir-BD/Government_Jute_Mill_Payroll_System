package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.Department;
import java.util.List;

public interface IDepartmentService {

    List<Department> getAllObject();

    Department getObjectById(int id);

    boolean addObject(Department obj);

    void updateObject(Department obj);

    void deleteObject(int id);
}
