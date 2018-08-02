package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.Department;
import com.payroll.govtjutemillpayrollsystem.domain.House;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class HouseDAO implements IHouseDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<House> getAllObject() {
        String hql = "FROM House as d ORDER BY d.houseId";
        return (List<House>) hibernateTemplate.find(hql);
    }

    @Override
    public House getObjectById(int id) {
        return hibernateTemplate.get(House.class, id);
    }

    @Override
    public void addObject(House obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(House obj) {
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(int houseCd) {
        String hql = "FROM House as d WHERE d.houseCd = ?";
        List<House> lst = (List<House>) hibernateTemplate.find(hql, houseCd);
        return lst.size() > 0 ? true : false;
    }

}
