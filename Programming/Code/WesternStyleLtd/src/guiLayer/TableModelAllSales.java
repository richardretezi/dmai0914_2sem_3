package guiLayer;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModelAllSales extends AbstractTableModel{
	private String[] colNames = {"Select all", "Name", "Quantity", "Price (DKK)"};
	private ArrayList<String> l;
	
	public TableModelAllSales() { 

	}
	
	
	
	@Override
	public Class<?> getColumnClass(int col) {
		switch(col) {
		case 0:
			return Boolean.class;
		case 1:
			return String.class;
		case 2:
			return Integer.class;
		case 3:
			return Double.class;
		default:
			return null;
		}
	}


	@Override
	public boolean isCellEditable(int row, int col) {
		switch(col) {
		case 0:
			return true;
		default:
			return false;
		}
	}
	
	


	/**
	@Override
	public void setValueAt(Object value, int row, int col) {
		if(sl == null) return;
		SaleLine saleLine = sl.get(row);
		switch(col) {
		case 0:
			saleLine.setRowDelete((Boolean)value);
			break;
		default:
			return;
		}
	}

 	
	public void setData(ArrayList<SaleLine> sl){
		this.sl = sl;
	}
	*/
	@Override
	public int getColumnCount() {
		return 4;
	}
	@Override
	public int getRowCount() {
		return 10;
	}
	
	@Override
	public Object getValueAt(int row, int col) { //int row

		String s = l.get(row);
		//SaleLine saleLine = sl.get(row);
		//itemController = new ItemController();
		
		switch(col) {
		case 0:
			return true;//saleLine.getRowDelete();
		case 1:
			return "yes";//itemController.findItem(saleLine.getBarcode()).getName();
		case 2:
			return 1;//saleLine.getQuantity();
		case 3:
			return 1.0;//saleLine.getPrice();
		default:
			return null;
		}
		// return null;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}
}
