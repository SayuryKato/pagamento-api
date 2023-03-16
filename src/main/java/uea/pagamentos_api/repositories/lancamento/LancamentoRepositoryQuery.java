package uea.pagamentos_api.repositories.lancamento;

import java.util.List;

import uea.pagamentos_api.repositories.filters.LancamentoFilter;
import uea.pagamentos_api_dto.ResumoLancamentoDTO;

public interface LancamentoRepositoryQuery {
	
	public List<ResumoLancamentoDTO> filtrar(LancamentoFilter lancamentoFiler);
	

}
