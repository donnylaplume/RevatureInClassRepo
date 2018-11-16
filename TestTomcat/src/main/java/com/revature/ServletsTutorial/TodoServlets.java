package com.revature.ServletsTutorial;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Todo;

public class TodoServlets extends HttpServlet {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7950849995569747989L;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
    	
    	Todo todo = new Todo();
    	todo.setName("Clean Room");
    	todo.setPriority(0);
    	
    	/*int i = Integer.parseInt(req.getParameter("priority"));
    	
    	if(i >= 10)
    	{
    		res.setStatus(404);
    		return;
    	}
    	*/
    	System.out.println(req.getParameter("name"));
    	System.out.println(req.getParameter("priority"));
    	
    	ObjectMapper mapper = new ObjectMapper();
    	res.setHeader("Content-Type", "application/json");
    	mapper.writeValue(res.getOutputStream(), todo);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
    	Todo newTodo = null;
    	
    	try {
    		newTodo = new ObjectMapper().readValue(req.getReader(), Todo.class);
    	}
    	catch(IOException e)
    	{
    		res.sendError(500);
    		return;
    	}
    	
    	HttpSession session = req.getSession();
    	session.setAttribute("todo", newTodo);
    	res.setStatus(201);
    	
/*    	ServletConfig sc = getServletConfig();
    	System.out.println(sc.getInitParameter("days"));
    	
    	//Todo newTodo = new ObjectMapper().readValue(req.getReader(), Todo.class);
    	System.out.println(newTodo);*/
    }
    
}
