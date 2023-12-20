package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoDAO {

    private Connection connection;

    public AlunoDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrarAluno(Aluno aluno) {
        String sql = "INSERT INTO aluno (matricula, nome) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
    }

    public Aluno buscarAlunoPorMatricula(String matricula) {
        String sql = "SELECT * FROM aluno WHERE matricula = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, matricula);
            
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new Aluno(resultSet.getString("matricula"), resultSet.getString("nome"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
           
        }

        return null;
    }

    public List<Aluno> listarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM aluno";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                alunos.add(new Aluno(resultSet.getString("matricula"), resultSet.getString("nome")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
         
        }

        return alunos;
    }

  
}