//**** IMPORT PACKAGES ****/
import java.util.Random; 
import java.util.Scanner;
import java.io.FileInputStream;

//****************************************************** */
//Author: Stephanie Abundio 
//Program : NewAccount.java
//Version 2.0 
//CS 152 - Professor Hassan 
//April 16,2025
//Homework 14 - Part 2 Version with Parent Class 
//****************************************************** */

public class NewAccount extends Account//class header
{//start of class 

    //****private variable for Account Number****//
    private int accountNum; //private string var 


    //****private variable for Account User Names****//
    private String firstName;
    private String lastName;
    private String username;

    private int [] dob = new int [3];//private array for birthday 

    private String password;//private string password 


    public NewAccount(String name, String surname, double initialDeposit, String dobInput,String username)//contructor  header 1 
    {//start of constructor 
        super(0,"",initialDeposit,"");//super called - empty bc num and pass are generated, and user cant be replicated 

        //**** assign the paramaters and methods ****//
        this.accountNum=accountNumber();
        this.firstName=name;
        this.lastName=surname;
        this.dob=parseBirthday(dobInput);
        this.password=generatePassword();
        this.username=username;

        super.setAcct(accountNum);
        super.setAcctUser(username);
        super.setpassCode(password);


    }//end of constructor 

    public NewAccount(String name, String surname, String dobInput, String username)//constructor header 2 
    {//start of constructor 
        this(name,surname,0,dobInput,username);//this - parameters dont take deposit so deposit set to 0 

    }//end of constructor 

    private static int [] parseBirthday(String dobInput)//private static int method header 
    {//start of method 

        int[] date= new int[3];//int [] array 
        String [] split = dobInput.split("/");//split user input string set to String [] 

        if(split.length==3)//if statement
        {//start of if 
    
            try
            {//start of try 

                //****parse String array set to int month****//
                int month=Integer.parseInt(split[0]);
                int day=Integer.parseInt(split[1]); 
                int year=Integer.parseInt(split[2]); 



                if (month>12 || month<1)//if statement - month
                {//start 
                    System.out.println("Error: Month Does Not Exist");//println statement 
                    return null;//return empty
                    
                }//end
                else if (month==11 || month==4 || month==9 || month==6)//else if statemnet - months 11,4,9,6
                {//start
                    if(day>30 || day<1)// inner if statement - days 
                    {//start of inner if 
                        System.out.println("Error: Day Does Not Exist ");//println statement 
                        return null;//return empty
                    }//end of inner if 
                }//end 
                else if (month==2)//else if - checks month of feb
                {//start
                    if(day>28 || day<1)//inner if statement - days 
                    {//start of inner
                        System.out.println("Error: Day Does Not Exist");//println statement 
                        return null;//return empty
                    }//end of inner 
                }//end
                else if (month==10 || month==12 || month==5 || month==8 || month==1 || month==3)//if statement - months 12,10,8,5,3,1
                {//start of else 
                    if (day>31 || day<1)//inner if statement
                    {//start
                        System.out.println("Error: Day Does Not Exist");//println statement
                        return null;//return empty
                    }//end 

                }//end of else 
                
                if (year<1000 || year>9999)//if statement - checking year
                {//start of if 
                    System.out.println("Error: Invalid Year Format");//println statement
                    return null;//return empty
                }//end of if 
                
                    //**** Setting Array Index to Variable ****//
                    date[0]=month;
                    date[1]=day;
                    date[2]=year;

                    return date;//return array date 
                
                
            }//end of try
            catch(NumberFormatException e)//catch statement
            {//start of catch
                System.out.println("Error: Date contains invalid numbers");//println statement

            }//end of catch
        }//end of if 
        else//else statement
        {//start of else 
            System.out.println("Error: Invalid Format");//println statement
        }//end of else 

        return null;//return null

    }//end of method 

