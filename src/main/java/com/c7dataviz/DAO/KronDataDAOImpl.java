package com.c7dataviz.DAO;

import com.c7dataviz.DAO.DAOInterface.KronDataDao;
import com.c7dataviz.Model.FilteredKSelection;
import com.c7dataviz.Model.KronData;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


public class KronDataDAOImpl implements KronDataDao {
    @Override
    public ArrayList<KronData> getAllData() {
        MongoDb mongoconn = new MongoDb();
        MongoDatabase db = mongoconn.Connect();
        MongoCursor<Document> cursor = db.getCollection("KronStadistics").find().iterator();
        return this.generateData(cursor);
    }

    @Override
    public ArrayList<KronData> getFilteredData(FilteredKSelection selection) {
        MongoDb mongoconn = new MongoDb();
        MongoDatabase db = mongoconn.Connect();
        BasicDBObject whereQuery = new BasicDBObject();

        if(selection.fecha.length > 0) whereQuery.put("fecha",new BasicDBObject("$in",selection.fecha));
        if(selection.hora.length > 0) whereQuery.put("hora", new BasicDBObject("$in", selection.hora));
        if(selection.usuario.length > 0) whereQuery.put("usuario", new BasicDBObject("$in", selection.usuario));
        if(selection.funcionalidad.length > 0) whereQuery.put("funcionalidad", new BasicDBObject("$in",selection.funcionalidad));
        if(selection.accion.length > 0) whereQuery.put("accion", new BasicDBObject("$in", selection.accion));
        if(selection.objeto.length > 0) whereQuery.put("objeto", new BasicDBObject("$in",selection.objeto));
        if(selection.dato_modificado.length > 0) whereQuery.put("dato_modificado", new BasicDBObject("$in",selection.dato_modificado));
        if(selection.old_data.length > 0) whereQuery.put("old_data", new BasicDBObject("$in",selection.old_data));
        if(selection.new_data.length > 0) whereQuery.put("new_data", new BasicDBObject("$in",selection.new_data));

        MongoCursor<Document> cursor = db.getCollection("KronStadistics").find(whereQuery).iterator();

        return this.generateData(cursor);
    }


    //Armo la data con el cursor que me llego de mongo
    private ArrayList<KronData> generateData(MongoCursor<Document> cursor){
        ArrayList<KronData> data = new ArrayList<>();

        try{
            while (cursor.hasNext()) {
                Document document = cursor.next();
                try {
                    KronData s = this.constructKronData(document);
                    data.add(s);
                }catch (Exception e){
                    System.out.println(document.toString());
                }
            }
        }finally{
            cursor.close();
        }
        return data;
    }

    //Instancio kron data por separado
    private KronData constructKronData(Document document){

        KronData kd = new KronData(
                (String) document.get("fecha"),
                (String) document.get("hora"),
                (String) document.get("usuario"),
                (String) document.get("funcionalidad"),
                (String) document.get("accion"),
                (String) document.get("objeto"),
                (String) document.get("dato_modificado"),
                (String) document.get("old_data"),
                (String) document.get("new_data")
        );

        return kd;
    }
}
