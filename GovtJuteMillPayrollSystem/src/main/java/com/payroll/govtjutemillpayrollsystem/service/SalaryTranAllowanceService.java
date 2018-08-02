package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.ISalaryTranAllowanceDAO;
import com.payroll.govtjutemillpayrollsystem.domain.SalaryTranAllowance;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryTranAllowanceService implements ISalaryTranAllowanceService {

    @Autowired
    private ISalaryTranAllowanceDAO iSalaryTranAllowanceDAO;

    @Override
    public List<SalaryTranAllowance> getAllObject() {
        return iSalaryTranAllowanceDAO.getAllObject();
    }

    @Override
    public SalaryTranAllowance getObjectById(int id) {
        SalaryTranAllowance obj = iSalaryTranAllowanceDAO.getObjectById(id);
        return obj;
    }

    @Override
    public boolean addObject(SalaryTranAllowance obj) {
        iSalaryTranAllowanceDAO.addObject(obj);
        return true;
    }

    @Override
    public void updateObject(SalaryTranAllowance obj) {
        iSalaryTranAllowanceDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iSalaryTranAllowanceDAO.deleteObject(id);
    }

}
