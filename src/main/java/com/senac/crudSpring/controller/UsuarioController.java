package com.senac.crudSpring.controller; // Define o pacote da camada de controle (Controller)

import com.senac.crudSpring.business.UsuarioService; // Importa o serviço de Usuario
import com.senac.crudSpring.infrastructure.entitys.Usuario; // Importa a entidade Usuario
import lombok.RequiredArgsConstructor; // Gera construtor com argumentos finais
import org.springframework.http.ResponseEntity; // Representa respostas HTTP
import org.springframework.web.bind.annotation.*; // Importa anotações REST do Spring

@RestController // Define a classe como um controller REST
@RequestMapping("/usuario") // Define o endpoint base "/usuario"
@RequiredArgsConstructor // Cria automaticamente o construtor com injeção de dependência
public class UsuarioController {

    private final UsuarioService usuarioService; // Serviço responsável pela lógica de negócio

    @PostMapping // Mapeia requisições HTTP POST
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario); // Chama o serviço para salvar o usuário
        return ResponseEntity.ok().build(); // Retorna resposta HTTP 200 sem corpo
    }

    @GetMapping // Mapeia requisições HTTP GET
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email){
        return ResponseEntity.ok(
                usuarioService.buscarUsuarioPorEmail(email) // Busca o usuário pelo e-mail
        );
    }

    @DeleteMapping // Mapeia requisições HTTP DELETE
    public ResponseEntity<Void> deleteUsuarioProEmail(@RequestParam String email){
        usuarioService.deletarUsuarioProEmail(email); // Remove o usuário pelo e-mail
        return ResponseEntity.ok().build(); // Retorna resposta HTTP 200 sem corpo
    }

    @PutMapping // Mapeia requisições HTTP PUT
    public ResponseEntity<Void> atualizarUsuarioPorId(
            @RequestParam Integer id, // Recebe o ID via parâmetro
            @RequestBody Usuario usuario // Recebe os dados atualizados no corpo da requisição
    ){
        usuarioService.atualizarUsuarioId(id, usuario); // Atualiza os dados do usuário
        return ResponseEntity.ok().build(); // Retorna resposta HTTP 200 sem corpo
    }
}
