package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.Department;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class DepartmentDAO implements IDepartmentDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Department> getAllObject() {
        String hql = "FROM Department as d ORDER BY d.departmentId";
        return (List<Department>) hibernateTemplate.find(hql);
    }

    @Override
    public Department getObjectById(int id) {
        return hibernateTemplate.get(Department.class, id);
    }

    @Override
    public void addObject(Department obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(Department obj) {
        hibernateTemplate.update(obj);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String departmentName) {
        String hql = "FROM Department as d WHERE d.departmentName = ?";
        List<Department> lst = (List<Department>) hibernateTemplate.find(hql, departmentName);
        return lst.size() > 0 ? true : false;
    }

}
