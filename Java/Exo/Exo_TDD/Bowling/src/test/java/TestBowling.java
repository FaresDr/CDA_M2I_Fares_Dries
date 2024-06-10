import org.example.Frame;
import org.example.IGenerateur;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestBowling {

    private final IGenerateur generateur = Mockito.mock(IGenerateur.class);






    @Test
   public void Roll_SimpleFrame_FirstRoll_CheckScore(){

        Frame frame = new Frame(generateur,false);

        Mockito.when(generateur.randomPin(10)).thenReturn(10);

        frame.makeRoll();
        Assert.assertEquals(10,frame.getScore());

    }
    @Test
    public void Roll_SimpleFrame_SecondRoll_CheckScore(){

        Frame frame = new Frame(generateur,false);

        Mockito.when(generateur.randomPin(10)).thenReturn(5);
        Mockito.when(generateur.randomPin(5)).thenReturn(3);

        frame.makeRoll();

        frame.makeRoll();

        Assert.assertEquals(8,frame.getScore());
    }

    @Test
    public void Roll_SimpleFrame_SecondRoll_FirstRollStrick_ReturnFalse(){

        Frame frame = new Frame(generateur,false);

        Mockito.when(generateur.randomPin(10)).thenReturn(10);

        frame.makeRoll();



       Assert.assertEquals(false,frame.makeRoll());

    }


    @Test
      public void  Roll_SimpleFrame_MoreRolls_ReturnFalse(){
        Frame frame = new Frame(generateur,false);
        Mockito.when(generateur.randomPin(10)).thenReturn(3);

        frame.makeRoll();
        frame.makeRoll();


        Assert.assertEquals(false,frame.makeRoll());
    }
    @Test
 public void  Roll_LastFrame_SecondRoll_FirstRollStrick_ReturnTrue(){
        Frame frame = new Frame(generateur,true);
        Mockito.when(generateur.randomPin(10)).thenReturn(10);
        frame.makeRoll();
        Assert.assertEquals(true,frame.makeRoll());
    }
@Test
     public void      Roll_LastFrame_SecondRoll_FirstRollStrick_CheckScore(){
    Frame frame = new Frame(generateur,true);
    Mockito.when(generateur.randomPin(10)).thenReturn(10);
    frame.makeRoll();
    Mockito.when(generateur.randomPin(10)).thenReturn(5);
    frame.makeRoll();
    Assert.assertEquals(15,frame.getScore());


}
@Test
    public void  Roll_LastFrame_ThirdRoll_FirstRollStrick_ReturnTrue(){
    Frame frame = new Frame(generateur,true);
    Mockito.when(generateur.randomPin(10)).thenReturn(10);
    frame.makeRoll();
    Mockito.when(generateur.randomPin(10)).thenReturn(5);
    frame.makeRoll();
    Assert.assertEquals(true,frame.makeRoll());

}
@Test
public void  Roll_LastFrame_ThirdRoll_FirstRollStrick_CheckScore(){
    Frame frame = new Frame(generateur,true);
    Mockito.when(generateur.randomPin(10)).thenReturn(10);
    frame.makeRoll();
    Mockito.when(generateur.randomPin(10)).thenReturn(5);
    frame.makeRoll();
    Mockito.when(generateur.randomPin(5)).thenReturn(3);
    frame.makeRoll();
    Assert.assertEquals(18,frame.getScore());

}
@Test
 public void Roll_LastFrame_ThirdRoll_Spare_ReturnTrue(){
    Frame frame = new Frame(generateur,true);
    Mockito.when(generateur.randomPin(10)).thenReturn(5);
    frame.makeRoll();
    Mockito.when(generateur.randomPin(5)).thenReturn(5);
    frame.makeRoll();

    Assert.assertEquals(true,frame.makeRoll());
}

@Test
public void     Roll_LastFrame_ThirdRoll_Spare_CheckScore(){
    Frame frame = new Frame(generateur,true);
    Mockito.when(generateur.randomPin(10)).thenReturn(8);
    frame.makeRoll();
    Mockito.when(generateur.randomPin(2)).thenReturn(1);
    frame.makeRoll();
    Mockito.when(generateur.randomPin(10)).thenReturn(3);
    frame.makeRoll();
    Assert.assertEquals(12,frame.getScore());
}
    @Test
public void   Roll_LastFrame_FourthRoll_ReturnFalse(){
        Frame frame = new Frame(generateur,true);
        Mockito.when(generateur.randomPin(10)).thenReturn(10);
        frame.makeRoll();
        Mockito.when(generateur.randomPin(10)).thenReturn(5);
        frame.makeRoll();
        Mockito.when(generateur.randomPin(10)).thenReturn(5);
        frame.makeRoll();
        Assert.assertEquals(false,frame.makeRoll());

}
}
