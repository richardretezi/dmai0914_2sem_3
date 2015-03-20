package guiLayer;

import javax.swing.SwingUtilities;

public class Run {

	public static void main(String[] args) {
			
			SwingUtilities.invokeLater(new Runnable() {

				public void run() {
					
					new MainFrameSalesOrder();

					
				}
				
			});

	}

}
