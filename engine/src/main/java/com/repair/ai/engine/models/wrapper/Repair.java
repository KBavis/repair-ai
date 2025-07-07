package com.repair.ai.engine.models.wrapper;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;

import java.util.List;

@Data
@JsonClassDescription("Relevant information regarding the repair to perform based on the issue")
public class Repair {

    @JsonPropertyDescription("The category this particular repair resides in")
    public String category;

    @JsonPropertyDescription("The specific component requiring attention")
    public String component;

    @JsonPropertyDescription("The type of issue this repair corresponds to")
    public String issueType;

    @JsonPropertyDescription("The general danger level that it would for one to perform this repair")
    public String dangerLevel;

    @JsonPropertyDescription("The level of difficulty for one to make this repair")
    public String difficulty;

    @JsonPropertyDescription("The estimated time to make this repair")
    public String estimatedTime;

    @JsonPropertyDescription("The necessary tools required to make this repair")
    public List<String> toolsRequired;

    @JsonPropertyDescription("The necessary materials required to make this repair")
    public List<String> materialsRequired;

    @JsonPropertyDescription("Determined steps for one to make this repair")
    public List<Step> steps;

    @JsonPropertyDescription("Potential reasons one should call for professional assistance based on the issue")
    public List<String> callProfessionalReasons;
}
