package com.senac.crudSpring.business; // Define o pacote da camada de negócio (Service)

import com.senac.crudSpring.infrastructure.entitys.Usuario; // Importa a entidade Usuario
import com.senac.crudSpring.infrastructure.repository.UsuarioRepository; // Importa o repositório de Usuario
import org.springframework.stereotype.Service; // Importa a anotação Service do Spring

@Service // Indica que a classe é um componente de serviço gerenciado pelo Spring
public class UsuarioService {

    private final UsuarioRepository repository; // Repositório responsável pelo acesso aos dados

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository; // Injeção de dependência via construtor
    }

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario); // Salva o usuário e força a sincronização imediata com o banco
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return repository.findByEmail(email) // Busca o usuário pelo e-mail
                .orElseThrow(
                        () -> new RuntimeException("Email não encontrado!") // Lança exceção se não existir
                );
    }

    public void deletarUsuarioProEmail(String email){
        repository.deleteByEmail(email); // Remove o usuário do banco com base no e-mail
    }

    public void atualizarUsuarioId(Integer id, Usuario usuario) {

        Usuario usuarioEntity = repository.findById(id) // Busca o usuário pelo ID
                .orElseThrow(
                        () -> new RuntimeException("Usuario não encontrado!") // Lança exceção se não existir
                );

        Usuario usuarioAtualizado = Usuario.builder() // Cria um novo objeto Usuario usando Builder
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail()) // Atualiza e-mail se informado
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome()) // Atualiza nome se informado
                .id(usuarioEntity.getId()) // Mantém o ID original
                .build();

        repository.saveAndFlush(usuarioAtualizado); // Persiste as alterações no banco de dados
    }
}

