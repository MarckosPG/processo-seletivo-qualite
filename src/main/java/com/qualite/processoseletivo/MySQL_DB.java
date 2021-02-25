package com.qualite.processoseletivo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQL_DB {
    
    public static final String SELECT_QUESTS = "select * from quests_responses";
    
    public Connection getConnection () {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQL_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quests_db", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public List<QuestResponseDAO> selectAllQuests () {
        List<QuestResponseDAO> qdao = new ArrayList();
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_QUESTS);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String timestamp = rs.getString("id");
                String section_id = rs.getString("section_id");
                String section_title = rs.getString("section_title");
                String quest_id = rs.getString("quest_id");
                String quest_type = rs.getString("quest_type");
                String quest_title = rs.getString("quest_title");
                String quest_response = rs.getString("quest_response");
                if(quest_response.equals("")) quest_response = "(Nao Respondido)";
                String _date = rs.getString("_date");
                qdao.add(new QuestResponseDAO(
                        timestamp,
                        section_id,
                        section_title,
                        quest_id,
                        quest_type,
                        quest_title,
                        quest_response,
                        _date
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qdao;
    }
            
    
}
