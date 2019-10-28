package be.milants.homeautomation.hue.service;

import be.milants.homeautomation.hue.data.HueLight;
import be.milants.homeautomation.hue.data.TurnLightOnOffRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        for (int i = 0; i < 10; i++) {


            turnLightOn(4);
            Thread.sleep(1000);
            turnLightOff(4);
            Thread.sleep(1000);
        }


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
