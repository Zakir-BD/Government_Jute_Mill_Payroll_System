package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.IBasicIncrementDAO;
import com.payroll.govtjutemillpayrollsystem.domain.BasicIncrement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicIncrementService implements IBasicIncrementService {

    @Autowired
    private IBasicIncrementDAO iBasicIncrementDAO;

    @Override
    public List<BasicIncrement> getAllObject() {
        return iBasicIncrementDAO.getAllObject();
    }

    @Override
    public BasicIncrement getObjectById(int id) {
        BasicIncrement obj = iBasicIncrementDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(BasicIncrement obj) {
        if (iBasicIncrementDAO.objectExists(obj.getIncrementName())) {
            return false;
        } else {
            iBasicIncrementDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(BasicIncrement obj) {
        iBasicIncrementDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iBasicIncrementDAO.deleteObject(id);
    }

}
