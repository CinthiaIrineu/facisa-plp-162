

/*FONTE: https://brizeno.wordpress.com/2011/09/23/praticando-concorrencia-em-java/
 * 
 * De maneira semelhante ao Consumidor, o produtor possui um identificador, 
 * uma referência para um buffer e um total de produtos a serem produzidos. 
 * Note que essa classe também é uma Thread, ou seja, cada produtor será 
 * executado independentemente. O método run() também é bem semelhante ao do 
 * Consumidor, um laço que faz as chamadas ao buffer.
 * */

public class Produtor extends Thread {
    private int idProdutor;
    private Buffer pilha;
    private int producaoTotal;
 
    public Produtor(int id, Buffer p, int producaoTotal) {
        idProdutor = id;
        pilha = p;
        this.producaoTotal = producaoTotal;
    }
 
    public void run() {
        for (int i = 0; i < producaoTotal; i++) {
            pilha.set(idProdutor, i);
        }
        System.out.println("Produtor #" + idProdutor + " concluido!");
    }
}