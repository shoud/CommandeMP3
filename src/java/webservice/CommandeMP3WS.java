/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Thomas
 */
@WebService(serviceName = "CommandeMP3WS")
public class CommandeMP3WS {

    private ArrayList<String> listJouer = new ArrayList<String>();
    private ArrayList<String> listSupprimer = new ArrayList<String>();
    private ArrayList<String> listRechercher = new ArrayList<String>();
    private ArrayList<String> listAjouter = new ArrayList<String>();
       
    public CommandeMP3WS()
    {
        //Pour jouer
        listJouer.add("jouer");
        listJouer.add("joue");
        listJouer.add("lance");
        listJouer.add("lire");

        //Pour supprimer
        listSupprimer.add("supprime");
        listSupprimer.add("supprimer");
        listSupprimer.add("enleve");

        //Pour rechercher
        listRechercher.add("recherche");
        listRechercher.add("rechercher");

        //Pour ajouter
        listAjouter.add("ajoute");
        listAjouter.add("ajouter");
        listAjouter.add("rajoute");         
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAction")
    public String getAction(@WebParam(name = "phrase") String phrase) {
        //TODO write your implementation code here:
        //Détection de jouer
           for(String jouer : listJouer)
                if(phrase.toLowerCase().contains(jouer))
                    return "jouer";

            //Détection de rechercher
            for(String rechercher : listRechercher)
                if(phrase.toLowerCase().contains(rechercher))
                    return "rechercher";

            //Détection de supprimer
            for(String supprimer : listSupprimer)
                if(phrase.toLowerCase().contains(supprimer))
                   return "supprimer";

            //Détection d'ajouter
            for(String ajouter : listAjouter)
                if(phrase.toLowerCase().contains(ajouter))
                    return "ajouter";

            //return commande.erreur;
            return "erreur";
    }
}