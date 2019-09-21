package org.learn.jenkv;

public class MonitorObject {

	public static void main(String[] args) {
		new MyWaitNotify().start();

	}

}

class MyWaitNotify extends Thread{

	  MonitorObject myMonitorObject = new MonitorObject();
	  
	  public void run() {
		  
		 doWait();
		  doNotify();
	  }
	  boolean wasSignalled = false;

	  public void doWait(){
	    synchronized(myMonitorObject){
	    if(!wasSignalled) {
	    try{
	    	  System.out.println("Monitored");
	        myMonitorObject.wait();
	      } catch(InterruptedException e){
	    	  System.out.println(e.getMessage());
	      }
	    wasSignalled = false;
	      }
	    }
	  }

	  public void doNotify(){
	    synchronized(myMonitorObject){
	    	 wasSignalled = true;
	    	System.out.println("Monitored Notify");
	      myMonitorObject.notify();
	    }
	  }
	}