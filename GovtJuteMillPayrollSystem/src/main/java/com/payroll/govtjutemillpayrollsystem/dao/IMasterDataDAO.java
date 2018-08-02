
package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.MasterData;
import java.util.List;

public interface IMasterDataDAO {
    List<MasterData> getAllObject();

    MasterData getObjectById(int id);

    void addObject(MasterData obj);

    void updateObject(MasterData obj);

    void deleteObject(int id);

    boolean objectExists(String bankAc);
}
