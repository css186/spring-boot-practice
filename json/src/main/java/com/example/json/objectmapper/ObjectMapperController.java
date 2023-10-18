package com.example.json.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectMapperController {

    @GetMapping("/convert")
    public String convert() throws JsonProcessingException {
        User user = new User();

        user.setId(1);
        user.setName("John");
        user.setContactEmail("test.com");

        ObjectMapper objectMapper = new ObjectMapper();

        // User -> json string
        String jsonResult = objectMapper.writeValueAsString(user);
        System.out.println("json value is: " + jsonResult);

        // json string -> User
        String jsonString = "{\n" +
                "  \"id\":1,\n" +
                "  \"name\":\"John\",\n" +
                "  \"contact_email\": \"hello@test.com\"\n" +
                "}";
        User userResult = objectMapper.readValue(jsonString, User.class);

        System.out.println("id: " + userResult.getId());
        System.out.println("name: " + userResult.getName());
        System.out.println("email: " + userResult.getContactEmail());

        return "convert success";
    }
}
