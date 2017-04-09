
/* IMPLEMENTA A INTERFACE RUNNABLE
   
    A implementaçao permitem que você estabeleça:
	O número básico e máximo do pool (número de threads)
	O tipo de estrutura de dados para armazenar as tarefas
	Como tratar tarefas rejeitadas
	Como criar e terminar threads 
	
	 Abaixo está uma tarefa WorkerThread que será executada por um thread
	A tarefa faz algo e periodicamente informa o percentual de trabalho realizado
 */


public class WorkerThread implements Runnable {
    private int workerNumber;

    WorkerThread(int number) {
        workerNumber = number;
    }

    public void run() {
        for (int i=0;i<=100;i+=20) {
            // executar a tarefa
            System.out.println("numero da tarefa: "
                + workerNumber
                + ", percentual completo: " + i );
            try {
                Thread.sleep((int)(Math.random() * 1000)); // deixa a tarefa em espera
            } catch (InterruptedException e) {
            }
        }
    }
}