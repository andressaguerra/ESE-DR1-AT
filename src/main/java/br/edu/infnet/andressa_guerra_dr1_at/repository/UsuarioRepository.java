package br.edu.infnet.andressa_guerra_dr1_at.repository;

import br.edu.infnet.andressa_guerra_dr1_at.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findUsuarioByNome(String nome);
}
