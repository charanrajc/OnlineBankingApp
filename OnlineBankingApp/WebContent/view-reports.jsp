<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*,java.util.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Online Bank</title>
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
html,body{
    background-image: url(images/img.gif);
}
.style2 {color: #FFFFFF; font-weight: bold; }
</style>
</head>

<body>
<table width="900" border="1" align="center" cellpadding="0" cellspacing="0" style="font-weight:normal; background-color:#FFFFFF">
  <tr>
    <th colspan="3" scope="col" style="height:90px; background-color:#2175bc;"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="900" height="90">
      <param name="movie" value="images/banks.swf" />
      <param name="quality" value="high" />
      <embed src="images/banks.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="900" height="90"></embed>
    </object></th>
  </tr>
  <tr>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
<td width="160" >
<div id="ddblueblockmenu">
  <div class="menutitle">Account Operations</div>
  <ul>
    <li><a href="main.jsp">Welcome,&nbsp;<%= (String)session.getAttribute("cust_name")%></a></li>
    <li><a href="CreateAccount.jsp">Create Account</a></li>
	<li><a href="deposite">Deposite</a></li>
    <li><a href="withdraw">Do Withdraw</a></li>
    <li><a href="getBalance">Get Balance</a></li>
	<li><a href="transfer">Trasnsfer Amount</a></li>
	<li><a href="ViewReport">View Report</a></li>
	<li><a href="logOff.jsp">LogOut</a></li>
  </ul>
  <div class="menutitle">&nbsp;</div>
</div>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>	</td>
    <td colspan="2" style="padding:20px;line-height:20px;">
	<div class="box1">
	<marquee><h2><font color="#FF0000"> Welcome To Online Bank.</font></h2></marquee>
	</div>
	<br/>
	<br/>
	<form id="form1" name="form1" method="post" action="get-balance-fanal.jsp">
	  <table width="96%" border="0" align="center" cellpadding="2" cellspacing="2">
        <tr>
          <th colspan="6" bgcolor="#333333" scope="col"><font color="#FFFFFF">Following are the Repost of Your Acount(s). </font></th>
        </tr>
        <tr>
          <td colspan="6">&nbsp;</td>
          </tr>
        <tr>
        <td bgcolor="#2175BC"><div align="center" class="style2">Account Name </div></td>
          <td bgcolor="#2175BC"><div align="center" class="style2">Acc No </div></td>
          <td bgcolor="#2175BC"><div align="center" class="style2">Dest Acc No</div></td>
          <td bgcolor="#2175BC"><div align="center" class="style2">Amount</div></td>
          <td bgcolor="#2175BC"><div align="center" class="style2">Operation</div></td>
          <td bgcolor="#2175BC"><div align="center" class="style2">Date - Time </div></td>
        </tr>
		<%
		//for(int i=0;i<one.size();i++) {
		//ArrayList o = (ArrayList)one.get(i); 
		%>
        <tr>
          <td><div align="center">Ramana</div></td>
          <td><div align="center">123123</div></td>
          <td><div align="center">878786</div></td>
          <td><div align="center">1000</div></td>
          <td><div align="center">transfer</div></td>
          <td><div align="center">10/10/17</div></td>
        </tr>
		<%// } %>
        <tr>
       	   <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td width="14%">&nbsp;</td>
          <td width="14%">&nbsp;</td>
          <td width="14%">&nbsp;</td>
          <td width="15%">&nbsp;</td>
          <td width="16%">&nbsp;</td>
          <td width="27%">&nbsp;</td>
        </tr>
      </table>
      </form>
	</td>
  </tr>
  <tr style="height:30px;">
    <td colspan="3" style="background-color:#2175bc;">&nbsp;</td>
  </tr>
</table>
</body>

</html>
