package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.IJobStatusDAO;
import com.payroll.govtjutemillpayrollsystem.domain.JobStatus;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobStatusService implements IJobStatusService {

    @Autowired
    private IJobStatusDAO iJobStatusDAO;

    @Override
    public List<JobStatus> getAllObject() {
        return iJobStatusDAO.getAllObject();
    }

    @Override
    public JobStatus getObjectById(int id) {
        JobStatus obj = iJobStatusDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(JobStatus obj) {
        if (iJobStatusDAO.objectExists(obj.getJobStatusName())) {
            return false;
        } else {
            iJobStatusDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(JobStatus obj) {
        iJobStatusDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iJobStatusDAO.deleteObject(id);
    }

}
