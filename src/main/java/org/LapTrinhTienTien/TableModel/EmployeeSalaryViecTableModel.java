package org.LapTrinhTienTien.TableModel;

import lombok.Getter;
import lombok.Setter;
import org.LapTrinhTienTien.model.customModel.EmployeeSalary;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmployeeSalaryViecTableModel extends AbstractTableModel {
    @Setter@Getter
    private List<EmployeeSalary> lstEmployeeSalarys;
    private final String[] COLUMNS ={"Mã Nhân Viên","Tên Nhân Viên","Số Buổi ca sáng","Số Buổi ca chiều","Số Buổi ca tối","Lương"};
    public EmployeeSalaryViecTableModel(List<EmployeeSalary> lstEmployeeSalarys){
        this.lstEmployeeSalarys = lstEmployeeSalarys;
    }
    @Override
    public int getRowCount() {
        return lstEmployeeSalarys.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUMNS[columnIndex];
    }
    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }


    /**
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex){
            case 0->lstEmployeeSalarys.get(rowIndex).getManv();
            case 1->lstEmployeeSalarys.get(rowIndex).getTennv();
            case 2->lstEmployeeSalarys.get(rowIndex).getMorning();
            case 3->lstEmployeeSalarys.get(rowIndex).getAfternoon();
            case 4->lstEmployeeSalarys.get(rowIndex).getEvening();
            case 5->lstEmployeeSalarys.get(rowIndex).getTotalMoney();
            default -> "-";
        };
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(getValueAt(0,columnIndex)!=null){
            return getValueAt(0,columnIndex).getClass();
        }else{
            return Object.class;
        }
    }

    public boolean AddSP(EmployeeSalary sp){
        return lstEmployeeSalarys.add(sp);
    }
    public Boolean removeSP(EmployeeSalary sp){
        return lstEmployeeSalarys.remove(sp);
    }
    public EmployeeSalary getRow(int index){
        if(index >= getRowCount())
            return null;
        return lstEmployeeSalarys.get(index);
    }
}
