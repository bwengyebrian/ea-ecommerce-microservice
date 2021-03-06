
Hello!

For this project we used Spring Boot to develop the servces. We developed catalog-service, account-service, order-service, payment-service, bank-payment-service, credit-payment-service, paypal-payment-service, stock-service, shipping-service, and config-management-service.
We used service discovery and secret management.
We used Google Cloud service for deploying our services using Kubernetes.

You can get the source code on this github link: https://github.com/bwengyebrian/ea-ecommerce-microservice

Follow this steps to make requests to the APIs get response:


Step 1: Make a POST request to http://localhost:8080/account/create/ to create an account, you can use the following JSON  body:

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


Step 2: Make a POST request to http://localhost:8080/account/login/2 to login to the system and be able to make order, you can use the following JSON body - it is 
the credential to one of the accounts saved in the system:

{

	"email": "namazzi@abebe.com",
	"password": "1234"
}


The account detail will be returned. Try using a different email and password to login - null (empty JSON) will be returned.


Step 3: Make a POST request to http://localhost:8080/order/addToCart/2 to add a product to cart, you can use the following JSON  body:

{

    "id": 1,
    "itemOrdered": 5
}

The above JSON object is like clicking a displayed product in the catalog page (id specifies the product and itemOrdered specifies the nuber of items you want to order).
We already saved 3 products in the databvase, you can use ids 1 - 3
A list of items in the cart will be displayed (we can add more products to the cart by sending the above request multiple times)

Step 4: Make a POST request to http://localhost:8080/order/placeOrder/ to place an order, you can use the following JSON  body:

{

    "paymentMethodType": "credit"
  
}

You can use "credit", "bank", or "payPal" as a payment methods.
Order detail will be displayed with the payment method included.

Step 5: Make a POST request to http://localhost:8080/order/checkout/2 to make a checkout of the order, you can use the following JSON  body:

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
