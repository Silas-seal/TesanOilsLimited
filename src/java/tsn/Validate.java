
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
@WebServlet(name = "Validate", urlPatterns = {"/Validate"})
public class Validate extends HttpServlet {

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
        
        //getting values from rct
        String ppnu=request.getParameter("ppno"), ppat=request.getParameter("atdname"),dat=request.getParameter("date"),tm=request.getParameter("time"),
                fpp=request.getParameter("fpricep"),fpa=request.getParameter("fpricea"),pmr=request.getParameter("pmsmprev"),
                pmc=request.getParameter("pmsmcur"),pvp=request.getParameter("pmsvprev"),pvc=request.getParameter("pmsvcur"),
                pcv=request.getParameter("pmscprev"),psc=request.getParameter("pmsccur"),
                amp=request.getParameter("agomprev"),amc=request.getParameter("agomcur"),avp=request.getParameter("agovprev"),
                avc=request.getParameter("agovcur"),asp=request.getParameter("agocprev"),asc=request.getParameter("agoccur");
        
        double pmsm=Double.valueOf(pmc) - Double.valueOf(pmr),
                pmsc=Double.valueOf(psc) - Double.valueOf(pcv);
        
        double agom=Double.valueOf(amc) - Double.valueOf(amp),
                agos=Double.valueOf(asc) - Double.valueOf(asp); 
        
        double pmsv=Double.valueOf(pvc) - Double.valueOf(pvp),
                agov=Double.valueOf(avc) - Double.valueOf(avp);
        
        String body="<td valign=\"top\">"
                + "<h2><font color=\"darkred\">Cash Balancing</font></h2>"
                + "<font face=\"Times new roman\" size=\"+1\" color=\"black\"> <form action=\"Savecash\" method=\"post\">"
                + "<font face=\"Cambria\" size=\"+1\" color=\"navy\">"+ppnu+"<br/>"+ppat+"<br/>"+dat+"<br/>"+tm+"</font><p/>"
                + "<input type=\"hidden\" name=\"ppno\" value=\""+ppnu+"\" /> <input type=\"hidden\" name=\"atdname\" value=\""+ppat+"\" /> "
                + "<input type=\"hidden\" name=\"date\" value=\""+dat+"\" /> <input type=\"hidden\" name=\"time\" value=\""+tm+"\" /><p/>"
                
                + "<b>PMS</b> <br/> Fuel Price <input type=\"text\" name=\"fpricep\" value=\""+fpp+"\"  maxlength=\"11\" width=\"320\"/> <p/>"
                + "<table border=\"0\" cellpadding=\"3\" cellspacing=\"3\" bgcolor=\"deeppink\">"
                + "<tr><th></th> <th>METER</th> <th>VOLUME</th> <th>CASH</th></tr>"
                + "<tr><td>PREVIOUS</td> <td><input type=\"text\" width=\"320\" name=\"pmsmprev\" value=\""+pmr+"\" /></td> "
                + "<td><input type=\"text\" width=\"320\" name=\"pmsvprev\" value=\""+pvp+"\" /></td>"
                + "<td><input type=\"text\" width=\"320\"/ name=\"pmscprev\" value=\""+pcv+"\" ></td> </tr>"
                + "<tr><td>CURRENT</td> <td><input type=\"text\" width=\"320\" name=\"pmsmcur\" value=\""+pmc+"\" /></td> "
                + "<td><input type=\"text\" width=\"320\" name=\"pmsvcur\" value=\""+pvc+"\" /></td>"
                + "<td><input type=\"text\" width=\"320\" name=\"pmsccur\" value=\""+psc+"\" /></td> </tr>"
                + "</td> </tr>"
                + "<tr><td>TOTAL</td> <td>"+pmsm+"</td> <td>"+pmsv+"</td> <td>"+pmsc+"</td> </tr>"
                + "<input type=\"hidden\" name=\"pmt\" value=\""+pmsm+"\" /> <input type=\"hidden\" name=\"pvt\" value=\""+pmsv+"\" />"
                + "<input type=\"hidden\" name=\"pct\" value=\""+pmsc+"\" />"
                + " </table> <p/>"
                
                + "<b>AGO</b> <br/> Fuel Price <input type=\"text\" name=\"fpricea\"  maxlength=\"11\" width=\"320\" value=\""+fpa+"\" /> <p/>"
                + "<table border=\"0\" cellpadding=\"3\" cellspacing=\"3\" bgcolor=\"gold\">"
                + "<tr><th></th> <th>METER</th> <th>VOLUME</th> <th>CASH</th></tr>"
                + "<tr><td>PREVIOUS</td> <td><input type=\"text\" width=\"320\"/ name=\"agomprev\" value=\""+amp+"\" /></td> "
                + "<td><input type=\"text\" width=\"320\" name=\"agovprev\" value=\""+avp+"\" /></td>"
                + "<td><input type=\"text\" width=\"320\" name=\"agocprev\" value=\""+asp+"\" /></td> </tr>"
                + "<tr><td>CURRENT</td> <td><input type=\"text\" width=\"320\" name=\"agomcur\" value=\""+amc+"\" /></td> "
                + "<td><input type=\"text\" width=\"320\"/ name=\"agovcur\" value=\""+avc+"\" /></td>"
                + "<td><input type=\"text\" width=\"320\" name=\"agoccur\" value=\""+asc+"\" /></td> </tr>"
                + "</td> </tr> "
                + "<tr><td>TOTAL</td> <td>"+agom+"</td> <td>"+agov+"</td> <td>"+agos+"</td> </tr>"
                + "<input type=\"hidden\" name=\"amt\" value=\""+agom+"\" /> <input type=\"hidden\" name=\"avt\" value=\""+agov+"\" />"
                + "<input type=\"hidden\" name=\"act\" value=\""+agos+"\" />"
                + "</table> <p/>"
                
                /*+ "<button type=\"submit\" style=\"background-color: navy\"> <font face=\"Cambria\" size=\"+1\" color=\"azure\">"
                + "VALIDATE  </font> </button>"*/
                + "<button type=\"submit\" style=\"background-color: darkgreen\"> <font face=\"Cambria\" size=\"+1\" color=\"azure\">"
                + "SAVE  </font> </button><p/> </form> </table>";
        
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
        return "Validation";
    }

}
