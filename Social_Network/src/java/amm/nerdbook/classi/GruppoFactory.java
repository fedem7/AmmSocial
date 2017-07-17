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
public class GruppoFactory {

//Pattern Design Singleton
    private static GruppoFactory singleton;

    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }

    private ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();

    private GruppoFactory() {
        UtenteFactory userFactory = UtenteFactory.getInstance();

        //Creazione Gruppi
        Gruppo gruppo1 = new Gruppo();
        gruppo1.setId(0);
        gruppo1.setNomeGruppo("Nerd");
        gruppo1.setAdmin(userFactory.getUtenteById(0));
        gruppo1.getListaMembri().add(userFactory.getUtenteById(1));
        gruppo1.getListaMembri().add(userFactory.getUtenteById(2));
        gruppo1.getListaMembri().add(userFactory.getUtenteById(3));

        Gruppo gruppo2 = new Gruppo();
        gruppo2.setId(1);
        gruppo2.setNomeGruppo("Calcetto");
        gruppo2.setAdmin(userFactory.getUtenteById(2));
        gruppo2.getListaMembri().add(userFactory.getUtenteById(0));
        gruppo2.getListaMembri().add(userFactory.getUtenteById(3));

        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);

    }

    public Gruppo getGruppoById(int id) {
        for (Gruppo group : this.listaGruppi) {
            if (group.getId() == id) {
                return group;
            }
        }
        return null;
    }

    public List getGrouptByAdmin(Utente usr) {

        List<Gruppo> listaGruppo = new ArrayList<Gruppo>();

        for (Gruppo gruppo : this.listaGruppi) {
            if (gruppo.getAdmin().equals(usr)) {
                listaGruppo.add(gruppo);
            }
        }
        return listaGruppo;
    }

    public List getGrouptByMembro(Utente usr) {

        List<Gruppo> listaGruppo = new ArrayList<Gruppo>();

        for (Gruppo gruppo : this.listaGruppi) {
            for (Utente membro : gruppo.getListaMembri()) {
                if (membro.equals(usr)) {
                    listaGruppo.add(gruppo);
                }
            }

        }
        return listaGruppo;
    }

    public List getListaGruppi() {
        return this.listaGruppi;
    }

}
