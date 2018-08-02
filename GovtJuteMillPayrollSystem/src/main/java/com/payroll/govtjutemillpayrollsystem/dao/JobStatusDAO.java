package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.JobStatus;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class JobStatusDAO implements IJobStatusDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<JobStatus> getAllObject() {
        String hql = "FROM JobStatus as j ORDER BY j.jobStatusId";
        return (List<JobStatus>) hibernateTemplate.find(hql);
    }

    @Override
    public JobStatus getObjectById(int id) {
        return hibernateTemplate.get(JobStatus.class, id);
    }

    @Override
    public void addObject(JobStatus obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(JobStatus obj) {
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String jobStatusName) {
        String hql = "FROM JobStatus as j WHERE j.jobStatusName = ?";
        List<JobStatus> lst = (List<JobStatus>) hibernateTemplate.find(hql, jobStatusName);
        return lst.size() > 0 ? true : false;
    }

}
