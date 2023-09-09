/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudsqlite.controller;

import crudsqlite.model.Estudante;
import crudsqlite.model.EstudanteDAO;
import java.util.List;

/**
 *
 * @author rolas
 */
public class EstudanteController {
    private EstudanteDAO estudanteDAO;

    public EstudanteController() {
        estudanteDAO = new EstudanteDAO();
    }

    // Método para adicionar um novo estudante
    public void adicionarEstudante(String nome, int idade) {
        Estudante novoEstudante = new Estudante();
        novoEstudante.setNome(nome);
        novoEstudante.setIdade(idade);
        estudanteDAO.inserirEstudante(novoEstudante);
    }

    // Método para buscar todos os estudantes
    public List<Estudante> buscarTodosEstudantes() {
        return estudanteDAO.buscarTodosEstudantes();
    }

    // Método para buscar um estudante por ID
    public Estudante buscarEstudantePorId(int id) {
        return estudanteDAO.buscarEstudantePorId(id);
    }

    // Método para buscar estudantes por nome
    public List<Estudante> buscarEstudantesPorNome(String nome) {
        return estudanteDAO.buscarEstudantesPorNome(nome);
    }

    // Método para atualizar um estudante
    public void atualizarEstudante(int id, String novoNome, int novaIdade) {
        Estudante estudante = estudanteDAO.buscarEstudantePorId(id);
        if (estudante != null) {
            estudante.setNome(novoNome);
            estudante.setIdade(novaIdade);
            estudanteDAO.atualizarEstudante(estudante);
        }
    }

    // Método para excluir um estudante por ID
    public void excluirEstudante(int id) {
        estudanteDAO.excluirEstudante(id);
    }
}
