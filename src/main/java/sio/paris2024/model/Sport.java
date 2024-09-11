/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.paris2024.model;

import java.util.ArrayList;

/**
 *
 * @author SIO2
 */
public class Sport {
    private int id;
    private String nom ;
    private ArrayList<Sport> lesSports ;

    public Sport() {
    }

    public Sport(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Sport(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Sport> getLesSports() {
        return lesSports;
    }

    public void setLesSports(ArrayList<Sport> lesSports) {
        this.lesSports = lesSports;
    }
    
    public void addSport(Sport a){
        
        if (lesSports == null){
            lesSports = new ArrayList<Sport>();
        }
        lesSports.add(a);
    }
    
}
