package InterviewProblems.UW143Spring16.HW3_Assassin;

import InterviewProblems.UW143Spring16.HW3_Assasin.AssasinManager;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AssasinTest {

    @Test
    public void assasinManagerTest() {
        ArrayList<String> set = new ArrayList();
        set.add("Erica Kane");
        set.add("Ruth Martin");
        set.add("Jackson Montgomery");
        set.add("Bobby Warner");
        set.add("Joe Martin");
        set.add("Anita Santos");
        set.add("Ted Martin");
        set.add("Phoebe Wallingford");
        set.add("Erica Kane");
        AssasinManager m = new AssasinManager(set);

        Assert.assertEquals(true, m.killRingContains("Ted Martin"));
        Assert.assertEquals(false, m.killRingContains("Baha Dundar"));

        m.kill("Bobby Warner");
        m.kill("Anita Santos");
        Assert.assertEquals(true, m.graveyardContains("Anita Santos"));
        Assert.assertEquals(false, m.killRingContains("Anita Santos"));

        String str = m.printGraveyard();
        System.out.println("Graveyard:\n" + str);

        str = m.printKillRing();
        System.out.println("Kill Ring:\n" + str);

        //Testing isGameOver()
        Assert.assertEquals(false, m.isGameOver());

        m.kill("Erica Kane");
        m.kill("Ruth Martin");
        m.kill("Joe Martin");
        m.kill("Ted Martin");
        m.kill("Jackson Montgomery");

        //Testing isGameOver()
        Assert.assertEquals(true, m.isGameOver());
        Assert.assertEquals("Phoebe Wallingford", m.winner());
    }
}
