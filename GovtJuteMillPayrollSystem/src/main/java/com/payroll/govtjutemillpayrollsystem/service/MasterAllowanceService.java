package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.IMasterAllowanceDAO;
import com.payroll.govtjutemillpayrollsystem.domain.MasterAllowance;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterAllowanceService implements IMasterAllowanceService {

    @Autowired
    private IMasterAllowanceDAO iMasterAllowanceDAO;

    @Override
    public List<MasterAllowance> getAllObject() {
        return iMasterAllowanceDAO.getAllObject();
    }

    @Override
    public MasterAllowance getObjectById(int id) {
        MasterAllowance obj = iMasterAllowanceDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(MasterAllowance obj) {
        if (iMasterAllowanceDAO.objectExists(obj.getMasterData())) {
            return false;
        } else {
            iMasterAllowanceDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(MasterAllowance obj) {
        iMasterAllowanceDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iMasterAllowanceDAO.deleteObject(id);
    }

}
