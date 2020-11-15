package garages;

public class Main {

	public static void main(String[] args) throws Exception {
		Voiture v1 = new Voiture("123 1BC 31");
                Voiture v2 = new Voiture("531 2BG 32");
		Garage g1 = new Garage("Castres");
                Garage g2 = new Garage("Albi");
		v1.entreAuGarage(g1);
		v1.sortDuGarage();
		v1.entreAuGarage(g2);
                v2.entreAuGarage(g1);
		v2.sortDuGarage();
	        v1.sortDuGarage();
		v1.entreAuGarage(g1);
                
		v1.imprimeStationnements(System.out);
                v1.garagesVisites();
                v2.imprimeStationnements(System.out);
                v2.garagesVisites();
                
                
                v1.estDansUnGarage();
                v2.estDansUnGarage();
	}

}
