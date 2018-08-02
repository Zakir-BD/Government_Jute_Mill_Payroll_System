package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.MasterAllowance;
import com.payroll.govtjutemillpayrollsystem.domain.MasterData;
import com.payroll.govtjutemillpayrollsystem.domain.MasterDeduction;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class MasterDeductionDAO implements IMasterDeductionDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<MasterDeduction> getAllObject() {
        String hql = "FROM MasterDeduction b LEFT JOIN FETCH  b.masterData LEFT JOIN FETCH  b.house ORDER BY b.masterDeductionId";
        return (List<MasterDeduction>) hibernateTemplate.find(hql);
    }

    @Override
    public MasterDeduction getObjectById(int id) {
        return hibernateTemplate.get(MasterDeduction.class, id);
    }

    @Override
    public void addObject(MasterDeduction obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(MasterDeduction obj) {
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(MasterData masterData) {
        String hql = "FROM MasterDeduction as d WHERE d.masterData = ?";
        List<MasterDeduction> lst = (List<MasterDeduction>) hibernateTemplate.find(hql, masterData);
        return lst.size() > 0 ? true : false;
    }

}
