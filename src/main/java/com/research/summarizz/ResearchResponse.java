package com.research.summarizz;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResearchResponse {
   private List<Candidate> candidates;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Candidate {
        private Content content;
    }
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
     static class Content {
        private List<Part> parts;
    }
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
     static class Part {
        private String text;
    }
}