package br.edu.infnet.andressa_guerra_dr1_at.controller;

import br.edu.infnet.andressa_guerra_dr1_at.model.Departamento;
import br.edu.infnet.andressa_guerra_dr1_at.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public List<Departamento> buscarDepartamentos() {
        return departamentoService.buscarTodosDepartamentos();
    }

    @GetMapping("/{id}")
    public Optional<Departamento> buscarDepartamentoPorId(@PathVariable Long id) {
        return departamentoService.buscarDepartamentoPorId(id);
    }

    @PostMapping
    public Departamento criarDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.salvarDepartamento(departamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarDepartamento(@PathVariable Long id) {
        return departamentoService.excluirDepartamento(id);
    }

    @PutMapping("/{id}")
    public Departamento atualizarDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
        return departamentoService.atualizarDepartamento(id, departamento);
    }





}
