import Products.Product;

public class Catalogue {
 private Product [] listofAllProducts;

 public Product[] getListofAllProducts() {
		Product product1= new Product();
		product1.setProductID("1");
		product1.setProductName("Samsung M10");
		product1.setCost("10,000");
		product1.setCategoryName("Electronic Device");
		Product product2= new Product();
		product2.setProductID("2");
		product2.setProductName("Cutlery");
		product2.setCost("650");
		product2.setCategoryName("House Hold");
		listofAllProducts= new Product[2];
		listofAllProducts[0]= product1;
		listofAllProducts[1]= product2;
		return listofAllProducts;
		
}

public void setListofAllProducts(Product[] listofAllProducts) {
	this.listofAllProducts = listofAllProducts;
}
}
