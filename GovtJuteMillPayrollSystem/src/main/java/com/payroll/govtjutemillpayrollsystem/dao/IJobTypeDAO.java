package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.JobType;
import java.util.List;

public interface IJobTypeDAO {

    List<JobType> getAllObject();

    JobType getObjectById(int id);

    void addObject(JobType obj);

    void updateObject(JobType obj);

    void deleteObject(int id);

    boolean objectExists(String jobTypeName);
}
