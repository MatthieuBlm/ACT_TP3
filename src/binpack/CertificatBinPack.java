package binpack;

import java.util.List;
import java.util.Random;

import structure.Certificat;

public class CertificatBinPack implements Certificat {
	
	private PblBinPack binPack;
	
	/**
	 * Variable qui determine dans quel sac va tel objet.<br>
	 * Exemple : disposition[1] = 2 veut dire que l'objet 1 va dans le sac 2.
	 */
	private int[] disposition;
	private int nbObjets;
	private int nbSacs;
	
	public CertificatBinPack(PblBinPack binPack) {
		this.binPack = binPack;
		this.nbObjets = binPack.getObjets().size();
		this.nbSacs = binPack.getSacs().size();
		this.disposition = new int[this.nbObjets];
		for(int i = 0; i < this.nbObjets; i++)
			this.disposition[i] = 0;
		this.ajouterObjetsDansSacs();
	}
	
	public PblBinPack getBinPack() {
		return this.binPack;
	}
	
	public void reset() {
		for(int i = 0; i < this.nbObjets; i++)
			this.disposition[i] = 0;
		viderSacs();
	}
	
	public void ajouterObjetsDansSacs() {
		List<Sac> sacs = this.binPack.getSacs();
		List<Objet> objets = this.binPack.getObjets();
		for(int i = 0; i < this.nbObjets; i++)
			sacs.get(disposition[i]).add(objets.get(i));
	}
	
	public void viderSacs() {
		this.binPack.viderSacs();
	}

	public boolean estCorrect() {
		this.viderSacs();
		this.ajouterObjetsDansSacs();
		for(Sac sac : this.binPack.getSacs()) {
			if(sac.estSurcharge())
				return false;
		}
		return true;
	}

	public void suivant() {
		int limit = this.nbSacs - 1;
		for(int i = disposition.length - 1; i >= 0; i--) {
			if(disposition[i] == limit)
				disposition[i] = 0;
			else {
				disposition[i]++;
				break;
			}
		}
	}

	public boolean estDernier() {
		int tmp = this.nbSacs - 1;
		int length = this.disposition.length;
		for(int i = 0; i < length; i++) {
			if(this.disposition[i] != tmp)
				 return false;
		}
		return true;
	}

	public void alea() {
		Random random = new Random();
		for(int i = 0; i < this.nbObjets; i++)
			this.disposition[i] = random.nextInt(this.nbSacs);
	}

	public void affiche() {
		System.out.println(this.binPack);
	}
	
	

}
