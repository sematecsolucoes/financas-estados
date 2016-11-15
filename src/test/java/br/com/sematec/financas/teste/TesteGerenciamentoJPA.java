package br.com.sematec.financas.teste;

import javax.persistence.EntityManager;

import br.com.sematec.financas.modelo.Conta;
import br.com.sematec.financas.util.JPAUtil;

public class TesteGerenciamentoJPA {
	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();

		// ID de uma conta que exista no banco de dados, no caso ID: 1
		Conta conta = manager.find(Conta.class, 1);

		// commit antes da alteração
		manager.getTransaction().commit();

		// Alteração do titular da conta
		conta.setTitular("sematec Ensimo e Inovação");

		manager.getTransaction().begin();
		manager.merge(conta);
		manager.getTransaction().commit();

		manager.close();
	}
}
