package binpack;

import java.util.ArrayList;
import java.util.List;

import structure.Certificat;
import structure.PblDec;

public class PblBinPack implements PblDec {
	
	private List<Objet> objets;
	private List<Sac> sacs;
	private Certificat certificat;
	
	public PblBinPack(int nbObjets, int[] poids, int nbSacs, int capacite) {
		this.objets = new ArrayList<Objet>();
		for(int i = 0; i < nbObjets; i++)
			objets.add(new Objet(poids[i]));
		this.sacs = new ArrayList<Sac>();
		for(int i = 0; i < nbSacs; i++)
			this.sacs.add(new Sac(capacite));
	}
	
	public List<Objet> getObjets() {
		return this.objets;
	}
	
	public List<Sac> getSacs() {
		return this.sacs;
	}
	
	public Certificat getCertificat() {
		return this.certificat;
	}
	
	public void viderSacs() {
		for(Sac sac : sacs)
			sac.vider();
	}
	
	@Override
	public boolean aUneSolution() {	
		this.certificat = new CertificatBinPack(this);
		
		while(!this.certificat.estDernier()) {
			if(this.certificat.estCorrect())
				return true;
			this.certificat.suivant();
		}
		
		return this.certificat.estCorrect();
	}
	
	//Algo non deterministe
    //si il y a une solution, au moins une execution doit retourner Vrai
    // sinon, toutes les exécutions doivent retourner Faux
    public boolean aUneSolutionNonDeterministe() {
    	this.certificat = new CertificatBinPack(this);
    	this.certificat.alea();
    	return certificat.estCorrect();
    }
    
    public String toString() {
    	String res = "{";
    	for(Sac sac : this.sacs)
    		res += sac.toString() + "\n";
    	res += "}";
    	return res;
    }

}