    private String generatePassword()//private method header - method generating passwords 
    {//start of method 
        final int length=12;//set length to 12 
        final String characters= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijknmlopqrstuvwxyz123456789!@#$%&*-_=+<>?";//String variable declared 

        Random generating= new Random(); //initialize random class 

        char[] passwordHolder= new char[length];//array of char created 

            for(int create=0; create<length; create++)//for statement
            {//start of for 

                passwordHolder[create]= characters.charAt(generating.nextInt(characters.length()));//generate password method invoking nextInt and CharAt

            }//end of for 

            password=new String(passwordHolder);//creating new string set to password 

        return password;//return statement 

    }//end of method 

    private int accountNumber()//private method header - method accountNumber generate
    {//start of method


        final int length=7;//final int 
        final String characters= "123456789";//final string

        Random creating= new Random(); //implement random 

        char[] accountHolder= new char[length];//char array to hold password 

        do//do statement 
        {//start of do 

            for(int create=0; create<length; create++)//for loop statement
            {//start

                accountHolder[create]= characters.charAt(creating.nextInt(characters.length()));//generated - assigned to accountHolder
            }//end 

            String change= new String(accountHolder);

            accountNum=Integer.parseInt(change);//accountNum set to new String 

        }//end of do 
        while (duplicateNum(accountNum));//while statement

        return (accountNum);//return statement 
    }//end of method 

    private static boolean duplicateNum(int accountNumbers)//private boolean method - checks for duplicates account num 
    {//start of method 

        try
        {//start of try
            FileInputStream checkFile= new FileInputStream("accountInfo.txt");//checks file
            Scanner reading= new Scanner(checkFile);//scanner initialized 

            while(reading.hasNextLine())//while statement
            {//start of while
                String storing=reading.nextLine();//string set to file nextline 

                String [] splitLine=storing.split("\\s+");//array to split 

                if(splitLine.length==6)//if statement
                {//start of if 
                    String username=splitLine[0];//set array to index 0
                    int verify=Integer.parseInt(username);


                    if(verify==accountNumbers)//if statement
                    {//start
                        return true;//return statement 

                    }//end 

                }//end of if 
                

            }//end of while 

            reading.close();//closing scanner
            checkFile.close();//closing file

        }//end 
        catch (Exception e)//catch statement
        {//start
            System.out.println("File Not Found");//println statement 

        }//end 
        return false;//return statement
    }

    private static boolean duplicateUser(String user)//private boolean method - checks for duplicates account user
    {//start of method 

        try
        {//start of try 
            FileInputStream checkFile= new FileInputStream("accountInfo.txt");//fis initialized
            Scanner reading= new Scanner(checkFile);//scanner initialized 

            while(reading.hasNextLine())//while statement
            {//start of while 
                String storing=reading.nextLine();//string to store next file line

                String [] splitLine=storing.split("\\s+");//string array to split string

                if(splitLine.length==6)//if statement
                {//start of if 
                    String username=splitLine[1];//string username set to array index 1 


                    if(username.equals(user))//if statement
                    {//start
                        return true;//return 

                    }//end

                }//end of if 
                

            }//end of while 

            reading.close();//close scanner
            checkFile.close();//close file

        }//end of try
        catch (Exception e)//catch statement
        {//start of catch
            System.out.println("File Not Found");//println statement

        }//end of catch 
        return false;//return statement
    }//end of method 

