package org.LapTrinhTienTien.model.customModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSalary {
    String manv;
    String tennv;
    int morning = 0;
    int afternoon = 0;
    int evening =0;
    float totalMoney = 0;


}
