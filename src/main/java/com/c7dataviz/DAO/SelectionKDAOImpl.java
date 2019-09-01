package com.c7dataviz.DAO;

import com.c7dataviz.DAO.DAOInterface.SelectionKDAO;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

public class SelectionKDAOImpl implements SelectionKDAO {

    @Override
    public ArrayList<String> getDistinctAttribute(String attr) {
        ArrayList<String> fields = new ArrayList<>();
        MongoDb mongoconn = new MongoDb();
        MongoDatabase db = mongoconn.Connect();
        MongoCollection ksel = db.getCollection("KronStadistics");
        DistinctIterable<String> iterable = ksel.distinct(attr,String.class);
        MongoCursor<String> cursor = iterable.iterator();
        while(cursor.hasNext()){
            fields.add(cursor.next());
        }

        return fields;
    }
}
