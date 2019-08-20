
package tsn;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*; import java.sql.*;


/**
 *
 * @author SeumX Plus
 */
@WebServlet(name = "Bik", urlPatterns = {"/Bik"})
public class Bik extends HttpServlet {

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
"            <tr><td colspan=\"4\"></td></tr>\n" +
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
                
        
        String body="<td valign=\"top\">"
                + "<h2><font color=\"darkred\">BIK Balancing</font></h2>"
                + "<font face=\"Times new roman\" size=\"+1\" color=\"black\"> <form action=\"Validatebik\" method=\"post\">"
                + "Fuel Price <input type=\"text\" name=\"fprice\" maxlength\"11\" /> <p/>Attendant Name <input type=\"text\" name=\"atdname\""
                + "width=\"320\" /> <p/> Date <input type=\"date\" name=\"date\" /> Time <select type=\"dropdown\" name=\"time\">"
                + "<option value=\"day\" selected>Day</option> </select> <p/>"
                + "<table border=\"0\" cellpadding=\"3\" cellspacing=\"3\" bgcolor=\"cyan\"> "
                + "<tr> <th> </th> <th>VOLUME</th> </tr>"
                + "<tr> <td>PREVIOUS</td> <td><input type=\"text\" name=\"bikprev\" /> </td> </tr>"
                + "<tr> <td>CURRENT</td> <td><input type=\"text\" name=\"bikcur\" /> </td </tr> </table> <p/>"
                
                + "<button type=\"submit\" style=\"background-color: navy\"> <font face=\"Cambria\" size=\"+1\" color=\"azure\">"
                + "VALIDATE  </font> </button> <p/>  "
                
                + "</td> "
                
                + "<td valign=\"top\">"
                + "<h2><font color=\"darkred\">BIK Dipping</font></h2>"
                + "<table border=\"0\" cellpadding=\"3\" cellspacing=\"3\" bgcolor=\"lightgreen\">"
                + "<tr><td><input type=\"hidden\" name=\"ftype\" value=\"bik\" /></td> </tr>"
                + "<tr><td>BF </td> <td> <input type=\"text\" name=\"bf\" width=\"320\" /> </td>"
                + "<td>Recieved </td> <td> <input type=\"text\" name=\"recieved\" width=\"320\" /> </td></tr>"
                + "<tr><td>Current Dip </td> <td> <input type=\"text\" name=\"curd\" width=\"320\" /> </td>"
                + "<td>Meter </td> <td> <input type=\"text\" name=\"meter\" width=\"320\" /> </td></tr> </table>"
                
                + "<h2><font color=\"darkred\">BULK SALES</font></h2>"
                + "<font face=\"Cambria\" size=\"+1\" color=\"black\">"
                + "Fuel Price <input type=\"text\" name=\"blprice\" width=\"320\" /> <p/>"
                + "<table border=\"0\" cellpadding=\"3\" cellspacing=\"3\" bgcolor=\"deeppink\">"
                + "<tr><th></th> <th>VOLUME</th></tr>"
                + "<tr><td>PREVIOUS</td><td><input type=\"text\" name=\"blprev\" width=\"320\"/></td>"
                + "<tr><td>CURRENT</td><td><input type=\"text\" name=\"blcur\" width=\"320\"/></td></tr></table>"
                
                + "</form></tr></table>";
        
        String lgft="<html>\n" +
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
"                        <li><a href=\"\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>About</i></font></a></li>\n" +
"                        <li><a href=\"\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Contact Us</i></font></a></li>\n" +
"                        <li><a href=\"\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Staff</i></font></a></li>\n" +
"                        <li><a href=\"\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Careers</i></font></a></li>\n" +
"                        <li><a href=\"\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Products</i></font></a></li>\n" +
"                    </ul>\n" +
"                </td>\n" +
"                <td>\n" +
"                    <font color=\"white\"> _____________________________________________</font>\n" +
"                </td>\n" +
"                \n" +
"                <td> <form action=\"Login\" method=\"post\">\n" +
"                    <font color=\"darkred\"> <h2>LOG IN</h2> </font>\n" +
"                    <font face=\"Cambria\" size=\"+1\" color=\"black\">\n" +
"                    User Type : <select type=\"dropdown\" name=\"utyp\">\n" +
"                        <option value=\"administrator\" selected>Administrator</option>\n" +
"                        <option value=\"manager\" >Manager</option>\n" +
"                        \n" +
"                    </select> <br/> <br/>\n" +
"                    Username : <input type=\"text\" name=\"username\" maxlength=\"11\" placeholder=\"username\"/> <br/> <br/>\n" +
"                    Password : <input type=\"password\" name=\"password\" maxlength=\"11\" placeholder=\"password\"/> <br/> <br/>\n" +
"                    <button type=\"submit\" width=\"270\" height=\"31\" style=\"background-color: darkgreen\"> <font face=\"Cambria\" size=\"+2\" color=\"azure\"> \n" +
"                        LOGIN  </font>\n" +
"                    </button> <p/>  <a href=\"fgtpas.jsp\"> <i><b>Forgot Password</b></i></a>\n" +
"                    </font> </form> \n" +
"                </td> \n" +
"                \n" +
"            </tr>\n" +
"            \n" +
"        </table>";
        
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
        return "Bik";
    }
}
