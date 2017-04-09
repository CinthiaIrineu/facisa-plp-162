package dead;

import java.util.concurrent.TimeUnit;

/*
 * FONTE: https://meteatamel.wordpress.com/2012/03/21/deadlock-detection-in-java/
 */

public class Dead {
	
	public static void main(String[] args) {
		
	    final Object objeto1 = new Object();
	    final Object objeto2 = new Object();	    
	    	
	    	Thread thread1 = new Thread(new Runnable() {
		        public void run() {
		            synchronized (objeto1) { 
		            	
		            	/*nesse momento o thread é ocupado pelo objeto1 
		            		e está prestes a adquirir o objeto2,
		            		porém a thread2 adquire o objeto2 e 
		            		está prestes a adquiquir o objeto1. 
		            		Por isso acontece o deadlock		            		
		            		*/
		                System.out.println("Thread1 adquirido pelo objeto 1");
		                try {
		                	//caso contrario esperaria um tempo e executaria a proxima instrução
		                	
		                    TimeUnit.MILLISECONDS.sleep(50);
		                    
		                    // caso contrário interruperia o processo
		                } catch (InterruptedException ignore) {}
		                synchronized (objeto2) {
		                    System.out.println("Thread1 adquirido pelo objeto 2");
		                }
		            }
		        }
		 
		    });
		    thread1.start();
		 
		    Thread thread2 = new Thread(new Runnable() {
		        public void run() {
		            synchronized (objeto2) {
		                System.out.println("Thread2 adquirido pelo objeto 2");
		                try {
		                    TimeUnit.MILLISECONDS.sleep(50);
		                } catch (InterruptedException ignore) {}
		                synchronized (objeto1) {
		                    System.out.println("Thread2 adquirido pelo objeto 1");
		                }
		            }
		        }
		    });
		    thread2.start();
		 
		    
		    try {
		        TimeUnit.MILLISECONDS.sleep(100);
		    } catch (InterruptedException ignore) {}
	    }	    
   }
