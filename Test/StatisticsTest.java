import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatisticsTest
{
    @Test
    public void statisticsStartAtZero()
    {
        Statistics stats =
                new Statistics();

        assertEquals(
                0,
                stats.getTotalHits());

        assertEquals(
                0,
                stats.getTotalMisses());

        assertEquals(
                0,
                stats.getStrikeCounter());

        assertEquals(
                0,
                stats.getMissCounter());
    }

    @Test
    public void hitAddsOneHit()
    {
        Statistics stats =
                new Statistics();

        stats.registerHit();

        assertEquals(
                1,
                stats.getTotalHits());
    }

    @Test
    public void missAddsOneMiss()
    {
        Statistics stats =
                new Statistics();

        stats.registerMiss();

        assertEquals(
                1,
                stats.getTotalMisses());
    }

    @Test
    public void fiveMissesCreateStrike()
    {
        Statistics stats =
                new Statistics();

        for(int i = 0; i < 5; i++)
        {
            stats.registerMiss();
        }

        assertEquals(
                1,
                stats.getStrikeCounter());
    }
}