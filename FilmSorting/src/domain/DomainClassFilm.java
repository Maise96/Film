package domain;

public class DomainClassFilm {

	private int ref;
	private String navn;
	private String name;
	private String aarstal;
	private String audio;
	private String sub;
	private String note;
	private boolean burned;

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
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

	public boolean getBurned() {
		return burned;
	}

	public void setBurned(boolean burned) {
		this.burned = burned;
	}
}