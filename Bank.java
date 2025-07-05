import java.util.Scanner;//scanner

//****************************************************** */
//Author: Stephanie Abundio 
//Program : Bank.java
//Version 1.0 
//CS 152 - Professor Hassan 
//April 16,2025
//Homework 14
//****************************************************** */

public class Bank//class header
 {//start of class 

    public static void main(String[] args) //main header
    
    {//start of main 

        Scanner scan= new Scanner(System.in);//initialize scanner 
        int check=0;//int variable


        do//do statement
        {//start of do 

            System.out.println();//empty println
            System.out.println("\t Main Menu \n1. Create New Account with deposit \n2. Create a New Account without Deposit \n3. Deposit to Existing Account \n4. Withdraw from Existing Account\n5.Exit");//menu
            System.out.println();//empty println 

            System.out.print("Enter Your Choice: ");//prompts user 
            check=scan.nextInt();//reads user input
            scan.nextLine();//consumes nextLine

            switch(check)//switch statement
            {//start of switch

                case 1://case1
                {//start of 1 

                    NewAccount.createAccount(1);//calls NewAccount method
                    break;//break statement
                    
                }//end of 1

                case 2://case 2
                {//start of case 2 

                    NewAccount.createAccount(2);//calls NewAccount method
                    break;//break statement

                }//end of case 2 

                case 3://case 3 
                {//start of case 3

                    AccessAccount res= null;//create AccessAccount set to null

                    while (res==null)//while statement
                    {//start of while 
                        System.out.print("Enter User ID or Username: ");//println statement
                        String myAccess=scan.nextLine();//scans user input

                

                        System.out.print("password: ");//print statement
                        String myAcceskeys=scan.nextLine();//scans user input



                        try
                        {//start of try

                            int accountid=Integer.parseInt(myAccess);//int set to myAccess

                            res=AccessAccount.login(accountid,myAcceskeys);//sets AccessAccount 
                        }//end of try 
                        catch(NumberFormatException e)//exception if parse doesnt work
                        {
                        res=AccessAccount.login(myAccess,myAcceskeys);//username 

                        }

                    }

                    System.out.print("Enter amount your depositing: ");//print statement
                    Double amount=scan.nextDouble();//scans user input

                    res.deposit(amount);//calls method deposit

                    break;//break statement


                }//end of case 3 

                case 4:
                {//start of case 4 

                    AccessAccount res= null;//create AccessAccount set to null

                    while (res==null)//start of while
                    {//start of while
                        System.out.print("Enter User ID or Username: ");//print statement
                        String myAccess=scan.nextLine();//reads user input

                

                        System.out.print("password: ");//print statement
                        String myAcceskeys=scan.nextLine();//reads user input



                        try
                        {//start of try

                            int accountid=Integer.parseInt(myAccess);//int parse

                            res=AccessAccount.login(accountid,myAcceskeys);//res set to AccessAccount Login
                        }//end of try
                        catch(NumberFormatException e)//catch
                        {//start
                        res=AccessAccount.login(myAccess,myAcceskeys);//res set to AccessAccount Login

                        }//end 

                    }//end of while 

                    System.out.print("Enter amount your withdrawing: ");//print statement
                    Double amount=scan.nextDouble();//prompts user 

                    res.withdraw(amount);//calls method withdraw

                    break;//break statement


                }//end of case
                default://default statement
                {//start

                    System.out.println("Thank You ");//print statement

                }//end 



            } //end of switch
        }while(check!=5);//do-while statement end 

    
        
        
    }//end of main
    
}//end of class 
