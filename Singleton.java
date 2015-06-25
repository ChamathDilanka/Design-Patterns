/* Make sure you create 2 java files named as following,
   1. SingleObject.java
   2. SingletonPatternDemo.java */
   
////////////////////////////////////////////////////////////////////////////////

/* File 1 */

public class SingleObject {

   //create an private instance of SingleObject
   private static SingleObject instance = new SingleObject();

   //Make the constructor private so that this class cannot be instantiated.
   private SingleObject(){}

   //Get the only object available, if not create and return.
   public static SingleObject getInstance(){
   	if(instance != null){
   	  return instance;	
   	}else{
   	  instance = new SingleObject();
   	  return instance;
   	}
   }

   public void showMessage(){
      System.out.println("Hello World!");
   }
}

////////////////////////////////////////////////////////////////////////////////

/* File 2 */

public class SingletonPatternDemo {
   public static void main(String[] args) {

      //As "SingleObject()" constructor is a private one, you can't call it like this! 
      //SingleObject object = new SingleObject();

      //Get a SingleObject available. One will be created & get.
      SingleObject object = SingleObject.getInstance();

      //show the message
      object.showMessage();
   }
}