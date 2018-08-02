package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.MasterAllowance;
import com.payroll.govtjutemillpayrollsystem.domain.MasterData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class MasterAllowanceDAO implements IMasterAllowanceDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<MasterAllowance> getAllObject() {
        String hql = "FROM MasterAllowance b LEFT JOIN FETCH  b.masterData ORDER BY b.masterAllowanceId";
        return (List<MasterAllowance>) hibernateTemplate.find(hql);
    }

    @Override
    public MasterAllowance getObjectById(int id) {
        return hibernateTemplate.get(MasterAllowance.class, id);
    }

    @Override
    public void addObject(MasterAllowance obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(MasterAllowance obj) {
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(MasterData masterData) {
        String hql = "FROM MasterAllowance as d WHERE d.masterData = ?";
        List<MasterAllowance> lst = (List<MasterAllowance>) hibernateTemplate.find(hql, masterData);
        return lst.size() > 0 ? true : false;
    }

}
