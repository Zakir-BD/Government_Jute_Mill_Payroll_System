package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.IBasicMasterDAO;
import com.payroll.govtjutemillpayrollsystem.domain.BasicMaster;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicMasterService implements IBasicMasterService {

    @Autowired
    private IBasicMasterDAO iBasicMasterDAO;

    @Override
    public List<BasicMaster> getAllObject() {
        return iBasicMasterDAO.getAllObject();
    }

    @Override
    public BasicMaster getObjectById(int id) {
        BasicMaster obj = iBasicMasterDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(BasicMaster obj) {
        if (iBasicMasterDAO.objectExists(obj.getBasicMain())) {
            return false;
        } else {
            iBasicMasterDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(BasicMaster obj) {
        iBasicMasterDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iBasicMasterDAO.deleteObject(id);
    }

}
