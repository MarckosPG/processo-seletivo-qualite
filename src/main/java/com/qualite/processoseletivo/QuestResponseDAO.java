package com.qualite.processoseletivo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestResponseDAO {
    
    private String timestamp;
    public String section_id;
    public String section_title;
    public String quest_id;
    public String quest_type;
    public String quest_title;
    public String quest_response;
    public String date;

    protected QuestResponseDAO () {}

    public QuestResponseDAO(String timestamp, String section_id, String section_title, String quest_id, String quest_type, String quest_title, String quest_response, String date) {
        this.timestamp = timestamp;
        this.section_id = section_id;
        this.section_title = section_title;
        this.quest_id = quest_id;
        this.quest_type = quest_type;
        this.quest_title = quest_title;
        this.quest_response = quest_response;
        this.date = date;
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
