/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alien;

/**
 *
 * @author parid
 */
public class Person {
    String name;
    String surname; //addition  surname
    int age;
    int arrival_time;
    String destination.Location;// tha qemali qe se kam ber akoma classen
    boolean urgent; 
   int leaving_time;
   boolean  luxury_class;
   int ID;// addition ID

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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public int getLeaving_time() {
        return leaving_time;
    }

    public void setLeaving_time(int leaving_time) {
        this.leaving_time = leaving_time;
    }

    public boolean isLuxury_class() {
        return luxury_class;
    }

    public void setLuxury_class(boolean luxury_class) {
        this.luxury_class = luxury_class;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
   
   
   
}
