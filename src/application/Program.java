package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int n = 0;
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		sc.nextLine();
		System.out.print("Holder: ");
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		Double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		
		Account acc1 = new Account(number, holder, balance, withdrawLimit);
		
		do {
			try {
				System.out.print("Enter amount for withdraw: ");
				Double amount = sc.nextDouble();
				System.out.println();
				System.out.print("New balance: " + acc1.withdraw(amount));
				n++;
			}
			catch(DomainException e){
				System.out.print("Error: " + e.getMessage());;
			}
		}while(n!=1);
		sc.close();
	}
}
