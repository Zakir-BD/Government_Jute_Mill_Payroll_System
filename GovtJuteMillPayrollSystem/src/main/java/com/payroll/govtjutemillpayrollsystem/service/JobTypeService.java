package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.IJobTypeDAO;
import com.payroll.govtjutemillpayrollsystem.domain.JobType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobTypeService implements IJobTypeService {

    @Autowired
    private IJobTypeDAO iJobTypeDAO;

    @Override
    public List<JobType> getAllObject() {
        return iJobTypeDAO.getAllObject();
    }

    @Override
    public JobType getObjectById(int id) {
        JobType obj = iJobTypeDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(JobType obj) {
        if (iJobTypeDAO.objectExists(obj.getJobTypeName())) {
            return false;
        } else {
            iJobTypeDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(JobType obj) {
        iJobTypeDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iJobTypeDAO.deleteObject(id);
    }

}
