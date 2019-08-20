
package tsn;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *
 * @author SeumX Plus
 */
@WebServlet(name = "Mail", urlPatterns = {"/Mail"})
public class Mail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        //declear Strings of page
        String head="<html>\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> \n" +
"        <title>TESAN OILS LTD - Account</title>\n" +
"    </head>\n" +
"    <body bgcolor=\"deepskyblue\">\n" +
"    <center>\n" +
"        <img style=\"background-color:azure\" src=\"logo.png\" height=\"128\" width=\"741\" alt=\"logo.png\"/> <br/>\n" +
"        <div style=\"background-color:navy\">\n" +
"            <a href=\"index.jsp\"><button type=\"button\" style=\"background-color: navy\"> <font face=\"Times new roman\" size=\"+2\" color=\"white\">\n" +
"                    Home</font> </button> </a>\n" +
"            <a href=\"account.jsp\"><button type=\"button\" style=\"background-color: white\"> <font face=\"Times new roman\" size=\"+2\" color=\"navy\">\n" +
"                    Account</font> </button> </a>\n" +
"        </div>\n" +
"    </center>\n" +
"\n" +
"    <div style=\"background-color: white\">\n" +
"        <table border=\"0\" bordercolor=\"orange\" cellpadding=\"4\" cellspacing=\"4\">\n" +
"            <tr><td colspan=\"3\"></td></tr>\n" +
"            <tr>\n" +
"                <td valign=\"top\" halign=\"left\" bgcolor=\"lightsteelblue\">\n" +
"                    <ul>\n" +
"                        <li><a href=\"index.jsp\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Home</i></font></a></li>\n" +
"                        <li><a href=\"Cash\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Cash Balancing</i></font></a></li>\n" +
                         "<li><a href=\"Bik\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>BIK Balancing</i></font></a></li>\n" +
"                        <li><a href=\"Dipping\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Dipping</i></font></a></li>\n" +
"                        <li><a href=\"Expense\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Expenses</i></font></a></li>\n" +
"                        <li><a href=\"Debts\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Debts</i></font></a></li>\n" +
                         "<li><a href=\"Payments\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Payments</i></font></a></li>\n" +
"                        <li><a href=\"Report\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Report</i></font></a></li>\n" +
                         "<li><a href=\"Myaccount\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>My Account</i></font></a></li>\n" +
"                        <li><a href=\"account.jsp\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>LogOut</i></font></a></li>\n" +
"                    </ul>\n" +
"                </td>\n" +
"                <td>\n" +
"                    <font color=\"white\"> ________________</font>\n" +
"                </td>";// Here the editing body bigins
                
        
        String body="<td valign=\"top\">"
                + "<h2><font color=\"darkred\">MY ACCOUNT</font></h2>"
                + "<font face=\"Cambria\" size=\"+1\" color=\"black\">"
                + "<table border=\"3\" cellpadding=\"5\" cellspacing=\"5\" bgcolor=\"darkslateblue\">"
                + "<tr><td bgcolor=\"lightgrey\"><a href=\"Mail\"><button type=\"button\" style=\"background-color:darkslateblue\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">MAIL</font></td>"
                + "<td><a href=\"Advance\"><button type=\"button\" style=\"background-color:darkslateblue\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">ADVANCE</font></td>"
                + "<td><a href=\"Reportfn\"><button type=\"button\" style=\"background-color:darkslateblue\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">REPORT</font></td>"
                + "<td><a href=\"Info\"><button type=\"button\" style=\"background-color:darkslateblue\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">INFO</font></td> </tr>"
                +"<tr><td valign=\"top\" colspan=\"4\" bgcolor=\"white\" height=\"478\" width=\"827\">";
        
        String fwd="</td> </tr>"
                + "</table> </form>"
                + "</td> </tr> </table>";
        
        String footer="<div> <table border=\"0\" bordercolor=\"orange\" cellpadding=\"1\" cellspacing=\"1\" background=\"rainbow.gif\" align=\"center\">\n" +
