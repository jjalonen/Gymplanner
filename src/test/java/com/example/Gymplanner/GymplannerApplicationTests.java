package com.example.Gymplanner;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Gymplanner.web.dto.GymController;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GymplannerApplicationTests {

    @Autowired
    private GymController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }	
    
}