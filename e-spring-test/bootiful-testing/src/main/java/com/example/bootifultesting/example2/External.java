package com.example.bootifultesting.example2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Component
public class External {

    public List<String> all(){
        return Arrays.asList("LOW", "MEDIUM", "HIGH");
    }
}
