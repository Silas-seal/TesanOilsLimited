
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
@WebServlet(name = "Savebik", urlPatterns = {"/Savebik"})
public class Savebik extends HttpServlet {

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
                + "<font face=\"Cambria\" size=\"+2\" color=\"darkgreen\"> BIK and BULKY Sales Data Successfully Saved. <p/></font> "
                
                + "<a href=\"Bik\"><button type=\"button\" style=\"background-color:navy\"><font face=\"Cambria\" size=\"+1\" color=\"azure\">OK"
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
                    String brc=rs.getString("branch"),atd=request.getParameter("atdname"),date=request.getParameter("date"),
                            time=request.getParameter("time"),fprc=request.getParameter("fprice"),prev=request.getParameter("bikprev"),
                            cur=request.getParameter("bikprev"),tt=request.getParameter("ttal"),ttsl=request.getParameter("ttsl"),
                            
                            bf=request.getParameter("bf"),rcd=request.getParameter("recieved"),curd=request.getParameter("curd"),
                            mtr=request.getParameter("meter"),ttd=request.getParameter("total"),dif=request.getParameter("dif"),
                            
                            blpr=request.getParameter("blprice"),blprev=request.getParameter("blprev"),blcur=request.getParameter("blcur"),
                            bldif=request.getParameter("bldif"), bltt=request.getParameter("bltt");
                    
                    //saving itms
                    String qr="insert into bik(branch,attendant,date,time,price,prev,cur,total,total_sales,bf,rec,total_l"
                            + ",cur_dip,cur_m,diff) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pstt; pstt=con.prepareStatement(qr);
                    pstt.setString(1,brc); pstt.setString(2,atd); pstt.setString(3,date); pstt.setString(4,time); pstt.setString(5,fprc);
                    pstt.setString(6,prev); pstt.setString(7,cur); pstt.setString(8,tt); pstt.setString(9,ttsl); pstt.setString(10,bf);
                    pstt.setString(11,rcd); pstt.setString(12,curd); pstt.setString(13,mtr); pstt.setString(14,ttd); pstt.setString(15,dif);
                    
                    pstt.executeUpdate();
                    
                    //Saving bulk sales
                    String qr1="insert into bulky(branch,date,attendant,price,prev_v,cur_v,total_sales,cash) Values(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement p=con.prepareStatement(qr1);
                    p.setString(1,brc); p.setString(2,date); p.setString(3,atd); p.setString(4,blpr); p.setString(5,blprev);
                    p.setString(6,blcur); p.setString(7,bldif); p.setString(8,bltt); p.setString(9,time);
                    
                    p.executeUpdate();
                    
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
