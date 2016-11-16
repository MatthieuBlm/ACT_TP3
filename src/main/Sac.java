package main;

import java.util.ArrayList;
import java.util.List;

public class Sac {
	
	private int capacite;
	private List<Objet> objets;
	
	public Sac(int capacite) {
		this.capacite = capacite;
		this.objets = new ArrayList<Objet>();
	}
	
	public int getCapacite() {
		return this.capacite;
	}
	
	public List<Objet> getObjets() {
		return this.objets;
	}
	
	public void add(Objet objet) {
		this.objets.add(objet);
	}
	
	public void vider() {
		this.objets.clear();
	}
	
	public int getPoids() {
		int res = 0;
		for(Objet objet : objets)
			res += objet.getPoids();
		return res;
	}
	
	public boolean estSurcharge() {
		return this.getPoids() > this.capacite;
	}

}
