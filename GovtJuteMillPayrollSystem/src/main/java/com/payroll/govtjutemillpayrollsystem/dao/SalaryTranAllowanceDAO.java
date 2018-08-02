package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.SalaryTranAllowance;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SalaryTranAllowanceDAO implements ISalaryTranAllowanceDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<SalaryTranAllowance> getAllObject() {
        String hql = "FROM SalaryTranAllowance b LEFT JOIN FETCH  b.salaryTran LEFT JOIN FETCH  b.masterData ORDER BY b.salaryTranAllowId";
        return (List<SalaryTranAllowance>) hibernateTemplate.find(hql);
    }

    @Override
    public SalaryTranAllowance getObjectById(int id) {
        return hibernateTemplate.get(SalaryTranAllowance.class, id);
    }

    @Override
    public void addObject(SalaryTranAllowance obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(SalaryTranAllowance obj) {
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

}
