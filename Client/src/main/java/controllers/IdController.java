package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public Id postId(Id id) throws JsonProcessingException {
        // create json from id
        // call server, get json result Or error
        // result json to Id obj
String json = "{name :"+id.getName()+
              "github :"+id.getGithub()+"}";

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Id.class);
    }

    public Id putId(Id id) {
        return null;
    }
 
}