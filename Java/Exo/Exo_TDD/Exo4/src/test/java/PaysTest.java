import org.example.IllegalArgException;
import org.example.RechercheVille;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaysTest {

    public RechercheVille rechercheVille;

    @Test
    public void If_Lenght_Inferior_Or_Equal_To_2_Return_Exception(){
        rechercheVille = new RechercheVille();
        Assert.assertThrows(IllegalArgException.class,()-> {rechercheVille.getPays("a");});
    }

    @Test
    public void If_Search_Equals_Va_Then_Return_Valence_And_Vancouver(){
        rechercheVille = new RechercheVille();
        List<String> result = rechercheVille.getPays("Va");
        List<String> expected = Arrays.asList(new String[]{"Valence","Vancouver"});
        Assert.assertEquals(expected, result);
    }
    @Test
    public void Search_Not_Case_Sensible(){
        rechercheVille = new RechercheVille();
        List<String> result = rechercheVille.getPays("vA");
        List<String> expected = Arrays.asList(new String[]{"Valence","Vancouver"});
        Assert.assertEquals(expected, result);
    }

    @Test
    public void If_Search_Contains_Part_Of_String(){
        rechercheVille = new RechercheVille();
        List<String> result = rechercheVille.getPays("ape");
        List<String> expected = Arrays.asList(new String[]{"Budapest"});
        Assert.assertEquals(expected, result);
    }

    @Test
    public void If_Search_Is_Asterisk(){
        rechercheVille = new RechercheVille();
        List<String> result = rechercheVille.getPays("*");
        List<String> expected = Arrays.asList(new String[]{"Paris","Budapest", "Skojpe","Rotterdam","Valence","Amsterdam","Vienne","Sydney","New York","Londres","Bangok","Hong Kong","Dubai","Rome","Instanbul","Vancouver"});
        Assert.assertEquals(expected, result);
    }


}
