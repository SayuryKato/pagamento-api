package uea.pagamentos_api.repositories.filters;

import java.util.Objects;

public class PessoaFilter {

	private String nome;

	public PessoaFilter() {
	}

	public PessoaFilter(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaFilter other = (PessoaFilter) obj;
		return Objects.equals(nome, other.nome);
	}
	
	

}