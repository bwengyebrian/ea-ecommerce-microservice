
Hello!
Follow this steps to run the application:


Step 1: Make a POST request to http://localhost:8094/account/create/ to create an account, you can use the following JSON  body:
{
	"firstName": "chala",
	"lastName": "chube",
	"email": "challa@challa.com",
	"address": {
		"street": "megenagna",
		"city": "Addis Ababa",
		"state": "Ethiopia",
		"zip": "4321"
	}

}

user detail will be saved to database and returned back as JSON object.

Step 2: Make a POST request to http://localhost:8092/order/addToCart/ to add a product to cart, you can use the following JSON  body:
{
    "id": 1,
    "itemOrdered": 5
}

The above JSON object is like clicking a displayed product in the catalog page (id specifies the product and itemOrdered specifies the nuber of items you want to order).
We already saved 3 products in the databvase, you can use ids 1 - 3
A list of items in the cart will be displayed (we can add more products to the cart by sending the above request multiple times)

Step 3: Make a POST request to http://localhost:8092/order/placeOrder/ to place an order, you can use the following JSON  body:
{
    "paymentMethodType": "credit"
  
}

You can use "credit", "bank", or "payPal" as a payment methods.
Order detail will be displayed with the payment method included.

Step 4: Make a POST request to http://localhost:8092/order/checkout/ to make a checkout of the order, you can use the following JSON  body:
{
	"id": 2,
	"street": "Arat Kilo",
	"city": "Dire Dawa",
	"state": "Ethiopia",
	"zip": "1234566"
}

This time we can provide the shipping address. If we send an empty JSON the system will use the address provided in the user's account.
A success message, a list of orderd products, information about payment transaction, and shipping information (wheb the order will be shipped) will be returned.  

End of the File.