"\n" +
"            <tr><td colspan=\"3\"></td></tr>\n" +
"            <tr>\n" +
"                <td valign=\"top\">\n" +
"                  <h3>Contacts</h3>\n" +
"                    <b>Phone:</b> <br/>\n" +
"                    +256 753209093<br/>\n" +
"                    +256 750464545 <br/>                     \n" +
"                    +256 756092254 <br/>\n" +
"                      <b>Email:</b> <br/>\n" +
"            Tesanoils@gmail.com	<br/>\n" +
"                  Tesanoils@yahoo.com<br/>\n" +
"                </td>\n" +
"				\n" +
"                <td valign=\"bottom\">\n" +
"                    <font color=\"lightslategrey\">_________________________ </font>\n" +
"                </td>\n" +
"				\n" +
"                <td valign=\"top\">\n" +
"                    <h3>Quick Links</h3>\n" +
"                    <font face=\"Cambria\" size=\"+1\" color=\"black\"><a href=\"about\">About</a> <br/></font>\n" +
"                    <font face=\"Cambria\" size=\"+1\" color=\"black\"><a href=\"contact\">Contact Us</a> <br/></font>\n" +
"                    <font face=\"Cambria\" size=\"+1\" color=\"black\"><a href=\"home\">Home</a> <br/></font>\n" +
"                    \n" +
"                  <font face=\"Cambria\" size=\"+1\" color=\"black\"><a href=\"location\">Location</a> <br/></font>\n" +
"                </td>\n" +
"               \n" +
"                <td valign=\"bottom\">\n" +
"                    <font color=\"lightslategrey\">________________________ </font>\n" +
"                </td>\n" +
"				\n" +
"                <td valign=\"top\">\n" +
"                    <h3>CORE VALUES</h3>\n" +
"                    	Goal Zero: putting safety first.</br>\n" +
"	Investing in the future.</br>\n" +
"	Delivering value to our employees:</br>\n" +
"	Empower, recognise and reward.</br>\n" +
"	Caring for the environment, communities and people.</br>\n" +
"	Clear vision and swift decision-making</br>\n" +
"\n" +
"                </td>\n" +
"            </tr>\n" +
"            </table> </div>\n" +
"    </div> \n" +
"    \n" +
"    <div style=\"background-color: black\" align=\"right\">\n" +
"        <font face=\"Cambria\" size=\"+1\" color=\"azure\">Tesan Oils Uganda Limited (C) 2019.<font color=\"black\">_________________\n" +
"        _______________________________</font>Developed by <a href=\"\">SeumxPlus</a> </font>\n" +
"     </div> \n" +
"        \n" +
"    </body>\n" +
"</html>";
        
        try (PrintWriter out = response.getWriter()) {  
            try {
                Cookie [] cks=request.getCookies();
                for(Cookie ck: cks) {System.out.println(ck.getValue());
                //establishing a database connection 
                String host = "jdbc:mysql://localhost:3306/tsndb", user = "root", pas = "";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(host, user, pas);
                PreparedStatement pst;
                String qry = "select *from user where name=?";
                pst = con.prepareStatement(qry);
                pst.setString(1, ck.getValue()); ResultSet rs=pst.executeQuery();
                if(rs.next() && rs.getString("title").equals("manager")) {
                    
                    out.println(head); out.println(body); 
                    
                    //calling new mails
                    String qr="select *from mail where owner=? && m_type=?";
                    PreparedStatement p; p=con.prepareStatement(qr); p.setString(1,ck.getValue()); p.setString(2,"new");
                    ResultSet r=p.executeQuery();
                    
                    out.println("<table border=\"0\" cellpadding=\"5\" cellspacing=\"5\" bgcolor=\"white\">"
                            + "<tr><th colspan=\"3\"> </th> </tr>"
                            + "<tr><td bgcolor=\"deeppink\"><ul type=\"disc\" valign=\"top\">"
                            + "<li><a href=\"Mail\" ><font face=\"Cambria\" size=\"+1\" color=\"azure\"><i>New</i></font> </a> "
                            + "</li> <li><a href=\"Red\" ><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Old</i></font> </a> </li>"
                            + "<li><a href=\"Sent\" ><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Sent</i> </a> </li> "
                            + "<li><a href=\"Compose\" ><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Compose</i> </a> </li>"
                            + "</td><td valign=\"top\"> <table border=\"1\" cellpadding=\"3\" cellspacing=\"3\" bgcolor=\"lightgrey\">");
                    
                    while(r.next()) {
                        out.println(""
                                + "<tr><td>"+r.getString("m_tofro")+"</td> <td>"+r.getString("m_date")+"</td><td>"+r.getString("m_subject")+"</td>"
                                        + "<td>"+r.getString("m_content")+"</td><td><form action=\"Read\" method=\"post\">"
                                        + "<input type=\"hidden\" name=\"id\" value=\""+r.getString("ID")+"\" />"
                                                + "<button type=\"submit\" style=\"background-color:navy\">"
                                + "<font face=\"Cambria\" size=\"+1\" color=\"azure\">Read</font> </button> </form></td> </tr>");
                    }
                    
                    out.println("</table> </table>"+fwd); out.println(footer);
                    
                } }
                
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Data retrieve error\n"+ex.getMessage());
            } }
    
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Mail";
    }

}
