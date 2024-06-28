package br.edu.infnet.andressa_guerra_dr1_at.controller;

import br.edu.infnet.andressa_guerra_dr1_at.model.Funcionario;
import br.edu.infnet.andressa_guerra_dr1_at.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/departamento/{departamentoId}")
    public Funcionario criarFuncionario(@PathVariable Long departamentoId, @RequestBody Funcionario funcionario) {
        return funcionarioService.salvarFuncionario(departamentoId, funcionario);
    }

    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.buscarTodosFuncionarios();
    }

    @GetMapping("/{id}")
    public Optional<Funcionario> listarFuncionarioPorId(@PathVariable Long id) {
        return funcionarioService.buscarFuncionarioPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarFuncionario(@PathVariable Long id) {
        return funcionarioService.excluirFuncionario(id);
    }

    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return funcionarioService.atualizarFuncionario(id, funcionario);
    }
}
