/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apurvai
 */
@WebServlet(name = "test", urlPatterns = {"/test"})
public class test extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
         response.setContentType("text/html");  
    PrintWriter pw = response.getWriter();  
    String connectionURL = "jdbc:mysql://127.0.0.1:3306/storage";// newData is the database  
    Connection connection; 
    
    try{ 
        
      String dropdown;
              dropdown = request.getParameter("dropdown"); 
      pw.print(dropdown);
      
     Class.forName("com.mysql.jdbc.Driver");  
      connection = DriverManager.getConnection(connectionURL, "root", "root");  
        
      Statement statement1 = connection.createStatement();
      ResultSet rs1 = null; 
      String command2=null;
      Statement statement2=connection.createStatement();
          
         
          
  
String command1 = null;
command1 = "Delete from info where url_data LIKE'%"+dropdown+"%'";
statement1.executeUpdate(command1);
command2="select url_data,input_data from info";
rs1=statement1.executeQuery(command2);


    int rowcount1=0;
   ResultSetMetaData md1 = rs1.getMetaData();
    int count1 = md1.getColumnCount(); 
   // while (rs1.next()) {
    //    rowcount1++;}
   // boolean flag = true;
    //if (rowcount1 < 1)
//    {flag = false;}
    
     
    //boolean flag = false;
    //if (){
    //}
    pw.println("<table border=1 width=100%>");
    pw.print("<tr>");
    for (int j=1; j<=count1; j++) {
      pw.print("<th>");
     pw.print(md1.getColumnLabel(j));
    }
    pw.println("</tr>");
    while (rs1.next()) {
        rowcount1++;
        
      pw.print("<tr>");
      for (int j=1; j<=count1; j++) {
        pw.print("<td>");
        pw.print(rs1.getString(j));
      }
      pw.println("</tr>");
    }
    pw.println("</table>");
    pw.print("The number of records found::"+rowcount1);
     }
    //pw.print("The number of records found::"+rowcount1);
     
 
      
    
      
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
