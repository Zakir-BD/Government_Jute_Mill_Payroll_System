
package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.JobType;
import java.util.List;


public interface IJobTypeService {
    List<JobType> getAllObject();

    JobType getObjectById(int id);

    boolean addObject(JobType obj);

    void updateObject(JobType obj);

    void deleteObject(int id);
}
