package com.main.session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class MySession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String id= session.getId();
        Integer a = null;
        try{
            a = (int)session.getAttribute("name");
            session.setAttribute("name",a+1);
        }catch(Exception e){
            //
            req.getSession().setAttribute("name",1);
        }


        System.out.println("id"+id);
        System.out.println("name:" +a);

        PrintWriter os = resp.getWriter();
        os.write("id: " + id);
        os.write("name: " + a);

    }
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    