package alien;

import java.io.Serializable;
import javafx.beans.property.StringProperty;

public class Location implements Serializable{
    private String name;
    private float x;
    private float y;

    public Location(String name, float x, float y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
}

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" + "name=" + name + ", x=" + x + ", y=" + y + '}';
    }
    
    
}
