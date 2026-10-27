public class GameManager
{
    private GameBoard board;
    private Statistics stats;

    public GameManager()
    {
        board = new GameBoard();
        stats = new Statistics();
    }

    public GameBoard getBoard()
    {
        return board;
    }

    public Statistics getStats()
    {
        return stats;
    }

    public void resetGame()
    {
        board = new GameBoard();
        stats.reset();
    }

    public boolean fireAt(int row, int col)
    {
        Cell cell =
                board.getCell(row,col);

        if(cell.isClicked())
        {
            return false;
        }

        cell.setClicked(true);

        if(cell.containsShip())
        {
            cell.getShip().hit();

            stats.registerHit();

            return true;
        }
        else
        {
            stats.registerMiss();

            return false;
        }
    }

    public boolean isWinner()
    {
        return stats.getTotalHits() == 17;
    }

    public boolean isLoser()
    {
        return stats.getStrikeCounter() == 3;
    }
}