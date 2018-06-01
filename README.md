# cityNBank
Dont forget change application.properties as you need.
To start app execute in command line from project folder:
mvn package //to compile project
mvn spring-boot:run //to run project on server

Task:
Write a web application that serves as a bank. Let it be a bank in the city of N with about 50 inhabitants.
It is necessary to store data about:
Customers (identifier, name - address, age);
Accounts (identifier, owner ID, amount);
Transactions - money transfers between accounts or their refills/write-offs.
The application should contain 3 pages and additional forms:
список клиентов банка, при щелчке по имени открываются счета выбранного клиента (плюс внизу форма для добавления нового клиента);
список счетов заданного клиента (плюс внизу форма для добавления нового счёта);
форма для перевода денег между счетами (и для пополнения / списания денег: это могут быть отдельные формы, на ваш вкус);
страница со списком транзакций (сверху форма фильтра, чтобы можно было выбрать за период и/или по заданному пользователю);
дополнения — на ваш вкус, например, в списке клиентов можно сумму на всех счетах у каждого выводить и т. п.

Task must be done using technologies, tools and libraries: Spring-boot, MySQL database.

From author:
Database dump is in the "db" folder.
Devtools is connected to the project.
The balance is stored as Long, because of Float and Double can not be used due to loss of accuracy. Solution of this question is not the purpose of this work.
For convenience and further scaling of refills/write-offs their transaction "senderId" has been assigned to "0".
Transactions that were not successfull have "DENIED" type.
