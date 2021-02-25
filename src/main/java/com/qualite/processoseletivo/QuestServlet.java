package com.qualite.processoseletivo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.net.Proxy.Type.HTTP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "QuestServlet", urlPatterns = {"/Quests"})
public class QuestServlet extends HttpServlet {
    
    private final int MAX_QUEST_REQUEST = 100; //numero de requisições de questões processadas
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //informações da seção
        String section_id = request.getParameter("item[id]");
        String section_title= request.getParameter("item[title]");
        
        //criando listas
        List<String> item_quests_id = new ArrayList();
        List<String> item_quests_type = new ArrayList();
        List<String> item_quests_quest = new ArrayList();
        List<String> item_quests_response = new ArrayList();
        
        int count = 0;
        
        //processamento das requisições
        for(int i = 0; i < MAX_QUEST_REQUEST; i++){
            if(request.getParameter("item[quests]["+i+"][id]") != null){
                item_quests_id.add(request.getParameter("item[quests]["+i+"][id]"));
                item_quests_type.add(request.getParameter("item[quests]["+i+"][type]"));
                item_quests_quest.add(request.getParameter("item[quests]["+i+"][quest]"));
                if(request.getParameter("item[quests]["+i+"][type]").equals("slide")){
                    item_quests_response.add(request.getParameter("item[quests]["+i+"][response]")+"%");
                }else{
                    item_quests_response.add(request.getParameter("item[quests]["+i+"][response]"));
                }
                count++;
            }
        }
        
        for(int i = 0; i < count; i ++){
            QuestResponse qr = new QuestResponse(
                section_id,
                section_title,
                item_quests_id.get(i),
                item_quests_type.get(i),
                item_quests_quest.get(i),
                item_quests_response.get(i)
            );
        }
        
        //response.getWriter().println(count);
    }

}
