package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.IBasicMasterDAO;
import com.payroll.govtjutemillpayrollsystem.dao.IUserDAO;
import com.payroll.govtjutemillpayrollsystem.domain.BasicMaster;
import com.payroll.govtjutemillpayrollsystem.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO iUserDAO;

    @Override
    public List<User> getAllObject() {
        return iUserDAO.getAllObject();
    }

    @Override
    public User getObjectById(int id) {
        User obj = iUserDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(User obj) {
        if (iUserDAO.objectExists(obj.getUserName())) {
            return false;
        } else {
            iUserDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(User obj) {
        iUserDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iUserDAO.deleteObject(id);
    }

}
