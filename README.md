# cityNBank //Java web app
Dont forget change application.properties as you need.

To start app execute in command line from project folder:
1) mvn package //to compile project
2) mvn spring-boot:run //to run project on server

Task:
Write a web application that serves as a bank. Let it be a bank in the city of N with about 50 inhabitants.

It is necessary to store data about:
1) Clients (identifier, name - address, age);
2) Accounts (identifier, owner ID, amount);
3) Transactions - money transfers between accounts or their refills/write-offs.
The application should contain 3 pages and additional forms:
- List of bank clients, when clicking on the name, the accounts of the selected client are opened (plus the form for adding a new client below);
- List of accounts of the specified client (plus the form below for adding a new account);
- Form for transferring money between accounts (and for refill/write-off: it can be separate forms);
- A page with a list of transactions (at the top of the form is the filter, so that you can select for the period and/or for the specified user);
- Add-ons - at your discretion, for example, in the list of clients you can show sum on all clients accounts, etc.

Task must be done using technologies, tools and libraries: Spring-boot, MySQL database.

From author:
- Database dump is in the "db" folder.
- Devtools is connected to the project.
- The balance is stored as Long, because of Float and Double can not be used due to loss of accuracy. Solution of this question is not the purpose of this work.
- For convenience and further scaling of refills/write-offs their transaction "senderId" has been assigned to "0".
- Transactions that were not successfull have "DENIED" type.
