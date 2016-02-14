package jaxb;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Strona {
	String nazwa;
	String komentarz;

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getKomentarz() {
		return komentarz;
	}

	public void setKomentarz(String komentarz) {
		this.komentarz = komentarz;
	}
}
