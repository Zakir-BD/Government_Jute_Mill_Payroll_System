
package com.payroll.govtjutemillpayrollsystem.dao;

import com.payroll.govtjutemillpayrollsystem.domain.SalaryStatus;
import java.util.List;


public interface ISalaryStatusDAO {
    List<SalaryStatus> getAllObject();

    SalaryStatus getObjectById(int id);

    void addObject(SalaryStatus obj);

    void updateObject(SalaryStatus obj);

    void deleteObject(int id);

    boolean objectExists(String salaryStatusName);
}
