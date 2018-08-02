package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.BasicIncrement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BasicIncrementDAO implements IBasicIncrementDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<BasicIncrement> getAllObject() {
        String hql = "FROM BasicIncrement as b ORDER BY b.incrementId";
        return (List<BasicIncrement>) hibernateTemplate.find(hql);
    }

    @Override
    public BasicIncrement getObjectById(int id) {
        return hibernateTemplate.get(BasicIncrement.class, id);
    }

    @Override
    public void addObject(BasicIncrement obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(BasicIncrement obj) {
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(int incrementName) {
        String hql = "FROM BasicIncrement as b WHERE b.incrementName = ?";
        List<BasicIncrement> lst = (List<BasicIncrement>) hibernateTemplate.find(hql, incrementName);
        return lst.size() > 0 ? true : false;
    }

}
