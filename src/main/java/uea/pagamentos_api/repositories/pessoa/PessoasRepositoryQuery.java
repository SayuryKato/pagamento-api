package uea.pagamentos_api.repositories.pessoa;

import java.util.List;

import uea.pagamentos_api.dto.ResumoPessoasDto;
import uea.pagamentos_api.repositories.filters.PessoasFilter;

public interface PessoasRepositoryQuery {

	public List<ResumoPessoasDto> filtrarPessoas(
			PessoasFilter pessoasFilter);

}