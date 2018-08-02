package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.BasicGrade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BasicGradeDAO implements IBasicGradeDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<BasicGrade> getAllObject() {
        String hql = "FROM BasicGrade as p ORDER BY p.gradeId";
        return (List<BasicGrade>) hibernateTemplate.find(hql);
    }

    @Override
    public BasicGrade getObjectById(int id) {
        return hibernateTemplate.get(BasicGrade.class, id);
    }

    @Override
    public void addObject(BasicGrade obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(BasicGrade obj) {
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(Double scaleStart) {
        String hql = "FROM BasicGrade as b WHERE b.scaleStart = ?";
        List<BasicGrade> lst = (List<BasicGrade>) hibernateTemplate.find(hql, scaleStart);
        return lst.size() > 0 ? true : false;
    }

}
