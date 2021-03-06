package com.example.demo.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@RestController
public class CountriesController {

    @Autowired
    private  RestTemplate restTemplate;

    @GetMapping("/countries")
    public List<Object> getCountries(){
        List<Object> list = null;
        try {
            URL countriesUrl = new URL("https://restcountries.eu/rest/v2/all");
            Object[] countries =  restTemplate.getForObject(countriesUrl.toURI(), Object[].class);
            System.out.println(Arrays.toString(countries));
            System.out.println(countries[0]);

            // cannot cast List<Object> to List<String>
            //List<String> list = (List<String>) Arrays.asList(countries);
            list = Arrays.asList(countries);
           // list.add(new Object(list.size()));

            String countriesAsString =  restTemplate.getForObject(countriesUrl.toURI(), String.class);
            System.out.println(countriesAsString);
            System.out.println("Retrieved countries: " + list.size());
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }
        return list;
    }

}
