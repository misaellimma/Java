package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	private Date moment = new Date();
	private OrderStatus status;
	private Client client;
	private List<OrderItem> itens = new ArrayList<>();
	
	public Order() {
		
	}
	
	public Order(OrderStatus status, Client client) {
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItens() {
		return itens;
	}
	
	public void addItem(OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	
	public Double total() {
		Double sum = 0.0;
		for(OrderItem item : itens) {
			sum += item.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment:" + sdf.format(moment));
		sb.append("\nOrder status: " + status);
		sb.append("\nClient: " + client.getName());
		sb.append(" (" + sdf1.format(client.getBirthDate()));
		sb.append(") - " + client.getEmail());
		sb.append("\nOrder items: \n");
		for(OrderItem item : itens) {
			sb.append(item.toString());
		}
		sb.append("Total price: " + total());

		return sb.toString();
	}
	
	
}