    public static void createAccount(int userChoice)//static void method - create account obj 
    {//start of method 
        NewAccount accountnew;//implement NewAccount class accountnew 

        Scanner userinfo= new Scanner(System.in);//initialze scanner 

        System.out.println("Enter Your First Name: "); //println statement
        String name = userinfo.nextLine();//reads user input

        System.out.println();//empty println statement
        System.out.println("Enter Your Last Name: ");//println statement
        String surname= userinfo.nextLine(); //reads user input 


        String birthday="";//empty string made
        double deposits;//double deposits made 

        int []parse=null; //int array set to null

        while(parse==null)//while statement
        {//start of while 
            System.out.println("Enter Your Date of Birth (Format: MM/DD/YYYY)");//println statement
            birthday=userinfo.nextLine();//reads user input 

            parse=parseBirthday(birthday);//parse [] set to the parse version of birthday 
        }//end of while 


        if (duplicateAcct(name,surname,birthday))//if statement - checks if duplicate account is found 
        {//start of if 
            System.out.println("Account Already Exists");//println statement
            return;//return statement
        }//end of if 


        System.out.println();//empty println statement


        String myUser="";//empty string 


        while(true)//while statement
        {//start of while 

            System.out.print("Enter username here: ");//print statement
            myUser=userinfo.nextLine();//reads user input

            if(duplicateUser(myUser))//if statement - condition set to if duplicate username is found 
            {//start of if 
                System.out.println("Error: "+myUser+" is taken. Pick another username");//println statement
            }//end of if 
            else//else statement 
            {//start of else 
                break;//break code
            }//end of else 


        }//end of while 

        if (userChoice==1)//if statement
        {//start of if 

            while(true)//while statement
            {//start of while 
                System.out.println("Enter Deposit Amount: ");//println statement
                String deposit = userinfo.nextLine();//reads user info 

                try
                {//start of try
                    deposits= Double.parseDouble(deposit);//parsing string user input to double 
                    accountnew= new NewAccount(name, surname, deposits,birthday,myUser);//account initalized to create new account obj 
                    break;//break statement
                }//end of try 
                catch(NumberFormatException e)//catch statement
                {//start

                    System.out.println("Error: Invalid Number");//print error message 

                }//end 
            }//end of while 

        }//end of if 
        else//else statement
        {//start of else 

            accountnew= new NewAccount(name, surname, birthday,myUser);//create obj using second constructor parameters 

        }//end of else 


        storingAccounts(accountnew);//write into file 

        //* CREATION OF ACCESS ACCOUNT TO SEND AS ACCOUNT OBJ  */
        String storePass=accountnew.getPass();
        int storeNum=accountnew.getAcct();
        String storeUser=accountnew.getName();
        double storeBal=accountnew.getBalance();


        AccessAccount accesstoNew= new AccessAccount(storeUser, storeBal, storeNum, storePass);//create AccessAccount obj
        
        Account.addAccount(accesstoNew);//add to Account Array

        //*************************************************** */

        System.out.println();//empty println 
        System.out.println("your password: "+accountnew.getPass()+"\n Account Number: "+accountnew.getAcct());
        System.out.println(accountnew.getBalance()+" has been deposited to the account");//println statement
        

    }//end of method 

    private static boolean duplicateAcct(String name, String lastname, String birthday)//boolean method private takes in 3 string parameters
    {//start of method 
        try
        {//start of try 
            FileInputStream checkFile= new FileInputStream("accountInfo.txt");//fis initialized 
            Scanner reading= new Scanner(checkFile);//scanner initialized

            while(reading.hasNextLine())//while statement
            {//start of while 
                String storing=reading.nextLine();//string saves file line 

                String [] splitLine=storing.split("\\s+");//split string set to array

                if(splitLine.length==6)//if statement 
                {//start of if 

                    //**** Setting Array Indexes to Strings  ****/
                    String first=splitLine[3];
                    String last= splitLine[4];
                    String dob= splitLine[5];

                    if(first.equals(name) && last.equals(lastname) && dob.equals(birthday))//if statement
                    {//start of if 
                        return true;//return statement

                    }//end of if 

                }//end of if 
                

            }//end of while 

            reading.close();//close scanner
            checkFile.close();//close file 

        }//end of try
        catch (Exception e)//catch statement
        {//start of catch
            System.out.println("File Not Found");//println statement

        }//end of catch
        return false;//return statement

    }//end of method 



    public String toString()//toString method
    {//start of method
        return accountNum+"\t"+username+"\t"+password+"\t"+firstName+"\t"+lastName+"\t"+dob[0]+"/"+dob[1]+"/"+dob[2]+"\t";//return statement 


    }//end of method 

  



}//end of class 
