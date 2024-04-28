package org.LapTrinhTienTien.TableModel;

import org.LapTrinhTienTien.model.HoaDon;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class HoaDonTableModel extends AbstractTableModel {
    private List<HoaDon> lstHoaDons;
    private final String[] COLUMNS ={"SDT Khách hàng","Điểm sử dụng","Đơn Giá","Mã Khuyến Mãi"};
    public HoaDonTableModel(List<HoaDon> lstHoaDons){
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
            case 0->lstHoaDons.get(rowIndex).getKhachHang().getSdt();
            case 1->lstHoaDons.get(rowIndex).getDiemSuDung();
            case 2->lstHoaDons.get(rowIndex).getGiaTri();
            case 3->lstHoaDons.get(rowIndex).getMaKhuyenMai();
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

    public boolean AddSP(HoaDon sp){
        return lstHoaDons.add(sp);
    }
    public Boolean removeSP(HoaDon sp){
        return lstHoaDons.remove(sp);
    }
    public HoaDon getRow(int index){
        if(index >= getRowCount())
            return null;
        return lstHoaDons.get(index);
    }
}
