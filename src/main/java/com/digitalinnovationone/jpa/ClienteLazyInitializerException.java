package com.digitalinnovationone.jpa;

import com.digitalinnovationone.jpa.model.Cliente;

import javax.persistence.*;
import java.util.Collections;

public class ClienteLazyInitializerException {

	public static void main(String... string) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();


		//Entity Graph  para buscar relacionamentos
//		EntityGraph<Cliente> entityGraph = entityManager.createEntityGraph(Cliente.class);
//		Subgraph<Object> carros = entityGraph.addSubgraph("carros");
//		carros.addSubgraph("multas");
//		Cliente cliente = entityManager.find(Cliente.class, 2, Collections.singletonMap("javax.persistence.loadgraph", entityGraph));


		Query query = entityManager.createQuery("SELECT c FROM Cliente c join fetch c.carros ca join fetch ca.multas m where c.id = :id");
		query.setParameter("id",2);
		Cliente cliente = (Cliente) query.getSingleResult();


		//Consultas Simples
		//Cliente cliente = entityManager.find(Cliente.class, 1);
		entityManager.close();
		System.out.println(cliente.getCarros().stream().findFirst().get().getMultas());
		entityManagerFactory.close();

	}
}
