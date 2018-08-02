package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.Department;
import com.payroll.govtjutemillpayrollsystem.domain.Mill;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class MillDAO implements IMillDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Mill> getAllObject() {
        String hql = "FROM Mill as m ORDER BY m.millId";
        return (List<Mill>) hibernateTemplate.find(hql);
    }

    @Override
    public Mill getObjectById(int id) {
        return hibernateTemplate.get(Mill.class, id);
    }

    @Override
    public void addObject(Mill obj) {
        hibernateTemplate.save(obj);
        
    }

    @Override
    public void updateObject(Mill obj) {
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String millName) {
        String hql = "FROM Mill as m WHERE m.millName = ?";
        List<Mill> lst = (List<Mill>) hibernateTemplate.find(hql, millName);
        return lst.size() > 0 ? true : false;
    }
    
    

}
