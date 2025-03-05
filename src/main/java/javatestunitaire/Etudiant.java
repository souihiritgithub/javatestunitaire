package javatestunitaire;

import java.sql.Date;

public class Etudiant {
	private String name;
	private String score;
	private String ExamCertification;
	private Date examDate;
	private String examPlace;
	private String certificateNumber;

	public Etudiant(String name, String score) {
		this.name = name;
		this.score = score;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getScore() {
		return score;
	}


	public void setScore(String score) {
		this.score = score;
	}


	public String getExamCertification() {
		return ExamCertification;
	}


	public void setExamCertification(String examCertification) {
		ExamCertification = examCertification;
	}


	public Date getExamDate() {
		return examDate;
	}


	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}


	public String getExamPlace() {
		return examPlace;
	}


	public void setExamPlace(String examPlace) {
		this.examPlace = examPlace;
	}


	public String getCertificateNumber() {
		return certificateNumber;
	}


	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}
	
	
	
	
	
	
	
	
		
		

}
