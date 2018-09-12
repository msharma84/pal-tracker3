package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private final String port;
    private final String memory_limit;
    private final String cf_index;
    private final String addr;

    public EnvController(@Value("${PORT:NOT SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT SET}") String memory_limit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}")String cf_index,
                         @Value("${CF_INSTANCE_ADDR:NOT SET}")String addr){
        this.port = port;
        this.memory_limit = memory_limit;
        this.cf_index = cf_index;
        this.addr  = addr;
    }
        @GetMapping("/env")
    public Map<String, String> getEnv(){

        Map<String, String> myMap = new HashMap<>();
        myMap.put("PORT",this.port);
        myMap.put("MEMORY_LIMIT",memory_limit);
        myMap.put("CF_INSTANCE_INDEX",cf_index);
        myMap.put("CF_INSTANCE_ADDR",addr);

        return myMap;
    }
}