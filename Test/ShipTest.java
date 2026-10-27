import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShipTest
{
    @Test
    public void shipStartsNotSunk()
    {
        Ship ship = new Ship(3);

        assertFalse(ship.isSunk());
    }

    @Test
    public void shipSinksAfterRequiredHits()
    {
        Ship ship = new Ship(3);

        ship.hit();
        ship.hit();
        ship.hit();

        assertTrue(ship.isSunk());
    }

    @Test
    public void shipSizeStoredCorrectly()
    {
        Ship ship = new Ship(5);

        assertEquals(5,
                ship.getSize());
    }
}