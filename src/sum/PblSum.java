package sum;

import binpack.PblBinPack;
import partition.PblPartition;

public class PblSum {
	
	private int nbEntiers;
	private int[] entiers;
	private int entierCible;
	
	public PblSum(int nbEntiers, int[] entiers, int entierCible) {
		this.nbEntiers = nbEntiers;
		this.entiers = entiers;
		this.entierCible = entierCible;
	}
	
	public int getNbEntiers() {
		return this.nbEntiers;
	}
	
	public int[] getEntiers() {
		return this.entiers;
	}
	
	public int getEntierCible() {
		return this.entierCible;
	}
	
	public PblPartition toPblPartition() {
		int somme = 0;
		int[] tab = new int[this.nbEntiers +1];
		System.arraycopy(this.entiers, 0, tab, 0, this.nbEntiers);
		for(int i = 0; i < nbEntiers; i++) {
			somme += this.entiers[i];
		}
		tab[this.nbEntiers] = (2 * this.entierCible) - somme;
		return new PblPartition(this.nbEntiers + 1, tab);
	}
	
	public PblBinPack toPblBinPack() {
		PblBinPack binPack = this.toPblPartition().toPblBinPack();
		binPack.getObjets().remove(binPack.getObjets().size() - 1);
		return binPack;
	}

}
