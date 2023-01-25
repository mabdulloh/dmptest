package com.test.dansmultipro.backendtest.service;

import java.io.IOException;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.dansmultipro.backendtest.dto.JobResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JobService {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    public JobResponse[] getAllJobs() {
        try {
            return MAPPER.readValue(new URL("http://dev3.dansmultipro.co.id/api/recruitment/positions.json"), JobResponse[].class);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            log.error("error while parsing: ", e);
            return null;
        } 
    }

    public JobResponse getJobById(String id) {
        try {
            return MAPPER.readValue(new URL("http://dev3.dansmultipro.co.id/api/recruitment/positions/" + id), JobResponse.class);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            log.error("error while parsing: ", e);
            return null;
        }
    }
}
