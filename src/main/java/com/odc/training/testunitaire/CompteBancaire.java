package com.odc.training.testunitaire;

public class CompteBancaire {
	private String proprietaire;
	private double solde;
	private String rib;

	public CompteBancaire(double solde) {
		this.solde = solde;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public void virement(double montant) {

		if (montant > 0 && solde >= montant) {
			solde -= montant;
		}

		else {
			System.out.println("Montant invalide ou solde insuffisant");
		}

	}

	public void versement(double montantV) {
		solde = solde + montantV;
	}

}
