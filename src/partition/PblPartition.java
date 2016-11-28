package partition;

import binpack.PblBinPack;

public class PblPartition {
	
	private int nbEntiers;
	private int[] entiers;
	
	public PblPartition(int nbEntiers, int[] entiers) {
		this.nbEntiers = nbEntiers;
		this.entiers = entiers;
	}
	
	public int getNbEntiers() {
		return this.nbEntiers;
	}
	
	public int[] getEntiers() {
		return this.entiers;
	}

	public PblBinPack toPblBinPack() {
		int capacite = 0;
		for(int i = 0; i < nbEntiers; i++)
			capacite += this.entiers[i];
		capacite /= 2;
		return new PblBinPack(this.nbEntiers, this.entiers, 2, capacite);
	}

}
