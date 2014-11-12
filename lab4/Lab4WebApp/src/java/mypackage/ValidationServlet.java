/* Copyright 2005 Sun Microsystems, Inc. All rights reserved. You may not modify, use, reproduce, or distribute this software except in compliance with the terms of the License at: http://developer.sun.com/berkeley_license.html  
$Id: ValidationServlet.java,v 1.2 2005/04/06 19:40:34 gmurray71 Exp $ */
package mypackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class ValidationServlet extends HttpServlet {
    
    private ServletContext context;
    private HashMap accounts = new HashMap();
 
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
        accounts.put("Billy111","aaa");
        accounts.put("Mary222","bbb");
        accounts.put("Joe333","ccc");

    }
    
    public  void doGet(HttpServletRequest request, HttpServletResponse  response)
        throws IOException, ServletException {
        
        String targetId = request.getParameter("id");
	    if ((targetId != null) && !accounts.containsKey(targetId.trim())) {
            response.setContentType("text/xml");
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().write("<valid>true</valid>");
        } else {
            response.setContentType("text/xml");
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().write("<valid>false</valid>");
        }
    }

    public  void doPost(HttpServletRequest request, HttpServletResponse  response)
        throws IOException, ServletException {

        String targetId = request.getParameter("id");
        if ((targetId != null) && !accounts.containsKey(targetId.trim())) {
            accounts.put(targetId.trim(), "account data");
            request.setAttribute("targetId", targetId);
            context.getRequestDispatcher("/success.jsp").forward(request, response);
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
    
}


