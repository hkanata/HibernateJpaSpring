package principal;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Global {

	EntityManagerFactory factory;
	EntityManager em;
	
	@RequestMapping("/")
	public String inicial(Model model){
		
		factory = Persistence.createEntityManagerFactory("databasexml");
		em      = factory.createEntityManager();
		
		/*
		 * opba.com.br
		 * falecom@opba.com.br
		 * To see the result Debug this program or put
		 * return data in each funcion.
		 * */
		
		//savePeoplesDisciplines();
		//savePeoplesUsers();
		//findSql2
		//getSql();
		//delete();
		//findAll
		
		update();
		
		model.addAttribute("message", "Opba.com.br");
		return "showMessage";
	}
	
	//Save peoples with disciplines - Many to many
	public void savePeoplesDisciplines(){
		
		Peoples p1 = new Peoples();
		p1.setName("Novo Mapa Disci");
		
		Disciplines d1 = new Disciplines();
		d1.setName_discipline("disciplina1");
		
		ArrayList<Peoples> aux = new ArrayList<Peoples>();
		aux.add(p1);
		
		d1.setPeoples(aux);
		
		em.getTransaction().begin();
		em.persist(d1);
		em.getTransaction().commit();
		em.close();
	}
	
	//save people and users
	public void savePeoplesUsers(){
		
		Peoples p1 = new Peoples();
		p1.setName("New Users");
		
		Users u1 = new Users();
		u1.setEmail("falecom@opba.com.br");
		u1.setPeople(p1);
		
		em.getTransaction().begin();
		em.persist(u1);
		em.getTransaction().commit();
		em.close();
	}
	
	//Usign native query
	public void getSql(){
		Query q = em.createNativeQuery("select p.*, u.email from peoples p LEFT JOIN users u ON u.people_id = p.people_id");
		q.getResultList();
	}
	
	//Update some data
	public void update(){
		Peoples p1 = new Peoples();
		
		try{
			
			p1 = em.find(Peoples.class, 1);
			p1.setName("Opba Man");
			
			em.getTransaction().begin();
			em.merge(p1);
			em.getTransaction().commit();
			
		}catch(Exception h){
			System.out.println("" + h.getMessage());
		}finally{
			em.close();
		}
	}
	
	//Delete registers
	public void delete(){
		
		Peoples p1 = new Peoples();
		p1         = em.find(Peoples.class, 3);
		
		em.getTransaction().begin();
		
		try{  
			em.remove(p1);
			em.getTransaction().commit();
		}catch(Exception h){
			System.out.println("" + h.getMessage());
		}finally{
			em.close();
		}
	}
	
	//Using Native Query
	public void findSql2(){
		
		String sql = "select " +
				"p.*, d.*, dp.* " +
				"from peoples p " +
				"inner join " +
				"disciplines_peoples dp " +
				"ON dp.peoples_people_id = p.people_id " +
				"inner join " +
				"disciplines d " +
				"ON d.discipline_id = dp.disciplines_discipline_id ";
		
		Query q = em.createNativeQuery(sql);
		q.getResultList();
	}
	
	//Using namedquery - See at Peoples.class
	public void findAll(){
		Query q = em.createNamedQuery("buscatodos", Peoples.class);
		q.getResultList();
	}

}
