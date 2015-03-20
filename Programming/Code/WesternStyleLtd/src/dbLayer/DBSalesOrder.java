package dbLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;








import dbLayer.*;

import modelLayer.*;


public class DBSalesOrder implements IFDBSalesOrder {

	private int costumerNumber;
	
	@Override
	public ArrayList<SalesOrder> getAllSalesOrders(boolean retriveAssociation) {
		
		return  miscWhere("", retriveAssociation);
	}

	@Override
	public SalesOrder findSalesOrder(int id, boolean retriveAssosciation) {
		
		SalesOrder d = singleWhere("id = " + id, retriveAssosciation);
		return d;
	}

	@Override
	public int insert(SalesOrder d) {
		int res = 0;
		String q = "insert into SALES_ORDER (sDate, deliveryStatus, deliveryDate, totalPrice, cID, discount, deliveryFee) values ('" +
		d.getDate() + "', '" +
		d.isDeliveryStatus() + "', " +
		d.getDeliveryDate() + "', " +
		d.getTotalPrice() + "', " +
		d.getInvoiceId() + "', " +
		d.getDiscount() + "', " +
		d.getDeliveryFee() + "', "
		+ "')'";
		//System.out.println(q);
		/*
		try (Statement s = DBConnect.getInstance().getDBcon().createStatement()) {
			res = s.executeUpdate(q, Statement.RETURN_GENERATED_KEYS);
			int id = new GeneratedKey().getGeneratedKey(s);
			d.setId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		return res;
	}

	@Override
	public int update(SalesOrder dept) {
		
		return 0;
	}
	
	private String buildQuery(String where) {
		String q = "select id, name, breed, person_id from dog";
		if(where != null && where.length() > 0) {
			q += " where " + where;
		}
		return q;
	}
	
	private SalesOrder buildSaleOrder(ResultSet rs) {
	SalesOrder d = null;
		try {
			d = new SalesOrder();
			d.setDate(rs.getString("sDate"));
			d.setDeliveryStatus(rs.getBoolean("deliveryStatus"));
			d.setTotalPrice(rs.getFloat("totalPrice"));
			d.setInvoiceId(rs.getInt("id"));
			d.setDeliveryDate(rs.getString("deliveryDate"));
			d.setDiscount(rs.getInt("discount"));
			d.setDeliveryFee(rs.getDouble("deliveryFee"));
			costumerNumber =(rs.getInt("cID"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	private SalesOrder singleWhere(String where, boolean retrieveAssociation) {
		ArrayList<SalesOrder> salesOrders = miscWhere(where, retrieveAssociation);
		if(salesOrders.size() > 0) {
			return salesOrders.get(0);
		}
		return null;
	}
	
	private ArrayList<SalesOrder> miscWhere(String where, boolean retrieveAssociation) {
		ResultSet rs;
		ArrayList<SalesOrder> salesOrders = new ArrayList<>();
		String query = buildQuery(where);
		try(Statement s = DBConnect.getInstance().getDBcon().createStatement()) {
			s.setQueryTimeout(5);
			rs = s.executeQuery(query);
			while(rs.next()) {
				SalesOrder d = buildSaleOrder(rs);
				
				salesOrders.add(d);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return salesOrders;
	}

}
