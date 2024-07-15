package org.proway.config.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDbConnection {
    private static MongoDbConnection instance;
    private static MongoClient mongoClient;
    private MongoDatabase db;

    public MongoDbConnection(){
        System.setProperty("java.util.logging.ConsoleHandler.level", "OFF");
        System.setProperty("org.mongodb.driver.level", "OFF");

        String url = "mongodb://localhost:27017";
        mongoClient = MongoClients.create(url);
        db = mongoClient.getDatabase("Netflix");
    }

    public static synchronized MongoDbConnection getInstance() {
        if (instance == null) {
            instance = new MongoDbConnection();
        }
        return instance;
    }

    public MongoDatabase getDatabase() {
        return db;
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
