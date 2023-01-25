package com.test.dansmultipro.backendtest.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class JobResponse {
    private String id;
    private String type;
    private String url;
    private String createdAt;
    private String company;
    private String companyUrl;
    private String companyLogo;
    private String location;
    private String title;
    private String description;
    private String howToApply;
}
