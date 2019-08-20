<%-- 
    Document   : index
    Created on : Jul 23, 2019, 10:51:58 AM
    Author     : SeumX Plus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>TESAN OILS LTD - Account</title>
    </head>
    <body bgcolor="deepskyblue">
    <center>
        <img style="background-color:azure" src="logo.png" height="128" width="741" alt="logo.png"/> <br/>
        <div style="background-color:navy">
            <a href="index.jsp"><button type="button" style="background-color: navy"> <font face="Times new roman" size="+2" color="white">
                    Home</font> </button> </a>
            <a href="account.jsp"><button type="button" style="background-color: white"> <font face="Times new roman" size="+2" color="navy">
                    Account</font> </button> </a>
        </div>
    </center>
    
    <%
        Cookie ck=new Cookie("user",request.getParameter("user")); ck.setMaxAge(0); response.addCookie(ck);
        %>

    <div style="background-color: white">
        <table border="0" bordercolor="orange" cellpadding="4" cellspacing="4">
            <tr><td colspan="3"></td></tr>
            <tr>
                <td valign="top" halign="left" bgcolor="lightsteelblue">
                    <ul>
                        <li><a href="index.jsp"><font face="Cambria" size="+1" color="black"><i>Home</i></font></a></li>
                        <li><a href=""><font face="Cambria" size="+1" color="black"><i>About</i></font></a></li>
                        <li><a href=""><font face="Cambria" size="+1" color="black"><i>Contact Us</i></font></a></li>
                        <li><a href=""><font face="Cambria" size="+1" color="black"><i>Products</i></font></a></li>
                    </ul>
                </td>
                <td>
                    <font color="white"> _____________________________________________</font>
                </td>
                
                <td> <form action="Login" method="post">
                    <font color="darkred"> <h2>LOG IN</h2> </font>
                    <font face="Cambria" size="+1" color="black">
                    User Type : <select type="dropdown" name="utyp">
                        <option value="administrator" selected>Administrator</option>
                        <option value="manager" >Manager</option>
                        
                    </select> <br/> <br/>
                    Username : <input type="text" name="username" maxlength="40" placeholder="username"/> <br/> <br/>
                    Password : <input type="password" name="password" maxlength="40" placeholder="password"/> <br/> <br/>
                    <button type="submit" width="270" height="31" style="background-color: darkgreen"> <font face="Cambria" size="+2" color="azure"> 
                        LOGIN  </font>
                    </button> <p/>  <a href="fgtpas.jsp"> <i><b>Forgot Password</b></i></a>
                    </font> </form> 
                </td> 
                
            </tr>
            
        </table>
        
        <div> <table border="0" bordercolor="orange" cellpadding="1" cellspacing="1" background="rainbow.gif" align="center">

            <tr><td colspan="3"></td></tr>
            <tr>
                <td valign="top">
                  <h3>Contacts</h3>
                    <b>Phone:</b> <br/>
                    +256 753209093<br/>
                    +256 750464545 <br/>                     
                    +256 756092254 <br/>
                      <b>Email:</b> <br/>
            Tesanoils@gmail.com	<br/>
                  Tesanoils@yahoo.com<br/>
                </td>
				
                <td valign="bottom">
                    <font color="lightslategrey">_________________________ </font>
                </td>
				
                <td valign="top">
                    <h3>Quick Links</h3>
                    <font face="Cambria" size="+1" color="black"><a href="about">About</a> <br/></font>
                    <font face="Cambria" size="+1" color="black"><a href="contact">Contact Us</a> <br/></font>
                    <font face="Cambria" size="+1" color="black"><a href="home">Home</a> <br/></font>
                    
                  <font face="Cambria" size="+1" color="black"><a href="location">Location</a> <br/></font>
                </td>
               
                <td valign="bottom">
                    <font color="lightslategrey">________________________ </font>
                </td>
				
                <td valign="top">
                    <h3>CORE VALUES</h3>
                    	Goal Zero: putting safety first.</br>
	Investing in the future.</br>
	Delivering value to our employees:</br>
	Empower, recognise and reward.</br>
	Caring for the environment, communities and people.</br>
	Clear vision and swift decision-making</br>

                </td>
            </tr>
            </table> </div>
    </div> 
    
    <div style="background-color: black" align="right">
        <font face="Cambria" size="+1" color="azure">Tesan Oils Uganda Limited (C) 2019.<font color="black">_________________
        _______________________________</font>Developed by <a href="">SeumxPlus</a> </font>
     </div> 
        
    </body>
</html>