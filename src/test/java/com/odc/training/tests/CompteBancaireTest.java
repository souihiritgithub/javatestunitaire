package com.odc.training.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.odc.training.testunitaire.CompteBancaire;

public class CompteBancaireTest {
	static CompteBancaire CompteIslem;
	double montant = 500;
	double montantV = 100;

	// Préparation des conditions : AIO Test

	@BeforeClass
	public static void setUp() throws Exception {

		System.out.println("Je suis la methode SetUp");

		CompteIslem = new CompteBancaire(1000);
		System.out.println("==>" + CompteIslem.getSolde());
		CompteIslem.setSolde(2000);
		System.out.println("==>" + CompteIslem.getSolde());
	}

	// Initialisation des données déjà utilisés
	@AfterClass
	public static void tearDown() throws Exception {
		System.out.println("Je suis la methode tearDown");
	}

	// Action : Expected result
	@Test
	public void testVirement() {

		System.out.println("je suis la méthode test Virement");

		double SoldeIslem = CompteIslem.getSolde();

		CompteIslem.virement(montant); // il existe une méthode virement dans la classe CompteBancaire
		assertEquals("Virement impossible", SoldeIslem - montant, CompteIslem.getSolde(), 0);
		System.out
				.println("Virement effectué avec succès! votre montant aprés Virement est :" + CompteIslem.getSolde());
	}

	@Test
	public void testVersement() {

		System.out.println("je suis la méthode test Versement");

		double SoldeIslem = CompteIslem.getSolde();

		CompteIslem.versement(montantV); // il existe une méthode versement dans la classe CompteBancaire

		assertEquals("Versement impossible", SoldeIslem + montantV, CompteIslem.getSolde(), 0);
		System.out.println(
				"Versement effectué avec succès! votre montant aprés Versement est :" + CompteIslem.getSolde());

	}
	
	
	
	
}
