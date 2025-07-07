package com.repair.ai.engine.models.wrapper;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;

@Data
@JsonClassDescription("The necessary steps to repair the issue")
public class Step {
    @JsonPropertyDescription("The number step this currently is")
    public Integer step;

    @JsonPropertyDescription("The necessary action to take")
    public String action;

    @JsonPropertyDescription("The description of the overall step being taken")
    public String description;

    @JsonPropertyDescription("Any specific location that the step should be performed")
    public String location;
}
