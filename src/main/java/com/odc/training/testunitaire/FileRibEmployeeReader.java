package com.odc.training.testunitaire;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRibEmployeeReader {

    public static List<CompteBancaireTwo> readListVirement() {

        String fichierCSV = "C:\\Users\\Orange\\UnitTests\\Comptes.csv"; // Mettez ici le chemin de votre fichier CSV
        List<CompteBancaireTwo> comptes = new ArrayList<CompteBancaireTwo>();

        // Essayer de lire le fichier
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichierCSV));
            String ligne;
            while ((ligne = br.readLine()) != null) {
                // Séparer la ligne par des virgules (ou un autre délimiteur si nécessaire)
                String[] valeurs = ligne.split(";");
                
                CompteBancaireTwo compteBancaire = new CompteBancaireTwo();
                compteBancaire.setProprietaire(valeurs[0]);
                compteBancaire.setRib(valeurs[1]);
                compteBancaire.setSolde(Double.parseDouble(valeurs[2]));

                comptes.add(compteBancaire);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return comptes;
    }

    public static void main(String[] args) {
         System.out.println(readListVirement().size());
    }
}
