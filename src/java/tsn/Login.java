
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @SuppressWarnings("ConvertToStringSwitch")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        //declear Strings of page
        String head1="<html>\n" +
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
        
        String head2="<html>\n" +
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
"                <td valign=\"top\" halign=\"left\" bgcolor=\"lightsteelblue\"><font color=\"black\"></font>" +
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
"                    <font color=\"white\"> ___</font>\n" +
"                </td>";// Here the editing body bigins
                
        
        String body="<td valign=\"top\">"
                + "<font face=\"Algerian\" size=\"+17\" color=\"navy\">"
                + "<h1><b><i>HI</i></b></h1></font> <p/>"
                + "<font face=\"Algerian\" size=\"+4\" color=\"darkred\">"
                + "MANAGER!</font> <p/>"
                + "<font face=\"Algerian\" size=\"+3\" color=\"darkgreen\">"
                + "WELCOME TO TESAN OILS ONLINE SERVICE</font>"
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
        
        String lgf=""
                + "<html>\n" +
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
"    </center>"
                + ""
                + "<div style=\"background-color: white\">\n" +
"        <table border=\"0\" bordercolor=\"orange\" cellpadding=\"4\" cellspacing=\"4\">\n" +
"            <tr><td colspan=\"3\"></td></tr>\n" +
"            <tr>\n" +
"                <td valign=\"top\" halign=\"left\" bgcolor=\"lightsteelblue\">\n" +
"                    <ul>\n" +
"                        <li><a href=\"index.jsp\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Home</i></font></a></li>\n" +
"                        <li><a href=\"\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>About</i></font></a></li>\n" +
"                        <li><a href=\"\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Contact Us</i></font></a></li>\n" +
"                        <li><a href=\"\"><font face=\"Cambria\" size=\"+1\" color=\"black\"><i>Products</i></font></a></li>\n" +
"                    </ul>\n" +
"                </td>\n" +
"                <td>\n" +
"                    <font color=\"white\">______________________________</font>\n" +
"                </td>\n" +
"                \n" +
"                <td> <form action=\"Login\" method=\"post\">\n" +
"                    <font color=\"darkred\"> <h2>LOG IN</h2> </font>\n" +
"                    <font face=\"Cambria\" size=\"+1\" color=\"black\">\n" +
"                    User Type : <select type=\"dropdown\" name=\"utyp\" >\n" +
"                        <option value=\"administrator\" selected>Administrator</option>\n" +
"                        <option value=\"manager\" >Manager</option>\n" +
"                        \n" +
"                    </select> <br/> <br/>\n" +
"                    Username : <input type=\"text\" name=\"username\" maxlength=\"40\" placeholder=\"username\"/> <br/> <br/>\n" +
"                    Password : <input type=\"password\" name=\"password\" maxlength=\"40\" placeholder=\"password\"/> <br/> <br/>\n" +
"                    <button type=\"submit\" width=\"270\" height=\"31\" style=\"background-color: darkgreen\"> <font face=\"Cambria\" size=\"+2\" color=\"azure\"> \n" +
"                        LOGIN  </font>\n" +
"                    </button> <p/>  <a href=\"fgtpas.jsp\"> <i><b>Forgot Password</b></i></a>\n" +
                "<font face=\"Cambria\" size=\"+1\" color=\"darkred\"><p/>LogIn attempt failed.<br/> Invalid Username Or Password entered.<p/>"
                + "Login using valid username and password."+
"                    </font> </form> \n" +
"                </td> \n" +
"                \n" +
"            </tr>\n" +
"            \n" +
"        </table>";
        
        try (PrintWriter out = response.getWriter()) {
            try {
            //establishing a database connection 
            String host="jdbc:mysql://localhost:3306/tsndb",user="root",pas="";   Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(host,user,pas);
            PreparedStatement pst; String qry="select *from user where email=? && password=?";
            pst=con.prepareStatement(qry); pst.setString(1,request.getParameter("username")); 
            pst.setString(2,request.getParameter("password"));
            ResultSet rs=pst.executeQuery();
            
            if(rs.next()) { System.out.println(rs.getString("title")+"\n"+request.getParameter("utyp"));
                if(rs.getString("title").equals(request.getParameter("utyp"))) {
                    if(rs.getString("title").equals("manager")) {
                        //creating cookies
                        Cookie ck1=new Cookie("user",rs.getString("name")); ck1.setMaxAge(60*60*12);
                        response.addCookie(ck1);
                        
                        out.println(head2); out.println(body); out.println(footer);
                    } 
                    else if(rs.getString("title").equals("administrator")) {
                        out.println(head1);
                        
                        //creating cookies
                        Cookie ck1=new Cookie("user",rs.getString("name")); ck1.setMaxAge(60*60*12);
                        response.addCookie(ck1);
                        
                        //creating admin date
                        out.println("<td valign=\"top\"><table border=\"2\" cellpadding=\"4\" cellspacing=\"4\" bgcolor=\"darkred\">"
                                + "<tr><th valign=\"top\"><a href=\"Mailad\"><button type=\"button\" style=\"background-color:darkred\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">MAIL"
                                + "</font></button></a></th>"
                                + "<th valign=\"top\"><a href=\"Employ\"><button type=\"button\" style=\"background-color:darkred\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">EMPLOYEES"
                                + "</font></button></a></th>"
                                + "<th valign=\"top\"><a href=\"User\"><button type=\"button\" style=\"background-color:darkred\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">USERS"
                                + "</font></button></a></th>"
                                + "<th valign=\"top\"><a href=\"Reportad\"><button type=\"button\" style=\"background-color:darkred\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">REPORT"
                                + "</font></button></a></th>"
                                + "<th valign=\"top\"><a href=\"Infoad\"><button type=\"button\" style=\"background-color:darkred\"><font color=\"azure\" size=\"+2\" face=\"Cambria\">INFO"
                                + "</font></button></a></th></tr>"
                                //body
                                + "<tr><td valign=\"top\" bgcolor=\"white\" colspan=\"5\" width=\"1178\" height=\"718\">"
                                + "<font face=\"Algerian\" size=\"+5\" color=\"blueviolet\"><h1><b>HI</b></h1></font> <p/>"
                                + "<font face=\"Algerian\" size=\"+4\" color=\"navy\">ADMINISTRATOR</font><p/>"
                                + "<font face=\"Algerian\" size=\"+2\" color=\"darkgreen\">WELCOME TO TESAN OILS ONLINE MANAGEMENT</font><p/>"
                                + "</td></tr></table></td></tr></table>");
                        
                        out.println(footer);
                    } else {
                        out.println(lgf); out.println(footer);
                    }
                }
            } else {
                out.println(lgf); out.println(footer);
            }
            
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
