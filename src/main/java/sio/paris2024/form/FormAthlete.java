/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.paris2024.form;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import sio.paris2024.model.Athlete;
import sio.paris2024.model.Pays;

/**
 *
 * @author zakina
 */
public class FormAthlete {
    
    private String resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs(Map<String, String> erreurs) {
        this.erreurs = erreurs;
    }
    
    //méthode de validation du champ de saisie nom
    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
        throw new Exception( "Le nom d'athlete doit contenir au moins 3 caractères." );
        }
    }

    private void setErreur( String champ, String message ) {
    erreurs.put(champ, message );
    }    
    
    private static String getDataForm( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }   
    }
    
    
    public Athlete ajouterAthlete( HttpServletRequest request ) {
      
        Athlete ath  = new Athlete();
         
        String nom = getDataForm( request, "nom" );
        String prenom = getDataForm( request, "prenom");
        
        String dateNaissanceStr = getDataForm(request, "dateNaiss");
        LocalDate dateNaissance = null;
        if (dateNaissanceStr != null) {
            try {
                dateNaissance = LocalDate.parse(dateNaissanceStr);
            } catch (DateTimeParseException e) {
                setErreur("dateNaiss", "Le format de la date de naissance est invalide.");
            }
        } else {
            setErreur("dateNaiss", "La date de naissance est requise.");
        }
        
        // Récupération et validation de l'ID du pays
        int idPays = -1;
        try {
            idPays = Integer.parseInt(getDataForm(request, "idPays"));
        } catch (NumberFormatException e) {
            setErreur("idPays", "Le pays sélectionné est invalide.");
        }

        // Validation du nom
        try {
            validationNom(nom);
        } catch (Exception e) {
            setErreur("nom", e.getMessage());
        }

        // Affectation des valeurs à l'objet Athlete
        ath.setNom(nom);
        ath.setPrenom(prenom);
        ath.setDateNaiss(dateNaissance);

        Pays p = new Pays(idPays);
        ath.setPays(p);

        // Détermination du résultat de l'ajout
        if (erreurs.isEmpty()) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }

        return ath;
    }
}
