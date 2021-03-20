

public class Anime {
	
	private String nume;
	private int episoade;
	private boolean terminat;
	private String gen;
	private int an;
	private String site,comentarii;
	public Anime(String nume, int episoade, boolean terminat, String gen, int an, String site, String comentarii) {
		super();
		this.nume = nume;
		this.episoade = episoade;
		this.terminat = terminat;
		this.gen = gen;
		this.an = an;
		this.site = site;
		this.comentarii = comentarii;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getEpisoade() {
		return episoade;
	}
	public void setEpisoade(int episoade) {
		this.episoade = episoade;
	}
	public boolean isTerminat() {
		return terminat;
	}
	public void setTerminat(boolean terminat) {
		this.terminat = terminat;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public int getAn() {
		return an;
	}
	public void setAn(int an) {
		this.an = an;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getComentarii() {
		return comentarii;
	}
	public void setComentarii(String comentarii) {
		this.comentarii = comentarii;
	}
	
	

}
