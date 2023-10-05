package user_management;
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;


public class usermanagement 
     {
	static ArrayList<user> al = new ArrayList();
	static {
		try {
			loadDataFromFileToArrayList();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
    public static void main(String[] args) throws IOException {
    	loadDataFromFileToArrayList();
	Scanner Sc= new Scanner(System.in);
	boolean canIKeepRunningTheProgram = true;
	while (canIKeepRunningTheProgram == true)
	 {
		
		
		System.out.println("welcome to the user management program:");
	    System.out.println("\n");
	    System.out.println("what would you like to do");
		System.out.println("1. Add User");
		System.out.println("2. Edit User");
		System.out.println("3. Delete User");
		System.out.println("4. Search User");
		System.out.println("5. Quit");
		
		int optionSelectedByUser = Sc.nextInt();
		if (optionSelectedByUser==useroptions.QUIT) {
			File file= new File
					(
				"\\Users\\user\\eclipse-workspace\\ShopManagement\\src\\user_management\\userdb.txt");
			FileWriter fileWriter = new FileWriter(file,false);
			BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
			for (user user :al) {
				bufferedWriter.write(
					user.LoginName+ ","+ user.Password +"," +user.userName+","+ user.userRole+"\n");
				}
			bufferedWriter.close();
			fileWriter.close();
			file=null;
			
		System.out.println("!!! program closed!!");
		
		canIKeepRunningTheProgram  = false;
		}
	
    else if (optionSelectedByUser==useroptions.ADD_USER){
			addUser();
			System.out.println("\n");
			
			}else if (optionSelectedByUser ==useroptions.SEARCH_USER ) {
				System.out.println("Enter User Name to Search");
				Sc.nextLine();
				String sn = Sc.nextLine();
				searchUser(sn);
				System.out.println("\n");
				
			}else if (optionSelectedByUser ==useroptions.DELETE_USER ) {
				System.out.println("Enter User Name to delete");
				Sc.nextLine();
				String deleteUserName = Sc.nextLine();
				deleteUser(deleteUserName);
				System.out.println("\n");
				
			}
			else if (optionSelectedByUser ==useroptions.EDIT_USER) {
				System.out.println("Enter User Name to edit");
				Sc.nextLine();
				String editUserName = Sc.nextLine();
				editUser(editUserName);
				System.out.println("\n");
			}
	 }
	System.out.println("\n");
	System.out.println("****after while loop");
	

	for(user u:al) {
		System.out.println(u.userName);
		System.out.println(u.LoginName);
		System.out.println(u.Password);
		System.out.println(u.confirmPassword);
		System.out.println(u.userRole);
		
	}
    }
       public static void addUser()
{
    	   
	Scanner Sc= new Scanner(System.in);
	user userobj=new user();
	System.out.println("User Name:");
	userobj.userName = Sc.nextLine();
	
	System.out.println("Login Name:");
	userobj.LoginName = Sc.nextLine();
	
	System.out.println("Password:");
	userobj.Password = Sc.nextLine();
	
	System.out.println("confirmPassword:");
    userobj.confirmPassword = Sc.nextLine();
    
	System.out.println("User Role:");
	userobj.userRole = Sc.nextLine();
	
	System.out.println("User Name:"+ userobj.userName);
	System.out.println("Login Name:"+ userobj.LoginName);
	System.out.println("Password:"+ userobj.Password);
	System.out.println("confirm Password:"+ userobj.confirmPassword);
	System.out.println("User Role:"+ userobj.userRole);
	al.add(userobj);

}
       public static void searchUser(String userName) {
    	   for (user user:al) {
    		   if (user.userName.equalsIgnoreCase(userName)) {
    			   System.out.println("User Name:"+ user.userName);
    				System.out.println("Login Name:"+ user.LoginName);
    				System.out.println("Password:"+ user.Password);
    				System.out.println("confirm Password:"+ user.confirmPassword);
    				System.out.println("User Role:"+ user.userRole);
    			    return;
    		   }
    	   }
    	   System.out.println("User not found");
       }
       public static void deleteUser(String userName) {
    	   Iterator<user> userIterator = al.iterator();
    	   while (userIterator.hasNext()) {
    		   user user = userIterator.next();
    		   if (user.userName.equalsIgnoreCase(userName)) {
    			   userIterator.remove();
    			   System.out.println("User"+user.userName+" has been deleted.");
    			   break;
    			   
    			   
    		   }
    	   }
    	   
       }
       
       
       public static void editUser(String userName) {
    	   for (user User:al) {
    		   if (User.userName.equalsIgnoreCase(userName)) {
    			   Scanner Sc= new Scanner(System.in);
    			   System.out.println("editting user:" + User.userName);

    			   System.out.println("New User Name:");
    				User.userName = Sc.nextLine();
    				System.out.println("New Login Name:");
    				User.LoginName = Sc.nextLine();
    				System.out.println("New Password:");
    				User.Password = Sc.nextLine();
    				System.out.println("New confirmPassword:");
    			    User.confirmPassword = Sc.nextLine();
    				System.out.println("New User Role:");
    				User.userRole = Sc.nextLine();
    				System.out.println("user information updated.");
    				return;
    		   }
    			   
    		   }
    	   System.out.println("user not found.");
    	   }

public static void loadDataFromFileToArrayList() throws IOException
{
	File file = new File("\\Users\\user\\eclipse-workspace\\ShopManagement\\src\\user_management\\userdb.txt");
	FileReader fr = new FileReader(file);
	BufferedReader br = new BufferedReader(fr);
	String line="";
	while((line=br.readLine())!=null)
	{
		user user = new user();
		String[] userDataArray = line.split(",");
		if(userDataArray.length>3 ) {
			user.LoginName = userDataArray[0];
			user.Password = userDataArray[1];
			user.userName = userDataArray[2];
			user.userRole = userDataArray[3];
			al.add(user);
		}
		
		}
		br.close();
		fr.close();
		file = null;
	}
public static boolean validateuserandpassword(String loginName,String password)throws IOException{
	Iterator<user>userIterator=al.iterator();
	while(userIterator.hasNext()) {
		user user= userIterator.next();
		if(user.LoginName.equalsIgnoreCase(loginName)&& user.Password.equalsIgnoreCase(password))
			return true;
	}
	return false;
}
public static void usermanagement1() {
	// TODO Auto-generated method stub
	
}

	
}

