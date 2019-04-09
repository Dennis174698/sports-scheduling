import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class provides unit test cases for the Match class.
 * @author Lyndon While
 * @version 1.0
 */
public class MatchTest
{
    private Match m;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        m = new Match("team1", "team2");
    }

    private String error(int k, String m)
    {
        return "error " + k + " in " + m + " -";
    }

    @Test
    public void testgetHome() 
    {
        assertEquals(error(1,"getHome"), "team1", m.getHome());
    }

    @Test
    public void testgetAway() 
    {
        assertEquals(error(1,"getAway"), "team2", m.getAway());
    }

    @Test
    public void testgetDisplayValue() 
    {
        assertEquals(error(1,"getDisplayValue"), "team1 vs. team2", m.getDisplayValue());
    }
}
