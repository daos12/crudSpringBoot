package com.senac.crudSpring.infrastructure.repository; // Define o pacote do repositório
import com.senac.crudSpring.infrastructure.entitys.Usuario; // Importa a entidade Usuario
import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface JPA Repository
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Interface responsável por realizar operações CRUD no banco de dados
    // Usuario  -> entidade que será gerenciada pelo repositório
    // Integer  -> tipo da chave primária (id)
    // Métodos como save, findById, findAll, delete, entre outros, são herdados automaticamente

    Optional <Usuario>findByEmail(String email); // Busca um usuário pelo e-mail e retorna um Optional para evitar NullPointerException

    @Transactional // Garante que a operação de exclusão seja executada dentro de uma transação sem erros
    void deleteByEmail(String email); // Remove o usuário do banco de dados com base no e-mail informado

}