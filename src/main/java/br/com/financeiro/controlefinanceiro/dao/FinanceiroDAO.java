package br.com.financeiro.controlefinanceiro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.financeiro.controlefinanceiro.model.Financeiro;

@Repository
@Transactional
public class FinanceiroDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public Financeiro getFinanceiroById(Integer id) {
		Financeiro financeiro = manager.find(Financeiro.class, id);
		return financeiro;
	} //find operation by its id and return it
	
	public void salvar(Financeiro financeiro) {
		manager.persist(financeiro);
	}//persist into the DB from the completed form
	
	public List<Financeiro> listar(){
		return manager.createQuery("select f from Financeiro f",
				Financeiro.class).getResultList();
	}//get a list of all the data registered in Database financeiro
	
	public void remover(Integer id) {
		Financeiro financa = getFinanceiroById(id);
		manager.remove(financa);
	}//remove "financeiro" by its id (sent from the controller)
	
	public void editar(Financeiro financa) {
		manager.merge(financa);
	}//merge a new "financa" from the update controller
	

}
