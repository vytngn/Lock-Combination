/**VY NGUYEN
 * CSC 263-IN 
 * LAB 2 ADTS - LOCK COMBINATION 
 */
import java.util.Scanner;

public class LockClientDemo {

	public static void main(String[] args) throws Exception{
		
		//create a new lock 
		LockDataStructure lock = new LockDataStructure();
	
		int selection;
		boolean cont = true;
		Scanner sc = new Scanner(System.in);
		while(cont) {
			displayMenu();
			System.out.println("Please enter your option: ");
			selection = sc.nextInt();
         	  switch (selection) {
         	  case 1:
                  System.out.print("\nEnter your first number: ");
                  int x = sc.nextInt();
                  System.out.print("\nEnter your second number: ");
                  int y = sc.nextInt();
                  System.out.print("\nEnter your third number: ");
                  int z = sc.nextInt();
                  lock.alter(x,y,z);
                  System.out.println("\nCombination set successfully");
              case 2:
                  lock.close();
                  System.out.println("Closing the lock");
                  break;
              case 3: 
                  lock.inquire();
                  break;
              case 4:
                  System.out.println("Enter your lock combination separated by space: ");
                  x= sc.nextInt();
                  y=sc.nextInt();
                  z=sc.nextInt();
                  
                  lock.attempt(x,y,z);
                  break;
              case 5:
                  System.out.println("The dial is currently at: ");
                  System.out.println(lock.getTopPosition());
                  break;
              case 6:
            		System.out.println("Exiting the program.");
            		cont=false;
            		System.exit(0);
            		break;
              default:
            		System.out.println("Invalid selection. Please choose an option from 1-6");
            		break;
		  	  } 	  
			}
		sc.close();
		}
	
	public static void displayMenu() {
		System.out.println("--------Lock Menu ----------");
		System.out.println("1: set lock combination" +
						"\n2: close lock" + 
						"\n3: check status" +
						"\n4: attempt to open lock" +
						"\n5: check what the dial is currently pointing at" +
						"\n6: exit the program");
	}
}


