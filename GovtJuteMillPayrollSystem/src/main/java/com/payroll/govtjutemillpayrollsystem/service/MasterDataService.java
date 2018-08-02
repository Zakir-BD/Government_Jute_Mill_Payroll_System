package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.IBasicMasterDAO;
import com.payroll.govtjutemillpayrollsystem.dao.IMasterDataDAO;
import com.payroll.govtjutemillpayrollsystem.domain.BasicMaster;
import com.payroll.govtjutemillpayrollsystem.domain.MasterData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterDataService implements IMasterDataService {

    @Autowired
    private IMasterDataDAO iMasterDataDAO;

    @Override
    public List<MasterData> getAllObject() {
        return iMasterDataDAO.getAllObject();
    }

    @Override
    public MasterData getObjectById(int id) {
        MasterData obj = iMasterDataDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(MasterData obj) {
        if (iMasterDataDAO.objectExists(obj.getBankAc())) {
            return false;
        } else {
            iMasterDataDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(MasterData obj) {
        iMasterDataDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iMasterDataDAO.deleteObject(id);
    }

}
