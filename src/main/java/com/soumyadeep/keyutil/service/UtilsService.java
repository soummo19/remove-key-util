package com.soumyadeep.keyutil.service;

import org.springframework.stereotype.Service;

import com.soumyadeep.keyutil.utils.JsonUtils;

@Service
public class UtilsService {
    
    public String removeKeyJsonString(){

        String stringToRemoveKey="{\r\n" + //
                        "    \"IDU\":\"xyx\"\r\n" + //
                        "}";

        String keysToRemove[] = {"IDU" };

        String response = "";
        try{
            response = JsonUtils.removeKeysFromJson(stringToRemoveKey, keysToRemove);
        }
        catch(Exception e){
            return e.getMessage();
        }

        return response;
    }
}
