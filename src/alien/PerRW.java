package alien;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PerRW {

    private final File fp;
    private ArrayList<Person> pat;

    public PerRW() {
        fp = new File("users.ser");
        pat = new ArrayList<Person>();
        if (!fp.exists()) {
            write();
        } else {
            pat = read();
        }
    }

    public ArrayList<Person> read() {
        try {
            FileInputStream fis = new FileInputStream(fp);
            ObjectInputStream ois = new ObjectInputStream(fis);
            pat = (ArrayList<Person>) ois.readObject();
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
        pat.add((Person) p);
        write();
    }

    public void remove(Object p) {
        pat.remove((Person) p);
        write();
    }
    
    public void setPers(ArrayList<Person> p) {
        pat = p;
        write();
    }

}
