package binpack;

public class Objet {
	
	private int poids;
	
	public Objet(int poids) {
		this.poids = poids;
	}
	
	public int getPoids() {
		return this.poids;
	}
	
	public String toString() {
		return this.poids + "";
	}

}
