package alien;

import java.time.LocalTime;
import java.util.ArrayList;

public class Location_Timetravel {
    Location location;
    ArrayList<LocalTime> localtime;
    ArrayList<Integer> trafic;

    public Location_Timetravel(Location location, ArrayList<LocalTime> localtime, ArrayList<Integer> trafic) {
        this.location = location;
        this.localtime = localtime;
        this.trafic = trafic;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<LocalTime> getLocaltime() {
        return localtime;
    }

    public void setLocaltime(ArrayList<LocalTime> localtime) {
        this.localtime = localtime;
    }

    public ArrayList<Integer> getTrafic() {
        return trafic;
    }

    public void setTrafic(ArrayList<Integer> trafic) {
        this.trafic = trafic;
    }
    
    
}
