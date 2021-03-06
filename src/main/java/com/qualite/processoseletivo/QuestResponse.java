package com.qualite.processoseletivo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestResponse {
    
    private String timestamp;
    
    public String section_id;
    public String section_title;
    public String quest_id;
    public String quest_type;
    public String quest_title;
    public String quest_response;
    
    public String date;

    protected QuestResponse () {}
    
    public QuestResponse(String section_id, String section_title, String quest_id, String quest_type, String quest_title, String quest_response) {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        this.timestamp =  Double.toString(t.getTime()).replace(".", "");
        this.section_id = section_id;
        this.section_title = section_title;
        this.quest_id = quest_id;
        this.quest_type = quest_type;
        this.quest_title = quest_title;
        this.quest_response = quest_response;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
        LocalDateTime now = LocalDateTime.now();  
        this.date = dtf.format(now);
        insertInto();
    }
    
    public void insertInto () {
        MySQL_DB mysql = new MySQL_DB();
        Connection con = mysql.getConnection();
        try {
           Statement stmt = con.createStatement();
           stmt.executeUpdate("insert into quests_responses (id, section_id, section_title, quest_id, quest_type, quest_title, quest_response, _date) values ('"+timestamp+"', '"+section_id+"', '"+section_title+"', '"+quest_id+"', '"+quest_type+"', '"+quest_title+"', '"+quest_response+"', '"+date+"' )");
           //stmt.executeUpdate("insert into quests_responses (section_title) values ('cu')");
        } catch (SQLException ex) {
            Logger.getLogger(QuestResponse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getSection_title () {
        return section_title;
    }

    public void setSection_title(String section_name) {
        this.section_title = section_name;
    }

    public String getQuest_id() {
        return quest_id;
    }

    public void setQuest_id(String quest_id) {
        this.quest_id = quest_id;
    }

    public String getQuest_type() {
        return quest_type;
    }

    public void setQuest_type(String quest_type) {
        this.quest_type = quest_type;
    }

    public String getQuest_title() {
        return quest_title;
    }

    public void setQuest_title(String quest_title) {
        this.quest_title = quest_title;
    }

    public String getQuest_response() {
        return quest_response;
    }

    public void setQuest_response(String quest_response) {
        this.quest_response = quest_response;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
