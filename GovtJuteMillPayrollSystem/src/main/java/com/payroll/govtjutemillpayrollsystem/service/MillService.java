package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.IMillDAO;
import com.payroll.govtjutemillpayrollsystem.domain.BasicIncrement;
import com.payroll.govtjutemillpayrollsystem.domain.Mill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MillService implements IMillService {

    @Autowired
    private IMillDAO iMillDAO;

    @Override
    public List<Mill> getAllObject() {
        return iMillDAO.getAllObject();
    }

    @Override
    public Mill getObjectById(int id) {
        Mill obj = iMillDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(Mill obj) {
        if (iMillDAO.objectExists(obj.getMillName())) {
            return false;
        } else {
            iMillDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(Mill obj) {
        iMillDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iMillDAO.deleteObject(id);
    }

}
