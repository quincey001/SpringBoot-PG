package com.example.orderapi;


import com.example.orderapi.Controller.ApiControllers;
import com.example.orderapi.Exception.ExceptionControllerAdvice;
import com.example.orderapi.Models.Item;
import com.example.orderapi.Payloads.requests.CreateOrderRequest;
import com.example.orderapi.Services.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PostMapping;

@WebMvcTest(ApiControllerTests.class)
public class ApiControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;
    @InjectMocks
    private ApiControllers controllers;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders
                .standaloneSetup(controllers)
                .build();
    }
    // JUnit test for Create order REST API
    @Test
    public void givenAnOrder_whenAddOrder_thenReturnResponseOrder() throws Exception{
        // given - precondition or setup
        List<Item> listOfItems = new ArrayList<>();
        listOfItems.add(Item.builder().name("computer").unitPrice(1000.00).quantity(2).build());
        listOfItems.add(Item.builder().name("charger").unitPrice(10.00).quantity(20).build());
        CreateOrderRequest createOrderRequest = CreateOrderRequest.builder().items(listOfItems).build();

        // when -  action or the behaviour that we are going test

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/addOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createOrderRequest)))
                .andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("name").exists())
                .andExpect(jsonPath("items").exists())
                .andReturn();

        // then - verify the output
//        result.andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(jsonPath("$.totalAmount", is(4000.0)))
//                .andExpect(jsonPath("$.items",is(orderService.createOrder(createOrderRequest))));

        String r = result.getResponse().getContentAsString();

    }

}
