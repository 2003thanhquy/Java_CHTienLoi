package org.LapTrinhTienTien.TableModel;


import org.LapTrinhTienTien.model.GioHang;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class GioHangTableModel extends AbstractTableModel {
    private List<GioHang> lstHoaDons;
    private final String[] COLUMNS ={"MASP","So luong","Đơn Giá","Thanh Tien","action"};
    public GioHangTableModel(List<GioHang> lstHoaDons){
        this.lstHoaDons = lstHoaDons;
    }
    @Override
    public int getRowCount() {
        return lstHoaDons.size();
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
            case 0->lstHoaDons.get(rowIndex).getMaSP();
            case 1->lstHoaDons.get(rowIndex).getSoLuong();
            case 2->lstHoaDons.get(rowIndex).getGiaTien();
            case 3->lstHoaDons.get(rowIndex).getTongTien();
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
    private boolean[] canEdit = {false,true,false,false,true};
    private boolean cloumnCanEidt(int columnIndex){
        return canEdit[columnIndex];
        
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return cloumnCanEidt(columnIndex); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    public GioHang getRow(int row){
        return lstHoaDons.get(row);
    }
    
    
}
