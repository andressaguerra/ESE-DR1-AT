package br.edu.infnet.andressa_guerra_dr1_at.service;

import br.edu.infnet.andressa_guerra_dr1_at.model.Funcionario;
import br.edu.infnet.andressa_guerra_dr1_at.repository.DepartamentoRepository;
import br.edu.infnet.andressa_guerra_dr1_at.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Funcionario salvarFuncionario(Long departamentoId, Funcionario funcionario) {
        return departamentoRepository.findById(departamentoId).map(departamento -> {
            funcionario.setDepartamento(departamento);
            return funcionarioRepository.save(funcionario);
        }).orElseThrow(() -> new RuntimeException("Departamento não encontrado com Id: " + departamentoId));
    }

    public List<Funcionario> buscarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public ResponseEntity<?> excluirFuncionario(Long id) {
        return funcionarioRepository.findById(id).map(funcionario -> {
            funcionarioRepository.delete(funcionario);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new RuntimeException("Funcionário não encontrado com Id: " + id));
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionarioUpdate) {
        return funcionarioRepository.findById(id).map(funcionario -> {
            funcionario.setNome(funcionarioUpdate.getNome());
            funcionario.setEndereco(funcionarioUpdate.getEndereco());
            funcionario.setTelefone(funcionarioUpdate.getTelefone());
            funcionario.setEmail(funcionarioUpdate.getEmail());
            funcionario.setDataNascimento(funcionarioUpdate.getDataNascimento());
            funcionario.setDepartamento(funcionarioUpdate.getDepartamento());
            return funcionarioRepository.save(funcionario);
        }).orElseThrow(() -> new RuntimeException("Funcionário não encontrado com Id: " + id));
    }
}
