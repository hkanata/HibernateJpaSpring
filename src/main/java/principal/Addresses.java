package principal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="addresses")
public class Addresses {

	@Id
	@GeneratedValue
	private int addresse_id;
	
	private String Addresse_name;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "people_id")
	private Peoples people;

	public Peoples getPeople() {
		return people;
	}

	public void setPeople(Peoples people) {
		this.people = people;
	}

	public int getAddresse_id() {
		return addresse_id;
	}

	public void setAddresse_id(int addresse_id) {
		this.addresse_id = addresse_id;
	}

	public String getAddresse_name() {
		return Addresse_name;
	}

	public void setAddresse_name(String addresse_name) {
		Addresse_name = addresse_name;
	}
}
