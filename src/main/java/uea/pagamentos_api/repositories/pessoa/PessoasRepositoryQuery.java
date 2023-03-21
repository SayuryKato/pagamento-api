package uea.pagamentos_api.repositories.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uea.pagamentos_api.dto.ResumoPessoaDto;
import uea.pagamentos_api.repositories.filters.PessoaFilter;

public interface PessoasRepositoryQuery {

	public Page<ResumoPessoaDto> filtrar(PessoaFilter pessoasFilter, Pageable pageable);

}