package com.example;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        // MongoDB connection string (local MongoDB instance)
        String uri = "mongodb://localhost:27017"; // Update this if necessary
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("employee"); // Replace with your database name

        // Access the "employees" collection
        MongoCollection<Document> collection = database.getCollection("test");

        // Create a query to find an employee by name
        Document query = new Document("name", "kavi");
        

        // Find documents using the query
        FindIterable<Document> result = collection.find(query);

        // Iterate through the results and print them
        for (Document employee : result) {
            System.out.println("Employee found: " + employee.toJson());
        }

        // Close the MongoDB connection
        mongoClient.close();
    }
}
