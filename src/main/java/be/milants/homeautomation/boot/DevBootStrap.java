package be.milants.homeautomation.boot;

import be.milants.homeautomation.hue.service.HueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {
  private final HueService hueService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
        //    hueService.partyMode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
