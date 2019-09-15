package cn.ali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HelloService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void opreaRedis() {
//        redisTemplate.opsForValue().set("name", "pqs");
//        String name = redisTemplate.opsForValue().get("name");
//        System.out.println(name);
        //操作hash
        BoundHashOperations<String, Object, Object> person = redisTemplate.boundHashOps("person");
        person.put("name", "java");
        person.put("age", "34");
        person.put("address", "anhui");

        //获取数据
        Object name = person.get("name");
        System.out.println("name==" + name);

        Map<Object, Object> entries = person.entries();
        for (Map.Entry<Object, Object> entry : entries.entrySet()) {
            System.out.println(entry.getKey() + "==>" + entry.getValue());

        }

    }
}
