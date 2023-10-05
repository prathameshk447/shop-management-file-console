package product_management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
public class productmanagement 
{
	static ArrayList<product> al = new ArrayList();
    public static void main(String[] args) throws IOException {
    	loadDataFromFileToArrayList();
	Scanner Sc= new Scanner(System.in);
	boolean canIKeepRunningTheProgram = true;
	while (canIKeepRunningTheProgram == true)
	 {
		
		
		System.out.println("welcome to the product management program:");
		System.out.println("\n");
		System.out.println("what would you like to do");
		System.out.println("1. Add product");
		System.out.println("2. Edit product");
		System.out.println("3. Delete product");
		System.out.println("4. Search product");
		System.out.println("5. Quit");
		
		int optionSelectedByProduct = Sc.nextInt();
		if (optionSelectedByProduct==productoptions.QUIT) {
			File file= new File
					(
				"\\Users\\user\\eclipse-workspace\\ShopManagement\\src\\product_management\\productdb.txt");
			FileWriter fileWriter = new FileWriter(file,false);
			BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
			for (product product :al) {
				bufferedWriter.write(
					product.productName+ ","+ product.productId +"," +product.productPrice+","+ product.productQuantity+","+product.productCategory+"\n");
				}
			bufferedWriter.close();
			fileWriter.close();
			file=null;
			
		System.out.println("!!! program closed!!");
		
		canIKeepRunningTheProgram  = false;
		}
	
    else if (optionSelectedByProduct==productoptions.ADD_PRODUCT){
			addproduct();
			System.out.println("\n");
			
			}else if (optionSelectedByProduct ==productoptions.SEARCH_PRODUCT ) {
				System.out.println("Enter product Name to Search");
				Sc.nextLine();
				String sn = Sc.nextLine();
				searchproduct(sn);
				System.out.println("\n");
				
			}else if (optionSelectedByProduct ==productoptions.DELETE_PRODUCT ) {
				System.out.println("Enter product Name to delete");
				Sc.nextLine();
				String deleteproductName = Sc.nextLine();
				deleteproduct(deleteproductName);
				System.out.println("\n");
				
			}
			else if (optionSelectedByProduct ==productoptions.EDIT_PRODUCT) {
				System.out.println("Enter product Name to edit");
				Sc.nextLine();
				String editproductName = Sc.nextLine();
				editproduct(editproductName);
				System.out.println("\n");
			}
	 }
	System.out.println("\n");
	System.out.println("****after while loop");
	

	for(product p:al) {
		System.out.println(p.productName);
		System.out.println(p.productId);
		System.out.println(p.productPrice);
		System.out.println(p.productQuantity);
		System.out.println(p.productCategory);
		
	}
    }
       public static void addproduct()
{
    	   
	Scanner Sc= new Scanner(System.in);
	product productobj=new product();
	System.out.println("product Name:");
	productobj.productName = Sc.nextLine();
	
	System.out.println("product Id:");
	productobj.productId = Sc.nextLine();
	
	System.out.println("product Price:");
	productobj.productPrice = Sc.nextLine();
	
	System.out.println("product Quantity:");
	productobj.productQuantity = Sc.nextLine();
    
	System.out.println("product Category:");
	productobj.productCategory = Sc.nextLine();
	
	System.out.println("productName:"+ productobj.productName);
	System.out.println("productId:"+ productobj.productId);
	System.out.println("productPrice:"+ productobj.productPrice );
	System.out.println("productQuantity:"+ productobj.productPrice);
	System.out.println("productCategory:"+ productobj.productCategory);
	al.add(productobj);

}
       public static void searchproduct(String productName) {
    	   for (product product:al) {
    		   if (product.productName.equalsIgnoreCase(productName)) {
    			   System.out.println("productName:"+ product.productName);
    				System.out.println("productId:"+ product.productId);
    				System.out.println("productPrice:"+ product.productPrice);
    				System.out.println("productQuantity:"+ product.productQuantity);
    				System.out.println("productCategory:"+ product.productCategory);
    			    return;
    		   }
    	   }
    	   System.out.println("product not found");
       }
       public static void deleteproduct(String productName) {
    	   Iterator<product> productIterator = al.iterator();
    	   while (productIterator.hasNext()) {
    		   product product = productIterator.next();
    		   if (product.productName.equalsIgnoreCase(productName)) {
    			   productIterator.remove();
    			   System.out.println("Product"+product.productName+" has been deleted.");
    			   break;
    			   
    			   
    		   }
    	   }
    	   
       }
       
       
       public static void editproduct(String productName) {
    	   for (product product:al) {
    		   if (product.productName.equalsIgnoreCase(productName)) {
    			   Scanner Sc= new Scanner(System.in);
    			   System.out.println("editting product:" + product.productName);

    			   System.out.println("New product Name:");
    				product.productName = Sc.nextLine();
    				System.out.println("New  productId:");
    				product.productId = Sc.nextLine();
    				System.out.println("New productPrice:");
    				product.productPrice = Sc.nextLine();
    				System.out.println("New productQuantity:");
    			    product.productQuantity = Sc.nextLine();
    				System.out.println("New productCategory:");
    				product.productCategory = Sc.nextLine();
    				System.out.println("product information updated.");
    				return;
    		   }
    			   
    		   }
    	   System.out.println("user not found.");
    	   }

public static void loadDataFromFileToArrayList() throws IOException
{
	File file = new File("\\Users\\user\\eclipse-workspace\\ShopManagement\\src\\product_management\\productdb.txt");
	FileReader fr = new FileReader(file);
	BufferedReader br = new BufferedReader(fr);
	String line="";
	while((line=br.readLine())!=null)
	{
		product product = new product();
		String[] productDataArray = line.split(",");
		if(productDataArray.length>3 ) {
			product.productName = productDataArray[0];
			product.productId = productDataArray[1];
			product.productPrice= productDataArray[2];
			product.productQuantity = productDataArray[3];
			product.productCategory = productDataArray[3];
			al.add(product);
		}
		
		}
		br.close();
		fr.close();
		file = null;
	}
public static void productmanagement() {
	// TODO Auto-generated method stub
	
}
}

