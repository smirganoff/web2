package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Aula;
import model.Disciplina;

public class AulaDAO {

    private Connection connection;

    public AulaDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrarAula(Aula aula) {
        String sql = "INSERT INTO aula (data, codigo) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setDate(1, aula.getData());
            stmt.setString(2, aula.getDisciplina().getCodigo());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    aula.setId_aula(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o ID da aula após inserção.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Trate a exceção conforme necessário
        }
    }

    public List<Aula> listarAulasPorDisciplina(Disciplina disciplina) {
        List<Aula> aulas = new ArrayList<>();
        String sql = "SELECT * FROM aula WHERE codigo = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, disciplina.getCodigo());

            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    Aula aula = new Aula(
                            resultSet.getInt("id"),
                            resultSet.getDate("data"),
                            disciplina
                    );
                    aulas.add(aula);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Trate a exceção conforme necessário
        }

        return aulas;
    }

    public void registrarPresenca(Aluno aluno, Aula aula) {
        String sql = "INSERT INTO presenca (aluno_nome, aluno_matricula, nomeDisciplina, aula_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getMatricula());
            stmt.setString(3, aula.getDisciplina().getNomeDisciplina()); // Substitua getNome pela propriedade correta
            stmt.setInt(4, aula.getId_aula());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Trate a exceção conforme necessário
        }
    }

}
