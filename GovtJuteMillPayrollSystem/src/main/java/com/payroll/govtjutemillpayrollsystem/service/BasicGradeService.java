
package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.IBasicGradeDAO;
import com.payroll.govtjutemillpayrollsystem.domain.BasicGrade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BasicGradeService implements IBasicGradeService {

    @Autowired
    private IBasicGradeDAO iBasicGradeDAO;

    @Override
    public List<BasicGrade> getAllObject() {
        return iBasicGradeDAO.getAllObject();
    }

    @Override
    public BasicGrade getObjectById(int id) {
        BasicGrade obj = iBasicGradeDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(BasicGrade obj) {
        if (iBasicGradeDAO.objectExists(obj.getScaleStart())) {
            return false;
        } else {
            iBasicGradeDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(BasicGrade obj) {
        iBasicGradeDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iBasicGradeDAO.deleteObject(id);
    }

}
