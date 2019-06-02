package alien;

import java.util.ArrayList;

public class Location_Timetravel {
    Location location;
    int trafic[];

    public Location_Timetravel(Location location, int trafic[]) {
        this.location = location;
        this.trafic = trafic;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int[] getTrafic() {
        return trafic;
    }

    public void setTrafic(int[] trafic) {
        this.trafic = trafic;
    }
    
    
}
