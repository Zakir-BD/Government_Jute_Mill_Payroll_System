package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.JobType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class JobTypeDAO implements IJobTypeDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<JobType> getAllObject() {
        String hql = "FROM JobType as j ORDER BY j.jobTypeId";
        return (List<JobType>) hibernateTemplate.find(hql);
    }

    @Override
    public JobType getObjectById(int id) {
        return hibernateTemplate.get(JobType.class, id);
    }

    @Override
    public void addObject(JobType obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(JobType obj) {
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String jobTypeName) {
        String hql = "FROM JobType as j WHERE j.jobTypeName = ?";
        List<JobType> lst = (List<JobType>) hibernateTemplate.find(hql, jobTypeName);
        return lst.size() > 0 ? true : false;
    }

}
