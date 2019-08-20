
package tsn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SeumX Plus
 */
@WebServlet(name = "Validatedip", urlPatterns = {"/Validatedip"})
public class Validatedip extends HttpServlet {

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
"                    <font color=\"white\"> _____________________________________________</font>\n" +
"                </td>";// Here the editing body bigins
        
        String time=request.getParameter("time"),date=request.getParameter("date"),bfp=request.getParameter("bfp"),
                recp=request.getParameter("recievedp"), curdp=request.getParameter("curdp"),mtrp=request.getParameter("meterp"); 
        String bfa=request.getParameter("bfa"),
               reca=request.getParameter("recieveda"), curda=request.getParameter("curda"),mtra=request.getParameter("metera");
        
        double ttl= Double.valueOf(bfp) + Double.valueOf(recp);  double dif=Double.valueOf(mtrp) - Double.valueOf(curdp);
        double ttll= Double.valueOf(bfa) + Double.valueOf(reca);  double diff=Double.valueOf(mtra) - Double.valueOf(curda);
                
        String body="<td valign=\"top\">"
                + "<h2><font color=\"darkred\">Dipping</font></h2>"
                + "<font face=\"Times new roman\" size=\"+1\" color=\"black\"> <form action=\"Savedip\" method=\"post\">"
                + "Date <b>"+date+"</b> <input type=\"hidden\" name=\"date\" value=\""+date+"\" /> "
                + "Time <b>"+time+"</b> <input type=\"hidden\" name=\"time\" value=\""+time+"\" /> <p/>"
                
                + "<p/><h3>PMS</h3> <table cellpadding=\"4\" cellspacing=\"4\" bgcolor=\"pink\">"
                + "<tr><td>BF</td><td><input type=\"text\" name=\"bfp\" width=\"320\" value=\""+bfp+"\" />"
                + "<input type=\"hidden\" name\"pms\" value=\"PMS\" /> </td>"
                + "<td>RECIEVED</td><td><input type=\"text\" name=\"recievedp\" width=\"320\" value=\""+recp+"\" /></td> </tr>"
                + "<tr><td>CURRENT DIP</td><td><input type=\"text\" name=\"curdp\" width=\"320\" value=\""+curdp+"\" /></td>"
                + "<td>METER</td><td><input type=\"text\" name=\"meterp\" width=\"320\" value=\""+mtrp+"\" /></td> </tr> "
                + "<tr><td>TOTAL</td><td>"+ttl+"<input type=\"hidden\" name=\"totalp\" value=\""+ttl+"\" /></td>"
                + "<td>DIFFERENCE</td><td>"+dif+"<input type=\"hidden\" name=\"difp\" value=\""+dif+"\" /></td> </tr>"
                + "</table> <p/>"
                
                + "<p/><h3>AGO</h3> <table cellpadding=\"4\" cellspacing=\"4\" bgcolor=\"yellow\">"
                + "<tr><td>BF</td><td><input type=\"text\" name=\"bfa\" width=\"320\" value=\""+bfa+"\" />"
                + "<input type=\"hidden\" name\"ago\" value=\"AGO\" /> </td>"
                + "<td>RECIEVED</td><td><input type=\"text\" name=\"recieveda\" width=\"320\" value=\""+reca+"\" /></td> </tr>"
                + "<tr><td>CURRENT DIP</td><td><input type=\"text\" name=\"curda\" width=\"320\" value=\""+curda+"\" /></td>"
                + "<td>METER</td><td><input type=\"text\" name=\"metera\" width=\"320\" value=\""+mtra+"\" /></td> </tr> "
                + "<tr><td>TOTAL</td><td>"+ttll+"<input type=\"hidden\" name=\"totala\" value=\""+ttll+"\" /></td>"
                + "<td>DIFFERENCE</td><td>"+diff+"<input type=\"hidden\" name=\"difa\" value=\""+diff+"\" /></td> </tr>"
                + "</table> <p/>"
                
                + "<button type=\"submit\" style=\"background-color: darkgreen\"> <font face=\"Cambria\" size=\"+1\" color=\"azure\">"
                + "SAVE  </font> </button> <p/>"
                
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
                    out.println(head); out.println(body); out.println(footer);
                } }
                
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Data retrieve error");
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
        return "Short description";
    }

}
