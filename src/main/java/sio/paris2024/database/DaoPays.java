/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.paris2024.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static sio.paris2024.database.DaoPays.requeteSql;
import static sio.paris2024.database.DaoPays.resultatRequete;
import sio.paris2024.model.Athlete;
import sio.paris2024.model.Pays;

/**
 *
 * @author zakina
 */
public class DaoPays {
    
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Pays> getLesPays(Connection cnx){
        
         ArrayList<Pays> lesPays = new ArrayList<Pays>();
        try{
            requeteSql = cnx.prepareStatement("select * from pays");
            //System.out.println("REQ="+ requeteSql);
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Pays p = new Pays();
                p.setId(resultatRequete.getInt("id"));
                p.setCode(resultatRequete.getString("code"));
                p.setNom(resultatRequete.getString("nom"));
                
                lesPays.add(p);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLespayss e généré une erreur");
        }
        return lesPays;
    }
        
    public static Pays getLesAthletesByPaysId(Connection cnx, int idPays) {
        Pays p = new Pays();
        ArrayList<Athlete> athletes = new ArrayList<>();
        try {
            requeteSql = cnx.prepareStatement("select p.id as p_id, p.code as p_code, p.nom as p_nom, a.id as a_id, a.prenom as a_prenom, a.nom as a_nom " +
                         "from pays p inner join athlete a " +
                         "on p.id = a.pays_id " +
                         "where p.id = ?");
            requeteSql.setInt(1, idPays);
            resultatRequete = requeteSql.executeQuery();

            while (resultatRequete.next()) {
                if (p.getId() == 0) {
                    p.setId(resultatRequete.getInt("p_id"));
                    p.setCode(resultatRequete.getString("p_code"));
                    p.setNom(resultatRequete.getString("p_nom"));
                }
                Athlete a = new Athlete();
                a.setId(resultatRequete.getInt("a_id"));
                a.setPrenom(resultatRequete.getString("a_prenom"));
                a.setNom(resultatRequete.getString("a_nom"));
                athletes.add(a);
            }
            p.setLesAthletes(athletes);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getPaysById a généré une erreur");
        }
        return p;
    }


        
}