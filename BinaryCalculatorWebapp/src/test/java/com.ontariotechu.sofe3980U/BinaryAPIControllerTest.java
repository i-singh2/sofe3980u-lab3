package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10001"));
    }
	@Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    // 3 test cases
    @Test
    public void add3() throws Exception {
        this.mvc.perform(get("/add").param("operand1","100").param("operand2","1100"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("10000"));
    }

    @Test
    public void add4() throws Exception {
        this.mvc.perform(get("/add").param("operand1","001").param("operand2","1111"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("10000"));
    }

    @Test
    public void add5() throws Exception {
        this.mvc.perform(get("/add").param("operand1","011").param("operand2","1001"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1100"));
    }

    //Test cases for *, & and |
    @Test
    public void multiply() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1","11").param("operand2","101"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1111"));
    }
    @Test
    public void multiply2() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1","11").param("operand2","101"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(11))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(101))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    @Test
    public void and() throws Exception {
        this.mvc.perform(get("/and").param("operand1","1001").param("operand2","1011"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1001"));
    }
    @Test
    public void and2() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","1001").param("operand2","1011"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1011))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    @Test
    public void or() throws Exception {
        this.mvc.perform(get("/or").param("operand1","1001").param("operand2","1011"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1011"));
    }
    @Test
    public void or2() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","1001").param("operand2","1011"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1011))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1011))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }
}