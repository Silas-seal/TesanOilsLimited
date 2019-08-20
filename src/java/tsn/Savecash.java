
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
@WebServlet(name = "Savecash", urlPatterns = {"/Savecash"})
public class Savecash extends HttpServlet {

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
"                    <font color=\"white\"> _____________________________________________</font>\n" +
"                </td>";// Here the editing body bigins
                
        
        String body="<td valign=\"center\">"
                + "<font face=\"Cambria\" size=\"+2\" color=\"darkgreen\"> Cash Data Successfully Saved. <p/></font> "
                + "<a href=\"Cash\"><button type=\"button\" style=\"background-color:navy\"><font face=\"Cambria\" size=\"+1\" color=\"azure\">OK"
                + "</font> </button> </a>"
                
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
                    
                    //collecting itms
                    String brc=rs.getString("branch"),ppnu=request.getParameter("ppno"),ppat=request.getParameter("atdname"),
                            date=request.getParameter("date"),time=request.getParameter("time"),pmsp=request.getParameter("fpricep"),
                            pmsmpr=request.getParameter("pmsmprev"),pmsmcr=request.getParameter("pmsmcur"),pmsmt=request.getParameter("pmt"),
                            pmsvpr=request.getParameter("pmsvprev"),pmsvcr=request.getParameter("pmsvcur"),pmsvt=request.getParameter("pvt"),
                            pmscpr=request.getParameter("pmscprev"),pmsccr=request.getParameter("pmsccur"),pmsct=request.getParameter("pct"),
                            
                            agop=request.getParameter("fpricea"),
                            agompr=request.getParameter("agomprev"),agomcr=request.getParameter("agomcur"),agomt=request.getParameter("amt"),
                            agovpr=request.getParameter("agovprev"),agovcr=request.getParameter("agovcur"),agovt=request.getParameter("avt"),
                            agocpr=request.getParameter("agocprev"),agoccr=request.getParameter("agoccur"),agoct=request.getParameter("act");
                    
                    //saving itms to db
                    String ins="insert into cash(branch,pump,attendant,date,time,pms_price,pmsm_prev,pmsm_cur,pmsm_total,pmsv_prev,pmsv_cur,pmsv_total"
                            + ",pmsc_prev,pmsc_cur,pmsc_total,ago_price,agom_prev,agom_cur,agom_total,agov_prev,agov_cur,agov_total"
                            + ",agoc_prev,agoc_cur,agoc_total) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    
                    PreparedStatement pstt; pstt=con.prepareStatement(ins);
                    pstt.setString(1,brc); pstt.setString(2,ppnu); pstt.setString(3,ppat); pstt.setString(4,date); pstt.setString(5,time);
                    pstt.setString(6,pmsp); pstt.setString(7,pmsmpr); pstt.setString(8,pmsmcr); pstt.setString(9,pmsmt); 
                    pstt.setString(10,pmsvpr); pstt.setString(11,pmsvcr); pstt.setString(12,pmsvt);
                    pstt.setString(13,pmscpr); pstt.setString(14,pmsccr); pstt.setString(15,pmsct);
                    
                    pstt.setString(16,agop); pstt.setString(17,agompr); pstt.setString(18,agomcr); pstt.setString(19,agomt); 
                    pstt.setString(20,agovpr); pstt.setString(21,agovcr); pstt.setString(22,agovt);
                    pstt.setString(23,agocpr); pstt.setString(24,agoccr); pstt.setString(25,agoct);
                    
                    pstt.executeUpdate();
                    
                    out.println(head); out.println(body); out.println(footer);
                } }
                
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Data retrieve error"+"\n"+ex.getMessage());
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
