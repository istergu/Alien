
package alien;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EdgeRW {

    private final File fp;
    private ArrayList<WeightedGraph.Edge> pat;

    public EdgeRW() {
        fp = new File("edge.ser");
        pat = new ArrayList<WeightedGraph.Edge>();
        if (!fp.exists()) {
            write();
        } else {
            pat = read();
        }
    }

    public ArrayList<WeightedGraph.Edge> read() {
        try {
            FileInputStream fis = new FileInputStream(fp);
            ObjectInputStream ois = new ObjectInputStream(fis);
            pat = (ArrayList<WeightedGraph.Edge>) ois.readObject();
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
        pat.add((WeightedGraph.Edge) p);
        write();
    }

    public void remove(Object p) {
        pat.remove((WeightedGraph.Edge) p);
        write();
    }
    
    public void setEdge(ArrayList<WeightedGraph.Edge> p) {
        pat = p;
        write();
    }

}
