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
public class mysearch extends HttpServlet {

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
        response.setContentType("text/html");  
    PrintWriter pw = response.getWriter();  
    String connectionURL = "jdbc:mysql://127.0.0.1:3306/storage";// newData is the database  
    Connection connection; 
    
    try{ 
        
      String Content = request.getParameter("content").toLowerCase();  
      String Search_mode = request.getParameter("search_mode");
      
      //pw.print(Content);
         
     Class.forName("com.mysql.jdbc.Driver");  
      connection = DriverManager.getConnection(connectionURL, "root", "root");  
        
      Statement statement1 = connection.createStatement();
      ResultSet rs1 = null; 
          
          Statement statement = connection.createStatement();
          ResultSet rs = null; 
          
if ("OR".equalsIgnoreCase(Search_mode)){
String[]dataContent=new String[50];
 String command = null;
 dataContent=Content.split(" ");
 String commandpart1="select DISTINCT  url_data,input_data from info where";
 String commandpart2="";
 String commandpart3=" group by url_data  ";// order by url_data offset 0 rows fetch next 2 rows only";
 for(int i=0;i<dataContent.length;i++)
 {commandpart2 +=  " input_data LIKE '%"+dataContent[i] +"%'";  
   
     if (dataContent.length>1 && i< dataContent.length-1)
         commandpart2+=" or";
 }
  command=commandpart1+commandpart2+commandpart3;
  //pw.println(command);
   rs = statement.executeQuery(command);
    int rowcount=0;
      
    ResultSetMetaData md = rs.getMetaData();
    int count = md.getColumnCount();
   
    pw.println("<head> "
            + "<style> "
            + "body{"
            + "background-color: lightgoldenrodyellow;}</style>"
            + "</head>");
    pw.println("<table border=1 width= 100%>");
    pw.print("<tr>");
    for (int j=1; j<=count; j++) {
      pw.print("<th>");
     pw.print(md.getColumnLabel(j));
    }
    pw.println("</tr>");
    
    while (rs.next()) {
        rowcount++;
        
      pw.print("<tr>");
      for (int j=1; j<=count; j++) {
          if(j==1)
          {
            pw.print("<td>");
            pw.print("<a href="+rs.getString(j)+">"+rs.getString(j)+"</a>");
          }
        else
        {
            pw.print("<td>");
            pw.print(rs.getString(j));
            
        }
      }
      pw.println("</tr>");
    }
    pw.println("</table>");
   // int total_rowcount= rowcount1+rowcount;
 
   pw.print("The number of records found::"+rowcount);
}
/*         
String command1 = null;
command1 = "select DISTINCT url_data,input_data from info where input_data LIKE '%"+Content+"%' group by url_data";
rs1 = statement1.executeQuery(command1);
    int rowcount1=0;
   ResultSetMetaData md1 = rs1.getMetaData();
    int count1 = md1.getColumnCount(); 
   // while (rs1.next()) {
    //    rowcount1++;}
   // boolean flag = true;
    //if (rowcount1 < 1)
//    {flag = false;}
    
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
    */ 
    //pw.print("The number of records found::"+rowcount1);
     else {
             String command1 = null;
command1 = "select DISTINCT url_data,input_data from info where input_data LIKE '%"+Content+"%' group by url_data";
rs1 = statement1.executeQuery(command1);
    int rowcount1=0;
   ResultSetMetaData md1 = rs1.getMetaData();
    int count1 = md1.getColumnCount(); 
   // while (rs1.next()) {
    //    rowcount1++;}
   // boolean flag = true;
    //if (rowcount1 < 1)
//    {flag = false;}
    pw.println("<head> "
            + "<style> "
            + "body{"
            + "background-color: lightgoldenrodyellow;}</style>"
            + "</head>");
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
             /*
 String[]dataContent=new String[50];
 String command = null;
 dataContent=Content.split(" ");
 String commandpart1="select DISTINCT url_data,input_data from info where";
 String commandpart2="";
 String commandpart3=" group by url_data ";// order by url_data offset 0 rows fetch next 2 rows only";
 for(int i=0;i<dataContent.length;i++)
 {commandpart2 +=  " input_data LIKE '%"+dataContent[i] +"%'";  
   
     if (dataContent.length>1 && i< dataContent.length-1)
         commandpart2+=" or";
 }
  command=commandpart1+commandpart2+commandpart3;
  //pw.println(command);
   rs = statement.executeQuery(command);
    int rowcount=0;
      
    ResultSetMetaData md = rs.getMetaData();
    int count = md.getColumnCount();
   
    pw.println("<table border=1 width= 100%>");
    pw.print("<tr>");
    for (int j=1; j<=count; j++) {
      pw.print("<th>");
     pw.print(md.getColumnLabel(j));
    }
    pw.println("</tr>");
    
    while (rs.next()) {
        rowcount++;
        
      pw.print("<tr>");
      for (int j=1; j<=count; j++) {
          if(j==1)
          {
            pw.print("<td>");
            pw.print("<a href="+rs.getString(j)+">"+rs.getString(j)+"</a>");
          }
        else
        {
            pw.print("<td>");
            pw.print(rs.getString(j));
            
        }
      }
      pw.println("</tr>");
    }
    pw.println("</table>");
   // int total_rowcount= rowcount1+rowcount;
 
   pw.print("The number of records found::"+rowcount);
             */
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
