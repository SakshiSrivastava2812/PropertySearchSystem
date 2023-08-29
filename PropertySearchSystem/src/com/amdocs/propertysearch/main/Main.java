package com.amdocs.propertysearch.main;

import java.util.Scanner;

import com.amdocs.propertysearch.model.*;
import com.amdocs.propertysearch.dao.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PropertyDAO pdao = new PropertyDAO();
		// TODO Auto-generated method stub
		System.out.println("***** Welcome to Property Search System *****");
		while(true)
		{
		System.out.println("1.	Add new Property");
		System.out.println("2.	Update property cost");
		System.out.println("3.	Delete property");
		System.out.println("4.	Find by City");
		System.out.println("5.	View all properties");
		System.out.println("6.	Find by cost");
		System.out.println("7.	Find by no of rooms and city");
		System.out.println("8.	Exit");
		System.out.println("Enter your choice number:");
		int menu = sc.nextInt();
		switch(menu)
			{
			case 1:
			{
				try
				{
				System.out.println("Enter propertyId:");
				int propertyId = sc.nextInt();
				System.out.println("Enter number of rooms:");
				String noOfRooms = sc.next();
				System.out.println("Enter are in sqft");
				double areaInSqft = sc.nextDouble();
				System.out.println("Enter floor no");
				int floorno = sc.nextInt();
				System.out.println("Enter city");
				String city = sc.next();
				System.out.println("Enter state");
				String state = sc.next();
				System.out.println("Enter cost");
				double cost = sc.nextDouble();
				System.out.println("Enter owner name");
				String ownerName = sc.next();
				System.out.println("Enter owner contact details");
				String ownerContactNo = sc.next();
				
				Property p = new Property(propertyId,noOfRooms,areaInSqft,floorno,city,state,cost,ownerName,ownerContactNo);
				
				try
				{int count = pdao.addProperty(p);
				if(count > 0)
				{
					System.out.println("Insertd record successfully with record:");
					System.out.println(p.toString());
				}
					
				else
					System.out.println("No record inserted");}
				catch(Exception e) {
					
				}
				}
				catch(Exception e)
				{
					System.out.println("Please enter valid details");
				}
				break;
			}
			case 2:
			{
				try
				{
				System.out.println("Enter property id whose cost you want to update:");
				int id = sc.nextInt();
				System.out.println("Enter new cost:");
				double newcost = sc.nextDouble();
				
					try
					{
					int count = pdao.updateProperty(id,newcost);
					if(count > 0)
						{
							System.out.println("Updated record successfully");
						}
						
					else
						System.out.println("No record updated");
					}
					catch(Exception e) {}
				}
				catch(Exception e)
				{
					System.out.println("Please enter valid input");
				}
				break;
			}
			case 3:
			{
				try
				{
				System.out.println("Enter property id you want to delete:");
				int id = sc.nextInt();
				try
				{
				int count = pdao.deleteProperty(id);
				if(count > 0)
					System.out.println("Delete record successfully");
				else
					System.out.println("No record deleted");
				}
				catch(Exception e){}
				}
				catch(Exception e)
				{
					System.out.println("Please enter valid input");
				}
				break;
			}
			case 4:
			{
				
				System.out.println("Enter name of city:");
				String city = sc.next();
				pdao.searchbyCity(city);
				break;
			}
			case 5:
			{
				pdao.showAllProperties();
				break;
			}
			case 6:
			{
				try
				{
				System.out.println("Enter cost range:");
				double initialcost = sc.nextDouble();
				double finalcost = sc.nextDouble();
				pdao.searchbyCost(initialcost, finalcost);
				}
				catch(Exception e)
				{
					System.out.println("Please enter valid input");
				}
				break;
			}
			case 7:
			{
				try
				{
				System.out.println("Enter no of rooms");
				int noOfRooms = sc.nextInt();
				System.out.println("Enter city");
				String city = sc.next();
				pdao.searchbyRoomCity(noOfRooms, city);
				}
				catch(Exception e)
				{
					System.out.println("Please enter valid input");
				}
				break;
			}
			case 8:
			{
				System.out.println("Program ends. THANK YOU!");
				System.exit(0);
				break;
			}
			default:
			{
				System.out.println("Invalid choice");
				break;
			}
			}
			//System.out.println();
			
		
		
		}
		
	}

}
