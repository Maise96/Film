package domain;

public class DomainClassSeries {
	private int refs, cs, season, number, episode, volume;
	private String navns, names, audios, subs, years, notes;
	private boolean blurays;

	public int getRefs() {
		return refs;
	}

	public void setRefs(int refs) {
		this.refs = refs;
	}

	public String getNavns() {
		return navns;
	}

	public void setNavns(String navns) {
		this.navns = navns;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public int getCs() {
		return cs;
	}

	public void setCs(int cs) {
		this.cs = cs;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getEpisode() {
		return episode;
	}

	public void setEpisode(int episode) {
		this.episode = episode;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public boolean isBlurays() {
		return blurays;
	}

	public void setBlurays(boolean blurays) {
		this.blurays = blurays;
	}

	public String getAudios() {
		return audios;
	}

	public void setAudios(String audios) {
		this.audios = audios;
	}

	public String getSubs() {
		return subs;
	}

	public void setSubs(String subs) {
		this.subs = subs;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}