package com.example.bootifultesting.example2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TaxService {

    public String getBrackets(int income){
        if(income < 1000)
            return "LOW";
        else if(income < 5000)
            return "MEDIUM";
        else
            return "HIGH";
    }

    public List<String> allBrackets(){
        return Arrays.asList("LOW", "MEDIUM", "HIGH");
    }
}
