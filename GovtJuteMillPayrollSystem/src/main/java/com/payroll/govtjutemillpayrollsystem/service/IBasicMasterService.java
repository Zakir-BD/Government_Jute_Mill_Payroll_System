package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.BasicMaster;
import java.util.List;

public interface IBasicMasterService {

    List<BasicMaster> getAllObject();

    BasicMaster getObjectById(int id);

    boolean addObject(BasicMaster obj);

    void updateObject(BasicMaster obj);

    void deleteObject(int id);
}
