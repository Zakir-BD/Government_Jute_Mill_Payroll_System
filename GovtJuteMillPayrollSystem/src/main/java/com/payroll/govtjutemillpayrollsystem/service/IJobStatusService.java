
package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.JobStatus;
import java.util.List;


public interface IJobStatusService {
    List<JobStatus> getAllObject();

    JobStatus getObjectById(int id);

    boolean addObject(JobStatus obj);

    void updateObject(JobStatus obj);

    void deleteObject(int id);
}
