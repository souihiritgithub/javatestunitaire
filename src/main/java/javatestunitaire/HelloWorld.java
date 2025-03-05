package javatestunitaire;

public class HelloWorld {
    private static String[][] odcTeam = {{"Islem", "90"}, {"Saber", "87.5"}, {"Abderrahmane", "87.5"}, {"Oumayma", "In progress"}, {"Khalil", "In progress"}, {"Ali", "50"}, {"Smail", "40.b"}};
    
    public static void main(String[] args) {
        for (int i = 0; i < odcTeam.length; i++) {
            if (odcTeam[i][1].equals("In progress")) {
                System.out.println("Bonjour " + odcTeam[i][0] + ", good luck!");
            } else {
                String scoreStr = odcTeam[i][1];

                // Vérification si la chaîne est un nombre valide
                if (scoreStr.matches("-?\\d+(\\.\\d+)?")) {
                    // Convertir en double
                    double score = Double.parseDouble(scoreStr);

                    if (score >= 65) {
                        System.out.println("Bonjour " + odcTeam[i][0] + ", Félicitations!");
                    } else {
                        System.out.println("Bonjour " + odcTeam[i][0] + ", Essayez une autre fois.");
                    }
                } else {
                    System.out.println("Bonjour " + odcTeam[i][0] + ", Erreur dans la saisie du score. Veuillez vérifier.");
                }
            }
        }
    }
}



