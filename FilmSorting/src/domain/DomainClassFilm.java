package domain;

public class DomainClassFilm {

	private int reff;
	private String navnf, namef, audiof, subf;
	private boolean blurayf, burned, kids, animation, danish, horror;
	private String yearf, notef;

	public int getReff() {
		return reff;
	}

	public void setReff(int reff) {
		this.reff = reff;
	}

	public String getNavnf() {
		return navnf;
	}

	public void setNavnf(String navnf) {
		this.navnf = navnf;
	}

	public String getNamef() {
		return namef;
	}

	public void setNamef(String namef) {
		this.namef = namef;
	}

	public String getAudiof() {
		return audiof;
	}

	public void setAudiof(String audiof) {
		this.audiof = audiof;
	}

	public String getSubf() {
		return subf;
	}

	public void setSubf(String subf) {
		this.subf = subf;
	}

	public boolean isBlurayf() {
		return blurayf;
	}

	public void setBlurayf(boolean blurayf) {
		this.blurayf = blurayf;
	}

	public String getYearf() {
		return yearf;
	}

	public void setYearf(String yearf) {
		this.yearf = yearf;
	}

	public boolean isBurned() {
		return burned;
	}

	public void setBurned(boolean burned) {
		this.burned = burned;
	}

	public boolean isKids() {
		return kids;
	}

	public void setKids(boolean kids) {
		this.kids = kids;
	}

	public boolean isAnimation() {
		return animation;
	}

	public void setAnimation(boolean animation) {
		this.animation = animation;
	}

	public boolean isDanish() {
		return danish;
	}

	public void setDanish(boolean danish) {
		this.danish = danish;
	}

	public boolean isHorror() {
		return horror;
	}

	public void setHorror(boolean horror) {
		this.horror = horror;
	}

	public String getNotef() {
		return notef;
	}

	public void setNotef(String notef) {
		this.notef = notef;
	}

}