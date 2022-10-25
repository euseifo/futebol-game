package entities;

public class Time {

	private String id;
	private String nome;
	private int forca;
	private String estadio;
	private static int nTimes;
	
	public Time(String id, String nome, int forca, String estadio) {
		this.id = id;
		this.nome = nome;
		this.forca = forca;
		this.estadio = estadio;
		nTimes += 1;
	}

	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	
	@Override
	public String toString() {
		return "Nome do time: " + nome + "\nForça do time: " + forca + "\nEstádio: " + estadio;
	}
	
	public String timeFormat() {
		return id + "|" + nome + "|" + forca + "|" + estadio + "|" + nTimes; 
	}
	
	public int numeroDeTimes() {
		return nTimes;
	}
	
}
