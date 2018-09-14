package domain;

public class DomainClassSeries {
	private int refs;
	private String navn;
	private String name;
	private String aarstal;
	private int season;
	private String audio;
	private String sub;
	private boolean burned;
	private String note;

	public int getRefs() {
		return refs;
	}

	public void setRefs(int refs) {
		this.refs = refs;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAarstal() {
		return aarstal;
	}

	public void setAarstal(String aarstal) {
		this.aarstal = aarstal;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}