package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.Department;
import java.util.List;

public interface IDepartmentDAO {

    List<Department> getAllObject();

    Department getObjectById(int id);

    void addObject(Department obj);

    void updateObject(Department obj);

    void deleteObject(int id);

    boolean objectExists(String departmentName);
}
