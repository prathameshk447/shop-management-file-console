package shop_management;
import java.io.IOException;
import java.util.Scanner;
import product_management.productmanagement;
import user_management.usermanagement;



public class ApplicationMain


{
	public static void main(String[]args)throws IOException 
	{
		Scanner scanner = new Scanner(System.in);
		
		
		boolean canIKeepRunningTheProgram = true;
		
		System.out.println("***welcome to shop management***");
		System.out.println("\n");
		
		System.out.println("enter login name");
		String loginName = scanner.nextLine();
		System.out.println("enter password");
		String password = scanner.nextLine();
		
		if(!usermanagement.validateuserandpassword(loginName,password)) 

		
		{
	     System.out.println("!!!!!login failed.colsing the application");
	     return;
        }
		
		while (canIKeepRunningTheProgram == true)
		 {
			
			System.out.println("welcome to the product login program:");
		    System.out.println("\n");
		    System.out.println("what would you like to do");
			System.out.println("1.usermanagement");
			System.out.println("2.productmanagement");
			System.out.println("3.Quit");
			int optionSelectedByUser = scanner.nextInt();
			
			if (optionSelectedByUser==1) {
			   usermanagement.usermanagement1();
			}
			
			else if (optionSelectedByUser==2)
			{
				productmanagement.productmanagement();
				
				}else if (optionSelectedByUser==3) {
					break;
				}
		 }
		
	}

}
