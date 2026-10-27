import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameManagerTest
{
    @Test
    public void gameStartsWithZeroHits()
    {
        GameManager game =
                new GameManager();

        assertEquals(
                0,
                game.getStats()
                        .getTotalHits());
    }

    @Test
    public void gameStartsWithZeroMisses()
    {
        GameManager game =
                new GameManager();

        assertEquals(
                0,
                game.getStats()
                        .getTotalMisses());
    }

    @Test
    public void boardIsCreated()
    {
        GameManager game =
                new GameManager();

        assertNotNull(
                game.getBoard());
    }

    @Test
    public void statisticsIsCreated()
    {
        GameManager game =
                new GameManager();

        assertNotNull(
                game.getStats());
    }
}