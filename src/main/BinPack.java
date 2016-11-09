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

}
