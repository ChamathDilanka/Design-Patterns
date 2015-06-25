/* Create seperate file for each class. */

////////////////////////////////////////////////////////////////////////////////

/* File 1 */
/* Subject class creation. ArrayList will keep references for Observers. */

import java.util.ArrayList;
import java.util.List;

public class Subject {
	
   private List<Observer> observers = new ArrayList<Observer>();
   private int state;

   public int getState() {
      return state;
   }

   public void setState(int state) {
      this.state = state;
      notifyAllObservers();
   }

   public void attach(Observer observer){
      observers.add(observer);		
   }

   public void notifyAllObservers(){
      for (Observer observer : observers) {
         observer.update();
      }
   } 	
}

////////////////////////////////////////////////////////////////////////////////

/* File 2 */
/* Abstract class Observer creation. Used to cast the ArrayList for common
   data type, so that any object inherited from Observer abstract class can be 
   stored. */

public abstract class Observer {
   protected Subject subject;
   public abstract void update();
}

////////////////////////////////////////////////////////////////////////////////

/* File 3 */
/* Class BinaryObserver creation. */

public class BinaryObserver extends Observer{

   public BinaryObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      System.out.println( "BINARY Value: " + Integer.toBinaryString( subject.getState() ) ); 
   }
}

////////////////////////////////////////////////////////////////////////////////

/* File 4 */
/* Class OctalObserver creation. */

public class OctalObserver extends Observer{

   public OctalObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
     System.out.println( "OCTAL Value: " + Integer.toOctalString( subject.getState() ) ); 
   }
}

////////////////////////////////////////////////////////////////////////////////

/* File 5 */
/* Class HexaObserver creation. */

public class HexaObserver extends Observer{

   public HexaObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      System.out.println( "HEX Value: " + Integer.toHexString( subject.getState() ).toUpperCase() ); 
   }
}

////////////////////////////////////////////////////////////////////////////////

/* File 5 */
/*Demonstratin here! :P */

public class ObserverPatternDemo {
   public static void main(String[] args) {
      Subject subject = new Subject();

      new HexaObserver(subject);
      new OctalObserver(subject);
      new BinaryObserver(subject);

      System.out.println("First Change: 12");	
      subject.setState(15);
      System.out.println("Second Change: 16");	
      subject.setState(10);
   }
}