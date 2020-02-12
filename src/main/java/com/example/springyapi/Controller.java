package com.example.springyapi;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class Controller {

    private final String BASE_URL = "https://bpdts-test-app.herokuapp.com";
    private final String LONDON = "/city/London/users";

    @GetMapping("/users")
    public String getAllUsers() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(BASE_URL + "/users", String.class);

        return result;
    }

    @GetMapping("/usersInLondon")
    public String getAllUsersInLondon() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(BASE_URL + LONDON, String.class);

        return result;
    }

    @GetMapping("/usersNearLondon")
    public JSONArray getAllUsersNearLondon() {
        RestTemplate restTemplate = new RestTemplate();
        AreaConverter areaConverter = new AreaConverter();

        String result = restTemplate.getForObject(BASE_URL + "/users", String.class);

        JSONArray filteredResult = areaConverter.cityRadiusCalculator(result);

        return filteredResult;
    }
}

