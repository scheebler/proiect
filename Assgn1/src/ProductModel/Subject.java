package ProductModel;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	 private static List<Observer> observers = new ArrayList<Observer>();
	   private int state;

	   public int getState() {
	      return state;
	   }

	   public static void setState(String s) {
	      notifyAllObservers(s);
	   }

	   public void attach(Observer observer){
	      observers.add(observer);		
	   }

	   public static void notifyAllObservers(String s){
	      for (Observer observer : observers) {
	         observer.update(s);
	      }
	   } 	

}
