public class Cell
{
    private boolean containsShip;
    private boolean clicked;
    private Ship ship;

    public Cell()
    {
        containsShip = false;
        clicked = false;
        ship = null;
    }

    public boolean containsShip()
    {
        return containsShip;
    }

    public void setShip(Ship ship)
    {
        this.ship = ship;
        containsShip = true;
    }

    public Ship getShip()
    {
        return ship;
    }

    public boolean isClicked()
    {
        return clicked;
    }

    public void setClicked(boolean clicked)
    {
        this.clicked = clicked;
    }
}