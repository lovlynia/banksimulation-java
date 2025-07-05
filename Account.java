//**** IMPORT PACKAGES ****/
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

//****************************************************** */
//Author: Stephanie Abundio 
//Program : NewAccount.java
//Version 1.0 
//CS 152 - Professor Hassan 
//April 16,2025
//Homework 14 - Part 2 
//****************************************************** */


public class Account //class header
{//start of class 

    //**** Creation of private variable of Account Class ****/
    private String user;
    private double balance; 
    private int acctnum;
    private String password;

    private static ArrayList<Account> accounts = new ArrayList<>();//private array to store AccessAccount obj 

    public Account(int acctnumber, String username, double total,String pass)//constructor header
    {//start of constructor
        this.acctnum=acctnumber;
        this.user=username;
        this.balance=total;
        this.password=pass;

    }//end of constructor 

    
    public static void storingAccounts(NewAccount account)//static void method - stores to file 
    {//start of method 
        try
        {//start of try

            FileOutputStream accountInfo=new FileOutputStream("accountInfo.txt",true);//FOS initiated 
            PrintWriter writeTo= new PrintWriter(accountInfo);//PrintWriter Initialized 

            writeTo.println(account.toString());//write to file - toString to print the obj - account is the obj 

            writeTo.close();//close writer
            accountInfo.close();



        }//end of try
        catch (Exception e)//catch statement
        {//start
            System.out.println("File Not Found");//println statement
        }//end 


    }//end of method 


    public static void addAccount(Account myacc)//method header - add Account
    {//start of method 

        accounts.add(myacc);//adds to array 

    }//end of method 

    public static ArrayList<Account> getAccounts()
    {
        return accounts;
    }

    public String getPass()//getter method 
    {//start of method 
        return password;//return statement

    }//end of method 
    
    public double getBalance()//getter method
    {//start of method 
        return balance;//return statement
    }//end of method 

    public String getName()//getter method
    {//start of method 
        return user;//return statement
    }//end of method 

    public int getAcct()//getter method 
    {//start of method 
        return acctnum;//return statement

    }//end of method 


    //**** METHOD OVERRIDING  ****/

    public void deposit(double amt)
    {

        System.out.println("New Balance: "+balance+amt);

    }

    public void withdraw(double amt)
    {
        if(amt>balance){
            System.out.println("Insufficient Funds ");
            return;
        }

        System.out.println("New Balance: "+(balance-amt));



    }



    public void set(double change)//set method
    {//start of set
        this.balance=change;// set change to this.balance
    }//end of set 

    public void setAcctUser(String userid)//set method
    {//start of set 
        this.user=userid;//sets userid to this.user
    }//end of set 

    public void setAcct(int number)//set method
    {//start of set 
        this.acctnum=number;//sets account number to this.acctnum
    }

    public void setpassCode(String code)//set method 
    {//start of set 
        this.password=code;//sets code to this.password
    }//end of set 

    
    
}//end of class 
