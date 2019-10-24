package be.milants.homeautomation.hue.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TurnLightOnOffRequest {

    private boolean on;
    private int sat;
    private int bri;
    private long hue;

    public TurnLightOnOffRequest(boolean on) {
        this.on = on;
    }
}
