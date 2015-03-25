package principal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="peoples")
@NamedQuery(name="buscatodos", query="select l from Peoples l")
public class Peoples {

	@Id
	@GeneratedValue
	private int people_id;
	
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Disciplines> disciplines;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "people_id")
	private Users user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "people")
	private List<Addresses> addresse;
	
	public List<Addresses> getAddresse() {
		return addresse;
	}

	public void setAddresse(List<Addresses> addresse) {
		this.addresse = addresse;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Disciplines> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(List<Disciplines> disciplines) {
		this.disciplines = disciplines;
	}

	public int getPeople_id() {
		return people_id;
	}

	public void setPeople_id(int people_id) {
		this.people_id = people_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
