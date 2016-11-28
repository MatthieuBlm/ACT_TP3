package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import binpack.PblBinPack;

public class Main {
	
	@SuppressWarnings("resource")
	private static int entrerNombreDeSacs() {
		try {
			System.out.print("\nNombre de sacs : ");
			Scanner scan = new Scanner(System.in);
			int tmp = scan.nextInt();
			if(tmp < 1) {
				System.err.println("Veuillez indiquer un entier positif\n");
				return -1;
			}
			return tmp;
		} catch(Exception e) {
			System.err.println("Veuillez indiquer un entier positif\n");
			return -1;
		}
	}
	
	@SuppressWarnings("resource")
	private static String entrerMode() {
		try {
			System.out.println("\nVeuillez choisir un mode d'ex�cution parmis les suivants :");
			System.out.println("Exhaustif (exh)");
			System.out.println("Non d�terministe (nd)");
			System.out.println("V�rification (ver)");
			System.out.print("Mode : ");
			Scanner scan = new Scanner(System.in);
			String tmp = scan.next();
			if(!tmp.equals("-exh") && !tmp.equals("-nd") && !tmp.equals("-ver")) {
				System.err.println(tmp + " Mode non valide\n");
				return "";
			}
			return tmp;
		} catch(Exception e) {
			System.err.println("Mode non valide\n");
			return "";
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/* Fichier � lire */
		BufferedReader br = new BufferedReader(new FileReader("DonTPNP/BinPack/exBPeq1"));
		
		/* Lecture des donn�es du fichier */
		int capacite = Integer.parseInt(br.readLine());
		int nbObjets = Integer.parseInt(br.readLine());
		int[] poids = new int[nbObjets];
		for(int i = 0; i < nbObjets; i++)
			poids[i] = Integer.parseInt(br.readLine());
		
		/* Saisie du nombre de sacs */
		int nbSacs = -1;
		while(nbSacs == -1)
			nbSacs = entrerNombreDeSacs();
		
		/* Choix du mode d'ex�cution */
		String mode = "";
		while(!mode.equals("-exh") && !mode.equals("-nd") && !mode.equals("-ver"))
			mode = entrerMode();
		
		/* Initialisation du BinPack */
		PblBinPack binPack = new PblBinPack(nbObjets, poids, nbSacs, capacite);
		
		boolean res;
		switch(mode) {
			case "-exh":
				res = binPack.aUneSolution();
				if(res) {
					System.out.println("Solution trouv�e:\n");
					binPack.getCertificat().affiche();
				} else
					System.out.println("Aucune solution trouv�e");
				break;
			case "-nd":
				res = binPack.aUneSolutionNonDeterministe();
				if(res) {
					System.out.println("Solution non d�terministe trouv�e:\n");
					binPack.getCertificat().affiche();
				} else
					System.out.println("Le certificat g�n�r� n'est pas une solution.");
				break;
			default:
				System.out.println("V�rification pas encore impl�ment�e");
				break;
		}


	}

}
