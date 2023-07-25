package br.com.gfelipe.MicroService.Pessoas.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.gfelipe.MicroService.Pessoas.Dto.PessoaDTO;
import br.com.gfelipe.MicroService.Pessoas.Model.PessoaModel;
import br.com.gfelipe.MicroService.Pessoas.compartilhado.PessoaModelDetalhes;



public interface IPessoaService {

	
	PessoaDTO criarPessoa(PessoaDTO pessoa);
	List<PessoaDTO> obterTodos();
	Optional<PessoaModelDetalhes>obterPorId(Integer id);
	void removerPessoa(Integer id);
	PessoaDTO atualizarPessoa(Integer id, PessoaDTO pet);
	
}
