package com.ibm.dst.frame.mongo.component;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.ibm.dst.frame.mongo.entity.Person;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

@Component
public class MongoDemo {
	
	@Autowired
	private MongoOperations mongoOperation = null;
	
	@PostConstruct
	public void testWithSpringData() {
		System.out.println("MongoOperation:"+mongoOperation);
		
		//insert
		Person p = new Person();
		p.setCode("1001");
		p.setName("Bob");
		Map<String, String> m = new HashMap<String, String>();
		m.put("a", "a");
		m.put("b", "b");
		String [] arr = new String[] {"string1","string2"};
		List<String> list = new ArrayList<String> ();
		list.add("test1");
		list.add("test2");
		p.setTestMap(m);
		p.setArr(arr);
		p.setList(list);
		mongoOperation.insert(p);
		Person find = mongoOperation.findOne(new Query(Criteria.where("code").is("1001")), Person.class);
		System.out.println("Person Name:"+find.getName());
		
		//update
		mongoOperation.updateFirst(new Query(Criteria.where("code").is("1001")), new Update().set("name", "bob"), Person.class);
		find = mongoOperation.findOne(new Query(Criteria.where("code").is("1001")), Person.class);
		System.out.println("After update, Person Name:"+find.getName());
		
		//delete
		Criteria criteria = Criteria.where("code").in("1001");
        if(criteria == null) {
             Query query = new Query(criteria);
             if(query != null && mongoOperation.findOne(query, Person.class) != null)
            	 mongoOperation.remove(mongoOperation.findOne(query, Person.class));
        }
        
	}
	
	@PostConstruct
	public void testWithMongoDriver() throws UnknownHostException {
		MongoClient mongo = new MongoClient("localhost",27017);
		//connect to mongo
		DB db = mongo.getDB("testmongo");
		DBCollection person = db.getCollection("person");
		BasicDBObject p = new BasicDBObject();
		p.append("code", "1002");
		p.put("name", "Cui");
		person.insert(p);
		
		DBCursor cursor = person.find();
        int i=1;
        while (cursor.hasNext()) {
           System.out.println("Inserted Document: "+i);
           System.out.println(cursor.next());
           i++;
        }
        person.remove(new BasicDBObject("code", new BasicDBObject("$in", new String[] {"1002"}))).getN();
	}
	
	@PreDestroy
	public void done() {
		mongoOperation.dropCollection(Person.class);
	}
	
}
