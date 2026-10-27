import javax.swing.*;
import java.awt.*;

public class BattleshipGUI extends JFrame
{
    private JButton[][] buttons;

    private JLabel missLabel;
    private JLabel strikeLabel;
    private JLabel totalMissLabel;
    private JLabel totalHitLabel;

    private GameManager game;

    public BattleshipGUI()
    {
        game = new GameManager();

        setTitle("Battleship");
        setSize(900, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        buildStatusPanel();
        buildBoard();
        buildBottomPanel();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void buildStatusPanel()
    {
        JPanel panel =
                new JPanel(new GridLayout(2, 2));

        missLabel = new JLabel();
        strikeLabel = new JLabel();
        totalMissLabel = new JLabel();
        totalHitLabel = new JLabel();

        panel.add(missLabel);
        panel.add(strikeLabel);
        panel.add(totalMissLabel);
        panel.add(totalHitLabel);

        updateLabels();

        add(panel, BorderLayout.NORTH);
    }

    private void buildBoard()
    {
        JPanel panel =
                new JPanel(new GridLayout(10, 10));

        buttons = new JButton[10][10];

        for(int row = 0; row < 10; row++)
        {
            for(int col = 0; col < 10; col++)
            {
                JButton button =
                        new JButton("~");

                button.setBackground(Color.CYAN);

                final int r = row;
                final int c = col;

                button.addActionListener(
                        e -> processMove(r, c));

                buttons[row][col] = button;

                panel.add(button);
            }
        }

        add(panel, BorderLayout.CENTER);
    }

    private void buildBottomPanel()
    {
        JPanel panel = new JPanel();

        JButton playAgain =
                new JButton("Play Again");

        JButton quit =
                new JButton("Quit");

        playAgain.addActionListener(
                e -> restartGame());

        quit.addActionListener(
                e -> quitGame());

        panel.add(playAgain);
        panel.add(quit);

        add(panel, BorderLayout.SOUTH);
    }

    private void processMove(
            int row,
            int col)
    {
        boolean hit =
                game.fireAt(row, col);

        JButton button =
                buttons[row][col];

        button.setEnabled(false);

        if(hit)
        {
            button.setText("X");
            button.setForeground(Color.RED);

            Ship ship =
                    game.getBoard()
                            .getCell(row, col)
                            .getShip();

            if(ship.isSunk())
            {
                JOptionPane.showMessageDialog(
                        this,
                        "Ship Sunk!");
            }
        }
        else
        {
            button.setText("M");
            button.setForeground(Color.YELLOW);
        }

        updateLabels();

        if(game.isWinner())
        {
            int choice =
                    JOptionPane.showConfirmDialog(
                            this,
                            "You Win! Play Again?",
                            "Winner",
                            JOptionPane.YES_NO_OPTION);

            if(choice == JOptionPane.YES_OPTION)
            {
                restartGame();
            }
            else
            {
                System.exit(0);
            }
        }

        if(game.isLoser())
        {
            int choice =
                    JOptionPane.showConfirmDialog(
                            this,
                            "You Lose! Play Again?",
                            "Game Over",
                            JOptionPane.YES_NO_OPTION);

            if(choice == JOptionPane.YES_OPTION)
            {
                restartGame();
            }
            else
            {
                System.exit(0);
            }
        }
    }

    private void updateLabels()
    {
        Statistics s =
                game.getStats();

        missLabel.setText(
                "Miss Counter: "
                        + s.getMissCounter());

        strikeLabel.setText(
                "Strike Counter: "
                        + s.getStrikeCounter());

        totalMissLabel.setText(
                "Total Misses: "
                        + s.getTotalMisses());

        totalHitLabel.setText(
                "Total Hits: "
                        + s.getTotalHits());
    }

    private void restartGame()
    {
        int option =
                JOptionPane.showConfirmDialog(
                        this,
                        "Start New Game?",
                        "Play Again",
                        JOptionPane.YES_NO_OPTION);

        if(option ==
                JOptionPane.YES_OPTION)
        {
            dispose();
            new BattleshipGUI();
        }
    }

    private void quitGame()
    {
        int choice =
                JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to quit?",
                        "Quit Game",
                        JOptionPane.YES_NO_OPTION);

        if(choice == JOptionPane.YES_OPTION)
        {
            int replay =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Would you like to start a new game instead?",
                            "Play Again",
                            JOptionPane.YES_NO_OPTION);

            if(replay == JOptionPane.YES_OPTION)
            {
                restartGame();
            }
            else
            {
                System.exit(0);
            }
        }
    }
}