package br.edu.infnet.andressa_guerra_dr1_at.repository;

import br.edu.infnet.andressa_guerra_dr1_at.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
