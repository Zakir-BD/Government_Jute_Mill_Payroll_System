package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.SalaryTranDeduction;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SalaryTranDeductionDAO implements ISalaryTranDeductionDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<SalaryTranDeduction> getAllObject() {
        String hql = "FROM SalaryTranDeduction b LEFT JOIN FETCH  b.salaryTran LEFT JOIN FETCH  b.masterData ORDER BY b.salaryTranDedId";
        return (List<SalaryTranDeduction>) hibernateTemplate.find(hql);
    }

    @Override
    public SalaryTranDeduction getObjectById(int id) {
        return hibernateTemplate.get(SalaryTranDeduction.class, id);
    }

    @Override
    public void addObject(SalaryTranDeduction obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(SalaryTranDeduction obj) {
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

}
