import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* IMPLEMENTAÇÃO COM CALLABLE - UTILIZA A CLASSE CALLABLEWORKED
   temos um exemplo com 4 thread e 4 tarefas
 */

public class ThreadPoolTest2 {
	 public static void main(String[] args) {
		// cria quantos threads forem necessários mas reutiliza 
		 //threads quando uma tarefa termina
		 ExecutorService tpes = Executors.newCachedThreadPool();
		 CallableWorkerThread workers[] = new CallableWorkerThread[4];
		 Future futures[] = new Future[4];
		 
		 for (int i = 0; i < workers.length; i++) {
			 workers[i] = new CallableWorkerThread(i);
			 //Future que permite controlar a tarefa
			 futures[i]=tpes.submit(workers[i]); //pede a um executor para rodar um Callable
		 }
		 
		 for (int i = 0; i < workers.length; i++) {
			  try {
				  System.out.println("Ending worker: " +futures[i].get());
				   } catch (Exception e) {}
		 }
	tpes.shutdown();
	 }
} 