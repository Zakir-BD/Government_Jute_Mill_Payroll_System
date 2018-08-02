package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.ISalaryTranDAO;
import com.payroll.govtjutemillpayrollsystem.domain.BasicMaster;
import com.payroll.govtjutemillpayrollsystem.domain.SalaryTran;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryTranService implements ISalaryTranService {

    @Autowired
    private ISalaryTranDAO iSalaryTranDAO;

    @Override
    public List<SalaryTran> getAllObject() {
        return iSalaryTranDAO.getAllObject();
    }

    @Override
    public SalaryTran getObjectById(int id) {
        SalaryTran obj = iSalaryTranDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(SalaryTran obj) {
        iSalaryTranDAO.addObject(obj);
        return true;
    }

    @Override
    public void updateObject(SalaryTran obj) {
        iSalaryTranDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iSalaryTranDAO.deleteObject(id);
    }

}
