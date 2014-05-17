package JerseyPackage

import com.mongodb.BasicDBObject
import com.mongodb.DB
import com.mongodb.DBCursor
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import org.jongo.Jongo
import org.jongo.MongoCollection

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 17/05/14
 * Time: 17:01
 * To change this template use File | Settings | File Templates.
 */

class MongoDbHelper {
    static DB db = new MongoClient(new MongoClientURI("mongodb://localhost/MCSProductServicesDb?w=1&fsync=true")).getDB("MCSProductServicesDb")

    Map privilegeDetails = [:]
    static void getPrivilegeDetails(String collectionName){
        DBCursor cursor = db.getCollection(collectionName).find(new BasicDBObject(), new BasicDBObject("name": 1))
        while(cursor.hasNext()){
            println cursor.next().get("_id")
            priv
        }
}

    public static void main(String[] args) {
        getPrivilegeDetails("privileges")
    }
}

