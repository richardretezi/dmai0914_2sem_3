package guiLayer;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrameSalesOrder extends JFrame {
	
	private FormPanelSalesOrder formPanelSalesOrder;
	private TablePanelSalesOrder tPanelSalesOrder;
	
	public MainFrameSalesOrder(){
		super("Purchase");
		
		setLayout(new BorderLayout());
		
		
		
		formPanelSalesOrder = new FormPanelSalesOrder();
		tPanelSalesOrder = new TablePanelSalesOrder();
		//tPanelSalesOrder.setData(discountFor, percents, total);
		
		/**
		saleController = new SaleController();
		itemController = new ItemController();
		customerController = new CustomerController();
		*/

		
		
		/**
		formPanelSalesOrder.setFormListenerSalesOrder(new FormListenerSalesOrder() {
			public void formEventOcurred(FormSalesOrderEvent e) {
				System.out.println("Success !");
				
				}
			
		});
		
		tPanelSalesOrder.setFormListenerSalesOrder(new FormListenerSalesOrder() {
			public void formEventOcurred(FormSalesOrderEvent e) {
				
				//Process Button
			}
		});
		*/
		add(formPanelSalesOrder, BorderLayout.WEST);
		
		add(tPanelSalesOrder, BorderLayout.CENTER);
		
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		


	}
	
}
