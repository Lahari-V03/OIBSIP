import java.util.Scanner;
class accountDetails{
    String fName,lName,userName,accNo,pw;
    String username,password,rNo;
    String history="";
    Float bal=1000000f;
    Float amt;
    int t=0;

    /* method to activate atm account */
    public void create(){
        Scanner s;
        s = new Scanner(System.in);
        System.out.println("Enter the details");
        System.out.println("\nEnter your First Name: ");
        this.fName = s.nextLine();
        System.out.println("\nEnter your Last Name: ");
        this.lName = s.nextLine();
        System.out.println("\nEnter User Name: ");
        this.userName = s.nextLine();
        System.out.println("\nEnter Password: ");
        this.pw = s.nextLine();
        System.out.println("\nEnter your Account number: ");
        this.accNo = s.nextLine();
        System.out.println("\nDetails entered Successfully");
        System.out.println("\n");
    }

    /* method to login into atm to perform certain operations */
    public boolean toLogin(){
        boolean login=false;
        Scanner s;
        s = new Scanner(System.in);
        while(true){
            if (login) {
                break;
            }
            System.out.println("\nEnter the User Name: ");
            this.username=s.nextLine();
            System.out.println("\nEnter the Password:");
            this.password=s.nextLine();
            if(username.equals(userName))
            {
                if(password.equals(pw))
                {
                    System.out.println("\nLogin Successful");
                    login=true;
                }
            }
            else
            {
                System.out.println("\nInvalid User Name or Password");
            }
        }
        return true;
    }

    /* method for transaction history */
    public void transactionHistory(){
        System.out.println(t != 0 ? "\n" + t : "\nNo Transactions has been done");
    }

    /* method to withdraw amount */
    public void withdraw(){
        System.out.println("\nEnter the amount to withdraw: ");
        Scanner s;
        s = new Scanner(System.in);
        this.amt=s.nextFloat();
        if(bal>=amt)
        {
            t = t + 1;
            bal=bal-amt;
            System.out.println("\nAn amount of " + amt +" withdrawn successfully: ");
            history=history.concat(String.valueOf(amt));
            System.out.println("\nAvailable balance: "+bal);
        }
        else{
            System.out.println("\nInsufficient Balance");
            System.out.println("\nAvailable balance: "+bal);
        }
    }

    /* method to deposit amount */
    public void deposit()
    {
        System.out.println("\nEnter amount to deposit: ");
        Scanner s;
        s = new Scanner(System.in);
        this.amt=s.nextFloat();
        if (!(amt <= 50000f)) {
            System.out.println("Amount cannot be deposited");
        } else {
            t = t + 1;
            bal=bal+amt;
            System.out.println("\nAn amount of "+amt+" is deposited successfully");
            history=history.concat(String.valueOf(amt));
        }
        System.out.println("\nAvailable balance: "+bal);
    }

    /* method to transfer amount */
    public void transfer(){
        Scanner s;
        s = new Scanner(System.in);
        System.out.println("\nEnter the account number of the receiver: ");
        this.rNo=s.nextLine();
        System.out.println("\nEnter the amount to transfer: ");
        this.amt=s.nextFloat();
        if (bal < amt || !(amt >= 1000f)) {
            System.out.println("\nAmount cannot be transferred");
        } else {
            t = t + 1;
            bal=bal-amt;
            System.out.println("\nAn amount of "+amt+" has been successfully transferred to "+rNo);
            history=history.concat(String.valueOf(amt));
            System.out.println("\nAvailable balance: "+bal);
        }
    }
}
public class atmInterface {
    public static int userInput(){
        int userChoice=0;
        boolean bool=false;
        if (bool) {
            return userChoice;
        }
        do {
            Scanner s;
            s = new Scanner(System.in);
            userChoice = s.nextInt();
            bool = true;
        }
        while (!bool);
        return userChoice;
    }
    public static void main(String[] args) {
        System.out.println("ATM INTERFACE");
        System.out.println("\nEnter 1 to Activate your ATM account and 2 to Exit");
        int choice1;
        choice1 = userInput();
        switch (choice1) {
            case 1 -> {
                accountDetails ad = new accountDetails();
                ad.create();
                while (true) {
                    System.out.println("\nEnter 1 to Login and 2 to Exit");
                    int choice2;
                    choice2 = userInput();
                    switch (choice2) {
                        case 1:
                            if (ad.toLogin()) {
                                boolean b = false;
                                while (!b) {
                                    System.out.println("\nEnter your choice");
                                    System.out.println("\n1.Transaction History\t2.Withdraw\t3.Deposit\t4.Transfer\t5.Exit");
                                    int choice3;
                                    choice3 = userInput();
                                    switch (choice3) {
                                        case 1 -> ad.transactionHistory();
                                        case 2 -> ad.withdraw();
                                        case 3 -> ad.deposit();
                                        case 4 -> ad.transfer();
                                        case 5 -> System.exit(0);
                                        default -> System.out.println("Enter a valid choice");
                                    }
                                }
                            }
                            break;
                        default:
                            System.exit(0);
                    }
                }
            }
            default -> System.exit(0);
        }
    }
}