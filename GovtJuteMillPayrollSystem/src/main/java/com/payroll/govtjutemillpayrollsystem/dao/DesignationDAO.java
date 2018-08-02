package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.Designation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class DesignationDAO implements IDesignationDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Designation> getAllObject() {
        String hql = "FROM Designation as d ORDER BY d.designationId";
        return (List<Designation>) hibernateTemplate.find(hql);
    }

    @Override
    public Designation getObjectById(int id) {
        return hibernateTemplate.get(Designation.class, id);
    }

    @Override
    public void addObject(Designation obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Designation obj) {
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String designationName) {
        String hql = "FROM Designation as d WHERE d.designationName = ?";
        List<Designation> lst = (List<Designation>) hibernateTemplate.find(hql, designationName);
        return lst.size() > 0 ? true : false;
    }

}
