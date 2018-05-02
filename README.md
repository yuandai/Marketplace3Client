# Marketplace3
Marketplace Project

Marketplace is a sample web application, to allow owner posting project online with description, budget and ending date, allow engineer biding the project with proposal and amount, upon project ending date, the system will automatically assign projects to the engineer with lowest amount proposal.


Marketplace web application was developed using Spring Boot, Hibernate/JPA, Postgres and Tomcat, with Java, JavaScript, SQL/HQL, JSON, jQuery, Maven, Git and Eclipse.


The following are the RestAPIs provided:


"C:\Program Files\cURL\bin\curl.exe" -X POST http://localhost:8080/MarketPlace/rest/service/initial

"C:\Program Files\cURL\bin\curl.exe" -d "@person.txt" -H "Content-Type: application/json" -X POST http://localhost:8080/MarketPlace/rest/service/persons 

"C:\Program Files\cURL\bin\curl.exe" -d "@project.txt" -H "Content-Type: application/json" -X POST http://localhost:8080/MarketPlace/rest/service/projects

"C:\Program Files\cURL\bin\curl.exe" -d "@bid.txt" -H "Content-Type: application/json" -X POST http://localhost:8080/MarketPlace/rest/service/bids

"C:\Program Files\cURL\bin\curl.exe" -H "Content-Type: application/json" -X GET http://localhost:8080/MarketPlace/rest/service/projects?name=Mark

"C:\Program Files\cURL\bin\curl.exe" -H "Content-Type: application/json" -X GET http://localhost:8080/MarketPlace/rest/service/bidsByPerson?name=Jonathan

"C:\Program Files\cURL\bin\curl.exe" -H "Content-Type: application/json" -X GET http://localhost:8080/MarketPlace/rest/service/bidsByProject?projectName=PCRepair

"C:\Program Files\cURL\bin\curl.exe" -d "@projectupdate.txt" -H "Content-Type: application/json" -X PUT http://localhost:8080/MarketPlace/rest/service/projects

"C:\Program Files\cURL\bin\curl.exe" -d "@bidupdate.txt" -H "Content-Type: application/json" -X PUT http://localhost:8080/MarketPlace/rest/service/bids

"C:\Program Files\cURL\bin\curl.exe" -X POST http://localhost:8080/MarketPlace/rest/service/assign

