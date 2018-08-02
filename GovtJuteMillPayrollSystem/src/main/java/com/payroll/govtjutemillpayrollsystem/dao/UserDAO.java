package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserDAO implements IUserDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<User> getAllObject() {
        String hql = "FROM User b LEFT JOIN FETCH  b.masterData ORDER BY b.userId";
        return (List<User>) hibernateTemplate.find(hql);
    }

    @Override
    public User getObjectById(int id) {
        return hibernateTemplate.get(User.class, id);
    }

    @Override
    public void addObject(User obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(User obj) {
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String userName) {
        String hql = "FROM User as d WHERE d.userName = ?";
        List<User> lst = (List<User>) hibernateTemplate.find(hql, userName);
        return lst.size() > 0 ? true : false;
    }

}
