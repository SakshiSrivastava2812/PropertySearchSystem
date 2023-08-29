package com.amdocs.propertysearch.dao;

import java.sql.Connection;
import com.amdocs.propertysearch.model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.amdocs.propertysearch.exception.*;

import com.amdocs.propertysearch.model.Property;

public class PropertyDAO {
	DBConnection dbObj = new DBConnection();
	Connection c = dbObj.getConnection();

	public int addProperty(Property p) throws InsertException
	{
		int count = 0;
		try
		{
			PreparedStatement pst = c.prepareStatement("insert into PROPERTY values(?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, p.getPropertyId());
			pst.setString(2, p.getNoOfRooms());
			pst.setDouble(3, p.getAreaInSqft());
			pst.setInt(4, p.getFloorNo());
			pst.setString(5, p.getCity());
			pst.setString(6, p.getState());
			pst.setDouble(7, p.getCost());
			pst.setString(8, p.getOwnerName());
			pst.setString(9, p.getOwnerContactNo());
			
			count = pst.executeUpdate();
		}
		catch(Exception e)
		{
			throw new InsertException(e);
		}
		
		return count;
	}
	
	public int deleteProperty(int id) throws DeleteException
	{
		int count=0;
		try {
			PreparedStatement pst = c.prepareStatement("delete from PROPERTY where propertyId="+id);
			count = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw new DeleteException(e);
		}
		return count;
	}
	
	public int updateProperty(int id,double cost) throws UpdateException
	{

		int count=0;
		try {
			PreparedStatement pst = c.prepareStatement("update PROPERTY set cost=? where propertyId=?");
			pst.setDouble(1, cost);
			pst.setInt(2, id);
			count = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw new UpdateException(e);
		}
		return count;
	}
	public void searchbyCity(String city)
	{
		ResultSet rs=null;
		try {
			System.out.println("Inside try of searchbycity");
			PreparedStatement pst = c.prepareStatement("select * from PROPERTY where city=?");
			pst.setString(1, city);
			rs = pst.executeQuery();
			if(rs != null)
				this.displayResult(rs);
			else
				System.out.println("No record found!");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error occured: " + e.getMessage());
		}
		
	}
	
	public void searchbyCost(double initialcost, double finalcost)
	{
		ResultSet rs=null;
		try {
			PreparedStatement pst = c.prepareStatement("select * from PROPERTY where cost>=? and cost<=?");
			pst.setDouble(1,initialcost);
			pst.setDouble(2,finalcost);
			rs = pst.executeQuery();
			if(rs != null)
				this.displayResult(rs);
			else
				System.out.println("No record found!");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error occured: " + e.getMessage());
		}
		
	}
	public void searchbyRoomCity(int noOfRoom, String city)
	{
		ResultSet rs=null;
		try {
			PreparedStatement pst = c.prepareStatement("select * from PROPERTY where NOOFROOMS=? && city=?");
			pst.setInt(1,noOfRoom);
			pst.setString(2,city);
			rs = pst.executeQuery();
			if(rs != null)
				this.displayResult(rs);
			else
				System.out.println("No record found!");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error occured: " + e.getMessage());
		}
		
	}
	
	public void showAllProperties()
	{
		ResultSet rs=null;
		
		try {
			PreparedStatement pst = c.prepareStatement("select * from PROPERTY");
			rs = pst.executeQuery();
			this.displayResult(rs);
			
			} 
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error occured: " + e.getMessage());
		}
		
	}
	public void displayResult(ResultSet rs)
	{
		try {
			while(rs.next())
			{
				System.out.println("---------------------------------------------------------------------------------");
			System.out.println("PropertyId:" + rs.getInt(1) + " ,No of Rooms:"+ rs.getString(2) + " ,Area in Sqft:" + rs.getDouble(3));
			System.out.println("Floor no:" + rs.getInt(4) + " ,City:"+ rs.getString(5) + " ,State:" + rs.getString(6));
			System.out.println("Cost:" + rs.getDouble(7) + " ,Owner Name:"+ rs.getString(8) + " ,Owner Contact No:" + rs.getString(9));
			System.out.println("---------------------------------------------------------------------------------");
			}
	
		} catch (Exception e) {
	// TODO: handle exception
			System.out.println("Error occured: " + e.getMessage());
}
	}

}
