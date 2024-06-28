package br.edu.infnet.andressa_guerra_dr1_at;

import br.edu.infnet.andressa_guerra_dr1_at.model.Funcionario;
import br.edu.infnet.andressa_guerra_dr1_at.repository.FuncionarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class FuncionarioRepositoryTest {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Test
    public void testarSalvarEBuscarFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Andressa Guerra");
        funcionario.setEndereco("Botafogo");
        funcionario.setTelefone("98889-3080");
        funcionario.setEmail("andressa.guerra@al.infnet.edu.br");
        funcionario.setDataNascimento("1996-03-07");

        funcionarioRepository.save(funcionario);

        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        assertTrue(funcionarios.size() > 0);

        Funcionario found = funcionarioRepository.findById(funcionario.getId()).orElse(null);
        assertEquals(funcionario.getNome(), found.getNome());
        assertEquals(funcionario.getEndereco(), found.getEndereco());
        assertEquals(funcionario.getTelefone(), found.getTelefone());
        assertEquals(funcionario.getEmail(), found.getEmail());
        assertEquals(funcionario.getDataNascimento(), found.getDataNascimento());
    }
}