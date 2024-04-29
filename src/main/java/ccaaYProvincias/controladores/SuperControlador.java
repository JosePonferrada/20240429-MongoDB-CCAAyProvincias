package ccaaYProvincias.controladores;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class SuperControlador {
	
	// Mongodb inicializando parámetros.
    int port_no = 27017;
    String host_name = "localhost", db_name = "", 
    		db_collection_name = "";
    
	public SuperControlador(String host_name, String db_name, String db_collection_name) {
		this.host_name = host_name;
		this.db_name = db_name;
		this.db_collection_name = db_collection_name;
	}

    public MongoCollection<Document> getCollection() {
    	// Mongodb creando la cadena de conexión.
        String client_url = "mongodb://" + host_name + ":" + port_no + "/" + db_name;
        MongoClientURI uri = new MongoClientURI(client_url);
 
        // Conectando y obteniendo un cliente.
        MongoClient mongo_client = new MongoClient(uri);
 
        // Obteniendo un enlace a la base de datos.
        MongoDatabase db = mongo_client.getDatabase(db_name);
 
        // Obteniendo la colección de la base de datos
        MongoCollection<Document> coll = db.getCollection(db_collection_name);
 
        return coll;
        
    }

}
