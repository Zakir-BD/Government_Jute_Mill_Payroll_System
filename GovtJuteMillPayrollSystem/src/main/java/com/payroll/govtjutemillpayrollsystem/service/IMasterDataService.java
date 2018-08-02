package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.MasterData;
import java.util.List;

public interface IMasterDataService {

    List<MasterData> getAllObject();

    MasterData getObjectById(int id);

    boolean addObject(MasterData obj);

    void updateObject(MasterData obj);

    void deleteObject(int id);
}
