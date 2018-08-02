package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.MasterData;
import com.payroll.govtjutemillpayrollsystem.domain.SalaryTran;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SalaryTranDAO implements ISalaryTranDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<SalaryTran> getAllObject() {
        String hql = "FROM SalaryTran b LEFT JOIN FETCH  b.masterData LEFT JOIN FETCH  b.masterData.designation LEFT JOIN FETCH  b.masterData.basicMaster LEFT JOIN FETCH  b.masterData.mill LEFT JOIN FETCH  b.masterData.department LEFT JOIN FETCH  b.masterData.jobType LEFT JOIN FETCH  b.masterData.jobStatus LEFT JOIN FETCH  b.masterData.salaryStatus ORDER BY b.salaryTranId";
        return (List<SalaryTran>) hibernateTemplate.find(hql);
    }

    @Override
    public SalaryTran getObjectById(int id) {
        return hibernateTemplate.get(SalaryTran.class, id);
    }

    @Override
    public void addObject(SalaryTran obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(SalaryTran obj) {
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

}
