package com.c7dataviz.DAO;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.jongo.Jongo;


public class MongoDb {

    private MongoClientURI clientURI;
    private MongoClient mongoClient ;
    private MongoDatabase mongoDatabase;
    private Jongo jongo;

    public MongoDatabase Connect(){
        String uri = "mongodb://localhost:27017";
        this.clientURI = new MongoClientURI(uri);
        this.mongoClient = new MongoClient(clientURI);
        this.mongoDatabase = mongoClient.getDatabase("SuperHeroes");

        return mongoDatabase;
    }

    public String getData(){
        MongoCursor<Document> cursor = this.mongoDatabase.getCollection("SuperHeroes").find().iterator();
        String ret = "[";
        try {

            while (cursor.hasNext()) {
                ret += cursor.next().toJson()+",";
            }
        }finally {
            cursor.close();
        }
        ret += "]";
        return ret;
    }


}
