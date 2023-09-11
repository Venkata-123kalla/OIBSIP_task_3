import java.util.Scanner;
import java.util.ArrayList;
class ATM 
{
    public static void main(String[] args) 
	{
        Scanner input = new Scanner(System.in);
		int pinAttempts = 0;
        int pin = 0;
		int num;
		int balance=0;
        boolean isAuthorized = false;
		ArrayList<String>transactionHistory = new ArrayList<String>();
        while(pinAttempts<3&&!isAuthorized) 
		{
            System.out.println("Welcome to MyBank ATM!");
            System.out.print("Create your 4-digit PIN: ");
            num = input.nextInt();
			System.out.println("Enter your 4-digit PIN");
			pin=input.nextInt();
            if(pin==num)			
			{
                isAuthorized=true;
                System.out.println("PIN accepted. You can now proceed.");
                break;
            } 
			else 
			{
                pinAttempts++;
                System.out.println("Invalid PIN. Please try again.");
                if(pinAttempts==3) 
				{
                    System.out.println("You have exceeded the maximum number of attempts. The ATM is now locking your card.");
                    return;
                }
            }
        }

        while (isAuthorized) 
		{
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch(choice) 
			{
                case 1:
                    System.out.println("Your balance is .5000");
                    transactionHistory.add("Checked balance");
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int amount = input.nextInt();
                    if(amount>0&&amount<=5000) 
					{
                        System.out.println("Please take your cash.");
                        transactionHistory.add("Withdrawn $"+amount);
                    } 
					else 
					{
                        System.out.println("Invalid amount. Please try again.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    int deposit = input.nextInt();
                    if(deposit>0) 
					{
                        System.out.println("$"+deposit+" has been deposited to your account.");
						
                        transactionHistory.add("Deposited $"+deposit);
                    } 
					else 
					{
                        System.out.println("Invalid amount. Please try again.");
                    }
                    break;
                case 4:
                    System.out.println("Transaction history:");
                    for (String transaction : transactionHistory) 
					{
                        System.out.println(transaction);
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using MyBank ATM!");
                    isAuthorized = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        input.close();
    }
}
