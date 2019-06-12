package alien;

import java.io.Serializable;
public class Person implements Serializable{
    String name;
    String surname; 
    int age;
    int arrival_time;
    Location source;
    Location destination;
    boolean urgent; 

    public Person(String name, String surname, int age, int arrival_time, Location source, Location destination, boolean urgent) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.arrival_time = arrival_time;
        this.source = source;
        this.destination = destination;
        this.urgent = urgent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(int arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Location getSource() {
        return source;
    }

    public void setSource(Location source) {
        this.source = source;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", surname=" + surname + ", age=" + age + ", arrival_time=" + arrival_time + ", source=" + source + ", destination=" + destination + ", urgent=" + urgent + '}';
    }
    
    

}
