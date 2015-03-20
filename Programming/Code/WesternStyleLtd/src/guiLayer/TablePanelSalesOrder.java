package guiLayer;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

public class TablePanelSalesOrder extends JPanel{

	private JTable table;
	//private TableModelSalesOrder tableModel;
	private JLabel label;
	private JLabel labelTotal;
	private JLabel labelAmount;
	private JButton processBtn;
	private JLabel labelTop;
	private FormListenerSalesOrder formListenerSalesOrder;
	private JButton cancelBtn;
	private JButton goBackBtn;
	private JLabel labelDiscount;
	private JLabel labelDiscountAmount;
	//private DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	
	public TablePanelSalesOrder() {
		
		//tableModel = new TableModelSalesOrder();
		table = new JTable();
		//label = new JLabel("Western Style Ltd");
		labelTop = new JLabel("Western Style Ltd");
		labelTotal = new JLabel("Total:");
		labelAmount = new JLabel("0.0 DKK");
		processBtn = new JButton("Process payment");
		cancelBtn = new JButton(" Cancel payment  ");
		goBackBtn = new JButton("             Exit             ");
		labelDiscount = new JLabel("Discount");
		labelDiscountAmount = new JLabel("0.0 DKK");
		
		/**
		processBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormPurchaseEvent pev = new FormPurchaseEvent(this, "", false, true);
				
				if(formListenerPurchase != null){
					formListenerPurchase.formEventOcurred(pev);
				}
				
			}
		});
		*/
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		Border innerBorder = BorderFactory.createBevelBorder(1);
		Border outerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		//First row
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridwidth = 3;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.CENTER;
		add(labelTop, gc);
		labelTop.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		//Second Row
		/**
		gc.weightx = 1;
		gc.weighty = 0.05;
		
		gc.gridwidth = 3;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_START;
		add(label, gc);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		*/
		//Second Third
	
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridwidth = 3;
		gc.gridx = 0;
		gc.gridy = 2; 
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(0, 0, 0, 0);
		add(new JScrollPane(table), gc);
		//centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		//table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		//table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		//table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
				
		//Fourth row
		/**
				
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.fill = GridBagConstraints.BOTH;
		gc.gridwidth = 3;
		gc.gridx = 0;
		gc.gridy = 3; 
		add(new JScrollPane(table_1), gc);
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table_1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		
		*/
		//Fifth row
		
		gc.weightx = 1;
		gc.weighty = 0.01;
		
		gc.gridwidth = 1;
		gc.gridx = 0;
		gc.gridy = 3; 
		gc.insets = new Insets(0, 5, 0, 0);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(processBtn, gc);
		
		gc.weightx = 0.2;
		gc.weighty = 0.01;
		
		gc.gridwidth = 1;
		gc.gridx = 1;
		gc.gridy = 3; 
		gc.insets = new Insets(0, 0, 0, 5);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		add(labelDiscount, gc);
		
		gc.gridwidth = 1;
		gc.gridx = 2;
		gc.gridy = 3; 
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.LINE_START;
		add(labelDiscountAmount, gc);
		
		gc.weightx = 0.2;
		gc.weighty = 0.01;
		
		gc.gridwidth = 1;
		gc.gridx = 1;
		gc.gridy = 4; 
		gc.insets = new Insets(0, 0, 0, 5);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		add(labelTotal, gc);
		
		gc.gridwidth = 1;
		gc.gridx = 2;
		gc.gridy = 4; 
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.LINE_START;
		add(labelAmount, gc);
		
		
		//Fourth row
		
		gc.weightx = 0.2;
		gc.weighty = 0.01;
		
		gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy =4;
		gc.insets = new Insets(0, 5, 0, 0);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(cancelBtn, gc);
		
		//Fifth row
		
		gc.weightx = 0.2;
		gc.weighty = 0.01;
		
		gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy =5;
		gc.insets = new Insets(0, 5, 0, 0);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(goBackBtn, gc);
		
	}
	/**
	public void setData(ArrayList<SaleLine> sl){
		tableModel.setData(sl);
	}
	public void setData(ArrayList<String> discountFor, ArrayList<String> percents, ArrayList<String> total){
		tableModel_1.setData(discountFor, percents, total);
	}
	*/
	/**
	public void refresh(){
		tableModel.fireTableDataChanged();
	}
	*/
	/**
	public void refresh1(){
		tableModel_1.fireTableDataChanged();
	}
	*/
	public void addTotalPrice(String amount){
		labelAmount.setText(amount + " DKK");
	}
	
	public void setFormListenerSalesOrder(FormListenerSalesOrder listener){
		this.formListenerSalesOrder = listener;	
	}
}
