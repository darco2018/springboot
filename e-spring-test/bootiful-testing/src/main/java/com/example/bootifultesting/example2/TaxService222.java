package com.example.bootifultesting.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxService222 {

    private  External external;

    public TaxService222(External external) {
        this.external = external;
    }

    public String getBrackets(int income){
        if(income < 1000)
            return "LOW";
        else if(income < 5000)
            return "MEDIUM";
        else
            return "HIGH";
    }

    public List<String> allBrackets(){
        return this.external.all();
    }
}
