/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author apurvai
 */
public class mydata extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

      String Input = request.getParameter("input");  
      String URL = request.getParameter("url"); 
      out.println("<head> "
            + "<style> "
            + "body{"
            + "background-color: lightgoldenrodyellow;}</style>"
            + "</head>");
      out.print("</br>Inserted data::");
      out.print("</br>"+Input);
      out.print("</br>"+URL);
      
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  
    PrintWriter pw = response.getWriter();  
    String connectionURL = "jdbc:mysql://127.0.0.1:3306/storage";// newData is the database  
    Connection connection; 
    
    try{ 
        
      String Input = request.getParameter("input");  
      String URL = request.getParameter("url");  
      //String Email = request.getParameter("email");  
        CircularShift shifter = new CircularShift();
		Input input = new Input(shifter);
		Alphabetize alphabetizer = new Alphabetize();
                //mydata data= new mydata();
                //input.takeInput();
                String line = Input.trim();
                shifter.performShift(line);
                alphabetizer.alphabetize(shifter);
		
                
      
     

      Class.forName("com.mysql.jdbc.Driver");  
      connection = DriverManager.getConnection(connectionURL, "root", "root");  
        
      Statement statement = connection.createStatement();
      
           
            for (int i = 0; i < alphabetizer.get_numOfLine(); i++)
                {
                    
                    String s=alphabetizer.select_line_string(i);
                    String command = "INSERT INTO info (input_data,url_data) VALUES ('"+s+"','"+URL+"')";
                    //Area2.append(alphabetizer.select_line_string(i)+"\n");
                    statement.executeUpdate(command);
                    
                }
           
            
  
      /*int i = statement.executeUpdate();  
      if(i!=0){  
        pw.println("<br>Record has been inserted");  
          
  
      }  
      else{  
        pw.println("failed to insert the data");  
       } */ 
    }  
    catch (Exception e){  
      pw.println(e);  
    } 
   
  

        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
