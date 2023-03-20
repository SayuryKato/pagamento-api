package uea.pagamentos_api.repositories.pessoa;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import uea.pagamentos_api.dto.ResumoLancamentoDto;
import uea.pagamentos_api.dto.ResumoPessoasDto;
import uea.pagamentos_api.models.Lancamento;
import uea.pagamentos_api.models.Pessoa;
import uea.pagamentos_api.repositories.filters.LancamentoFilter;
import uea.pagamentos_api.repositories.filters.PessoasFilter;

public class PessoasRepositoryQueryImpl 
implements PessoasRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<ResumoPessoasDto> filtrarPessoas(PessoasFilter pessoasFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<ResumoPessoasDto> criteria = builder.createQuery(ResumoPessoasDto.class);
		Root<Pessoa> root = criteria.from(Pessoa.class);
		
		criteria.select(builder.construct(ResumoPessoasDto.class, root.get("codigo"), root.get("nome"),
				root.get("ativo"),root.get("endereco").get("cidade")));
		
		Predicate[] predicates = criarRestricoes(pessoasFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}
		
		List<ResumoPessoasDto> returnList = manager.createQuery(criteria).getResultList();
		
		return returnList;
	}
	
	private Predicate[] criarRestricoes(PessoasFilter pessoasFilter, CriteriaBuilder builder,
			Root<Pessoa> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!ObjectUtils.isEmpty(pessoasFilter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get("nome")),
					"%" + pessoasFilter.getNome().toLowerCase() + "%"));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	

}