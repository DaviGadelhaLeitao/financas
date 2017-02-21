package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteEstadosJPA {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = manager.find(Conta.class, 1);

		manager.getTransaction().begin();
		
		conta.setTitular("Davi Gadelha");
		
		manager.getTransaction().commit();
		
		System.out.println(conta.getTitular());

		manager.close();

	}
}
