package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.BasicGrade;
import com.payroll.govtjutemillpayrollsystem.domain.BasicMaster;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BasicMasterDAO implements IBasicMasterDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<BasicMaster> getAllObject() {
        String hql = "FROM BasicMaster b LEFT JOIN FETCH  b.basicGrade LEFT JOIN FETCH  b.basicIncrement ORDER BY b.basicId";
        return (List<BasicMaster>) hibernateTemplate.find(hql);
    }

    @Override
    public BasicMaster getObjectById(int id) {
        return hibernateTemplate.get(BasicMaster.class, id);
    }

    @Override
    public void addObject(BasicMaster obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(BasicMaster obj) {
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(Double basicMain) {
        String hql = "FROM BasicMaster as b WHERE b.basicMain = ?";
        List<BasicGrade> lst = (List<BasicGrade>) hibernateTemplate.find(hql, basicMain);
        return lst.size() > 0 ? true : false;
    }

}
