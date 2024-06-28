package br.edu.infnet.andressa_guerra_dr1_at;

import br.edu.infnet.andressa_guerra_dr1_at.model.Funcionario;
import br.edu.infnet.andressa_guerra_dr1_at.repository.FuncionarioRepository;
import br.edu.infnet.andressa_guerra_dr1_at.service.FuncionarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FuncionarioServiceTest {

    @Autowired
    private FuncionarioService funcionarioService;

    @MockBean
    private FuncionarioRepository funcionarioRepository;

    @BeforeEach
    public void setup() {
        Mockito.reset(funcionarioRepository);
    }

    @Test
    public void testarBuscarTodosFuncionarios() {
        funcionarioService.buscarTodosFuncionarios();
        verify(funcionarioRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testarBuscarFuncionarioPorId() {
        Long id = 1L;
        Funcionario funcionario = new Funcionario();
        when(funcionarioRepository.findById(id)).thenReturn(Optional.of(funcionario));

        Optional<Funcionario> result = funcionarioService.buscarFuncionarioPorId(id);

        assertTrue(result.isPresent());
        assertEquals(funcionario, result.get());
        verify(funcionarioRepository, Mockito.times(1)).findById(id);
    }
}