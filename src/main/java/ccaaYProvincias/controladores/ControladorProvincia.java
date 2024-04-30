package ccaaYProvincias.controladores;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import ccaaYProvincias.entities.Provincia;

public class ControladorProvincia extends SuperControlador{

	private static ControladorProvincia instance = null;

	public ControladorProvincia() {
		super("localhost", "ComunidadesProvinciasPoblaciones", "provincias");

	}
	
	public static ControladorProvincia getInstance() {
		if (instance == null) {
			instance = new ControladorProvincia();
		}
		return instance;
	}
	
	private static Provincia documentToProvincia(Document doc) {
		Provincia provincia = new Provincia();
		provincia.setParent_code(doc.getString("parent_code"));
		provincia.setCode(doc.getString("code"));
		provincia.setLabel(doc.getString("label"));
    	return provincia;
    }
	
	public static List<Provincia> getAllProvincias(MongoCollection<Document> col) {
        System.out.println("Obteniendo todas las ccaa de la colección");
 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = col.find();
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
	
}
