package main;

public interface Certificat {
	
	/**
	 * Retournera vrai SSi le certificat est bien correct pour le pb auquel il est associé<br>
	 * (L'algorithme A du cours)
	 */
	public boolean estCorrect();
	
	/**
	 * Pour pouvoir enumérer les certificats, on définit un ordre sur les certificats<br>
	 * Le certificat passe au suivant dans l'ordre choisi
	 */
	public void suivant();
	
	/**
	 * Le certificat est le dernier dans l'ordre choisi
	 */
	public boolean estDernier();
	
	/**
	 * Le certificat prend une valeur aléatoire
	 */
	public void alea();
	
	public void affiche();

}
