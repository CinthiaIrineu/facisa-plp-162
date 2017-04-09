
/* FONTE: https://brizeno.wordpress.com/2011/09/23/praticando-concorrencia-em-java/
 * 
 * Uma ou mais thread de consumidores consomem o produto colocado no buffer. 
 * O produtor precisa esperar o buffer ficar livre para produzir o produto e 
 * o cliente precisa esperar o buffer ficar preenchido para consumir o produto.

 * A tarefa do problema é sincronizar o acesso ao recurso, no caso a pilha, 
 * para que produtores saibam quando podem produzir e consumidores saibam 
 * quando podem consumir.
 * 
 * */


//derivada da clase Thread, ou seja, cada cliente vai funcionar em um thread diferente
public class Consumidor extends Thread { 
	
	// Os dados que utilizamos são um identificador (idConsumidor), uma referência para
	// um Buffer e um contador (totalConsumir) que vai indicar quanto deve ser consumido 
	// pelo consumidor.
    private int idConsumidor;
    private Buffer pilha;
    private int totalConsumir;
 
    public Consumidor(int id, Buffer p, int totalConsumir) {
        idConsumidor = id;
        pilha = p;
        this.totalConsumir = totalConsumir;
    }
 
    //O método run() é chamado quando a thread for iniciada, ou seja, 
    // é nele que devemos definir o nosso cliente de fato. Definimos então o 
    // laço para executar as chamadas que consomem o recurso do buffer.
    public void run() {
        for (int i = 0; i < totalConsumir; i++) {
            pilha.get(idConsumidor);
        }
        System.out.println("Consumidor #" + idConsumidor + " concluido!");
    }
}