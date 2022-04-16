package com.dojinyou.thejavatestpractice;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {
    @Test
    @Order(4)
    void sampleTest1(){}
    @Test
    @Order(3)
    void sampleTest2(){}
    @Test
    @Order(2)
    void sampleTest3(){}
    @Test
    @Order(1)
    void sampleTest4(){}
}
