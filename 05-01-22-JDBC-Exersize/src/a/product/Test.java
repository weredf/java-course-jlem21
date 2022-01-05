package a.product;

public class Test {

	public static void main(String[] args) {

		ProductDao productDao = new ProductDao();
//		productDao.create(); // create new table
		
		// add 10 products to the table and print
		for (int i = 0; i < 10; i++) {
			Product product = new Product(0, "package", 20);
			productDao.save(product);
			System.out.println(product);
		}
		
//		Product p = productDao.get(1);
//		System.out.println(p);
		for (int i = 0; i < 10; i++) {
			Product product = productDao.get(i);
			System.out.println(product);
		}
//		Product p2 = new Product(0, "envelope", 5);
//		productDao.update(p2);
//		System.out.println("updated: " + p2);
//		productDao.delete(2);
//		System.out.println("deleted");
		System.out.println("===END===");
	}

}
