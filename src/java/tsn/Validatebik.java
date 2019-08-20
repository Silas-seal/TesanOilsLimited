
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
@WebServlet(name = "Validatebik", urlPatterns = {"/Validatebik"})
public class Validatebik extends HttpServlet {

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
                
        //reading values from rct
        String fpr=request.getParameter("fprice"),prev=request.getParameter("bikprev"),cur=request.getParameter("bikcur"),
        atn=request.getParameter("atdname"),dat=request.getParameter("date"),tme=request.getParameter("time"),
                bf=request.getParameter("bf"),rcd=request.getParameter("recieved"), curd=request.getParameter("curd"),
                mtr=request.getParameter("meter"),blp=request.getParameter("blprev"),blc=request.getParameter("blcur"),
                blpr=request.getParameter("blprice");
        double ttl=Double.valueOf(bf) + Double.valueOf(rcd), df=Double.valueOf(mtr) - Double.valueOf(curd);
        
        double dif=Double.valueOf(cur) - Double.valueOf(prev), tt=(Math.round(Double.valueOf(fpr))) * dif; 
        
        double diff=Double.valueOf(blc) - Double.valueOf(blp), ttll=(Math.round(Double.valueOf(blpr))) * diff;
        
        String body="<td valign=\"top\">"
                + "<h2><font color=\"darkred\">BIK Balancing</font></h2>"
                + "<font face=\"Times new roman\" size=\"+1\" color=\"black\"> <form action=\"Savebik\" method=\"post\">"
                + "Fuel Price : <input type=\"hidden\" name=\"fprice\" value=\""+fpr+"\" /> <b>"+fpr+"</b>"
                + "<p/>Attendant Name : <input type=\"hidden\" name=\"atdname\" value=\""+atn+"\" /> <b>"+atn+"</b>"
                + "<p/> Date : <b>"+dat+"</b> <input type=\"hidden\" name=\"date\" value=\""+dat+"\" />"
                + "<p/> Time : <b>"+tme+"</b> <input type=\"hidden\" name=\"time\" value=\""+tme+"\" /> <p/>"
                + "<table border=\"0\" cellpadding=\"3\" cellspacing=\"3\" bgcolor=\"cyan\"> "
                + "<tr> <th> </th> <th>VOLUME</th> </tr>"
                + "<tr> <td>PREVIOUS</td> <td><input type=\"text\" name=\"bikprev\" value=\""+prev+"\" /> </td> </tr>"
                + "<tr> <td>CURRENT</td> <td><input type=\"text\" name=\"bikcur\" value=\""+cur+"\" /> </td </tr> "
                + "<tr> <td>SALES </td> <td><b>"+dif+" </b></td> <input type=\"hidden\" name=\"ttal\" value=\""+dif+"\" /> </tr>"
                + "<tr> <td >CASH </td> <td><b>"+tt+" </b></td> <input type=\"hidden\" name=\"ttsl\" value=\""+tt+"\" /> </tr>"
                + "</table> <p/>" 
                
                + "<button type=\"submit\" style=\"background-color: green\"> <font face=\"Cambria\" size=\"+1\" color=\"azure\">"
                + "SAVE  </font> </button>"
                
                + "</td> "
                
                + "<td valign=\"top\">"
                + "<h2><font color=\"darkred\">BIK Dipping</font></h2>"
                + "<table border=\"0\" cellpadding=\"3\" cellspacing=\"3\" bgcolor=\"lightgreen\">"
                + "<tr><td><input type=\"hidden\" name=\"ftype\" value=\"bik\" /></td> </tr>"
                + "<tr><td>BF </td> <td> <input type=\"text\" name=\"bf\" width=\"320\" value=\""+bf+"\" /> </td>"
                + "<td>Recieved </td> <td> <input type=\"text\" name=\"recieved\" width=\"320\" value=\""+rcd+"\" /> </td></tr>"
                + "<tr><td>Current Dip </td> <td> <input type=\"text\" name=\"curd\" width=\"320\" value=\""+curd+"\" /> </td>"
                + "<td>Meter </td> <td> <input type=\"text\" name=\"meter\" width=\"320\" value=\""+mtr+"\" /> </td></tr> "
                + "<tr><td>Total (Litres) </td> <td><b>"+ttl+"</b><input type=\"hidden\" name=\"total\" value=\""+ttl+"\" /> </td>"
                + "<td>Difference </td> <td><b>"+df+"</b><input type=\"hidden\" name=\"dif\" value=\""+df+"\" /> </td> </tr>"
                + "</table>"
                
                + "<h2><font color=\"darkred\">BULK SALES</font></h2>"
                + "<font face=\"Cambria\" size=\"+1\" color=\"black\">"
                + "Fuel Price "+blpr+"<input type=\"hidden\" name=\"blprice\" width=\"320\" value=\""+blpr+"\" /> <p/>"
                + "<table border=\"0\" cellpadding=\"3\" cellspacing=\"3\" bgcolor=\"deeppink\">"
                + "<tr><th></th> <th>VOLUME</th></tr>"
                + "<tr><td>PREVIOUS</td><td><input type=\"text\" name=\"blprev\" width=\"320\" value=\""+blp+"\"/></td>"
                + "<tr><td>CURRENT</td><td><input type=\"text\" name=\"blcur\" width=\"320\"/ value=\""+blc+"\"></td></tr>"
                + "<tr><td>SALES</td><td><b>"+diff+"</b><input type=\"hidden\" name=\"bldif\" value=\""+diff+"\" /></td></tr>"
                + "<tr><td>CASH</td><td><b>"+ttll+"</b><input type=\"hidden\" name=\"bltt\" value=\""+ttll+"\" /></td></tr>"
                
                + "</table>"
                
                + "</form></tr></table>";
        
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
        return "validate";
    }

}
