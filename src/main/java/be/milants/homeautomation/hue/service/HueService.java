package be.milants.homeautomation.hue.service;

import be.milants.homeautomation.hue.data.HueLight;
import be.milants.homeautomation.hue.data.TurnLightOnOffRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@RequiredArgsConstructor
public class HueService {

    private final RestTemplate restTemplate;

    public void getAllLights() {
        //RestTemplate restTemplate = new RestTemplate();
        String hueBridgeUrl = "http://192.168.0.219/api/Kbx0n7TMx6eUQa27b576MNADwvngsTarPy5LgLgN/lights";
        ResponseEntity<HueLight[]> response = restTemplate.getForEntity(hueBridgeUrl, HueLight[].class);
        System.out.println(response);
    }

    public void partyMode() throws Exception {

        Map<Integer, Boolean> lightsOn = new HashMap<>();
        lightsOn.put(4,false);
        lightsOn.put(5,false);
        lightsOn.put(6,false);
        lightsOn.put(7,false);
        lightsOn.put(8
                ,false);


        for (int i = 0; i < 100; i++) {
            int randomTime = (int) (Math.random() * 150 + 100);
            List<Integer> keysAsArray = new ArrayList<Integer>(lightsOn.keySet());
            Random r = new Random();
           int randomLamp =  keysAsArray.get(r.nextInt(keysAsArray.size()));

            if (lightsOn.get(randomLamp)) {
                turnLightOff(randomLamp);
                lightsOn.put(randomLamp, false);
            } else {
                turnLightOn(randomLamp);
                lightsOn.put(randomLamp, true);
            }

            Thread.sleep(randomTime);
        }

        turnLightOn(5);
        turnLightOn(6);
        turnLightOn(7);
        turnLightOn(8);
        turnLightOn(4);


    }

    public void turnLightOn(int lightId) {
        System.out.println("turn light on");

        String hueBridgeUrl = "http://192.168.0.219/api/Kbx0n7TMx6eUQa27b576MNADwvngsTarPy5LgLgN/lights/" + lightId + "/state";
        // ResponseEntity<HueLight[]> response = restTemplate.postForEntity(hueBridgeUrl, HueLight[].class, "{'on':true}");
        HttpEntity<TurnLightOnOffRequest> requestEntity = new HttpEntity<TurnLightOnOffRequest>(new TurnLightOnOffRequest(true, 200, 200, 5000), new HttpHeaders());
        HttpEntity<Object[]> response = restTemplate.exchange(hueBridgeUrl, HttpMethod.PUT, requestEntity, Object[].class, new HashMap<>());

    }

    public void turnLightOff(int lightId) {
        System.out.println("turn light off");

        String hueBridgeUrl = "http://192.168.0.219/api/Kbx0n7TMx6eUQa27b576MNADwvngsTarPy5LgLgN/lights/" + lightId + "/state";
        // ResponseEntity<HueLight[]> response = restTemplate.postForEntity(hueBridgeUrl, HueLight[].class, "{'on':true}");
        HttpEntity<TurnLightOnOffRequest> requestEntity = new HttpEntity<TurnLightOnOffRequest>(new TurnLightOnOffRequest(false), new HttpHeaders());
        HttpEntity<Object[]> response = restTemplate.exchange(hueBridgeUrl, HttpMethod.PUT, requestEntity, Object[].class, new HashMap<>());

    }
}
