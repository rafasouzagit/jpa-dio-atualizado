package com.digitalinnovationone.jpa;

import com.digitalinnovationone.jpa.model.Carro;
import com.digitalinnovationone.jpa.model.Cliente;
import com.digitalinnovationone.jpa.model.Multa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class UpdateClienteTransacao {

    public static void main(String... string) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        //ACID: OU EU SALVO TUDO OU NÃO SALVO NADA
        Cliente cliente = new Cliente();
        cliente.setNome("Leonardo Lopes Alves");
        entityManager.persist(cliente);


        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();


        Carro carro = new Carro();
        carro.setModelo("Corola");
        carro.setMarca("Toyota");

        if(carro != null){
            throw  new RuntimeException("Você não vai salvar o carro hahahaha!!!");
        }

        entityManager.persist(carro);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

//        Cliente cliente = new Cliente();
//        cliente.setNome("Maria Testa Transacao");
//        entityManager.persist(cliente);
//
//        Carro carro = new Carro();
//
//        carro.setCliente(cliente);
//        carro.setMarca("Ford");
//        carro.setModelo("Fiesta");
//
//        entityManager.persist(carro);
//
//        Multa multa = new Multa();
//        multa.setCarro(carro);
//        multa.setValor(50.00);
//        multa.setData(LocalDateTime.now());

//        if (multa != null){
//            throw new RuntimeException("Voce nao vai salvar nada hahahahahahah");
//        }
//        entityManager.persist(multa);
//        entityManager.getTransaction().commit();
//        entityManager.getTransaction().begin();
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        entityManagerFactory.close();
    }
}

