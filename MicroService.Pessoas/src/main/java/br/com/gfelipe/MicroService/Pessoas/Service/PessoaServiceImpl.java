package br.com.gfelipe.MicroService.Pessoas.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gfelipe.MicroService.Pessoas.Dto.PessoaDTO;
import br.com.gfelipe.MicroService.Pessoas.Model.PessoaModel;
import br.com.gfelipe.MicroService.Pessoas.Repository.IPessoaRepository;
import br.com.gfelipe.MicroService.Pessoas.compartilhado.AnimalDTO;
import br.com.gfelipe.MicroService.Pessoas.compartilhado.PessoaModelDetalhes;
import br.com.gfelipe.MicroService.Pessoas.http.AnimaisFeignClient;


@Service
public class PessoaServiceImpl implements IPessoaService{

	@Autowired
	private IPessoaRepository repo;
	
	@Autowired
    private AnimaisFeignClient animaisMs;

	@Override
	public PessoaDTO criarPessoa(PessoaDTO pessoa) {
		
		return salvarPessoa(pessoa);
	}

	private PessoaDTO salvarPessoa(PessoaDTO pessoa) {
			ModelMapper mapper = new ModelMapper();
			PessoaModel pessoaEntity= mapper.map(pessoa, PessoaModel.class);
			pessoaEntity = repo.save(pessoaEntity);
		
		return mapper.map(pessoaEntity, PessoaDTO.class);
	}

	@Override
	public List<PessoaDTO> obterTodos() {
		List<PessoaModel> pessoas = repo.findAll();
		
		return pessoas.stream()
				.map(pessoa -> new ModelMapper().map(pessoa, PessoaDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<PessoaModelDetalhes> obterPorId(Integer id) {
		Optional<PessoaModel> pessoa = repo.findById(id);
		
		if(pessoa.isPresent()) {
			PessoaModelDetalhes dto = new ModelMapper().map(pessoa.get(), PessoaModelDetalhes.class);
			
			List<AnimalDTO> animais = animaisMs.obterAnimais(id);
		
			dto.setPets(animais);
			
			return Optional.of(dto);
		}
		
		return Optional.empty();
	}

	@Override
	public void removerPessoa(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public PessoaDTO atualizarPessoa(Integer id, PessoaDTO pessoa) {
		pessoa.setId(id);
		return salvarPessoa(pessoa);
		
	}

}
