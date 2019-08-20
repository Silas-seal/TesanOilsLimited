
package tsn;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 *
 * @author SeumX Plus
 */
@WebServlet(name = "Savepasad", urlPatterns = {"/Savepasad"})
public class Savepasad extends HttpServlet {

    @SuppressWarnings("ConvertToStringSwitch")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
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
"                <td valign=\"top\" halign=\"left\" bgcolor=\"black\"><font color=\"black\"> _____________________________</font>" +
/*"                    <ul>\n" +
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
"                    </ul>\n" +*/
"                </td>\n" +
"                <td>\n" +
"                    <font color=\"white\"> ___</font>\n" +
"                </td>";// Here the editing body bigins
  
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
                if(rs.next() && rs.getString("title").equals("administrator")) {
                    out.println(head);
                        //creating admin date
                        out.println("<td valign=\"top\"><table border=\"2\" cellpadding=\"4\" cellspacing=\"4\" bgcolor=\"darkred\">"
                                + "<tr><th valign=\"top\" ><a href=\"Mailad\"><button type=\"button\" style=\"background-color:darkred\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">MAIL"
                                + "</font></button></a></th>"
                                + "<th valign=\"top\"><a href=\"Employ\"><button type=\"button\" style=\"background-color:darkred\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">EMPLOYEES"
                                + "</font></button></a></th>"
                                + "<th valign=\"top\"><a href=\"User\"><button type=\"button\" style=\"background-color:darkred\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">USERS"
                                + "</font></button></a></th>"
                                + "<th valign=\"top\"><a href=\"Reportad\"><button type=\"button\" style=\"background-color:darkred\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">REPORT"
                                + "</font></button></a></th>"
                                + "<th valign=\"top\" bgcolor=\"aliceblue\"><a href=\"Infoad\"><button type=\"button\" style=\"background-color:darkred\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">INFO"
                                + "</font></button></a></th></tr>"
                                //body
                                + "<tr><td valign=\"top\" bgcolor=\"white\" colspan=\"5\" width=\"1178\" height=\"718\">");
                                
                                out.println("<h2><font color=\"darkgreen\">MY INFO</font> </h2>"
                            + "<font face=\"Algerian\" size=\"+4\" color=\"navy\">"
                            + rs.getString("name")+"</font><p/>"
                            + "<font face=\"Algerian\" size=\"+3\" color=\"darkred\">"
                             +rs.getString("title")+"<p/>"
                            + "<font face=\"Cambria\" size=\"+2\" color=\"black\">"
                             +rs.getString("contact")+"<br/>"
                    +rs.getString("branch")+"<br/>"
                    +rs.getString("email")+"<p/>");
                                
                    if(rs.getString("password").equals(request.getParameter("old"))) {
                        
                        PreparedStatement ps=con.prepareStatement("update user set password=? where name=?");
                        ps.setString(1,request.getParameter("new")); ps.setString(2,rs.getString("name")); 
                        ps.executeUpdate();
                        
                        out.println("<font face=\"Cambria\" size=\"+2\" color=\"darkgreen\">"
                                + "Password Successfully Changed. </font>");
                        
                    } else {
                        
                        out.println("<font face=\"Cambria\" size=\"+2\" color=\"darkred\">"
                                + "Password provided is invalid. </font>");
                        
                    }
                    
                    out.println("<form action=\"Changepasad\" method=\"post\">"
                            + "<input type=\"hidden\" name=\"name\" value=\""+rs.getString("name")+"\" />"
                                    + "<button type=\"submit\" style=\"background-color:navy\"><font face=\"Cambria\" size=\"+1\" color=\"azure\">"
                                    + "CHANGE PASSWORD</font></button></form>");
                    
                    out.println("<a href=\"account.jsp\"><button type=\"button\" style=\"background-color:black\"><font face=\"Cambria\" size=\"+1\" color=\"azure\">"
                            + "LogOut</font></button> </a>");
                    
                    out.println("</table> </table>");
                                
                out.println("</td></tr></table></td></tr></table>"+footer);
                } }
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Data Retrive error....."+ex.getMessage());
            }
        }
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
        return "Login";
    }

}  