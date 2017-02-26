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
	
	public Double getGastoMedioDeUmaConta(Conta conta) {
		
		TypedQuery<Double> query = manager.createQuery("select avg(m.valor) from Movimentacao"
				+ " m where m.conta=:pConta and m.tipoMovimentacao='SAIDA'", Double.class);
		query.setParameter("pConta", conta);
		return query.getSingleResult();
	}

	public BigDecimal somatorioDasMovimentacoesPeloTipo(Conta conta, TipoMovimentacao tipo) {

		String jpql = "select sum(m.valor) from Movimentacao m where m.conta=:pConta " + "and m.tipoMovimentacao=:pTipo";

		TypedQuery<BigDecimal> query = manager.createQuery(jpql, BigDecimal.class);

		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);

		BigDecimal singleResult = query.getSingleResult();

		return singleResult;
	}
	
	public Long getTotalDeMovimentacoesDeUmaConta(Conta conta) {

		TypedQuery<Long> query = manager.createNamedQuery("getTotalDeMovimentacoesDeUmaConta", Long.class);
		query.setParameter("pConta", conta);
		return query.getSingleResult();
	}
}

















