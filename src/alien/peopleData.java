package alien;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author qemal
 */
public class peopleData {
    private ArrayList<Person> people = new ArrayList<>();
    File pp = new File("people.bin");
   
   public peopleData(){
       if(pp.exists()){
           try{ 
               FileInputStream fis = new FileInputStream(pp);
            ObjectInputStream ois = new ObjectInputStream(fis);
           people = (ArrayList<Person>) ois.readObject();
           fis.close();
           ois.close();
           }
           catch(Exception e){}
       }
   }
   
   public void updateFile(){
        try{
           FileOutputStream fos = new FileOutputStream(pp);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(people);
           oos.close();
           fos.close();
           }
           catch(Exception e){}
   }
          
   void registerPerson(Person p){
       people.add(p);
       updateFile();
       
   }
   
   void deletePerson(int index){
       people.remove(index);
       updateFile();
   }
    
}
