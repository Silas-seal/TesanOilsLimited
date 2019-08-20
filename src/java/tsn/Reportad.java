
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
@WebServlet(name = "Reportad", urlPatterns = {"/Reportad"})
public class Reportad extends HttpServlet {

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
                                + "<tr><th valign=\"top\"><a href=\"Mailad\"><button type=\"button\" style=\"background-color:darkred\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">MAIL"
                                + "</font></button></a></th>"
                                + "<th valign=\"top\"><a href=\"Employ\"><button type=\"button\" style=\"background-color:darkred\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">EMPLOYEES"
                                + "</font></button></a></th>"
                                + "<th valign=\"top\"><a href=\"User\"><button type=\"button\" style=\"background-color:darkred\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">USERS"
                                + "</font></button></a></th>"
                                + "<th valign=\"top\" bgcolor=\"aliceblue\"><a href=\"Reportad\"><button type=\"button\" style=\"background-color:darkred\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">REPORT"
                                + "</font></button></a></th>"
                                + "<th valign=\"top\"><a href=\"Infoad\"><button type=\"button\" style=\"background-color:darkred\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">INFO"
                                + "</font></button></a></th></tr>"
                                //body
                                + "<tr><td valign=\"top\" bgcolor=\"white\" colspan=\"5\" width=\"1178\" height=\"718\">"
                                + "<h2>REPORTS</h2>");
                        out.println("<form action=\"Reportad\" method=\"post\">"
                                + "Data <input type=\"date\" name=\"date\" />"
                                + "Branch <input tye=\"text\" name=\"br\" />__________________________"
                                + "<button type=\"submit\" style=\"background-color:navy\" ><font face=\"Cambria\" size=\"+1\" color=\"azure\">"
                                + "REQUEST REPORT</button> </form>");
                                
                                String qr="select *from cash where branch=? && date=?"; PreparedStatement p;
                    p=con.prepareStatement(qr); p.setString(1,request.getParameter("br")); p.setString(2,request.getParameter("date"));
                    ResultSet r; r=p.executeQuery();
                    
                    out.println("<h2><font color=\"darkred\">CASH</font></h2>");
                            
                            if(r.next()) {
                            out.println("Fuel Price : <b>"+r.getString("pms_price")+"</b>"); }
                            
                    r=p.executeQuery();
                    while(r.next()) {
                    //reporting cash
                    out.println(
                             "<table border=\"2\" cellpadding=\"4\" cellspacing=\"4\" bgcolor=\"deeppink\" width=\"778\">"
                            + "<tr><th>"+r.getString("attendant")+"</th><th>METER</th><th>VOLUME</th><th>CASH</th></tr>"
                            + "<tr><td>PREVIOUS</td><td>"+r.getString("pmsm_prev")+"</td><td>"+r.getString("pmsv_prev")+"</td><td>"+r.getString("pmsc_prev")+"</td></tr>"
                            + "<tr><td>CURRENT</td><td>"+r.getString("pmsm_cur")+"</td><td>"+r.getString("pmsv_cur")+"</td><td>"+r.getString("pmsc_cur")+"</td></tr>"
                            + "<tr><td>TOTAL</td><td>"+r.getString("pmsm_total")+"</td><td>"+r.getString("pmsv_total")+"</td><td>"+r.getString("pmsc_total")+"</td></tr>"
                            + "</table>");
                    
                }
                    r=p.executeQuery();
                    out.println("<h3>AGO</h3>");
                    
                            if(r.next()) {
                            out.println("Fuel Price : <b>"+r.getString("ago_price")+"</b>"); }
                            r=p.executeQuery();
                    while(r.next()) {
                    //reporting cash
                    out.println(
                             "<table border=\"2\" cellpadding=\"4\" cellspacing=\"4\" bgcolor=\"gold\" width=\"778\">"
                            + "<tr><th>"+r.getString("attendant")+"</th><th>METER</th><th>VOLUME</th><th>CASH</th></tr>"
                            + "<tr><td>PREVIOUS</td><td>"+r.getString("agom_prev")+"</td><td>"+r.getString("agov_prev")+"</td><td>"+r.getString("agoc_prev")+"</td></tr>"
                            + "<tr><td>CURRENT</td><td>"+r.getString("agom_cur")+"</td><td>"+r.getString("agov_cur")+"</td><td>"+r.getString("agoc_cur")+"</td></tr>"
                            + "<tr><td>TOTAL</td><td>"+r.getString("agom_total")+"</td><td>"+r.getString("agov_total")+"</td><td>"+r.getString("agoc_total")+"</td></tr>"
                            + "</table>");
                }
                    p=con.prepareStatement("select *from bulky where branch=? && date=?"); 
                    p.setString(1,request.getParameter("br")); p.setString(2,request.getParameter("date"));
                    r=p.executeQuery();
                    out.println("<h2><font color=\"darkred\">BULKY</font></h2>");
                    
                    if(r.next()) {
                        out.println("Fuel Price : <b>"+r.getString("price")+"</b>");
                    }
                    r=p.executeQuery();
                    while(r.next()) {
                        out.println(
                             "<table border=\"2\" cellpadding=\"4\" cellspacing=\"4\" bgcolor=\"violet\" width=\"778\">"
                                     + "<tr><th>"+r.getString("attendant")+"</th><th>VOLUME</th>"
                                     + "<tr><td>PREVIOUS</td><td>"+r.getString("prev_v")+"</td></tr>"
                                     + "<tr><td>CURRENT</td><td>"+r.getString("cur_v")+"</td></tr>"
                                     + "<tr><td>TOTAL SALES</td><td>"+r.getString("total_sales")+"</td></tr>"
                                     + "<tr><td>CASH</td><td>"+r.getString("cash")+"</td></tr></table>"
                        );
                    }
                    
                    p=con.prepareStatement("select *from bik where branch=? && date=?"); 
                    p.setString(1,request.getParameter("br")); p.setString(2,request.getParameter("date"));
                    r=p.executeQuery();
                    out.println("<h2><font color=\"darkred\">BIK</font></h2>");
                    
                    if(r.next()) {
                        out.println("Fuel Price : <b>"+r.getString("price")+"</b>");
                    }
                    r=p.executeQuery();
                    while(r.next()) {
                        out.println(
                             "<table border=\"2\" cellpadding=\"4\" cellspacing=\"4\" bgcolor=\"lightgreen\" width=\"778\">"
                                     + "<tr><th>"+r.getString("attendant")+"</th><th>VOLUME</th>"
                                     + "<tr><td>PREVIOUS</td><td>"+r.getString("prev")+"</td></tr>"
                                     + "<tr><td>CURRENT</td><td>"+r.getString("cur")+"</td></tr>"
                                     + "<tr><td>TOTAL SALES</td><td>"+r.getString("total")+"</td></tr>"
                                     + "<tr><td>CASH</td><td>"+r.getString("total_sales")+"</td></tr></table>"
                        );
                    }
                    
                    p=con.prepareStatement("select *from bik where branch=? && date=?"); 
                    p.setString(1,request.getParameter("br")); p.setString(2,request.getParameter("date"));
                    out.println("<h3><font color=\"navy\">BIK DIPPING</font></h3>");
                    
                    r=p.executeQuery();
                    while(r.next()) {
                        out.println(
                             "<table border=\"2\" cellpadding=\"4\" cellspacing=\"4\" bgcolor=\"pink\" width=\"778\">"
                                     + "<tr><th>"+r.getString("attendant")+"</th><th>VOLUME</th>"
                                     + "<tr><td>BF</td><td>"+r.getString("bf")+"</td></tr>"
                                     + "<tr><td>RECIEVED</td><td>"+r.getString("rec")+"</td></tr>"
                                     + "<tr><td>TOTAL_LITRES</td><td>"+r.getString("total_l")+"</td></tr>"
                                     + "<tr><td>CURRENT DIP</td><td>"+r.getString("cur_dip")+"</td></tr>"
                                     + "<tr><td>CURRENT METER</td><td>"+r.getString("cur_m")+"</td></tr>"
                                     + "<tr><td>DIFFERENCE</td><td>"+r.getString("diff")+"</td></tr></table>"
                        );
                    }
                    
                    p=con.prepareStatement("select *from dipping where branch=? && date=?"); 
                    p.setString(1,request.getParameter("br")); p.setString(2,request.getParameter("date"));
                    out.println("<h2><font color=\"darkred\">DIPPING</font></h3>");
                    
                    r=p.executeQuery();
                    while(r.next()) {
                        out.println(
                             "<table border=\"2\" cellpadding=\"4\" cellspacing=\"4\" bgcolor=\"olivegreen\" width=\"778\">"
                                     + "<tr><th>"+r.getString("time")+"</th><th>VOLUME</th>"
                                     + "<tr><td>BF</td><td>"+r.getString("bf")+"</td></tr>"
                                     + "<tr><td>RECIEVED</td><td>"+r.getString("recieved")+"</td></tr>"
                                     + "<tr><td>TOTAL_LITRES</td><td>"+r.getString("total_l")+"</td></tr>"
                                     + "<tr><td>CURRENT DIP</td><td>"+r.getString("cur_dip")+"</td></tr>"
                                     + "<tr><td>CURRENT METER</td><td>"+r.getString("cur_m")+"</td></tr>"
                                     + "<tr><td>DIFFERENCE</td><td>"+r.getString("diff")+"</td></tr></table>"
                        );
                    }
                    
                    p=con.prepareStatement("select *from expense where branch=? && date=?"); 
                    p.setString(1,request.getParameter("br")); p.setString(2,request.getParameter("date"));
                    out.println("<h2><font color=\"darkred\">EXPENSES</font></h3>");
                    
                    out.println("<table border=\"2\" cellpadding=\"4\" cellspacing=\"4\" bgcolor=\"blueviolet\" width=\"778\">"
                            + "<tr><th>ITEM</th><th>QUANTITY</th><th>AMOUNT</th>");
                    r=p.executeQuery();
                    while(r.next()) {
                        out.println(
                             "<tr><td>"+r.getString("item")+"</td><td>"+r.getString("quantity")+"</td><td>"+r.getString("amount")+"</td>"
                        );
                    } out.println("</table>");
                    
                    p=con.prepareStatement("select *from debts where branch=? && date=?"); 
                    p.setString(1,request.getParameter("br")); p.setString(2,request.getParameter("date"));
                    out.println("<h2><font color=\"darkred\">DEBTS</font></h3>");
                    
                    out.println("<table border=\"2\" cellpadding=\"4\" cellspacing=\"4\" bgcolor=\"red\" width=\"778\">"
                            + "<tr><th>NAME</th><th>CONTACT</th><th>ADDRESS</th><th>OCCUPATION</th><th>FUEL TYPE</th>"
                            + "<th>AMOUNT</th></tr>");
                    r=p.executeQuery();
                    while(r.next()) {
                        out.println(
                             "<tr><td>"+r.getString("name")+"</td><td>"+r.getString("contact")+"</td><td>"+r.getString("address")+"</td>"+
                                "<td>"+r.getString("job")+"</td><td>"+r.getString("fuel_type")+"</td><td>"+r.getString("amount")+"</td></tr>"
                        );
                    } out.println("</table>");
                    
                    p=con.prepareStatement("select *from payment where branch=? && date=?"); 
                    p.setString(1,request.getParameter("br")); p.setString(2,request.getParameter("date"));
                    out.println("<h2><font color=\"darkred\">PAYMENTS</font></h3>");
                    
                    out.println("<table border=\"2\" cellpadding=\"4\" cellspacing=\"4\" bgcolor=\"green\" width=\"778\">"
                            + "<tr><th>NAME</th><th>CONTACT</th><th>ADDRESS</th><th>OCCUPATION</th><th>FUEL TYPE</th>"
                            + "<th>AMOUNT</th></tr>");
                    r=p.executeQuery();
                    while(r.next()) {
                        out.println(
                             "<tr><td>"+r.getString("name")+"</td><td>"+r.getString("contact")+"</td><td>"+r.getString("address")+"</td>"+
                                "<td>"+r.getString("job")+"</td><td>"+r.getString("fuel_type")+"</td><td>"+r.getString("amount")+"</td></tr>"
                        );
                    } out.println("</table>");
                    
                    p=con.prepareStatement("select *from report where branch=? && date=?"); 
                    p.setString(1,request.getParameter("br")); p.setString(2,request.getParameter("date"));
                    out.println("<h2><font color=\"darkred\">REPORTS</font></h3>");
                    
                    r=p.executeQuery();
                    while(r.next()) {
                        out.println(
                             "<table border=\"2\" cellpadding=\"4\" cellspacing=\"4\" bgcolor=\"slateblue\" width=\"778\">"
                                     + "<tr><th>"+r.getString("time")+"</th><th>"+r.getString("attendant")+"</th>"
                                     + "<tr><td>PREVIOUS COINS</td><td>"+r.getString("prev_coins")+"</td></tr>"
                                     + "<tr><td>DEPOSIT</td><td>"+r.getString("deposit")+"</td></tr>"
                                     + "<tr><td>TOTAL PAYMENT</td><td>"+r.getString("total_payment")+"</td></tr>"
                                     + "<tr><td>TOTAL EXPENSE</td><td>"+r.getString("total_expense")+"</td></tr>"
                                     + "<tr><td>TOTAL SALES</td><td>"+r.getString("total_sales")+"</td></tr>"
                                     + "<tr><td>AMOUNT</td><td>"+r.getString("amount")+"</td></tr>"
                                             + "<tr><td>TOTAL BALANCE</td><td>"+r.getString("total_balance")+"</td></tr>"
                                                     + "<tr><td>BALANCE</td><td>"+r.getString("balance")+"</td></tr>"
                                                             + "<tr><td>LESS</td><td>"+r.getString("less")+"</td></tr>"
                                             + "</table>"
                        );
                    }
                    
                    out.println("</td></table> </table>");
                                
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
