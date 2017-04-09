
/*FONTE: https://brizeno.wordpress.com/2011/09/23/praticando-concorrencia-em-java/
 * 
 * o buffer. Ele possui um conte�do, que � colocado pelo produtor, 
  	e um booleano que indica quando o conte�do est� dispon�vel.
  	
	Para permitir que um produtor coloque um produto ela oferece um m�todo set,
 	que carrega o conte�do e avisa para as outras thread que o produto est� dispon�vel. 
	Para dar acesso ao Consumidor, o buffer oferece um m�todo get, que devolve o 
	conte�do e avisa para outras thread que o produto n�o est� mais dispon�vel.
  */

public class Buffer {
 
    private int conteudo;
    private boolean disponivel;
 
    
    //Enquanto houver um conte�do dispon�vel no buffer, o produtor deve esperar. 
    //Quando o buffer n�o estiver mais com conte�do dispon�vel, o conte�do � carregado 
    //e as outras thread s�o notificadas que um novo conte�do est� dispon�vel.
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
    
    // De forma semelhante ao Produtor, no m�todo get o consumidor deve esperar 
    // enquanto n�o houver conte�do dispon�vel. Quando o conte�do estiver dispon�vel 
    // novamente o consumidor consome o recurso e notifca as outras thread que n�o h� 
    // mais recurso dispon�vel.
 
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