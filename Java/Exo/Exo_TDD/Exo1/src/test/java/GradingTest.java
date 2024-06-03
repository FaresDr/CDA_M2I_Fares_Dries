import org.example.GradingCalculator;
import org.junit.Assert;
import org.junit.Test;

public class GradingTest {

    private GradingCalculator gradingCalculator;

    @Test
    public void WhenPresence_90And_Score_95_Then_A (){
        int score = 95;
        int presence = 90;
        //Arrange
        gradingCalculator = new GradingCalculator(score,presence);

        char res = gradingCalculator.getGrade();

        Assert.assertEquals(res,'A');
    }

    @Test
    public void When_Presence_90And_Score_85_Then(){
        int score =85;
        int presence = 90;

        gradingCalculator = new GradingCalculator(score,presence);

        char res = gradingCalculator.getGrade();

        Assert.assertEquals(res,'B');
    }

    @Test
    public void When_Score_65_And_Presence_90_Then_C(){
        int score = 65;
        int prsence = 90;
        gradingCalculator = new GradingCalculator(score,prsence);

        char res = gradingCalculator.getGrade();

        Assert.assertEquals(res,'C');
    }
    @Test
    public void When_Score_95_And_Presence_65_Then_B(){
        int score = 95;
        int prsence = 65;
        gradingCalculator = new GradingCalculator(score,prsence);

        char res = gradingCalculator.getGrade();

        Assert.assertEquals(res,'B');
    }
    @Test
    public void When_Score_95_And_Presence_55_Then_F(){
        int score = 95;
        int prsence = 55;
        gradingCalculator = new GradingCalculator(score,prsence);

        char res = gradingCalculator.getGrade();

        Assert.assertEquals(res,'F');
    }
    @Test
    public void When_Score_65_And_Presence_55_Then_F(){
        int score = 65;
        int prsence = 5;
        gradingCalculator = new GradingCalculator(score,prsence);

        char res = gradingCalculator.getGrade();

        Assert.assertEquals(res,'F');
    }
    @Test
    public void When_Score_50_And_Presence_90_Then_F(){
        int score = 50;
        int prsence = 90;
        gradingCalculator = new GradingCalculator(score,prsence);

        char res = gradingCalculator.getGrade();

        Assert.assertEquals(res,'F');
    }

}
