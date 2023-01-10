package com.liblab.lotrsdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonPropertyOrder({"_id"})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("_id")
    private String id;
    private String name;
    private int runtimeInMinutes;
    private int budgetInMillions;
    private int boxOfficeRevenueInMillions;
    private int academyAwardNominations;
    private int academyAwardWins;
    private int rottenTomatoesScore;
    private List<String> quotes;
}
