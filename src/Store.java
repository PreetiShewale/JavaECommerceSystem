
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Products.Cart;
import Products.Product;
import TypeOfUser.Admin;
import TypeOfUser.Customer;
import TypeOfUser.Seller;

public class Store {

	public static void main(String[] args) {
		System.out.println("Welcome to ecommerce project");
		System.out.println("Which user are you? .1.Customer 2.Seller 3.Admin");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		if (choice == 1) {
			String typeofuser;
			typeofuser = "Customer";
			Customer current = new Customer();
			System.out.println("What is your userID? ");
			sc.nextLine();
			current.setUserID(sc.nextLine());
			System.out.println("What is your Password? ");
			sc.nextLine();
			current.setPassword(sc.nextLine());
			if (current.verifyUser() == true) {
				System.out.println("User Verified! ");
				while (true) {
					System.out.println(
							"Do you want to-1.view products 2. vies cart 3.Order any product 4.Contact us 5.exit");
					choice = sc.nextInt();

					if (choice == 1) {
						Catalogue catalogue = new Catalogue();
						Product[] Allproducts = catalogue.getListofAllProducts();
						for (int i = 0; i < Allproducts.length; i++) {
							System.out.println(Allproducts[i].getProductID() + " " + Allproducts[i].getProductName()
									+ " " + Allproducts[i].getCost() + " ");
						}

						System.out.println("Do you want to add any product to cart? Y/N");

						sc.nextLine();
						String addtocart = sc.nextLine();
						if (addtocart.equals("Y")) {
							System.out.println("Input the product id of product which you want to add to cart ");
							String productid = sc.nextLine();
							Product[] cartproducts = new Product[1];
							for (int i = 0; i < Allproducts.length; i++) {
								if (Allproducts[i].getProductID().equals(productid))
									cartproducts[0] = Allproducts[i];

								Cart cart = new Cart();
								cart.setCartID("1");
								cart.setListofproducts(cartproducts);
								// System.out.println(cartproducts[i].getProductName());
								current.setCart(cart);
								// System.out.println("The product is successfully added to the cart ");
							}
							System.out.println("The product is successfully added to the cart ");
						} else {
							System.out.println("OK, THANK YOU");
						}

					} else if (choice == 2) {
						Product[] cartproducts = current.getCart().getListofproducts();
						System.out.println(current.getCart().getCartID());
						for (int i = 0; i < cartproducts.length; i++) {
							System.out.println(i);
							System.out.println(cartproducts[i].getProductID() + " " + cartproducts[i].getProductName()
									+ " " + cartproducts[0].getCategoryName() + " " + cartproducts[i].getCost() + " ");
						}

						System.out.println("Do you want to checkout? Y/N ");
						sc.nextLine();
						String checkout = sc.nextLine();
						if (checkout.equals("Y")) {
							if (current.getCart().checkout()) {
								System.out.println("Your order is placed successfully ");
							}
							File file1 = new File("Pratik.txt");

							try {
								file1.createNewFile();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							boolean exits = file1.exists();
							if (exits == true) {
								System.out.println("Product id= " + cartproducts[0].getProductID() + "Product Name= "
										+ cartproducts[0].getProductName() + "Product Category= "
										+ cartproducts[0].getCategoryName() + "Product Cost= "
										+ cartproducts[0].getCost());
							}
						}
					} else if (choice == 3) {
						Catalogue catalogue = new Catalogue();
						Product[] Allproducts = catalogue.getListofAllProducts();
						System.out.println("Want to order now?  Y/N");
						sc.nextLine();
						String order = sc.nextLine();
						if (order.equals("Y")) {
							System.out.println("Input product id which you want to order ");
							String productid1 = sc.nextLine();
							System.out.println("Input product name which you want to order ");
							String productname1 = sc.nextLine();
							System.out.println("Input product price which you want to order ");
							String productprice1 = sc.nextLine();
							Product[] orderedproducts = new Product[1];
							for (int i = 0; i < Allproducts.length; i++) {
								if (Allproducts[i].getProductID().equals(productid1))
									orderedproducts[0] = Allproducts[i];
							}

							Order o1 = new Order();
							o1.setOrderID("1");
							System.out.println("The product " + productname1 + " is ordered  successfully");
						} else {
							System.out.println("OK, THANK YOU");
						}
					} else if (choice == 4) {
						System.out.println("To contact us, please mail on store@ecommerde.com ");
					} else if (choice == 5) {
						System.out.println("OK, THANK YOU FOR USING OUR WEBSITE");
						break;
					} else {
						System.out.println("Invalid choice, please try again ");
					}

				}

			}
		}

		else if (choice == 2) {
			String typeofuser;
			typeofuser = "Seller";
			Seller current1 = new Seller();
			System.out.println("What is your userID? ");
			sc.nextLine();
			current1.setUserID(sc.nextLine());
			System.out.println("What is your Password? ");
			sc.nextLine();
			current1.setPassword(sc.nextLine());
			if (current1.verifyUser() == true)
				System.out.println("User Verified! ");
			while (true) {
				System.out.println(
						"Do you want to-1.view products 2.add any product  3.Order any product 4.contact us 5.Exit");
				choice = sc.nextInt();

				if (choice == 1) {
					Catalogue catalogue = new Catalogue();
					Product[] Allproducts = catalogue.getListofAllProducts();
					for (int i = 0; i < Allproducts.length; i++) {
						System.out.println(Allproducts[i].getProductID() + " " + Allproducts[i].getProductName() + " "
								+ Allproducts[i].getCost() + " ");
					}
				} else if (choice == 2) {
					System.out.println("Do you want to add product?  Y/N");
					sc.nextLine();
					String addtoproduct = sc.nextLine();
					if (addtoproduct.equals("Y")) {

						System.out.println("Input the product id of product which you want to add to products ");
						String productid = sc.nextLine();
						System.out.println("Input the product name of product which you want to add to products ");
						String productname = sc.nextLine();
						System.out.println("Input the product price of product which you want to add to products ");
						String productprice = sc.nextLine();

						Product[] products = new Product[1];

						System.out.println("The product " + productname + " is successfully added to the products ");
					} else {
						System.out.println("OK, THANK YOU ");
					}
				} else if (choice == 3) {
					Catalogue catalogue = new Catalogue();
					Product[] Allproducts = catalogue.getListofAllProducts();
					System.out.println("Want to order now?  Y/N");
					sc.nextLine();
					String order = sc.nextLine();
					if (order.equals("Y")) {
						System.out.println("Input product id which you want to order ");
						String productid1 = sc.nextLine();
						System.out.println("Input product name which you want to order ");
						String productname1 = sc.nextLine();
						System.out.println("Input product price which you want to order ");
						String productprice1 = sc.nextLine();
						Product[] orderedproducts = new Product[1];
						for (int i = 0; i < Allproducts.length; i++) {
							if (Allproducts[i].getProductID().equals(productid1))
								orderedproducts[0] = Allproducts[i];
						}

						Order o1 = new Order();
						o1.setOrderID("1");
						System.out.println("The product " + productname1 + " is ordered  successfully");

					} else {
						System.out.println("OK, THANK YOU");
					}

				} else if (choice == 4) {
					System.out.println("To contact us, please mail on store@ecommerde.com ");
				} else if (choice == 5) {
					System.out.println("OK, THANK YOU FOR USING OUR WEBSITE");
					break;
				} else {
					System.out.println("Invalid choice, please try again ");
				}
			}

		}

		else if (choice == 3) {
			String typeofuser;
			typeofuser = "Admin";
			Admin current1 = new Admin();
			System.out.println("What is your userID? ");
			sc.nextLine();
			current1.setUserID(sc.nextLine());
			System.out.println("What is your Password? ");
			sc.nextLine();
			current1.setPassword(sc.nextLine());
			if (current1.verifyUser() == true) {
				System.out.println("User Verified! ");
				while (true) {
					System.out.println(
							"Do you want to-1.view products 2.view cart 3.add any product  4.Order any product  5.contact us 6.Exit");
					choice = sc.nextInt();

					if (choice == 1) {
						Catalogue catalogue = new Catalogue();
						Product[] Allproducts = catalogue.getListofAllProducts();
						for (int i = 0; i < Allproducts.length; i++) {
							System.out.println(Allproducts[i].getProductID() + " " + Allproducts[i].getProductName()
									+ " " + Allproducts[i].getCost() + " ");
						}
						System.out.println("Do you want to add any product to cart? Y/N");

						sc.nextLine();
						String addtocart = sc.nextLine();
						if (addtocart.equals("Y")) {
							System.out.println("Input the product id of product which you want to add to cart ");
							String productid = sc.nextLine();
							Product[] cartproducts = new Product[1];
							for (int i = 0; i < Allproducts.length; i++) {
								if (Allproducts[i].getProductID().equals(productid))
									cartproducts[0] = Allproducts[i];
							}
							Cart cart = new Cart();
							cart.setCartID("1");
							cart.setListofproducts(cartproducts);
							// System.out.println(cartproducts[i].getProductName());
							// current1.setCart(cart);
							System.out.println("The product is successfully added to the cart ");
						} else {
							System.out.println("OK, THANK YOU");
						}
					} else if (choice == 2) {
						Product[] cartproducts = current1.getCart().getListofproducts();
						System.out.println(current1.getCart().getCartID());
						for (int i = 0; i < cartproducts.length; i++) {
							System.out.println(i);
							System.out.println(cartproducts[i].getProductID() + " " + cartproducts[i].getProductName()
									+ " " + cartproducts[i].getCost() + " ");
						}

						System.out.println("Do you want to checkout? Y/N ");
						sc.nextLine();
						String checkout = sc.nextLine();
						if (checkout.equals("Y")) {
							if (current1.getCart().checkout()) {
								System.out.println("Your order is placed successfully ");

							}
							File file1 = new File("Pratik.txt");
							try {
								file1.createNewFile();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							boolean exits = file1.exists();
							if (exits == true) {
								System.out.println("Product id= " + cartproducts[0].getProductID() + "Product Name= "
										+ cartproducts[0].getProductName() + "Product Category= "
										+ cartproducts[0].getCategoryName() + "Product Cost= "
										+ cartproducts[0].getCost());
							}
						}
					} else if (choice == 3) {
						System.out.println("Do you want to add product?  Y/N");
						sc.nextLine();
						String addtoproduct = sc.nextLine();
						if (addtoproduct.equals("Y")) {

							System.out.println("Input the product id of product which you want to add to products ");
							String productid = sc.nextLine();
							System.out.println("Input the product name of product which you want to add to products ");
							String productname = sc.nextLine();
							System.out.println("Input the product price of product which you want to add to products ");
							String productprice = sc.nextLine();

							Product[] products = new Product[1];

							System.out
									.println("The product " + productname + " is successfully added to the products ");
						} else {
							System.out.println("OK, THANK YOU ");
						}

					} else if (choice == 4) {
						Catalogue catalogue = new Catalogue();
						Product[] Allproducts = catalogue.getListofAllProducts();
						System.out.println("Want to order now?  Y/N");
						sc.nextLine();
						String order = sc.nextLine();
						if (order.equals("Y")) {
							System.out.println("Input product id which you want to order ");
							String productid1 = sc.nextLine();
							System.out.println("Input product name which you want to order ");
							String productname1 = sc.nextLine();
							System.out.println("Input product price which you want to order ");
							String productprice1 = sc.nextLine();
							Product[] orderedproducts = new Product[1];
							for (int i = 0; i < Allproducts.length; i++) {
								if (Allproducts[i].getProductID().equals(productid1))
									orderedproducts[0] = Allproducts[i];

								Order o1 = new Order();
								o1.setOrderID("1");
								System.out.println("The product" + productname1 + " is ordered  successfully");
							}
						} else {
							System.out.println("OK, THANK YOU");
						}
					} else if (choice == 5) {
						System.out.println("To contact us, please mail on store@ecommerde.com ");
					} else if (choice == 6) {
						System.out.println("OK, THANK YOU FOR USING OUR WEBSITE");
						break;
					} else {
						System.out.println("Invalid choice, please try again ");
					}
				}
			}
		} else {
			System.out.println("Invalid input, Try again");

		}

		// private static void Customer() {
		// TODO Auto-generated method stub
//	}

//	private static void checkingfortypeofuser() { 
		// TODO Auto-generated method stub
		// }
	}
}
