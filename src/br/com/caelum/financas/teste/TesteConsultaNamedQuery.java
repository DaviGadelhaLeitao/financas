package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaNamedQuery {

	public static void main(String[] args) {

		
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = manager.find(Conta.class, 1);
		
		
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(manager);
		System.out.println(movimentacaoDAO.getTotalDeMovimentacoesDeUmaConta(conta));
		
	}

}
