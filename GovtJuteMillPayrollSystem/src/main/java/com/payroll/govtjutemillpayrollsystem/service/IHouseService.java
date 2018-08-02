package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.House;
import java.util.List;

public interface IHouseService {

    List<House> getAllObject();

    House getObjectById(int id);

    boolean addObject(House obj);

    void updateObject(House obj);

    void deleteObject(int id);
}
