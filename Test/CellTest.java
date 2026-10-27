import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest
{
    @Test
    public void cellStartsWithoutShip()
    {
        Cell cell = new Cell();

        assertFalse(
                cell.containsShip());
    }

    @Test
    public void settingShipWorks()
    {
        Cell cell = new Cell();

        Ship ship = new Ship(2);

        cell.setShip(ship);

        assertTrue(
                cell.containsShip());
    }

    @Test
    public void clickedStartsFalse()
    {
        Cell cell = new Cell();

        assertFalse(
                cell.isClicked());
    }

    @Test
    public void clickedCanBeSetTrue()
    {
        Cell cell = new Cell();

        cell.setClicked(true);

        assertTrue(
                cell.isClicked());
    }
}