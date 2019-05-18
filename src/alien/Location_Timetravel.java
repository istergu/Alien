package alien;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;

public   class Location_Timetravel implements RW{
    private  File fp;
    private ArrayList<Location> pat1;
     private ArrayList<Object> pat;
    public Location_Timetravel(){
        fp=new File("Timetravel.ser");
        if(!fp.exists()){
			write();
		} else {
			pat=read();
		}
    }
  
public ArrayList<Location> read() throws IOException {
                try {
			FileInputStream fis=new FileInputStream(fp);
			ObjectInputStream ois=new ObjectInputStream(fis);
			pat1=(ArrayList<Location>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (ClassNotFoundException e) {
			System.err.println("Class not Found!!!");
		} catch (IOException e) {
			System.err.println("Could not read file!!");
		}
		return pat1;
    }

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
public void setPat(ArrayList<Location> pat1) {
        this.pat1 = pat1;
    }
    @Override
    public void add(Object p) {
        pat1.add((Location)p);
        write();
    }
    @Override
    public void remove(Object p) {
        pat1.remove((Location)p);
        write();
    }

    @Override
    public void write() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    