package com.c7dataviz.DAO;

import com.c7dataviz.DAO.DAOInterface.SuperHeroDAO;
import com.c7dataviz.Model.FilteredSelection;
import com.c7dataviz.Model.SuperHero;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class SuperHeroDAOImpl implements SuperHeroDAO {

    @Override
    public ArrayList<SuperHero> getAllSuperHeroes() {
        MongoDb mongoconn = new MongoDb();
        MongoDatabase db = mongoconn.Connect();
        MongoCursor<Document> cursor = db.getCollection("SuperHeroes").find().iterator();
        ArrayList<SuperHero> superHeroes = new ArrayList<>();

        try{
            while (cursor.hasNext()) {
                Document document = cursor.next();
                try {

                    SuperHero s = new SuperHero(
                            (String) document.get("name"),
                            (String) document.get("Gender"),
                            (String) document.get("Eye color"),
                            (String) document.get("Race"),
                            (String) document.get("Hair color"),
                            (Double) document.get("Height"),
                            (String) document.get("Publisher"),
                            (String) document.get("Skin color"),
                            (String) document.get("Alignment"),
                            (Double) document.get("Weight")
                    );

                    superHeroes.add(s);
                }catch (Exception e){
                    System.out.println(document.toString());
                }
        }
        }finally{
            cursor.close();
        }

        return superHeroes;
    }

    @Override
    public ArrayList<SuperHero> getFilteredSuperHeroes(FilteredSelection selection) {
        MongoDb mongoconn = new MongoDb();
        MongoDatabase db = mongoconn.Connect();
        BasicDBObject whereQuery = new BasicDBObject();

        if(selection.gender.length > 0) whereQuery.put("Gender",new BasicDBObject("$in",selection.gender));
        if(selection.height.length > 0) whereQuery.put("Height",new BasicDBObject("$gt",selection.height[0]).append("$lt",selection.height[1]));
        if(selection.race.length > 0) whereQuery.put("Race", new BasicDBObject("$in", selection.race));
        if(selection.haircolor.length > 0) whereQuery.put("Hair color", new BasicDBObject("$in",selection.haircolor));
        if(selection.eyecolor.length > 0) whereQuery.put("Eye color", new BasicDBObject("$in", selection.height));
        if(selection.publisher.length > 0) whereQuery.put("Publisher", new BasicDBObject("$in",selection.publisher));
        if(selection.skincolor.length > 0) whereQuery.put("Skin color", new BasicDBObject("$in",selection.skincolor));
        if(selection.alignment.length > 0) whereQuery.put("Aligment", new BasicDBObject("$in",selection.alignment));
        if(selection.weight.length > 0) whereQuery.put("Weight",new BasicDBObject("$gt",selection.weight[0]).append("$lt",selection.weight[1]));

        MongoCursor<Document> cursor = db.getCollection("SuperHeroes").find(whereQuery).iterator();
        ArrayList<SuperHero> superHeroes = new ArrayList<>();

        try{
            while (cursor.hasNext()) {
                Document document = cursor.next();
                try {

                    SuperHero s = new SuperHero(
                            (String) document.get("name"),
                            (String) document.get("Gender"),
                            (String) document.get("Eye color"),
                            (String) document.get("Race"),
                            (String) document.get("Hair color"),
                            (Double) document.get("Height"),
                            (String) document.get("Publisher"),
                            (String) document.get("Skin color"),
                            (String) document.get("Alignment"),
                            (Double) document.get("Weight")
                    );

                    superHeroes.add(s);
                }catch (Exception e){
                    System.out.println(document.toString());
                }
            }
        }finally{
            cursor.close();
        }

        return superHeroes;
    }



}
