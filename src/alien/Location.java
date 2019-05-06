package alien;

public class Location {
    private String name;
    private float x;
    private float y;
    private float distanceFromTR;

    public Location(String name, float x, float y, float distanceFromTR) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.distanceFromTR = distanceFromTR;
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

    public float getDistanceFromTR() {
        return distanceFromTR;
    }

    public void setDistanceFromTR(float distanceFromTR) {
        this.distanceFromTR = distanceFromTR;
    }
    
    
}