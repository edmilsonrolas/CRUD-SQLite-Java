/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudsqlite.teste;

import crudsqlite.model.ConexaoSQLite;
import crudsqlite.model.Estudante;
import crudsqlite.model.EstudanteDAO;
import java.util.List;

/**
 *
 * @author rolas
 */
public class TesteEstudanteDAO {
    public static void main(String[] args) {
        // Criar uma instância de EstudanteDAO
        EstudanteDAO estudanteDAO = new EstudanteDAO();
        
        try{
            // Inserir um estudante
            Estudante novoEstudante = new Estudante();
            novoEstudante.setNome("Alberta");
            novoEstudante.setIdade(21);
            estudanteDAO.inserirEstudante(novoEstudante);
            System.out.println("Estudante inserido com sucesso!");

            // Buscar todos os estudantes e exibir
            List<Estudante> estudantes = estudanteDAO.buscarTodosEstudantes();
            System.out.println("Lista de estudantes:");
            for (Estudante estudante : estudantes) {
                System.out.println("ID: " + estudante.getId());
                System.out.println("Nome: " + estudante.getNome());
                System.out.println("Idade: " + estudante.getIdade());
                System.out.println("----------------------");
            }

            // Buscar um estudante por ID (substitua o ID pelo desejado)
            int idParaBuscar = 16; // Exemplo: buscar estudante com ID 1
            Estudante estudantePorId = estudanteDAO.buscarEstudantePorId(idParaBuscar);
            if (estudantePorId != null) {
                System.out.println("Estudante encontrado por ID:");
                System.out.println("ID: " + estudantePorId.getId());
                System.out.println("Nome: " + estudantePorId.getNome());
                System.out.println("Idade: " + estudantePorId.getIdade());
                System.out.println("-----");
            } else {
                System.out.println("Estudante não encontrado por ID.");
            }
            
            // Buscar estudantes por nome (substitua o nome pelo desejado)
            String nomeParaBuscar = "Alice"; // Exemplo: buscar estudantes com o nome "Joana"
            List<Estudante> estudantesPorNome = estudanteDAO.buscarEstudantesPorNome(nomeParaBuscar);
            System.out.println("Estudantes encontrados por nome:");
            for (Estudante estudante : estudantesPorNome) {
                System.out.println("ID: " + estudante.getId());
                System.out.println("Nome: " + estudante.getNome());
                System.out.println("Idade: " + estudante.getIdade());
                System.out.println("-----");
            }
            
            // Atualizar um estudante (substitua o ID pelo desejado)
            int idParaAtualizar = 5; // Exemplo: atualizar estudante com ID 1
            Estudante estudanteAtualizado = new Estudante();
            estudanteAtualizado.setId(idParaAtualizar);
            estudanteAtualizado.setNome("Marcio");
            estudanteAtualizado.setIdade(23);
            estudanteDAO.atualizarEstudante(estudanteAtualizado);
            System.out.println("Estudante atualizado com sucesso!");
            
            // Excluir um estudante (substitua o ID pelo desejado)
            int idParaExcluir = 7; // Exemplo: excluir estudante com ID 2
            estudanteDAO.excluirEstudante(idParaExcluir);
            System.out.println("Estudante excluído com sucesso!");
            
        } finally {    
            // Fechar a conexão
            ConexaoSQLite.fecharConexao();
        }
    }
}
