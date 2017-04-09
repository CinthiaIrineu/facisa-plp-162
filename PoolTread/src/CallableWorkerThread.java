import java.util.concurrent.*;


/* IMPLEMENTAÇÃO COM A INTERFACE CALLABLE 
	Callable é mais flexível que Runnable pois pode retornar 
	um valor lançar uma exceção

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