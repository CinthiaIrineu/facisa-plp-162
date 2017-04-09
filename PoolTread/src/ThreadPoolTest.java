import java.util.concurrent.*;


/* IMPLEMENTA A INTERFACE RUNNABLE - UTILIZA A CLASSE WORKEDTHREAD
 * 

   Aqui temos um exemplo com 2 theads e 5 tarefas
 
	especificamos o n�mero de "worker threads" (tarefas) a 
	criar e o tamanho do pool de threads usados para executar as tarefas
	O exemplo usa um n�mero fixo de threads e com menos threads do que tarefas
 
 */


public class ThreadPoolTest {
	public static void main(String[] args) {
		//interface ExecutorService extende de Executor 		
		ExecutorService tpes = Executors.newFixedThreadPool(2); // numero de threads
		
		WorkerThread[] workers = new WorkerThread[5]; // numero de tarefas
		
		for (int i = 0; i < workers.length; i++) {
			workers[i] = new WorkerThread(i);
			tpes.execute(workers[i]);
		}
		
	 tpes.shutdown();
	 
	 }
}