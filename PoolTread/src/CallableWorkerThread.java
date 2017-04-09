import java.util.concurrent.*;


/* IMPLEMENTA��O COM A INTERFACE CALLABLE 
	Callable � mais flex�vel que Runnable pois pode retornar 
	um valor lan�ar uma exce��o

*/


public class CallableWorkerThread implements Callable<Integer> {
    private int workerNumber;

    CallableWorkerThread(int number) {
        workerNumber = number;
    }

    public Integer call() {
        for (int i = 0; i <= 100; i += 20) {
        	System.out.println("Worker number: " + workerNumber
                + ", percent complete: " + i );
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
        return(workerNumber);
    }
}