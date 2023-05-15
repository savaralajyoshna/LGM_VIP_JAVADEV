import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    JFrame f;
    JPanel panel;
    JButton[][] buttons;
    JLabel message;
    boolean xTurn = true;
    int turns = 0;

    public TicTacToe() {
        f = new JFrame("Tic Tac Toe");
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.addActionListener(this);
                panel.add(button);
                buttons[i][j] = button;
            }
        }

        message = new JLabel("X's turn");
        f.add(panel, BorderLayout.CENTER);
        f.add(message, BorderLayout.SOUTH);

        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getText().equals("")) {
            if (xTurn) {
                button.setText("X");
                message.setText("O's turn");
            } else {
                button.setText("O");
                message.setText("X's turn");
            }
            turns++;
            xTurn = !xTurn;
        }
        checkForWin();
    }

    public void checkForWin() {
        String winner = null;

        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText())
                    && buttons[i][0].getText().equals(buttons[i][2].getText()) && !buttons[i][0].getText().equals("")) {
                winner = buttons[i][0].getText();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (buttons[0][i].getText().equals(buttons[1][i].getText())
                    && buttons[0][i].getText().equals(buttons[2][i].getText()) && !buttons[0][i].getText().equals("")) {
                winner = buttons[0][i].getText();
            }
        }

        if (buttons[0][0].getText().equals(buttons[1][1].getText())
                && buttons[0][0].getText().equals(buttons[2][2].getText()) && !buttons[0][0].getText().equals("")) {
            winner = buttons[0][0].getText();
        }
        if (buttons[0][2].getText().equals(buttons[1][1].getText())
                && buttons[0][2].getText().equals(buttons[2][0].getText()) && !buttons[0][2].getText().equals("")) {
            winner = buttons[0][2].getText();
        }

        if (winner != null) {
            JOptionPane.showMessageDialog(f, "Player " + winner + " wins !");
            f.setVisible(false);
            new TicTacToe();
        } else if (turns == 9) {
            JOptionPane.showMessageDialog(f, "It's a draw  ! ");
            f.setVisible(false);
            new TicTacToe();
        }
    }

    public void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
