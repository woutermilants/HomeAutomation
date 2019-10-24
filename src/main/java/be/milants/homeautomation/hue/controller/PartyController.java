package be.milants.homeautomation.hue.controller;

import be.milants.homeautomation.hue.service.HueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PartyController  {

    private final HueService hueService;

    @GetMapping("/startPartyMode")
    public void startPartyMode() {
        try {
            hueService.partyMode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
