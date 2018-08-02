
package com.payroll.govtjutemillpayrollsystem.service;

import com.payroll.govtjutemillpayrollsystem.domain.SalaryStatus;
import java.util.List;


public interface ISalaryStatusService {
    List<SalaryStatus> getAllObject();

    SalaryStatus getObjectById(int id);

    boolean addObject(SalaryStatus obj);

    void updateObject(SalaryStatus obj);

    void deleteObject(int id);
}
