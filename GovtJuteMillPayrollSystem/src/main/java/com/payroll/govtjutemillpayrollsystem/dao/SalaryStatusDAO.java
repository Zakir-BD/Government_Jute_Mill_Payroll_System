package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.JobStatus;
import com.payroll.govtjutemillpayrollsystem.domain.SalaryStatus;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SalaryStatusDAO implements ISalaryStatusDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<SalaryStatus> getAllObject() {
        String hql = "FROM SalaryStatus as s ORDER BY s.salaryStatusId";
        return (List<SalaryStatus>) hibernateTemplate.find(hql);
    }

    @Override
    public SalaryStatus getObjectById(int id) {
        return hibernateTemplate.get(SalaryStatus.class, id);
    }

    @Override
    public void addObject(SalaryStatus obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(SalaryStatus obj) {
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String salaryStatusName) {
        String hql = "FROM SalaryStatus as s WHERE s.salaryStatusName = ?";
        List<SalaryStatus> lst = (List<SalaryStatus>) hibernateTemplate.find(hql, salaryStatusName);
        return lst.size() > 0 ? true : false;
    }

}
