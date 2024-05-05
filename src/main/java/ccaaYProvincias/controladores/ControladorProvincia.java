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
import com.mongodb.client.model.Updates;

import ccaaYProvincias.entities.Provincia;

public class ControladorProvincia extends SuperControlador{

	private static ControladorProvincia instance = null;
	private MongoCollection<Document> mc = null;
	private String hostName = "localhost";
	private String dBName = "ComunidadesProvinciasPoblaciones";
	private String collectionName = "provincias";
	private int port = 27017;

	public ControladorProvincia() {
		super("localhost", "ComunidadesProvinciasPoblaciones", "provincias");

	}
	
	public static ControladorProvincia getInstance() {
		if (instance == null) {
			instance = new ControladorProvincia();
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
	
	private Provincia documentToProvincia(Document doc) {
		Provincia provincia = new Provincia();
		provincia.setParent_code(doc.getString("parent_code"));
		provincia.setCode(doc.getString("code"));
		provincia.setLabel(doc.getString("label"));
    	return provincia;
    }
	
	public List<Provincia> getAllProvincias() {
//      System.out.println("Obteniendo todas las ccaa de la colección");
 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = getCollection().find();
        MongoCursor<Document> cursor = fi.iterator();

        List<Provincia> allProvincia = new ArrayList<Provincia>();
        try {
            while(cursor.hasNext()) {
            	allProvincia.add(documentToProvincia(cursor.next()));
            }
        } finally {
            cursor.close();
        }
        
        return allProvincia;
    }
	
	public void updateProvincia(Provincia p) {
		try {
			Document query = new Document()
					.append("code", p.getCode());
			
			Bson update = Updates.combine(
					Updates.set("label", p.getLabel()),
					Updates.set("parent_code", p.getParent_code())
			);
			
			getCollection().updateOne(query, update);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
