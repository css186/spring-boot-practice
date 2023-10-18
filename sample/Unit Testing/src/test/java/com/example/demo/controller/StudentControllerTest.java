package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // test GET method
    @Test
    public void getById() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders // create a mock request object that use GET method
                .get("/students/{studentId}", 3) // URL path
                .header("headerName", "headerValue") // add customized header
                .queryParam("graduate", "true");

        MvcResult mvcResult = mockMvc.perform(requestBuilder) // execute request
                .andDo(print()) // allow JSON to be printed out (for better understanding of JSON structure)
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", equalTo(3)))
                .andExpect(jsonPath("$.name", notNullValue()))
                .andReturn(); // andReturn: can obtain the complete return result from API (can be only put at the end)

        String body = mvcResult.getResponse().getContentAsString(); // get response body
        System.out.println("Returned Response body is " + body);
    }

    // test POST method
    @Test
    public void create() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/students")
                .contentType(MediaType.APPLICATION_JSON) // this line is very important!!!
                .content("{\n" +
                        "  \"name\": \"Hank\",\n" +
                        "  \"score\": 14.6,\n" +
                        "  \"graduate\": false\n" +
                        "}");
        mockMvc.perform(requestBuilder)
                .andExpect(status().is(201));
    }
}