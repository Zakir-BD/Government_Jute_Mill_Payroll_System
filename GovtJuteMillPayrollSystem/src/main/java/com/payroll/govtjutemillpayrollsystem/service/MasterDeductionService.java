package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.IMasterDeductionDAO;
import com.payroll.govtjutemillpayrollsystem.domain.MasterDeduction;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterDeductionService implements IMasterDeductionService {

    @Autowired
    private IMasterDeductionDAO iMasterDeductionDAO;

    @Override
    public List<MasterDeduction> getAllObject() {
        return iMasterDeductionDAO.getAllObject();
    }

    @Override
    public MasterDeduction getObjectById(int id) {
        MasterDeduction obj = iMasterDeductionDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(MasterDeduction obj) {
        if (iMasterDeductionDAO.objectExists(obj.getMasterData())) {
            return false;
        } else {
            iMasterDeductionDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(MasterDeduction obj) {
        iMasterDeductionDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iMasterDeductionDAO.deleteObject(id);
    }

}
