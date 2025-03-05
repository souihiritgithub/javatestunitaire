package com.odc.training.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.odc.training.testunitaire.CompteBancaireTwo;
import com.odc.training.testunitaire.FileRibEmployeeReader;

public class CompteBancaireTestTwo
 {
	static CompteBancaireTwo compteBiat, compteBNA, compteATB, compteZitouna, compteAmen, compteAmen1, compteAmen2,
			compteAmen3, compteSTB, compteSTB1, compteSTB2, compteSTB3;

	// Préparation des préconditions : AIO Test

	@BeforeClass
	public static void setUp() throws Exception {

		compteBiat = new CompteBancaireTwo("12345678912345678912", 1000, false, 300);
		compteBNA = new CompteBancaireTwo("12345678912345678911", 700, true, 300);
		compteATB = new CompteBancaireTwo("12345678912345678912", 1000, true, 800);
		compteZitouna = new CompteBancaireTwo("12345678912345678912", 520, false, 300);

		compteAmen = new CompteBancaireTwo("12345678912345678912", 520);
		compteAmen1 = new CompteBancaireTwo("12345678912345678912", 520);
		compteAmen2 = new CompteBancaireTwo("123456789123456789", 520);
		compteAmen3 = new CompteBancaireTwo("a23456789123456789", 520);

		compteSTB = new CompteBancaireTwo("12345678912345678912", 2000);
		compteSTB1 = new CompteBancaireTwo("12345678912345678912", 800);
		compteSTB2 = new CompteBancaireTwo("12345678912345678911", 800);
		compteSTB3 = new CompteBancaireTwo("62345678912345678922", 800);

	}
	// Initialisation des données déjà utilisés: Postconditions

	@AfterClass
	public static void tearDown() throws Exception {
		System.out.println("je suis la méthode tearDown");

	}

	// Action, Expected Result
	// @Test
	public void testVirement() {

		/*
		 * System.out.println("je suis la méthode test Virement");
		 * compteBiat.virement(compteBNA, 400); assertEquals(600, compteBiat.getSolde(),
		 * 0); assertEquals(1100, compteBNA.getSolde(), 0);
		 * 
		 * compteBNA.virement(compteBiat, 400); assertEquals(700, compteBNA.getSolde(),
		 * 0);
		 */
		// Valide RIB
		compteAmen.virement(compteAmen1, 100);
		assertEquals(620, compteAmen1.getSolde(), 0);
		// invalide RIB
		compteAmen.virement(compteAmen2, 300);
		assertEquals(520, compteAmen2.getSolde(), 0);
		// invalide RIB avec caractère
		compteAmen.virement(compteAmen3, 300);
		assertEquals(520, compteAmen3.getSolde(), 0);
	}

	// @Test
	public void testVersement() {

		System.out.println("je suis la méthode test Versement");
		compteBiat.versement(400);
		assertEquals(1400, compteBiat.getSolde(), 0);
		compteBiat.versement(-800);
		assertEquals(1400, compteBiat.getSolde(), 0);
	}

	// @Test
	public void testRetraitPlafond() {

		System.out.println("je suis la méthode test testRetraitPlafond");
		compteBNA.retraitArgent(200);
		assertEquals(500, compteBNA.getSolde(), 0);
	}

	// @Test
	public void testRetraitAvecDecouvert() {

		System.out.println("je suis la méthode test testRetraitAvecDecouvert");
		compteATB.retraitArgent(800);
		compteATB.retraitArgent(800);
		compteATB.retraitArgent(800);
		assertEquals(-1400, compteATB.getSolde(), 0);
		compteATB.retraitArgent(300);
		assertEquals(-1700, compteATB.getSolde(), 0);
		compteATB.retraitArgent(300);
		assertEquals(-1700, compteATB.getSolde(), 0);
	}

	// @Test
	public void testRetraitSansDecouvert() {

		System.out.println("je suis la méthode test testRetraitSansDecouvert");
		compteZitouna.retraitArgent(1200);
		assertEquals(520, compteZitouna.getSolde(), 0);

		compteZitouna.retraitArgent(200);
		assertEquals(320, compteZitouna.getSolde(), 0);
	}

	// @Test
	public void testVirementEnMasse() {
		List<CompteBancaireTwo> comptes = new ArrayList<CompteBancaireTwo>();
		comptes.add(compteSTB1);
		comptes.add(compteSTB2);
		comptes.add(compteSTB3);
		compteSTB.virementEnMasse(comptes, 100);
		assertEquals(900, compteSTB1.getSolde(), 0);
		assertEquals(900, compteSTB2.getSolde(), 0);
		assertEquals(900, compteSTB3.getSolde(), 0);
	}

	@Test
	public void testVirementEmployeeEnMasseFromFile() {
		List<CompteBancaireTwo> comptes = FileRibEmployeeReader.readListVirement();
		compteSTB.virementEnMasse(comptes, 200);
		assertEquals(1200, compteSTB.getSolde(), 0);
	}

}
