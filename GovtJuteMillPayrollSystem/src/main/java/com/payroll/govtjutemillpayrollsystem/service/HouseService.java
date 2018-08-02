package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.dao.IDepartmentDAO;
import com.payroll.govtjutemillpayrollsystem.dao.IHouseDAO;
import com.payroll.govtjutemillpayrollsystem.domain.Department;
import com.payroll.govtjutemillpayrollsystem.domain.House;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService implements IHouseService {

    @Autowired
    private IHouseDAO iHouseDAO;

    @Override
    public List<House> getAllObject() {
        return iHouseDAO.getAllObject();
    }

    @Override
    public House getObjectById(int id) {
        House obj = iHouseDAO.getObjectById(id);
        return obj;
    }

    @Override
    public boolean addObject(House obj) {
        if (iHouseDAO.objectExists(obj.getHouseCd())) {
            return false;
        } else {
            iHouseDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(House obj) {
        iHouseDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iHouseDAO.deleteObject(id);
    }

}
