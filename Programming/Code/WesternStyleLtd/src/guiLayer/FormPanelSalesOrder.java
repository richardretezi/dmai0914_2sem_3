package guiLayer;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class FormPanelSalesOrder extends JPanel{
	
	private JLabel barcodeLabel;
	private JTextField barcodeField;
	private JButton addBtn;
	private JTable table;
	private JLabel showSalesLabel;

	private JTextField customerTextField;
	private JLabel customerLabel;
	private JButton customerBtn;
	
	public FormPanelSalesOrder(){
		Dimension dim = getPreferredSize();
		dim.width = 350;
		setPreferredSize(dim);
		
		barcodeLabel = new JLabel("Product name:");
		barcodeField = new JTextField(10);
		addBtn = new JButton("   Add   ");
		table = new JTable();

		customerLabel = new JLabel("Cust. phone No:");
		customerBtn = new JButton("Search");
		customerTextField = new JTextField(10);
		showSalesLabel = new JLabel("All Sales:");

		
		/**addBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String barcode = barcodeField.getText();
				
				FormPurchaseEvent pev = new FormPurchaseEvent(this, barcode, false, false);
				
				if(formListenerPurchase != null){
					formListenerPurchase.formEventOcurred(pev);
				}
				
			}
		});
		
		delBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FormPurchaseEvent pev = new FormPurchaseEvent(this, "", true, false);
				
				if(formListenerPurchase != null){
					formListenerPurchase.formEventOcurred(pev);
				}	
			}
		});
		
		delAllBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FormPurchaseEvent pev = new FormPurchaseEvent(this, "delAll", true, false);
				
				if(formListenerPurchase != null){
					formListenerPurchase.formEventOcurred(pev);
				}	
			}
		});
		
		customerBtn.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				int cusField = Integer.parseInt(customerTextField.getText());
				//if(cusField != null){
					ArrayList<Customer> customers = customerController.getAllCustomers();
					Customer customer = null;
					for(Customer c : customers){
						if(c.getCprNo() == cusField){
							customer = c;
						}
					}
				FormPurchaseEvent pev = new FormPurchaseEvent(this, customer, "discount");
				
				if(formListenerPurchase != null){
					formListenerPurchase.formEventOcurred(pev);
				}		
				
				//}
				}
		});
		*/
		
		Border innerBorder = BorderFactory.createTitledBorder("Add product / discaunts / all sales ");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		//First row
		
		gc.weightx = 0.1;
		gc.weighty = 0.01;
		
		gc.gridwidth = 1;
		gc.gridx = 1;
		gc.gridy = 0; 
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(20, 0, 0, 0);
		add(barcodeLabel, gc);
		
		gc.weightx = 1;
		gc.gridx = 2;
		gc.gridy = 0; 
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(20, 0, 0, 0);
		add(barcodeField, gc);
		
		gc.weightx = 0.3;
		gc.gridx = 3;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(20, 0, 0, 0);
		add(addBtn, gc);
		
		//Second row
		
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		
		gc.gridwidth = 1;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH ;
		gc.insets = new Insets(5, 0, 0, 0);
		add(customerLabel, gc);
		
		gc.weightx = 1;
		gc.gridwidth = 1;
		gc.gridx = 2;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH ;
		gc.insets = new Insets(5, 0, 0, 0);
		add(customerTextField, gc);
		
		gc.weightx = 0.3;
		gc.gridwidth = 1;
		gc.gridx = 3;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH ;
		gc.insets = new Insets(5, 0, 0, 0);
		add(customerBtn, gc);
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		
		gc.gridwidth = 4;
		gc.gridx = 0;
		gc.gridy = 2;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH ;
		gc.insets = new Insets(5, 0, 0, 0);
		add(showSalesLabel, gc);
		
		//Third row
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridwidth = 4;
		gc.gridx = 0;
		gc.gridy = 3;
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets = new Insets(0, 0, 0, 0);
		add(new JScrollPane(table), gc);
		
		
		

		
		
		
		}
	/**
	public void setFormListenerPurchase(FormListenerPurchase listener){
		this.formListenerPurchase = listener;	
	}
*/
}

