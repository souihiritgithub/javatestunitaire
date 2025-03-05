package javatestunitaire;
import java.util.ArrayList;
import java.util.List;

public class HelloWorldEtudiant {
 private static List<Etudiant> etudiants= new ArrayList<Etudiant>();
 
 public static void main(String[] args) {
	 Etudiant islem= new Etudiant("islem", "90.@");
	 islem.setCertificateNumber("154789658");
	 Etudiant saber= new Etudiant("saber", "87.5");
	 saber.setCertificateNumber("58777798");
	 
	 etudiants.add(islem);
	 etudiants.add(saber);
	 
	 for(Etudiant etudiant : etudiants) {
	            if (etudiant.getScore().equals("In progress")) {
	                System.out.println("Bonjour " + etudiant.getName() + ", good luck!");
	            } else {
	                    try {
							// Convertir en double
							double score = Double.parseDouble(etudiant.getScore());
							if (score >= 65) {
							    System.out.println("Bonjour " + etudiant.getName() + ", Félicitations!");
							} else {
							    System.out.println("Bonjour " + etudiant.getName() + ", Essayez une autre fois.");
							}
						} catch (NumberFormatException e) {
							System.out.println("Bonjour " + etudiant.getName()+ ", Erreur dans la saisie du score. Veuillez vérifier.");
						}
	                }
	            }
	 }
 }

