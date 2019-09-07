# MyRetailStore# RetailWebsite
This is the Flow for the Retail website Application. This application is basically used by The Store executive for discount based billing purpose and registering a new customer for the Store.

# Overview
Create Retail website Application	system	which	allows	to	do	following	operations:
1. Login to application for Store Executive.
2. Create new Customer.
3. View Existing customer details.
4. Apply Discounts based on Customer type.
5. Bill Generation based on applied discounts.

System	&	technology	used:

1. Operating	System:	Mac	OSX	High	Sierra.
2. Eclipse	Oxygen.
3. Glassfish 5
4. Java	8
5. JSF	2.x
6. Hibernate	5.x.x
7. Primefaces	6.x.x
8. MySQL	database
9. pom.xml	file	contains	all	the	dependencies	(as	it’s	a	maven	project)


# Credentials
Username : admin Password : admin123


# Store Executive Login

![alt text](https://github.com/mohdfaizkhan/MyRetailStore/blob/master/screenshot/1.png "preview1")

# Retail Application Summary page
In this page you have mainly 3 Tabs, first one is for fetching the customer info and generate discount based bill based on the Customer segments whether he is Staff,Affiliate or Customer who is over  2 years with the store

![alt text](https://github.com/mohdfaizkhan/MyRetailStore/blob/master/screenshot/2.png "preview2")

# Validation 
Validation to Enter Customer ID which is manadatory for all the customers

![alt text](https://github.com/mohdfaizkhan/MyRetailStore/blob/master/screenshot/3.png "preview3")

![alt text](https://github.com/mohdfaizkhan/MyRetailStore/blob/master/screenshot/4.png "preview4")

# Customer Register
![alt text](https://github.com/mohdfaizkhan/MyRetailStore/blob/master/screenshot/5.png "preview5")

![alt text](https://github.com/mohdfaizkhan/MyRetailStore/blob/master/screenshot/8.png "preview8")

# Entry in DB
![alt text](https://github.com/mohdfaizkhan/MyRetailStore/blob/master/screenshot/7.png "preview7")

# Customer Information Summary Flow
On entering Customer ID and clicking on search it will display a panel which will show all the customer related data like his name, address,email,telephone and the segment of the customer with 2 options Bill entry or clear the search

![alt text](https://github.com/mohdfaizkhan/MyRetailStore/blob/master/screenshot/10.png "preview10")

# Bill Entry
On Click of Bill entry option, the below form will appear where i have segregated the Customer purchases as 2 categories grocery items and non grocery items , as both have rsepective discounts for the store. On enetering amount based on purchases and generate bill it will show a popup with Bill invoice

![alt text](https://github.com/mohdfaizkhan/MyRetailStore/blob/master/screenshot/11.png "preview11")

![alt text](https://github.com/mohdfaizkhan/MyRetailStore/blob/master/screenshot/12.png "preview12")

# Test Cases: 
Case 1:- If the user is an employee of the store, he gets a 30% discount

![alt text](https://github.com/mohdfaizkhan/MyRetailStore/blob/master/screenshot/12.png "preview12")

Case 2:- If the user is an affiliate of the store, he gets a 10% discount

![alt text](https://github.com/mohdfaizkhan/MyRetailStore/blob/master/screenshot/13.png "preview13")

Case 3:- If the user has been a customer for over 2 years, he gets a 5% discount.

![alt text](https://github.com/mohdfaizkhan/MyRetailStore/blob/master/screenshot/16.png "preview16")

Case 4 :- For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
as a discount).

![alt text](https://github.com/mohdfaizkhan/MyRetailStore/blob/master/screenshot/14.png "preview14")

Case 5 :- The percentage based discounts do not apply on groceries.

![alt text](https://github.com/mohdfaizkhan/MyRetailStore/blob/master/screenshot/15.png "preview15")


# Code Coverage Report:

![alt text](https://github.com/mohdfaizkhan/MyRetailStore/blob/master/screenshot/CodeCovrage.png "preview16")




