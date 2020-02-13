package com.example.springyapi;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AreaConverter {

    private static final Logger log = LoggerFactory.getLogger(AreaConverter.class);
    private JSONArray filteredUsers = new JSONArray();
    private JSONParser parser = new JSONParser();

    public JSONArray cityRadiusCalculator(String users) throws ParseException {

        JSONArray fullUserJSON = new JSONArray(users);

        for (Object user : fullUserJSON) {
            if (user instanceof JSONObject) {
                User userObj = new User(
                        ((JSONObject) user).getInt("id"),
                        ((JSONObject) user).getString("first_name"),
                        ((JSONObject) user).getString("last_name"),
                        ((JSONObject) user).getString("email"),
                        ((JSONObject) user).getString("ip_address"),
                        ((JSONObject) user).getDouble("latitude"),
                        ((JSONObject) user).getDouble("longitude"));

                calculateDistance(userObj);
            } else {
                log.error("Invalid JSON format.");
            }
        }
        return filteredUsers;
    }

    private void calculateDistance(User user) {
        double distance = Haversine.haversine(user.getLatitude(), user.getLongitude());

        if (distance <= 50) {
            filteredUsers.put(user);
        }
    }
}
