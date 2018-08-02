package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.ISalaryTranDeductionDAO;
import com.payroll.govtjutemillpayrollsystem.domain.SalaryTranAllowance;
import com.payroll.govtjutemillpayrollsystem.domain.SalaryTranDeduction;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryTranDeductionService implements ISalaryTranDeductionService {

    @Autowired
    private ISalaryTranDeductionDAO iSalaryTranDeductionDAO;

    @Override
    public List<SalaryTranDeduction> getAllObject() {
        return iSalaryTranDeductionDAO.getAllObject();
    }

    @Override
    public SalaryTranDeduction getObjectById(int id) {
        SalaryTranDeduction obj = iSalaryTranDeductionDAO.getObjectById(id);
        return obj;
    }

    @Override
    public boolean addObject(SalaryTranDeduction obj) {
        iSalaryTranDeductionDAO.addObject(obj);
        return true;
    }

    @Override
    public void updateObject(SalaryTranDeduction obj) {
        iSalaryTranDeductionDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iSalaryTranDeductionDAO.deleteObject(id);
    }

}
