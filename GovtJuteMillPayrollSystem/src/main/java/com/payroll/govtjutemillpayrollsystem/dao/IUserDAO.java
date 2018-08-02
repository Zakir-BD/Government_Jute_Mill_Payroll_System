
package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.User;
import java.util.List;

public interface IUserDAO {
    List<User> getAllObject();

    User getObjectById(int id);

    void addObject(User obj);

    void updateObject(User obj);

    void deleteObject(int id);

    boolean objectExists(String userName);
}
