
/*FONTE: https://brizeno.wordpress.com/2011/09/23/praticando-concorrencia-em-java/
 * 
 * Criamos dois produtores e dois consumidores. Em seguida executamos 
 * o método da classe Thread chamado start(). Este método vai então 
 * inicializar a Thread e logo em seguida vai executar o método run(),
 *  que nós definimos nas classes Consumidor e Produtor.
 */

public class Main {
	public static void main(String[] args) {
	    Buffer bufferCompartilhado = new Buffer();
	    Produtor produtor1 = new Produtor(1, bufferCompartilhado, 5);
	    Produtor produtor2 = new Produtor(2, bufferCompartilhado, 5);
	    Consumidor consumidor1 = new Consumidor(1, bufferCompartilhado, 2);
	    Consumidor consumidor2 = new Consumidor(2, bufferCompartilhado, 8);
	 
	    produtor1.start();
	    consumidor1.start();
	    produtor2.start();
	    consumidor2.start();
	}
}