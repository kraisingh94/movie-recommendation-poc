package com.infogain.controller;


import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.dto.RecommendationDTO;
import com.infogain.service.RecommendationClientService;

@RestController
@RequestMapping("/api")
public class RecommendationClientController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RecommendationClientController.class);
	   
    @Autowired
    private RecommendationClientService recommendationClientService;
       
    @GetMapping(value ="/recommendation/user/{userId}")
    public RecommendationDTO getRecommendation(@PathVariable(value = "userId") Long userId) throws InterruptedException{
        RecommendationDTO dto = null;
        try {
            dto = this.recommendationClientService.getRecommendationData(userId).get();
        } catch (ExecutionException ex) {
        	LOGGER.error("{}", ex.getMessage());
        }
     // if null, hystrix will call fallback method
        return dto;
    }
    
}
