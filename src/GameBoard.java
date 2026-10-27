import java.util.ArrayList;
import java.util.Random;

public class GameBoard
{
    private Cell[][] board;
    private ArrayList<Ship> ships;

    public GameBoard()
    {
        board = new Cell[10][10];
        ships = new ArrayList<>();

        for(int r = 0; r < 10; r++)
        {
            for(int c = 0; c < 10; c++)
            {
                board[r][c] = new Cell();
            }
        }

        placeShips();
    }

    public Cell getCell(int row, int col)
    {
        return board[row][col];
    }

    public ArrayList<Ship> getShips()
    {
        return ships;
    }

    private void placeShips()
    {
        int[] sizes = {5,4,3,3,2};

        Random rand = new Random();

        for(int size : sizes)
        {
            Ship ship = new Ship(size);

            boolean placed = false;

            while(!placed)
            {
                boolean horizontal =
                        rand.nextBoolean();

                int row = rand.nextInt(10);
                int col = rand.nextInt(10);

                if(horizontal)
                {
                    if(col + size > 10)
                    {
                        continue;
                    }

                    boolean clear = true;

                    for(int i=0;i<size;i++)
                    {
                        if(board[row][col+i]
                                .containsShip())
                        {
                            clear = false;
                        }
                    }

                    if(clear)
                    {
                        for(int i=0;i<size;i++)
                        {
                            board[row][col+i]
                                    .setShip(ship);
                        }

                        ships.add(ship);
                        placed = true;
                    }
                }
                else
                {
                    if(row + size > 10)
                    {
                        continue;
                    }

                    boolean clear = true;

                    for(int i=0;i<size;i++)
                    {
                        if(board[row+i][col]
                                .containsShip())
                        {
                            clear = false;
                        }
                    }

                    if(clear)
                    {
                        for(int i=0;i<size;i++)
                        {
                            board[row+i][col]
                                    .setShip(ship);
                        }

                        ships.add(ship);
                        placed = true;
                    }
                }
            }
        }
    }
}