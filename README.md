#User profile application


#Database configuration with local MongoDB(Community Edition)

   1. Install MongoDB https://www.mongodb.com/try/download/community

   2. Create "data" directory for database storage

   3. To start MongoDB - go to MongoDB Installation dir \bin 
 
   4. run command ./mongod --dbpath={data directory path}/data

#Install MongoDB UI client "MongoDB Compass"

#Create Database schema "receipt-wallet" and collection  "userprofile"


# Start SpringBoot application
   1. Configure MongoDB url in application.properties  (ex: spring.data.mongodb.uri=mongodb://localhost:27017/receipt-wallet)


#Swagger Doc url 
    http://localhost:8080/swagger-ui.html