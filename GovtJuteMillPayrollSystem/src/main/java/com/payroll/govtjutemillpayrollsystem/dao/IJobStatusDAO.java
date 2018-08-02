
package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.JobStatus;
import java.util.List;


public interface IJobStatusDAO {
    List<JobStatus> getAllObject();

    JobStatus getObjectById(int id);

    void addObject(JobStatus obj);

    void updateObject(JobStatus obj);

    void deleteObject(int id);

    boolean objectExists(String jobStatusName);
}
