package ccaaYProvincias.controladores;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

import ccaaYProvincias.entities.Ccaa;

public class ControladorCCAA extends SuperControlador {
	
	private static ControladorCCAA instance = null;

	public ControladorCCAA() {
		super("localhost", "ComunidadesProvinciasPoblaciones", "ccaa");

	}
	
	public static ControladorCCAA getInstance() {
		if (instance == null) {
			instance = new ControladorCCAA();
		}
		return instance;
	}

	private Ccaa findCCAAByCode(String code, MongoCollection<Document> col) {
		
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
	
	private static Ccaa documentToCcaa(Document doc) {
    	Ccaa ccaa = new Ccaa();
    	ccaa.setParent_code(doc.getString("parent_code"));
    	ccaa.setCode(doc.getString("code"));
    	ccaa.setLabel(doc.getString("label"));
    	return ccaa;
    }
	
}
