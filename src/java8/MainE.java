package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Given a list of Product objects and a limit, 
 * return the names of the cheapest in-stock products.
*/
public class MainE {
	static class Product{
		final String name;
		final int price;
		final boolean inStock;
		Product(String name, int price, boolean inStock) {
			super();
			this.name = name;
			this.price = price;
			this.inStock = inStock;
		}
		public String getName() {
			return name;
		}
		public int getPrice() {
			return price;
		}
		public boolean isInStock() {
			return inStock;
		}
	}
	public static void main(String[] args) {
		List<Product> products = Arrays.asList(
				new Product("Keyboard", 80, true),
				new Product("Mouse", 25, false),
				new Product("Stand", 40, true),
				new Product("Cable", 40, true),
				new Product("Monitor", 200, true)
				);
		List<String>names = cheapestProductNames(products, 3);
		System.out.println("products="+ names);
	}
	private static List<String> cheapestProductNames(List<Product> products, long limit) {
		
		return products.stream().filter(Product::isInStock).sorted(Comparator.comparing(Product::getPrice))
				.limit(limit)
				.map(Product::getName).collect(Collectors.toList());
	}

}
