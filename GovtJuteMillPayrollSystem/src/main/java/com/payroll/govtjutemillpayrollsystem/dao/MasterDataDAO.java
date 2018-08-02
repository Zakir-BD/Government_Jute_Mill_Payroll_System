package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.MasterData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class MasterDataDAO implements IMasterDataDAO {
    
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @Override
    public List<MasterData> getAllObject() {
        String hql = "FROM MasterData m LEFT JOIN FETCH m.basicMaster LEFT JOIN FETCH m.department LEFT JOIN FETCH m.designation LEFT JOIN FETCH m.mill LEFT JOIN FETCH m.department LEFT JOIN FETCH m.jobType LEFT JOIN FETCH m.jobStatus LEFT JOIN FETCH m.salaryStatus ORDER BY m.employeeId";
        return (List<MasterData>) hibernateTemplate.find(hql);
    }
    
    @Override
    public MasterData getObjectById(int id) {
        String hql = "FROM MasterData m LEFT JOIN FETCH m.basicMaster LEFT JOIN FETCH m.department LEFT JOIN FETCH m.designation LEFT JOIN FETCH m.mill LEFT JOIN FETCH m.department LEFT JOIN FETCH m.jobType LEFT JOIN FETCH m.jobStatus LEFT JOIN FETCH m.salaryStatus where m.employeeId=?";
//        return hibernateTemplate.get(MasterData.class, id);
        List<MasterData> mList = (List<MasterData>) hibernateTemplate.find(hql, id);
        return mList.get(0);
    }
    
    @Override
    public void addObject(MasterData obj) {
        hibernateTemplate.save(obj);
    }
    
    @Override
    public void updateObject(MasterData obj) {
        hibernateTemplate.update(obj);
    }
    
    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }
    
    @Override
    public boolean objectExists(String bankAc) {
        String hql = "FROM MasterData as m WHERE m.bankAc = ?";
        List<MasterData> lst = (List<MasterData>) hibernateTemplate.find(hql, bankAc);
        return lst.size() > 0 ? true : false;
    }
    
}
