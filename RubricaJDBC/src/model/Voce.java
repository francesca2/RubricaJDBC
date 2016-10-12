package model;

public class Voce {
private long idVoce;
private String nome;
private String cognome;
private String telefono;
private long idRubrica;

public Voce() {

}

public Voce(long idVoce, String nome, String cognome, String telefono,
		long idRubrica) {
	super();
	this.idVoce = idVoce;
	this.nome = nome;
	this.cognome = cognome;
	this.telefono = telefono;
	this.idRubrica = idRubrica;
}



public long getIdVoce() {
	return idVoce;
}

public void setIdVoce(long idVoce) {
	this.idVoce = idVoce;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCognome() {
	return cognome;
}

public void setCognome(String cognome) {
	this.cognome = cognome;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}
	
}
