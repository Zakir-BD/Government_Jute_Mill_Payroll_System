package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.User;
import java.util.List;

public interface IUserService {

    List<User> getAllObject();

    User getObjectById(int id);

    boolean addObject(User obj);

    void updateObject(User obj);

    void deleteObject(int id);
}
