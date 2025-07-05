//* IMPORT PACKAGES */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

//****************************************************** */
//Author: Stephanie Abundio 
//Program : AccessAccount.java
//Version 1.0
//CS 152 - Professor Hassan 
//April 16,2025
//Homework 14
//****************************************************** */


public class AccessAccount extends Account 
{


    public AccessAccount(String nameid, double newbal, int accountid, String accountpass)//constructor header
    {//start of constructor 
        super(accountid,nameid,newbal,accountpass);//super called 

    }//end of constructor 


    public static void trackTransactions(Account updateAccount,double oldbal,String act,String date,double newbal)//static void method - stores to file 
    {//start of method 

        try
        {//start of try

            FileOutputStream accountInfo=new FileOutputStream("transactions.txt",true);//FOS initiated 
            PrintWriter writeTo= new PrintWriter(accountInfo);//PrintWriter Initialized 

            writeTo.println(updateAccount.getName()+"\t"+updateAccount.getAcct()+"\t"+oldbal+"\t"+act+"\t"+date+"\t"+newbal);//write to file - toString to print the obj - account is the obj 

            writeTo.close();//close writer
        }//end of try
        catch(FileNotFoundException e)//catch statement
        {//start of catch
            System.out.println("File Not Found");//print statement

        }//end of catch

    }//end of method 

    public static AccessAccount login(int acctNum, String pass)//static login method - return AccessAccount
    {//start of method 
        for(Account bankAcc : Account.getAccounts())//for each statement - for every bankAcc in getAccounts 
        {//start of for 
            if(bankAcc.getAcct()==acctNum && bankAcc.getPass().equals(pass))//if statement
            {//start of if 
                System.out.println("Welcome Back! "+bankAcc.getName());//println statement
                return (AccessAccount)bankAcc;//return Access Account
            }//end of if 

        }//end of for 

        System.out.println("Login Failed - Invalid Account Number or Password");
        return null;


    }//end of method 

    public static AccessAccount login(String userid, String pass)//static method login - return type AccessAccount
    {//start of method 

        for(Account bankAcc : Account.getAccounts())//for each statement - for every bankAcc in getAccounts
        {//start of for 
            if(bankAcc.getName().equals(userid) && bankAcc.getPass().equals(pass))//if statement
            {
                System.out.println("Welcome Back! "+bankAcc.getName());//print statement
                return (AccessAccount)bankAcc;//return bankAcc parse to AccessAccount
            }

        }//end of for 

        System.out.println("Login Failed - Invalid Username or Password");//print ln 
        return null;//return empty

    }//end of method 


    public void withdraw(double amt)//override method - withdraw
    {//start of method 
        if(amt>getBalance())//if statement
        {//start of if 
            System.out.println("Insufficient Funds ");//println statement
            return;
        }//end of if 
        else if (amt<=0)//else if statement
        {//start of else if 
            System.out.println("Withdrawal must be greater than 0");//println statement

        }//end of else if 

        double oldbal=getBalance();//store old bal

        String withdraw="withdraw";//string with word withdraw set to it 

        String date=java.time.LocalDate.now().toString();//keeps track of date 

        double newbal=getBalance()-amt;//double new bal 

        set(newbal);//set newbal to obj 

        System.out.println("Withdrew: "+amt+" New Balance: "+newbal);//println statement

        trackTransactions(this,oldbal,withdraw,date,newbal);//print to file 



    }//end of method 

    public void deposit(double amt)//method override - void method deposit
    {//start of method 
        if(amt<=0)//if statement
        {//start of if 
            System.out.println("Deposit must be greater than zero");//println statement
            return;//return statement
        }//end of if 
        

        double oldbal=getBalance();//double oldbal to store user balance

        String deposit="deposit";//string with word deposit set to it 

        String date=java.time.LocalDate.now().toString();//String set to tracking the date 

        double newbal=getBalance()+amt;//double new bal 

        set(newbal);//set newbal to obj 

        System.out.println("Deposited: "+amt+" New Balance: "+newbal);//print ln statement

        trackTransactions(this,oldbal,deposit,date,newbal);//print to file 



    }//end of method 

   



    
}//end of class 
