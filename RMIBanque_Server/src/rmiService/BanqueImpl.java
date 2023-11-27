package rmiService;
import metier.Compte;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BanqueImpl extends UnicastRemoteObject implements IBanque {
	
	private List<Compte> comptes;
    public BanqueImpl() throws RemoteException {
        super();
        comptes=new ArrayList();
    }

    @Override
    public String creerCompte(Compte c) throws RemoteException {
        // Implémentation de la méthode creerCompte
    	comptes.add(c);
        return c+ "a ajoutée avec succée";
    }

    @Override
    public String getInfoCompte(int code) throws RemoteException {
        // Implémentation de la méthode getInfoCompte
    	for(Compte compte : comptes) {
    		if(compte.getCode()==code) {
    			return "code" + compte.getCode() +"\n solde" + compte.getCode() +"date" + compte.getDateCreation() ;
    		}
    	}
        return "le compte n'existe pas";
    }
}