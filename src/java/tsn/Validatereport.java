
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
@WebServlet(name = "Validatereport", urlPatterns = {"/Validatereport"})
public class Validatereport extends HttpServlet {

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
                
        
        String body="<td valign=\"top\">"
                + "<h2><font color=\"darkred\">Report</font></h2>"
                + "<font face=\"Cambria\" size=\"+1\" color=\"black\"> <form action=\"Savereport\" method=\"post\">"
                + "Date : <b>"+request.getParameter("date")+"</b><input type=\"hidden\" name=\"date\" value=\""+request.getParameter("date")+"\" /> <p/>"
                + "Time : <b>"+request.getParameter("time")+"</b><input type=\"hidden\" name=\"time\" value=\""+request.getParameter("time")+"\" /> <p/>"
               
                + "Attendant Name : <b>"+request.getParameter("atdname")+"</b> <input type=\"hidden\" name=\"atdname\" value=\""+request.getParameter("atdname")+"\" /> <p/>"
                + "<table border=\"2\" bordercolor=\"navy\" cellpadding=\"9\" cellspacing=\"9\" bgcolor=\"plum\" >";
                
        
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
                    
                    //read itms
                    String date=request.getParameter("date"),time=request.getParameter("time"),atd=request.getParameter("atdname");
                    int dep=Integer.valueOf(request.getParameter("deposit")),prevc=Integer.valueOf(request.getParameter("prevcoins"));
                    
                    //total payment
                    String qr1="select *from payment where date=?";
                    PreparedStatement p; p=con.prepareStatement(qr1);
                    p.setString(1,date);   ResultSet r=p.executeQuery();
                    double ttpay=0;
                    while(r.next()) {
                        ttpay=ttpay+Integer.valueOf(r.getString("amount"));
                    }   
                    ttpay=ttpay+Double.valueOf(prevc);
                    
                    //total exp
                    String qr2="select *from expense where date=?"; 
                    PreparedStatement ps; ps=con.prepareStatement(qr2); ps.setString(1,date); ResultSet re=ps.executeQuery();
                    double ttexp=0;
                    while(re.next()) {
                        ttexp=ttexp+Integer.valueOf(re.getString("amount"));
                    }
                    
                    //total sales and amount
                    String qr3="select *from cash where date=? && time=?";
                    PreparedStatement pstt; pstt=con.prepareStatement(qr3); pstt.setString(1,date); pstt.setString(2,time); 
                    ResultSet res=pstt.executeQuery();
                    double ttsl=0,ammt=0;
                    if(res.next()) {
                        ttsl=Double.valueOf(res.getString("pmsv_total")) + Double.valueOf(res.getString("agov_total"));
                        ammt=Double.valueOf(res.getString("pmsc_total")) + Double.valueOf(res.getString("agoc_total"));
                    }
                    
                    //debts and expenses
                    String qr5="select *from debts where date=?";
                    PreparedStatement pll; pll=con.prepareStatement(qr5); pll.setString(1,date);
                    ResultSet rsl=pll.executeQuery();
                    
                    double k=0;
                    while(rsl.next()) {
                        k=k+Double.valueOf(rsl.getString("amount"));
                    }
                    double de=ttexp+k;
                    
                    //reading bulky
                    String qr4="select *from bulky where date=?";
                    PreparedStatement pl; pl=con.prepareStatement(qr4); pl.setString(1,date);
                    ResultSet rslt=pl.executeQuery();
                    double blv=0, blc=0;
                    
                    while(rslt.next()) {
                        blv=Double.valueOf(rslt.getString("total_sales"));
                        blc=Double.valueOf(rslt.getString("cash"));
                    }
                    
                    //ttt  v & c
                    ttsl=ttsl+blv; ammt=ammt+blc;
                    
                    //total bal && bal
                    double bal=ammt-de;
                    double ttbal=bal+ttpay; 
                    
                    //less en extra
                    double ls=dep-ttbal;        
                    
                    //report table
                    String rep="<tr><td>Previous Coins</td> <td>"+prevc+"</td></tr> <input type=\"hidden\" name=\"prevcoins\" value=\""+prevc+"\" />"
                            + "<tr><td>Total Expenses</td> <td>"+ttexp+"</td></tr>  <input type=\"hidden\" name=\"ttexp\" value=\""+ttexp+"\" />"
                            + "<tr><td>Debts & Expenses</td> <td>"+de+"</td></tr>  <input type=\"hidden\" name=\"de\" value=\""+de+"\" />"
                            + "<tr><td>Total Payments</td> <td>"+ttpay+"</td></tr>  <input type=\"hidden\" name=\"ttpay\" value=\""+ttpay+"\" />"
                            + "<tr><td>Total Sales</td> <td>"+ttsl+"</td></tr>      <input type=\"hidden\" name=\"ttsl\" value=\""+ttsl+"\" />"
                            + "<tr><td>Total Cash</td> <td>"+ammt+"</td></tr>           <input type=\"hidden\" name=\"ammt\" value=\""+ammt+"\" />"
                            + "<tr><td>Balance</td> <td>"+bal+"</td></tr>           <input type=\"hidden\" name=\"bal\" value=\""+bal+"\" />"
                            + "<tr><td>Total Balance</td> <td>"+ttbal+"</td></tr>   <input type=\"hidden\" name=\"ttbal\" value=\""+ttbal+"\" />"
                            + "<tr><td>Deposit</td> <td>"+dep+"</td></tr>  <input type=\"hidden\" name=\"dep\" value=\""+dep+"\" />"
                            + "<tr><td>Less & Extra</td> <td>"+ls+"</td></tr>  <input type=\"hidden\" name=\"less\" value=\""+ls+"\" />";
                    
                    
                    out.println(head); out.println(body); out.println(rep);
                    out.println("  </table> <p/> <button type=\"submit\" style=\"background-color: navy\"> <font face=\"Cambria\" size=\"+1\" color=\"azure\">"
                + "SEND REPORT  </font> </button> </form> </font> "
                + "</td> </tr> </table>");
                    
                    out.println(footer);
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
        return "Validatereport";
    }

}
