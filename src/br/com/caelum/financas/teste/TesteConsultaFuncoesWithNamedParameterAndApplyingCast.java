package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncoesWithNamedParameterAndApplyingCast {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = new Conta();
		conta.setId(3);
		
		// named parameter query
		String jpql = "select sum(m.valor) from Movimentacao m where m.conta=:pConta " + "and m.tipoMovimentacao=:pTipo";
		
		Query query = manager.createQuery(jpql);
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		
		BigDecimal singleResult = (BigDecimal) query.getSingleResult();
		System.out.println("\nO somatório de todas as movimentações de entrada da conta " + conta.getTitular() + " é: " + singleResult  + ".");
		
		manager.close();
	}
}







