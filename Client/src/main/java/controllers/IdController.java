package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Id;

public class IdController {
    private HashMap<String, Id> allIds;

    Id myId;

    public ArrayList<Id> getIds() {
        ArrayList<Id> idList = new ArrayList<Id>();
        for(Map.Entry id : allIds.entrySet()){
            idList.add((Id) id.getValue());
        }
        return idList;
    }

    public Id postId(Id id) {
        // create json from id
        // call server, get json result Or error
        // result json to Id obj


        return null;
    }

    public Id putId(Id id) {
        return null;
    }
 
}