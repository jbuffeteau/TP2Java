/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2;

import java.util.Scanner;

/**
 *
 * @author JacquesBuffeteau
 */
public class TP2 {
//jb
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Variable pour effectuer une saisie au clavier
        Scanner sc = new Scanner(System.in);
        // La variable pour le choix du MENU
        int choix;
        String saisie="";
        // Les constantes nécessaires pour les exercices
        final int seuil = 25000;
        final float taux1 = 0.32f;
        final float taux2 = 0.22f;
        final int consoMin = 100;
        final int consoMax = 200;
        final float taux1Conso = 0.083f;
        final float taux2Conso = 0.076f;
        final float taux3Conso = 0.06f;
        do
        {
            do
            {
                // Le MENU
                System.out.println("1  :  Exo1  ==> Frais d'un commercial");
                System.out.println("2  :  Exo2  ==> Consommation électrique");
                System.out.println("3  :  Exo3A ==> Somme des N premiers nombres");
                System.out.println("4  :  Exo3B ==> Factorielle d'un nombre");
                System.out.println("5  :  Exo4A ==> Etoiles en ligne");
                System.out.println("6  :  Exo4B ==> Etoiles en ligne et en colonne");
                System.out.println("7  :  Exo5  ==> Multiplication d'un nombre");
                System.out.println("8  :  Exo6  ==> Jeu de la fourchette");
                System.out.println("0  :  Quitter le programme");
                choix = sc.nextInt();
            }while(choix < 0 || choix > 8);

            // En fonction du choix du MENU, on execute les différents CAS
            switch(choix)
            {
                // On quitte le programme
                case 0:
                    System.out.println("Fin du programme");
                    break;
                case 1:
                    // Déclaration d'une variable pour le nombre de Km
                    int nbKm;
                    // On valide la saisie du nombre de Km
                    do
                    {
                        System.out.println("Veuillez saisir un nombre de KM(s)");
                        nbKm = sc.nextInt();
                    }while(nbKm < 0);
                    // Calcul des frais kilométriques
                    float frais;
                    // Est-ce que le nombre de Km est inférieur à 25000 ?
                    if(nbKm < seuil)
                    {
                        // Oui ! dans ce cas on multiplie par 0.32
                        frais = taux1 * nbKm;
                    }
                    else
                    {
                        // Non ! dans ce cas on multiplie par 0.22
                        frais = taux2 * nbKm;
                    }
                    // Affichage du résultat
                    System.out.println("Vos frais s'élèvent à : " + frais);
                    break;
                case 2:
                    // Variable pour l'ancien indice
                    int ind1;
                    do
                    {
                        System.out.println("Veuillez saisir votre ancien indice");
                        ind1 = sc.nextInt();
                    } while(ind1 < 0);
                    // Variable pour le nouvel indice
                    int ind2;
                    do
                    {
                        System.out.println("Veuillez saisir votre nouvel indice");
                        ind2 = sc.nextInt();
                    } while(ind2 < ind1);
                    // Calcul de la consommation
                    int conso = ind2 - ind1;
                    float montant;
                    // Si la conso est < à 100
                    if (conso <= consoMin)
                    {
                        // Tout est au tarif n°1
                        montant = conso * taux1Conso;
                    }
                    // Si la conso est > à 200
                    else if(conso > consoMax)
                    {
                        // Les 100 premiers au tarif n°1, les 100 suivants au tarif n°2 et le reste au tarif n°3
                        montant = consoMin * taux1Conso + consoMin * taux2Conso + (conso-consoMin)*taux3Conso;
                    }
                    // Sinon la conso est comprise entre 100 et 200
                    else
                    {
                        // Les 100 premiers au tarif n°1 et le reste au tarif n°2
                        montant = consoMin * taux1Conso + (conso-consoMin)*taux2Conso;
                    }
                    System.out.println("Pour une consommation de " + conso + " vous devez payer " + montant);
                    break;
                
                case 3:
                    // Saisie du nombre
                    int nb1;
                    int res;
                    do
                    {
                        System.out.println("Veuillez saisir votre nombre");
                        nb1 = sc.nextInt();
                    } while(nb1 < 0);
                    res = 0;
                    for(int i = 1; i <= nb1; i++)
                    {
                        res = res + i;
                    }
                    System.out.println("La somme des N premiers nombres vaut : " + res);
                    break;
                case 4:
                    // Saisie du nombre
                    do
                    {
                        System.out.println("Veuillez saisir votre nombre");
                        nb1 = sc.nextInt();
                    } while(nb1 < 0);
                    res = 1;
                    for(int i = 1; i <= nb1; i++)
                    {
                        res = res * i;
                    }
                    System.out.println("La factorielle de votre nombre vaut : " + res);
                    break;
                case 5:
                    // Saisie du nombre
                    do
                    {
                        System.out.println("Veuillez saisir le nombre d'étoiles désiré");
                        nb1 = sc.nextInt();
                    } while(nb1 < 0);
                    for(int i = 1; i <= nb1; i++)
                    {
                         System.out.print("*");
                    }
                    System.out.println("");
                     break;
                case 6:
                    // Saisie du nombre d'étoiles en ligne
                    do
                    {
                        System.out.println("Veuillez saisir le nombre d'étoiles en ligne");
                        nb1 = sc.nextInt();
                    } while(nb1 < 0);
                    // Saisie du nombre d'étoiles en colonne
                    int nb2;
                    do
                    {
                        System.out.println("Veuillez saisir le nombre d'étoiles en colonne");
                        nb2 = sc.nextInt();
                    } while(nb2 < 0);
                    // Pour chaque ligne
                    for(int i = 1; i <= nb1; i++)
                    {
                        // Pour chaque colonne
                        for(int j = 1; j <= nb2; j++)
                        {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                     break;
                case 7:
                    // Saisie du nombre
                    do
                    {
                        System.out.println("Multiplication de quel nombre ?");
                        nb1 = sc.nextInt();
                    } while(nb1 < 0);
                    do
                    {
                        System.out.println("Jusqu'à quel nombre ?");
                        nb2 = sc.nextInt();
                    } while(nb2 < 0);
                    for(int j = 0; j <= nb2; j++)
                    {
                        System.out.println(j + " * " + nb1 + " = " + j * nb1);
                    }
                    break;
                case 8:
                        // A vous de jouer :)
                    
                    break;
                default:
                    System.out.println("Erreur de saisie");
                    break;
            }
        }while(choix!=0);
    }
    
}
