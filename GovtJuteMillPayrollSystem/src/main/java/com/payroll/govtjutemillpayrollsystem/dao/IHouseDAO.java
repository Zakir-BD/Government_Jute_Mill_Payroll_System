
package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.House;
import java.util.List;

public interface IHouseDAO {
    List<House> getAllObject();

    House getObjectById(int id);

    void addObject(House obj);

    void updateObject(House obj);

    void deleteObject(int id);

    boolean objectExists(int houseCd);
}
