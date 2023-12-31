package br.com.gfelipe.MicroService.Pessoas.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import br.com.gfelipe.MicroService.Pessoas.Model.PessoaModel;

@Repository
public interface IPessoaRepository extends JpaRepository<PessoaModel, Integer>{
	
	
	UserDetails findByEmail(String email);

}
