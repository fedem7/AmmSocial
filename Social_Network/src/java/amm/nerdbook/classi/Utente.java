/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.classi;
import java.util.*;

/**
 *
 * @author edef
 */
public class Utente {

    private int id;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String frasePresentazione;
    private String password;
    private String urlFotoProfilo;
    private ArrayList<Utente> listaAmici;

    public Utente() {
        id = 0;
        nome = "";
        cognome = "";
        dataNascita = "";
        frasePresentazione = "";
        password = "";
        urlFotoProfilo = "";
        listaAmici = new ArrayList<Utente>();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the dataNascita
     */
    public String getDataNascita() {

        return dataNascita;
    }

    /**
     * @param dataNascita the dataNascita to set
     */
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    /**
     * @return the frasePresentazione
     */
    public String getFrasePresentazione() {
        return frasePresentazione;
    }

    /**
     * @param frasePresentazione the frasePresentazione to set
     */
    public void setFrasePresentazione(String frasePresentazione) {
        this.frasePresentazione = frasePresentazione;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the urlFotoProfilo
     */
    public String getUrlFotoProfilo() {
        return urlFotoProfilo;
    }

    /**
     * @param urlFotoProfilo the urlFotoProfilo to set
     */
    public void setUrlFotoProfilo(String urlFotoProfilo) {
        this.urlFotoProfilo = urlFotoProfilo;
    }

    public String getUsername() {
        if (this.nome == null || this.cognome == null) {
            return "user" + this.id;
        }
        return nome + " " + cognome;
    }

    /**
     * @return the listaAmici
     */
    public ArrayList<Utente> getListaAmici() {
        return listaAmici;
    }

    /**
     * @param listaAmici the listaAmici to set
     */
    public void setListaAmici(ArrayList<Utente> listaAmici) {
        this.listaAmici = listaAmici;
    }
}
