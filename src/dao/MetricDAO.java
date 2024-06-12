package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetricDAO  {
    private Connection conexao;

    public void getEventsUserParticipated() throws SQLException {
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSQL = null;
        String sql = "SELECT event_user_email, COUNT(*) AS event_count FROM event_user_emails GROUP BY event_user_email";

        try {
            comandoSQL = conexao.prepareStatement(sql);
            ResultSet result = comandoSQL.executeQuery();

            while (result.next()) {
                String email = result.getString("event_user_email");
                int eventNumber = result.getInt("event_count");

                System.out.println("\n Usuário de email " + email + " participou de " + eventNumber + " reuniões \n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            comandoSQL.close();
            conexao.close();
        }
    }

    }   
