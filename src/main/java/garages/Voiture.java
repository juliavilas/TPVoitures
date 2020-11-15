package garages;

import java.io.PrintStream;
import java.util.*;

public class Voiture {

    private final String immatriculation;
    private final List<Stationnement> myStationnements = new LinkedList<>();

    public Voiture(String i) {
        if (null == i) {
            throw new IllegalArgumentException("Une voiture doit avoir une immatriculation");
        }

        immatriculation = i;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * Fait rentrer la voiture au garage Précondition : la voiture ne doit pas
     * être déjà dans un garage
     *
     * @param g le garage où la voiture va stationner
     * @throws java.lang.Exception Si déjà dans un garage
     */
    public void entreAuGarage(Garage g) throws Exception {
        // Et si la voiture est déjà dans un garage ?
        if (this.estDansUnGarage() == true) {
            throw new IllegalArgumentException("La voiture est déjà dans un garage");
        } else {

            Stationnement s = new Stationnement(this, g);
            myStationnements.add(s);
        }
    }

    /**
     * Fait sortir la voiture du garage Précondition : la voiture doit être dans
     * un garage
     *
     * @throws java.lang.Exception si la voiture n'est pas dans un garage
     */
    public void sortDuGarage() throws Exception {
        // Trouver le dernier stationnement de la voiture
        // Terminer ce stationnement
        if (this.estDansUnGarage() == false) {
            throw new IllegalArgumentException("La voiture n'est pas dans un garage");
        } else {
            Stationnement dernierStationnement = myStationnements.get(myStationnements.size() - 1);
            dernierStationnement.terminer();
        }
    }

    /**
     * @return l'ensemble des garages visités par cette voiture
     */
    public Set<Garage> garagesVisites() {
        Set<Garage> garagesVisites = new HashSet<>();
        for (int i = 0; i < myStationnements.size(); i++) {
            Garage g = myStationnements.get(i).getGarage();
            garagesVisites.add(g);
        }
        System.out.println("Les garages visités sont :" + garagesVisites);
        return garagesVisites;
    }

    /**
     * @return vrai si la voiture est dans un garage, faux sinon
     */
    public boolean estDansUnGarage() {
        // Vrai si le dernier stationnement est en cours
        if (myStationnements.isEmpty()) {
            return false;
        } else {
            Stationnement dernierStationnement = myStationnements.get(myStationnements.size() - 1);
            if (dernierStationnement.estEnCours()) {
                System.out.println("La voiture est dans un garage");
                return true;
            } else {
                System.out.println("La voiture n'est pas dans un garage");
                return false;
            }
        }
    }

    /**
     * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste
     * des dates d'entrée / sortie dans ce garage
     * <br>Exemple :
     * <pre>
     * Garage Castres:
     *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
     *		Stationnement{ entree=28/01/2019, en cours }
     *  Garage Albi:
     *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
     * </pre>
     *
     * @param out l'endroit où imprimer (ex: System.out)
     */
    public void imprimeStationnements(PrintStream out) {
        for (int i = 0; i < myStationnements.size(); i++) {
            System.out.println("Garage " + myStationnements.get(i).getGarage().getName() + ":");
            System.out.println(myStationnements.get(i).toString());
        }

    }

}
