
package alien;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LocRW {

    private final File fp;
    private ArrayList<Location_Timetravel> pat;

    public LocRW() {
        fp = new File("loctra.ser");
        pat = new ArrayList<Location_Timetravel>();
        if (!fp.exists()) {
            write();
        } else {
            pat = read();
        }
    }

    public ArrayList<Location_Timetravel> read() {
        try {
            FileInputStream fis = new FileInputStream(fp);
            ObjectInputStream ois = new ObjectInputStream(fis);
            pat = (ArrayList<Location_Timetravel>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not Found!!!");
        } catch (ClassNotFoundException e) {
            System.err.println("Class not Found!!!");
        } catch (IOException e) {
            System.err.println(e);
        }
        return pat;
    }

    public void write() {
        try {
            FileOutputStream fos = new FileOutputStream(fp);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pat);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not Found!!!");
        } catch (IOException e) {
            System.err.println("File not Writable!!!");
        }
        read();
    }

    public void add(Object p) {
        pat.add((Location_Timetravel) p);
        write();
    }

    public void remove(Location_Timetravel p) {
        pat.remove(p);
        write();
    }
    
    public void setLoc(ArrayList<Location_Timetravel> p) {
        pat = p;
        write();
    }

}
