package ccaaYProvincias.controladores;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import ccaaYProvincias.entities.Ccaa;

public class ControladorCCAA extends SuperControlador {
	
	private static ControladorCCAA instance = null;
	private MongoCollection<Document> mc = null;
	private String hostName = "localhost";
	private String dBName = "ComunidadesProvinciasPoblaciones";
	private String collectionName = "ccaa";
	private int port = 27017;

	public ControladorCCAA() {
		super("localhost", "ComunidadesProvinciasPoblaciones", "ccaa");

	}
	
	public static ControladorCCAA getInstance() {
		if (instance == null) {
			instance = new ControladorCCAA();
		}
		return instance;
	}
	
	private MongoCollection<Document> getCollection() {
		if (mc == null) {
			// Mongodb creando la cadena de conexión.
	        String client_url = "mongodb://" + hostName + ":" + port + "/" + dBName;
	        MongoClientURI uri = new MongoClientURI(client_url);
	 
	        // Conectando y obteniendo un cliente.
	        MongoClient mongo_client = new MongoClient(uri);
	 
	        // Obteniendo un enlace a la base de datos.
	        MongoDatabase db = mongo_client.getDatabase(dBName);
	 
	        // Obteniendo la colección de la base de datos
	        return mc = db.getCollection(collectionName);
		}
		return mc;
	}

	public Ccaa findCCAAByCode(String code, MongoCollection<Document> col) {
		
		System.out.println("Filtrando elementos de una colección");
		 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = col.find(Filters.eq("code", code));        
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while(cursor.hasNext()) {
            	System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
        
        return documentToCcaa((Document) cursor);
		
	}
	
	private Ccaa documentToCcaa(Document doc) {
    	Ccaa ccaa = new Ccaa();
    	ccaa.setParent_code(doc.getString("parent_code"));
    	ccaa.setCode(doc.getString("code"));
    	ccaa.setLabel(doc.getString("label"));
    	return ccaa;
    }
	
	public List<Ccaa> getAllCcaa() {
//      System.out.println("Obteniendo todas las ccaa de la colección");
 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = getCollection().find();
        MongoCursor<Document> cursor = fi.iterator();

        List<Ccaa> allCcaa = new ArrayList<Ccaa>();
        try {
            while(cursor.hasNext()) {
            	allCcaa.add(documentToCcaa(cursor.next()));
            }
        } finally {
            cursor.close();
        }
        
        return allCcaa;
    }
	
	public void updateCCAA(Ccaa ccaa) {
		try {
			Document query = new Document()
					.append("code", ccaa.getCode());
			
			Bson update = Updates.combine(
					Updates.set("label", ccaa.getLabel()),
					Updates.set("parent_code", ccaa.getParent_code())
			);
			
			getCollection().updateOne(query, update);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
