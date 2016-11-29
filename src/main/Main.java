package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import partition.PblPartition;
import sum.PblSum;
import binpack.PblBinPack;

public class Main {
	
	@SuppressWarnings("resource")
	private static int choixProbleme() {
		System.out.println("\nVeuillez choisir un problème parmis les suivants (indiquer numéro) :");
		System.out.println("1. BinPack");
		System.out.println("2. Partition");
		System.out.println("3. Sum");
		System.out.print("Numéro du problème : ");
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		if(tmp < 1 || tmp > 3) {
			System.err.println("Numéro de problème invalide");
			return 0;
		}
		return tmp;
	}
	
	@SuppressWarnings("resource")
	private static int entrerNombreDeSacs() {
		System.out.print("\nNombre de sacs : ");
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		if(tmp < 1) {
			System.err.println("Veuillez indiquer un entier positif\n");
			return -1;
		}
		return tmp;
	}
	
	@SuppressWarnings("resource")
	private static String entrerMode() {
		System.out.println("\nVeuillez choisir un mode d'exécution parmis les suivants :");
		System.out.println("Exhaustif (exh)");
		System.out.println("Non déterministe (nd)");
		System.out.println("Vérification (ver)");
		System.out.print("Mode : ");
		Scanner scan = new Scanner(System.in);
		String tmp = scan.next();
		if(!tmp.equals("exh") && !tmp.equals("nd") && !tmp.equals("ver")) {
			System.err.println(tmp + " Mode non valide\n");
			return "";
		}
		return tmp;
	}
	
	/*@SuppressWarnings("resource")
	private static int entrerEntierCible(int sommePoids) {
		System.out.println("\nVeuillez entrer un entier cible compris entre 1 et la somme des poids (" + sommePoids + ")");
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		if(tmp < 1) {
			System.err.println("L'entier cible doit être positif");
			return -1;
		}
		if(tmp > sommePoids) {
			System.err.println("L'entier cible est supérieur à la somme des poids");
			return -1;
		}
		return tmp;
	}*/
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/* Choix du problème */
		int pb = 0;
		while(pb == 0)
			pb = choixProbleme();
		
		BufferedReader br;
		int capacite;
		int nbObjets;
		int[] poids;
		int nbSacs;
		String mode;
		boolean res;
		
		switch(pb) {
		
		/////////////
		/* BinPack */
		/////////////
		case 1:
			
			/* Fichier à lire */
			br = new BufferedReader(new FileReader("DonTPNP/BinPack/exBPeq1"));
			
			/* Lecture des données du fichier */
			capacite = Integer.parseInt(br.readLine());
			nbObjets = Integer.parseInt(br.readLine());
			poids = new int[nbObjets];
			for(int i = 0; i < nbObjets; i++)
				poids[i] = Integer.parseInt(br.readLine());
			
			/* Saisie du nombre de sacs */
			nbSacs = -1;
			while(nbSacs == -1)
				nbSacs = entrerNombreDeSacs();
			
			/* Choix du mode d'exécution */
			mode = "";
			while(!mode.equals("exh") && !mode.equals("nd") && !mode.equals("ver"))
				mode = entrerMode();
			
			/* Initialisation de BinPack */
			PblBinPack binPack = new PblBinPack(nbObjets, poids, nbSacs, capacite);
			
			switch(mode) {
				case "exh":
					res = binPack.aUneSolution();
					if(res) {
						System.out.println("Solution trouvée:\n");
						binPack.getCertificat().affiche();
					} else
						System.out.println("Aucune solution trouvée");
					break;
				case "nd":
					res = binPack.aUneSolutionNonDeterministe();
					if(res) {
						System.out.println("Solution non déterministe trouvée:\n");
						binPack.getCertificat().affiche();
					} else
						System.out.println("Le certificat généré n'est pas une solution.");
					break;
				default:
					System.out.println("Vérification pas encore implémentée");
					break;
			}
			
			break;
			
		///////////////
		/* Partition */
		///////////////
		case 2:
			
			/* Fichier à lire */
			br = new BufferedReader(new FileReader("DonTPNP/Partition/exPart2"));
			
			/* Lecture des données du fichier */
			nbObjets = Integer.parseInt(br.readLine());
			poids = new int[nbObjets];
			for(int i = 0; i < nbObjets; i++)
				poids[i] = Integer.parseInt(br.readLine());
			
			/* Choix du mode d'exécution */
			mode = "";
			while(!mode.equals("exh") && !mode.equals("nd") && !mode.equals("ver"))
				mode = entrerMode();
			
			/* Initialisation de Partition */
			PblPartition partition = new PblPartition(nbObjets, poids);
			
			/* Réduction en BinPack */
			binPack = partition.toPblBinPack();
			
			switch(mode) {
				case "exh":
					res = binPack.aUneSolution();
					if(res) {
						System.out.println("Solution trouvée:\n");
						binPack.getCertificat().affiche();
					} else
						System.out.println("Aucune solution trouvée");
					break;
				case "nd":
					res = binPack.aUneSolutionNonDeterministe();
					if(res) {
						System.out.println("Solution non déterministe trouvée:\n");
						binPack.getCertificat().affiche();
					} else
						System.out.println("Le certificat généré n'est pas une solution.");
					break;
				default:
					System.out.println("Vérification pas encore implémentée");
					break;
			}
			
			break;
			
		/////////
		/* Sum */
		/////////
		case 3:
			
			/* Fichier à lire */
			br = new BufferedReader(new FileReader("DonTPNP/Sum/exSum2"));
			
			/* Lecture des données du fichier */
			// définir capacité
			//capacite = Integer.parseInt(br.readLine());
			nbObjets = Integer.parseInt(br.readLine());
			poids = new int[nbObjets];
			for(int i = 0; i < nbObjets; i++)
				poids[i] = Integer.parseInt(br.readLine());
			int entierCible = Integer.parseInt(br.readLine());
			
			/* Choix du mode d'exécution */
			mode = "";
			while(!mode.equals("exh") && !mode.equals("nd") && !mode.equals("ver"))
				mode = entrerMode();
			
			/* Initialisation de Sum */
			PblSum sum = new PblSum(nbObjets, poids, entierCible);
			
			/* Réduction en BinPack */
			binPack = sum.toPblBinPack();
			binPack.setCertificatSum();
			
			switch(mode) {
				case "exh":
					res = binPack.aUneSolution();
					if(res) {
						System.out.println("Solution trouvée:\n");
						binPack.getCertificat().affiche();
					} else
						System.out.println("Aucune solution trouvée");
					break;
				case "nd":
					res = binPack.aUneSolutionNonDeterministe();
					if(res) {
						System.out.println("Solution non déterministe trouvée:\n");
						binPack.getCertificat().affiche();
					} else
						System.out.println("Le certificat généré n'est pas une solution.");
					break;
				default:
					System.out.println("Vérification pas encore implémentée");
					break;
			}
			
			break;
		
		default:
			System.err.println("An error occured during the problem choice");
			break;
		}

	}

}
