package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FactRepositoryTest {

    FactRepository factRepository;
    @BeforeEach
    void setUp() {
        factRepository = new FactRepository();
    }

    @Test
    void testFactRepository(){
        HashMap<String,Boolean> hm = new HashMap<>();
        hm.put("testKey",true);
        Fact testFact = new Fact("testID","testDescription",hm);
        factRepository.addFact(testFact);
        assertEquals(testFact,factRepository.getFacts().get(0));
    }
    @Test
    void testAddToRepository(){
        HashMap<String,Boolean> hm = new HashMap<>();
        hm.put("testKey",true);
        for (int i = 0; i < 10; i++) {
            Fact testFact = new Fact(Integer.toString(i),"testDescription",hm);
            factRepository.addFact(testFact);
        }
        assertEquals(10,factRepository.getFacts().size(),"Fact list size should equals to 10");

    }
}