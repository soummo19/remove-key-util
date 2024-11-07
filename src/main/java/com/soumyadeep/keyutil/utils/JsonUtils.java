package com.soumyadeep.keyutil.utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;
import java.util.Map;

public class JsonUtils {

    public static String removeKeysFromJson(String jsonString, String... keysToRemove) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(jsonString, Map.class);
        removeKeys(map, keysToRemove);
        return objectMapper.writeValueAsString(map);
    }
    private static void removeKeys(Map<String, Object> map, String[] keysToRemove) {
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            String key = entry.getKey();
            Object value = entry.getValue();
            for (String keyToRemove : keysToRemove) {
                if (key.equals(keyToRemove)) {
                    iterator.remove();
                    break;
                }
            }
            if (value instanceof Map) {
                removeKeys((Map<String, Object>) value, keysToRemove);
            }
            else if (value instanceof Iterable) {
                for (Object item : (Iterable<?>) value) {
                    if (item instanceof Map) {
                        removeKeys((Map<String, Object>) item, keysToRemove);
                    }
                }
            }
        }
    }
}