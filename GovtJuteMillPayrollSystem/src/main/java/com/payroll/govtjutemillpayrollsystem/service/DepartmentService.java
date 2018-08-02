package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.IDepartmentDAO;
import com.payroll.govtjutemillpayrollsystem.domain.Department;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentDAO iDepartmentDAO;

    @Override
    public List<Department> getAllObject() {
        return iDepartmentDAO.getAllObject();
    }

    @Override
    public Department getObjectById(int id) {
        Department obj = iDepartmentDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(Department obj) {
        if (iDepartmentDAO.objectExists(obj.getDepartmentName())) {
            return false;
        } else {
            iDepartmentDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(Department obj) {
        iDepartmentDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iDepartmentDAO.deleteObject(id);
    }

}
