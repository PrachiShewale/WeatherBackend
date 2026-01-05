package com.research.summarizz;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/research")
@CrossOrigin(origins = "*")//allow accessing all endpoints from all front end
@AllArgsConstructor
public class ResearchController {
    private final ResearchServiceImpl researchService;

    @PostMapping("/process")
    public String createRequest(@RequestBody  ResearchRequest request){
        return researchService.createRequest(request);

    }

}
