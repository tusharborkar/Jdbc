package com;

import java.util.*;

public class CoffeeShopDemo {

	public static void main(String[] args) {

		System.out.println("1.  cold coffee Rs.20");
		System.out.println("2.  Hot coffee Rs.30");
		System.out.println("3.  both cold and hot coffee ");

		Scanner scanner = new Scanner(System.in);
		int selection = scanner.nextInt();

		switch (selection) {
		case 1:
			System.out.println("How Much HOT Coffee Do You Want");
			break;
		case 2:
			System.out.println("How Much COLD Coffee Do You Want");
			break;
		case 3:
			System.out.println("Want both HOT and COLD Coffee");
			break;
		case 4:
			System.out.println("Invalid Number, plz try valid Number");
		}

		System.out.println("enter your quantity");
		int quantity = scanner.nextInt();
		int price = quantity * 20;
		System.out.println("Total price is ");
		System.out.println(price);
		System.out.println("plz pay ammount via cash");
		int gotcash = scanner.nextInt();
		if (gotcash > price) {
			System.out.println("u gave more cash than current ammount");
			System.out.println(gotcash - price);
		} else if (gotcash < price) {
			System.out.println("u gave less cash than current ammount");
			System.out.println(price - gotcash);
		} else if (gotcash == price) {
			System.out.println("thank you");
		} else {

			System.out.println("invalid type");
		}

	}

}