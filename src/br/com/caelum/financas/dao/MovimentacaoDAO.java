package br.com.caelum.financas.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class MovimentacaoDAO {

	private EntityManager manager;

	public MovimentacaoDAO(EntityManager manager) {
		this.manager = manager;
	}

	public BigDecimal somatorioDasMovimentacoesPeloTipo(Conta conta, TipoMovimentacao tipo) {

		// named parameter query
		String jpql = "select sum(m.valor) from Movimentacao m where m.conta=:pConta " + "and m.tipoMovimentacao=:pTipo";

		TypedQuery<BigDecimal> query = manager.createQuery(jpql, BigDecimal.class);

		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);

		BigDecimal singleResult = query.getSingleResult();

		return singleResult;

	}

}
