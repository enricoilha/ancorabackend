package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;

import model.Event;

public class EventDAO {
    private Connection conexao;

    public int insert(Event event) throws SQLException {
        conexao = GerenciadorBD.obterConexao();
		PreparedStatement comandoSQL = null;

        Event createdEvent = new Event();

		String sql = "INSERT INTO events (event_id, event_title, event_description, event_start_date, event_end_date) VALUES (SQ_EVENTS.NEXTVAL, ?, ?, ?, ?)";
        ResultSet query = null;
        try {
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, event.getTitle());
            comandoSQL.setString(2, event.getDescription());
            comandoSQL.setTimestamp(3, Timestamp.valueOf(event.getStartDate()));
            comandoSQL.setTimestamp(4, Timestamp.valueOf(event.getEndDate()));
            
            comandoSQL.executeUpdate();
         
            System.out.println("Evento criado com sucesso");

            PreparedStatement sequenceSQL = conexao.prepareStatement("select SQ_EVENTS.CURRVAL from dual");
            query = sequenceSQL.executeQuery();
           
            if(query.next()) {
               int id_created = query.getInt(1);
                createdEvent.setId(id_created);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            comandoSQL.close();
            conexao.close();
        }

        return createdEvent.getId();
    }

    public void insertEmailsTable(Event event) throws SQLException {
        conexao = GerenciadorBD.obterConexao();
		PreparedStatement comandoSQL = null;

        String sql = "INSERT INTO event_user_emails (event_user_email_id, event_user_email, event_related_id) VALUES (SQ_EVENT_USER_EMAILS.NEXTVAL,?, ?)";

        try {
            comandoSQL = conexao.prepareStatement(sql);

            for(int i = 0; i < event.getUserEmails().size(); i++) {
                comandoSQL.setString(1, event.getUserEmails().get(i));
                comandoSQL.setInt(2, event.getId());
                comandoSQL.addBatch();
            }
            comandoSQL.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            comandoSQL.close();
            conexao.close();
        }

    }

    public ArrayList<Event> selectAll() throws SQLException {
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSQL = null;

        String sql = "Select * from events e left join event_user_emails m on e.event_id = m.event_related_id";
        ArrayList<Event> events = new ArrayList<Event>();

        try {
            comandoSQL = conexao.prepareStatement(sql);
            ResultSet result = comandoSQL.executeQuery();


            int currentEventId = -1;
            Event currentEvent = null;

            while(result.next()) {
                int eventId = result.getInt("event_id");

                if (currentEventId != eventId) {
                    currentEventId = eventId;
                    currentEvent = new Event();
                    currentEvent.setId(eventId);
                    currentEvent.setTitle(result.getString("event_title"));
                    currentEvent.setDescription(result.getString("event_description"));
                    currentEvent.setStartDate(result.getTimestamp("event_start_date").toLocalDateTime());
                    currentEvent.setEndDate(result.getTimestamp("event_end_date").toLocalDateTime());
                    currentEvent.setUserEmails(new ArrayList<>());
                    events.add(currentEvent);
                }

                String email = result.getString("event_user_email");

                if(email != null) {
                    currentEvent.getUserEmails().add(email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            comandoSQL.close();
            conexao.close();
        }

        return events;
    }

    public Event selectSingleEvent(int id) throws SQLException {
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSQL = null;

        String sql = "Select * from events e left join event_user_emails m on e.event_id = m.event_related_id where event_id=?" ;
        Event event = new Event();
        try {
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, id);
            ResultSet result = comandoSQL.executeQuery();

           if(result.next()) {
            event.setId(id);
            event.setTitle(result.getString("event_title"));
            event.setDescription(result.getString("event_description"));
            event.setStartDate(result.getTimestamp("event_start_date").toLocalDateTime());
            event.setEndDate(result.getTimestamp("event_end_date").toLocalDateTime());
            event.setUserEmails(new ArrayList<>());

            String email = result.getString("event_user_email");

            if(email != null) {
                event.getUserEmails().add(email);
            }
           }
            
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
            comandoSQL.close();
            conexao.close();
        }

        return event;
    }

    public void delete(int id) throws SQLException {
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSQL = null;

        String sql = "DELETE FROM EVENTS WHERE event_id = ?";

        try{
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, id);
            comandoSQL.executeUpdate();

            System.out.println("Evento deletado com sucesso");
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            comandoSQL.close();
            conexao.close();
        }

    }
}
