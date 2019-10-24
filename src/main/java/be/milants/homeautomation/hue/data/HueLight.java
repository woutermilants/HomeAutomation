package be.milants.homeautomation.hue.data;

import lombok.Data;

import java.util.Date;
@Data
public class HueLight {
    public State state;
    public Swupdate swupdate;
    public String type;
    public String name;
    public String modelid;
    public String manufacturername;
    public String productname;
    public Capabilities capabilities;
    public Config config;
    public String uniqueid;
    public String swversion;
}

class State
{
    public boolean on;
    public int bri;
    public int ct;
    public String alert;
    public String colormode;
    public String mode;
    public boolean reachable;
}

class Swupdate
{
    public String state;
    public Date lastinstall;
}

 class Ct
{
    public int min;
    public int max;
}

 class Control
{
    public int mindimlevel;
    public int maxlumen;
    public Ct ct;
}

 class Streaming
{
    public boolean renderer;
    public boolean proxy;
}

 class Capabilities
{
    public boolean certified;
    public Control control;
    public Streaming streaming;
}

 class Config
{
    public String archetype;
    public String function;
    public String direction;
}
