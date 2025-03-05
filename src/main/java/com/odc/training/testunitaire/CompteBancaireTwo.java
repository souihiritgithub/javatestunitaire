package com.odc.training.testunitaire;

import java.util.List;

public class CompteBancaireTwo {
	private String proprietaire ; 
	private double Solde ; 
	private String rib ;
	private double CompteBancaire;
	private boolean debit ; 
	private double plafondRetrait ;  
	private double plafondSoldeDebit=3000;
	
	 public CompteBancaireTwo(String rib, double solde, boolean debit,double plafondRetrait ) {
	        this.rib = rib;
	        this.Solde = solde;
	        this.debit = debit;
	        this.plafondRetrait = plafondRetrait;
	    }
	 
	 public CompteBancaireTwo(String rib, double solde) {
	        this.rib = rib;
	        this.Solde = solde;
	    }
	 
	 

	public CompteBancaireTwo(int i, boolean b) {
	}






	public CompteBancaireTwo() {
		// TODO Auto-generated constructor stub
	}

	// Méthode pour effectuer un versement
	public void versement(double montant) {
	    if (montant > 0) {
	        Solde += montant;
	        System.out.println("Versement de " + montant + " TND effectué. Nouveau solde : " + Solde);
	    } else {
	        System.out.println("Le montant du versement doit être positif.");
	    }
	}


	/*// Méthode pour effectuer un virement vers un autre compte
		public void virement(CompteBancaireTwo destinataire, double montant) {
		  
			if (montant > 0) {
		        Solde -= montant;
		        destinataire.versement(montant);
		        System.out.println("Virement de " + montant + " TND effectué vers " + Solde);
		    } else {
		        System.out.println("Virement impossible : montant négatif ou solde insuffisant.");
		    }
		}*/


	public static void main(String[] args) {
	    CompteBancaireTwo compte1 = new CompteBancaireTwo(1000, true);
	    CompteBancaireTwo compte2 = new CompteBancaireTwo(500, true);


	    compte1.versement(200);
	    compte1.virement(compte2, 300);
	}
	
	public String getProprietaire() {
		return proprietaire;
	}
	public double getCompteBancaire() {
		return getCompteBancaire();
	}
	public void setCompteBancaire(double compteBancaire) {
		double CompteBancaire = compteBancaire;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
	public double getSolde() {
		return Solde;
	}
	public void setSolde(double solde) {
		this.Solde = solde;
	}
	public String getRib() {
		return rib;
	}
	
	

	
	
	public void retraitArgent(double montant) {
	    if (montant > plafondRetrait) {
	        // Vérification du plafond de retrait
	        System.out.println("Plafond de retrait dépassé !");
	        return;
	    } else if (Solde < montant && !debit) {
	        // Vérification du solde et du découvert
	        /* "Le solde du compte est inférieur au montant demandé et que
	         * l'option de découvert (debit) n'est pas activée (false), alors le retrait est refusé.
	         * L'opération s'arrête ici (return)."
	         */
	        System.out.println("Solde insuffisant !");
	        return;
	    }

	    System.out.println("Solde avant retrait = " + Solde);
	    Solde -= montant;

	    if (Solde < plafondSoldeDebit) {
	        System.out.println("Le plafond de solde de débit est atteint");
	        Solde += montant;
	    }

	    System.out.println("Solde après retrait = " + Solde);
	}
	
	
	

	
	
	public boolean isValidRIB() {
	    // Vérifier si le RIB est non nul et contient exactement 20 chiffres
	    if (rib != null && rib.matches("\\d{20}")) {
	        return true;
	    } else {
	        System.out.println("Le RIB doit contenir exactement 20 chiffres.");
	        return false;
	    }
	}

	
	 
	
	
	
	
	
	
	
	
	public void virementEnMasse(List<CompteBancaireTwo> comptes, double montant)
	
    {
    	for (CompteBancaireTwo compteBancaire : comptes) {
			virement(compteBancaire, montant);
		}
    }
	
	
	
	
	
    // Méthode pour effectuer un virement vers un autre compte
    public void virement(CompteBancaireTwo destinataire, double montant) {
    	
    	if(destinataire.isValidRIB())
    	{
    		
    		 if (montant > 0 && Solde - montant <= plafondSoldeDebit) {
 	            Solde -= montant;
 	            destinataire.versement(montant);
 	            System.out.println("Virement de " + montant + " TND est efectué avec succés. Le nouveau solde est : "+ Solde);
 	        } else {
 	            System.out.println("Dépassement de plafond non autorisé.");
 	        }
    	}
      
    }

	public void setRib(String rib) {
		this.rib = rib;
	}
    
    
    
    
    
	/*public void setRib(String rib) {
        if (isValidRib(rib)) {
            this.rib = rib;
        } else {
            System.out.println("RIB invalide. Il doit contenir exactement 20 chiffres.");
        }
    }
	
	
	private boolean isValidRib(String rib) {
        return rib != null && rib.matches("\\d{20}");
    }*/
   
	
	

	

	
	


}

