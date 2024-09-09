<%-- 
    Document   : consulterPays
    Created on : 9 sept. 2024, 11:22:36
    Author     : SIO2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sio.paris2024.model.Athlete"%>
<%@page import="sio.paris2024.model.Pays"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PARIS 2024</title>
    </head>
    <body>
        <%
            Pays p = (Pays) request.getAttribute("aPays");
        %>
        <h1><% out.println(p.getNom()); %></h1>
        
        <table>
            <tr>
                <td>Listes des Athlètes :</td>
                <td>
                    <%
                        if (p != null && p.getLesAthletes() != null) {
                            for (Athlete a : p.getLesAthletes()) {
                                out.println("<p>" + a.getPrenom() + " " + a.getNom() + "</p>");
                            }
                        } else {
                            out.println("Aucun athlète trouvé");
                        }
                    %>
                </td>
            </tr>
        </table>
    </body>
</html>
