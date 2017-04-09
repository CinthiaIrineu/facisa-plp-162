
/*FONTE: https://brizeno.wordpress.com/2011/09/23/praticando-concorrencia-em-java/
 * 
 * o buffer. Ele possui um conteúdo, que é colocado pelo produtor, 
  	e um booleano que indica quando o conteúdo está disponível.
  	
	Para permitir que um produtor coloque um produto ela oferece um método set,
 	que carrega o conteúdo e avisa para as outras thread que o produto está disponível. 
	Para dar acesso ao Consumidor, o buffer oferece um método get, que devolve o 
	conteúdo e avisa para outras thread que o produto não está mais disponível.
  */

public class Buffer {
 
    private int conteudo;
    private boolean disponivel;
 
    
    //Enquanto houver um conteúdo disponível no buffer, o produtor deve esperar. 
    //Quando o buffer não estiver mais com conteúdo disponível, o conteúdo é carregado 
    //e as outras thread são notificadas que um novo conteúdo está disponível.
    public synchronized void set(int idProdutor, int valor) {
        while (disponivel == true) {
            try {
                System.out.println("Produtor #" + idProdutor + " esperando...");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        conteudo = valor;
        System.out.println("Produtor #" + idProdutor + " colocou " + conteudo);
        disponivel = true;
        notifyAll();
    }
    
    // De forma semelhante ao Produtor, no método get o consumidor deve esperar 
    // enquanto não houver conteúdo disponível. Quando o conteúdo estiver disponível 
    // novamente o consumidor consome o recurso e notifca as outras thread que não há 
    // mais recurso disponível.
 
    public synchronized int get(int idConsumidor) {
        while (disponivel == false) {
            try {
                System.out.println("Consumidor #" + idConsumidor
                        + " esperado...");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumidor #" + idConsumidor + " consumiu: "
                + conteudo);
        disponivel = false;
        notifyAll();
        return conteudo;
    }
}