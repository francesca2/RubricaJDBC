package model;

public class Rubrica {
	
	private String nomeRubrica;
	private long idRubrica;
	public Rubrica() {

	}
	
	public Rubrica(long idRubrica ,String nomeRubrica) {
		super();
		this.nomeRubrica = nomeRubrica;
		this.idRubrica = idRubrica;
	}

	public String getNomeRubrica() {
		return nomeRubrica;
	}

	public void setNomeRubrica(String nomeRubrica) {
		this.nomeRubrica = nomeRubrica;
	}

	public long getIdRubrica() {
		return idRubrica;
	}

	public void setIdRubrica(long idRubrica) {
		this.idRubrica = idRubrica;
	}

}
