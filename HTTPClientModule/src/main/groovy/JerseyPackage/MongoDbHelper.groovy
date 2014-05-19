package JerseyPackage

import com.mongodb.BasicDBObject
import com.mongodb.DB
import com.mongodb.DBCursor
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import net.sf.json.JSONArray
import net.sf.json.JSONObject
import org.bson.types.ObjectId
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
            privilegeDetails.put(object.get("name"),object.get("_id").toString())
        }
        privilegeDetails.entrySet().value
    }
    static List getPrivilegeDetails(String privilegeName){
        DBCursor cursor = db.getCollection("privileges").find(new BasicDBObject("name": privilegeName), new BasicDBObject("name": 1))
        while(cursor.hasNext()){
            BasicDBObject object = cursor.next()
            privilegeDetails.put(object.get("name"),object.get("_id").toString())
        }
        privilegeDetails.entrySet().value
    }

    static String randomGroupName(){
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        Random random = new Random()
        print alphabets.charAt(random.nextInt(alphabets.length()))
        StringBuilder builder = new StringBuilder()
        for(int i =0;i <7;i++){
            builder.append(alphabets.charAt(random.nextInt(alphabets.length())))
        }
        builder
    }
    static List<ObjectId> getGroupId(String groupName){
        List<ObjectId> listGroupId = new ArrayList<>()
        ObjectId groupId = db.getCollection("groups").findOne(new BasicDBObject("name": groupName ), new BasicDBObject("name": 1)).get("_id")
        listGroupId.add(groupId)
    }
}

// group- adding a group with invalid privilege id doesn't throw an error
// adding a invalid json object does throw unathourized error while adding a user
//{"username":"privilegename@products.com","fulName":"privilegeName","groups":"537a8ab21b6cf2cab5d1f9e9"}

