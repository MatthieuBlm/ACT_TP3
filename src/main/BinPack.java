package main;

import java.util.List;

public class BinPack {
	
	private List<Objet> objets;
	private List<Sac> sacs;
	
	public BinPack(List<Objet> objets, List<Sac> sacs) {
		this.objets = objets;
		this.sacs = sacs;
	}
	
	public List<Objet> getObjets() {
		return this.objets;
	}
	
	public List<Sac> getSacs() {
		return this.sacs;
	}
	
	public void viderSacs() {
		for(Sac sac : sacs)
			sac.vider();
	}
	
	public boolean aUneSolution() {
		
		// On récupère le nombre de sacs
		int nbSacs = sacs.size();
		
		// S'il y a un seul sac
		if(nbSacs == 1) {
			Sac sac = sacs.get(0);
			for(Objet objet : objets) {
				sac.add(objet);
				return !sac.estSurcharge();
			}
		}
		
		// S'il y a plusieurs sacs
		int[] indexes = new int[nbSacs - 1];
		int nbObjets = objets.size();
		
		//  A compléter
		// essaie tous les certificats un à un jusqu'à en trouver un correct -si il existe	....
		
		return false;
	}
	
	//Algo non déterministe
    //si il y a une solution, au moins une exécution doit retourner Vrai
    // sinon, toutes les exécutions doivent retourner Faux
    public boolean aUneSolutionNonDeterministe() {
    	//   A compléter
    	//génère alétaoirement un certificat et vérifie si il est correct
    	return false;
    }

}
