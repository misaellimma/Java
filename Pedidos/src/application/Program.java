package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data:");
		System.out.println("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Order order = new Order(status, client);
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Enter #" + (i + 1) +" item data:");
			System.out.println("Product name: ");
			String productName = sc.nextLine();
			System.out.println("Product price: ");
			Double price = sc.nextDouble();
			System.out.println("Quantity: ");
			Integer quantity = sc.nextInt();
			sc.nextLine();
			Product product = new Product(productName, price);
			OrderItem item = new OrderItem(quantity, price, product);
			order.addItem(item);
		}
		
		
		System.out.println(order);
		
		sc.close();

	}

}
