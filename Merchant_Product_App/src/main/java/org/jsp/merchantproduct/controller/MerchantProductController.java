package org.jsp.merchantproduct.controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.*;

import org.jsp.merchantproduct.dao.MerchantDao;
import org.jsp.merchantproduct.dao.ProductDao;
import org.jsp.merchantproduct.dto.Merchant;
import org.jsp.merchantproduct.dto.Product;
public class MerchantProductController 
{
	static MerchantDao mdao=new MerchantDao();
	static Scanner sc=new Scanner(System.in);
	static ProductDao pdao=new ProductDao();
	
	public static void main(String[] args) 
	{
		System.out.println("1.Save Merchant");		
		System.out.println("2.Update Merchant");
		System.out.println("3.Find Merchant by id");
		System.out.println("4.Verify Merchant by Email and Password");
		System.out.println("5.Verify Merchant by Phone and Password");
		System.out.println("6.Add Product");
		System.out.println("7.Update Product");
		System.out.println("8.Find Products By Merchant id");
		System.out.println("9.Find Products By Brand");
		System.out.println("10.Find Products By Category");
		
		System.out.println("Enter Your Choice!");
		int choice=sc.nextInt();
		switch (choice) {
		case 1:saveMerchant();
			break;
			
		case 2:updateMerchant();
		break;
		
		case 3:findMerchantById();
		break;
		
		case 4:verifyMerchantByEmailAndPassword();
		break;
		
		case 5:verifyMerchantByPhoneAndPassword();
		break;
		
		case 6:addProduct();
		break;
		
		case 7:updateProduct();
		break;
		
		case 8:findProductsByMerchantId();
		break;
		
		case 9:findProductsByBrand();
		break;
		
		case 10:findProductsByCategory();
		break;

		default:System.err.println("Guldu,Open your eyes and see only 10 choices are ");
			break;
		}
		
	}

	private static void findProductsByCategory() {
		// TODO Auto-generated method stub
		
	}

	private static void findProductsByBrand() 
	{
		System.out.println("Enter the brand name to find Products");
		String brand=sc.next();
		List<Product>lpdb=pdao.findProductsByBrand(brand);
		if(lpdb.size()>0)
		{
			for (Product product : lpdb) {
				System.out.println(product);
			}
		}
		else
		{
			System.err.println("No Product info found since brand name is invalid");
		}
		
	}

	private static void findProductsByMerchantId() 
	{
		System.out.println("Enter Merchant id to display Products info ");
		int mid=sc.nextInt();
		
		List<Product>lpdb=pdao.findProductsByMerchantId(mid);
		if(lpdb.size()>0)
		{
			for (Product product : lpdb) {
				System.out.println(product);
			}
		}
		else
		{
			System.err.println("No Product info found since mid is invalid");
		}
		
		
	}

	private static void updateProduct() {
		// TODO Auto-generated method stub
		
	}

	private static void addProduct() 
	
	{
		System.out.println("Enter Merchant id to add the product");
		int mid=sc.nextInt();
		System.out.println("Enter the Product info ---name,brand,category,cost");
		Product p=new Product();
		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setCategory(sc.next());
		p.setCost(sc.nextDouble());
	
		Product pdb=pdao.addProduct(mid,p);
		if(pdb!=null)
		{
			System.out.println("Product is added with an id "+pdb.getId());
		}
		else
		{
			System.err.println("Product is not added since merchant id is invalid");
		}
		
	}

	private static void verifyMerchantByPhoneAndPassword() {
		// TODO Auto-generated method stub
		
	}

	private static void verifyMerchantByEmailAndPassword() 
	{
		System.out.println("Enter email id ");
		String em=sc.next();
		System.out.println("Enter Password");
		String pw=sc.next();
		Merchant mdb=mdao.verifyMerchantByEmailAndPassword(em,pw);
		if(mdb!=null)
		{
			System.out.println("Merchant is Verified!!");
		}
		else
		{
			System.err.println("Merchant is not verified!!");
		}
		
	}

	private static void findMerchantById()
	{
		System.out.println("Enter Merchant id to find Merchant");
		int id=sc.nextInt();
		Merchant mdb=mdao.findMerchantById(id);
		if(mdb!=null)
		{
			System.out.println(mdb);
		}
		else
		{
			System.err.println("No Merchant info found since merchant id is invalid");
		}
		
	}

	private static void updateMerchant() 
	{
		System.out.println("Enter the Merchant info with id---id,name,phone,gst_num,email,password");
		Merchant m=new Merchant();
		m.setId(sc.nextInt());
		m.setName(sc.next());
		m.setPhone(sc.nextLong());
		m.setGst_num(sc.next());
		m.setEmail(sc.next());
		m.setPassword(sc.next());
		
		Merchant mdb=mdao.updateMerchant(m);
		if(mdb!=null) 
		{
			System.out.println("Merchant Record is updated");
			
		}
		else
		{
			System.err.println("Merchant  info is not updated");
		}
		
		
	}

	private static void saveMerchant() 
	{
		System.out.println("Enter Merchant info---name,phone,gst_number,email,password");
		String nm=sc.next();
		long ph=sc.nextLong();
		String gst=sc.next();
		String em=sc.next();
		String pw=sc.next();
		
		Merchant m=new Merchant();
		m.setName(nm);
		m.setPhone(ph);
		m.setGst_num(gst);
		m.setEmail(em);
		m.setPassword(pw);
		Merchant mdb=mdao.saveMerchant(m);
		System.out.println("Merchant is saved with an id "+mdb.getId());
		
	}

}






