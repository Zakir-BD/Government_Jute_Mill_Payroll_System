package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.IJobStatusDAO;
import com.payroll.govtjutemillpayrollsystem.dao.ISalaryStatusDAO;
import com.payroll.govtjutemillpayrollsystem.domain.JobStatus;
import com.payroll.govtjutemillpayrollsystem.domain.SalaryStatus;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryStatusService implements ISalaryStatusService {

    @Autowired
    private ISalaryStatusDAO iSalaryStatusDAO;

    @Override
    public List<SalaryStatus> getAllObject() {
        return iSalaryStatusDAO.getAllObject();
    }

    @Override
    public SalaryStatus getObjectById(int id) {
        SalaryStatus obj = iSalaryStatusDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(SalaryStatus obj) {
        if (iSalaryStatusDAO.objectExists(obj.getSalaryStatusName())) {
            return false;
        } else {
            iSalaryStatusDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(SalaryStatus obj) {
        iSalaryStatusDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iSalaryStatusDAO.deleteObject(id);
    }

}
