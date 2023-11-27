package rmiServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmiService.BanqueImpl;

public class BanqueServer {
    public static void main(String[] args) {
        try {
            // Créer et initialiser le registre RMI
            Registry registry = LocateRegistry.createRegistry(1099);

            // Instancier l'implémentation de la banque
            BanqueImpl banque = new BanqueImpl();
          System.out.println(banque.toString());
            // Lier l'objet distant dans le registre sous le nom "BanqueService"
            registry.rebind("rmi://localhost:1090/BanqueService",banque);
            System.out.println("Serveur prêt...");
        } catch (Exception e) {
            System.err.println("Erreur : " + e.toString());
            e.printStackTrace();
        }
    }
}