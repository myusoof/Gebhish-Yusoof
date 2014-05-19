package JerseyPackage

import com.mongodb.BasicDBObject
import com.mongodb.DB
import com.mongodb.DBCursor
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import net.sf.json.JSONArray
import net.sf.json.JSONObject
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

    static Map privilegeDetails = [:]
    static List getPrivilegeDetails(){
        DBCursor cursor = db.getCollection("privileges").find(new BasicDBObject(), new BasicDBObject("name": 1))
        while(cursor.hasNext()){
            BasicDBObject object = cursor.next()
            privilegeDetails.put(object.get("name"),object.get("_id"))
        }
        println privilegeDetails.entrySet().value
        privilegeDetails.entrySet().value
    }

    public static void main(String[] args) {
        getPrivilegeDetails()
        def arrayList1 = []
        def arrayList2 =  privilegeDetails.entrySet().value
        println arrayList1
        Map abc = [:]
        JSONObject object1 = new JSONObject(abc)
        ArrayList list1 = new ArrayList()
        list1.add("priliefe")
        list1.add("privilege1")
        println list1
        JSONArray privilege = new JSONArray()
        object1.put("privileges", list1)
        println object1.toString()
        privilege
    }
}
