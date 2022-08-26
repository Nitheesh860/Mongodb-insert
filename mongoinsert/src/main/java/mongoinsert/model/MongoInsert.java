package mongoinsert.model;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoInsert {
	public static void main(String[] args) {
		// inserting documents to db

		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://Nitheesh:Atlas123@cluster0.q7oseyn.mongodb.net/?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000&keepAliveMS=100");
		try (MongoClient mongoClient = new MongoClient(uri)) {
			MongoDatabase database = mongoClient.getDatabase("samco");

			database.createCollection("Sample_collections");

			Document document = new Document();
			document.append("name", "Kalai");
			document.append("age", 23);
			document.append("city", "Chennai");

			database.getCollection("Sample_collections").insertOne(document);
			System.out.println("Document inserted successfully");

			// Retrieving all documents

			MongoDatabase database1 = mongoClient.getDatabase("samco");
			MongoCollection<Document> collection = database1.getCollection("Sample_collections");

			FindIterable<Document> iterDoc = collection.find();
			Iterator it = iterDoc.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}

		}
	}
}
