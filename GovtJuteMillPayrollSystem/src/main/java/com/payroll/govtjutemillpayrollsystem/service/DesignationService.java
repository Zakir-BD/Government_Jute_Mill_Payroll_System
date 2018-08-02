package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.IDesignationDAO;
import com.payroll.govtjutemillpayrollsystem.domain.Designation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesignationService implements IDesignationService {

    @Autowired
    private IDesignationDAO iDesignationDAO;

    @Override
    public List<Designation> getAllObject() {
        return iDesignationDAO.getAllObject();
    }

    @Override
    public Designation getObjectById(int id) {
        Designation obj = iDesignationDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(Designation obj) {
        if (iDesignationDAO.objectExists(obj.getDesignationName())) {
            return false;
        } else {
            iDesignationDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(Designation obj) {
        iDesignationDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iDesignationDAO.deleteObject(id);
    }

}
