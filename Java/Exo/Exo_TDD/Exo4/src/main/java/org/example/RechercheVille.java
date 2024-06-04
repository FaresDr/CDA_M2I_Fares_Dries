package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RechercheVille {
    public List<String> pays = Arrays.asList(new String[]{"Paris","Budapest", "Skojpe","Rotterdam","Valence","Amsterdam","Vienne","Sydney","New York","Londres","Bangok","Hong Kong","Dubai","Rome","Instanbul","Vancouver"});

    public List<String> getPays(String mot) throws IllegalArgException {
        List<String> searched = new ArrayList<>();

        if (mot.equals("*")){
            return pays;
        }
        else if (mot.length()<2){

          throw new  IllegalArgException();
        }else {

            for (String p : pays) {
                if (p.toLowerCase().contains(mot.toLowerCase())) {
                    searched.add(p);
                }
            }
            return searched;
        }
    }


}
