package br.edu.infnet.andressa_guerra_dr1_at.service;

import br.edu.infnet.andressa_guerra_dr1_at.model.Departamento;
import br.edu.infnet.andressa_guerra_dr1_at.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Departamento salvarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public List<Departamento> buscarTodosDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> buscarDepartamentoPorId(Long id) {
        return departamentoRepository.findById(id);
    }

    public ResponseEntity<?> excluirDepartamento(Long id) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado com Id: " + id));
        departamentoRepository.delete(departamento);
        return ResponseEntity.ok().build();
    }

    public Departamento atualizarDepartamento(Long id, Departamento departamentoUpdate) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado com Id: " + id));
        departamento.setNome(departamentoUpdate.getNome());
        departamento.setLocal(departamentoUpdate.getLocal());
        departamento.setFuncionarios(departamentoUpdate.getFuncionarios());
        return departamentoRepository.save(departamento);
    }
}