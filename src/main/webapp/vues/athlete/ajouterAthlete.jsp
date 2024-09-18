<%-- 
    Document   : ajouterPompier
    Created on : 18 mars 2024, 13:30:47
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sio.paris2024.model.Pays"%>
<%@page import="sio.paris2024.model.Athlete"%>
<%@page import="sio.paris2024.form.FormAthlete"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>paris 2024</title>
    </head>
    <body>
        <h1>NOUVEL ATHLETE</h1>
        
            <%
                FormAthlete form = (FormAthlete)request.getAttribute("form");
            %>
        
        <form class="form-inline" action="ajouter" method="POST">
                <label for="nom">NOM : </label>
                <input id="nom" type="text" name="nom"  size="30" maxlength="30" required>
                </br>
                <label for="prenom">PRENOM : </label>
                <input id="prenom" type="text" name="prenom"  size="30" maxlength="30" required> 
                </br>
                <label for="dateNaiss">DATE DE NAISSANCE : </label>
                <input id="dateNaiss" type="date" name="dateNaiss"  size="30" maxlength="30" required>     
                </br>
                <%-- Champ Liste des pays --%>
                <label for="pays">Pays : </label>
                <select name="idPays" required>
                    <%
                        ArrayList<Pays> lesPays= (ArrayList)request.getAttribute("pLesPays");
                        for (int i=0; i<lesPays.size();i++){
                            Pays p = lesPays.get(i);
                            out.println("<option value='" + p.getId()+"'>" + p.getNom()+"</option>" );
                        }
                    %>
                </select>
                </br>
                               
            <input type="submit" name="valider" id="valider" value="Valider"/>
            </form>
        
        
        
        
    </body>
</html>