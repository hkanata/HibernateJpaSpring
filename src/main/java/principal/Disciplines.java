package principal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="disciplines")
public class Disciplines {

	@Id
	@GeneratedValue
	private int discipline_id;
	
	private String name_discipline;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Peoples> peoples;

	public List<Peoples> getPeoples() {
		return peoples;
	}

	public void setPeoples(List<Peoples> peoples) {
		this.peoples = peoples;
	}

	public int getDiscipline_id() {
		return discipline_id;
	}

	public void setDiscipline_id(int discipline_id) {
		this.discipline_id = discipline_id;
	}

	public String getName_discipline() {
		return name_discipline;
	}

	public void setName_discipline(String name_discipline) {
		this.name_discipline = name_discipline;
	}
}
