package com.senac.crudSpring.infrastructure.entitys; // Define o pacote onde a entidade está localizada

import jakarta.persistence.*; // Importa anotações JPA para mapeamento objeto-relacional
import lombok.*; // Importa anotações do Lombok para reduzir código boilerplate

@Getter // Gera automaticamente os métodos getters
@Setter // Gera automaticamente os métodos setters
@AllArgsConstructor // Gera construtor com todos os atributos
@NoArgsConstructor // Gera construtor sem argumentos
@Builder // Permite criar objetos usando o padrão Builder
@Table(name = "usuario") // Mapeia a classe para a tabela "usuario" no banco de dados
@Entity // Indica que a classe é uma entidade JPA

public class Usuario {

    @Id // Define o atributo como chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) // Gera o valor do ID automaticamente
    private Integer id; // Identificador único do usuário

    @Column(name = "nome") // Mapeia o atributo para a coluna "nome" da tabela
    private String nome; // Armazena o nome do usuário

    @Column(name = "email", unique = true) // Mapeia a coluna "email" e define valor único
    private String email; // Armazena o e-mail do usuário

}
