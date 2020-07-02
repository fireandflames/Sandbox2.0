import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.*;


public class Main {
    static Integer cash = 1000;
    static Integer number = 0;
    static Integer bid = 0;
    static Integer wins = 0;
    static Integer losses = 0;
    static Integer playedNumber = 0;

    public static void CreateWindow() {


        JFrame frame = new JFrame("Roulette by fire_and_flames");
        frame.setVisible(true);
        frame.setSize(1, 1);
        frame.setLayout(new GridLayout(2,4));
        JTextField cashDisplay, bidDisplay, numberDisplay, playedNumberDisplay, lossesDisplay, winsDisplay;
        cashDisplay = new JTextField();
        cashDisplay.setVisible(true);
        cashDisplay.setEditable(false);
        cashDisplay.setText("Your cash : " + cash);
        cashDisplay.setBackground(Color.yellow);
        frame.add(cashDisplay);
        bidDisplay = new JTextField();
        bidDisplay.setVisible(true);
        bidDisplay.setEditable(true);
        bidDisplay.setText("Write your bid here");
        bidDisplay.setBackground(Color.green);
        bidDisplay.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bidDisplay.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        frame.add(bidDisplay);
        numberDisplay = new JTextField();
        numberDisplay.setVisible(true);
        numberDisplay.setEditable(true);
        numberDisplay.setText("Write your number here");
        numberDisplay.setBackground(Color.green);
        numberDisplay.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                numberDisplay.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        frame.add(numberDisplay);
        playedNumberDisplay = new JTextField();
        playedNumberDisplay.setVisible(true);
        playedNumberDisplay.setEditable(false);
        playedNumberDisplay.setText("Played number : ");
        playedNumberDisplay.setBackground(Color.green);
        frame.add(playedNumberDisplay);
        lossesDisplay = new JTextField();
        lossesDisplay.setVisible(true);
        lossesDisplay.setEditable(false);
        lossesDisplay.setText("Losses: " + losses);
        lossesDisplay.setBackground(Color.green);
        frame.add(lossesDisplay);
        winsDisplay = new JTextField();
        winsDisplay.setVisible(true);
        winsDisplay.setEditable(false);
        winsDisplay.setText("Wins: " + wins);
        winsDisplay.setBackground(Color.green);
        frame.add(winsDisplay);


        JButton play = new JButton("Play!");
        frame.add(play);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               bid = Integer.parseInt(bidDisplay.getText());
                if( bid != null && cash >= bid && bid > 0 )  {
                    number = Integer.parseInt(numberDisplay.getText());
                    if(number != null && number < 37 && number >= 0) {
                        Random rand = new Random();
                        playedNumber = rand.nextInt(37);
                        if (number == playedNumber) {
                            cash += bid * 36;
                            wins++;
                        } else {
                            cash -= bid;
                            losses++;
                        }
                        cashDisplay.setText("Your cash : " + cash);
                        bidDisplay.setText("Write your bid here");
                        playedNumberDisplay.setText("Played number : " + playedNumber);
                        numberDisplay.setText("Write your number here");
                        winsDisplay.setText("Wins: " + wins);
                        lossesDisplay.setText("Losses: " + losses);
                    }
                    else play.setText("Please, enter valid number and try again");
                }
                else
                {
                    play.setText("You can't play, please re-buy or choose a valid bid and then click this button");
                }

            }
        });
        JButton rebuyButton = new JButton();
        rebuyButton.setText("Click to rebuy");
        frame.add(rebuyButton);
        rebuyButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cash += 1000;
                cashDisplay.setText("Your cash : " + cash);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });




        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        CreateWindow();
    }

}