/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudsqlite.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rolas
 */

public class EstudanteDAO {
    private Connection conexao;

    public EstudanteDAO() {
        conexao = ConexaoSQLite.getConexao();
    }

    // Método para inserir um estudante na bd
    public void inserirEstudante(Estudante estudante) {
        try {
            String sql = "INSERT INTO Estudantes (nome, idade) VALUES (?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, estudante.getNome());
            stmt.setInt(2, estudante.getIdade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar todos os estudantes na bd
    public List<Estudante> buscarTodosEstudantes() {
        List<Estudante> estudantes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Estudantes";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Estudante estudante = new Estudante();
                estudante.setId(rs.getInt("id"));
                estudante.setNome(rs.getString("nome"));
                estudante.setIdade(rs.getInt("idade"));
                estudantes.add(estudante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudantes;
    }

    // Método para buscar um estudante por ID
    public Estudante buscarEstudantePorId(int id) {
        Estudante estudante = null;
        try {
            String sql = "SELECT * FROM Estudantes WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                estudante = new Estudante();
                estudante.setId(rs.getInt("id"));
                estudante.setNome(rs.getString("nome"));
                estudante.setIdade(rs.getInt("idade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudante;
    }
    
    // Método para atualizar um estudante na bd
    public void atualizarEstudante(Estudante estudante) {
        try {
            String sql = "UPDATE Estudantes SET nome = ?, idade = ? WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, estudante.getNome());
            stmt.setInt(2, estudante.getIdade());
            stmt.setInt(3, estudante.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para excluir um estudante por ID
    public void excluirEstudante(int id) {
        try {
            String sql = "DELETE FROM Estudantes WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para buscar estudantes por nome
    public List<Estudante> buscarEstudantesPorNome(String nome) {
        List<Estudante> estudantes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Estudantes WHERE nome LIKE ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%"); // Usamos o operador '%' para corresponder a qualquer parte do nome.
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Estudante estudante = new Estudante();
                estudante.setId(rs.getInt("id"));
                estudante.setNome(rs.getString("nome"));
                estudante.setIdade(rs.getInt("idade"));
                estudantes.add(estudante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudantes;
    }

}
