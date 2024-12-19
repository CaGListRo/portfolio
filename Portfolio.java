
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class Portfolio extends JFrame implements ActionListener {

    Font myfont = new Font("Ink Free", Font.BOLD, 23);
    JFrame frame;
    JButton program1, program2, program3, program4, program5;
    JButton[] buttons = new JButton[5];

    Portfolio() {
        frame = new JFrame("Portfolio");
        frame.pack();
        frame.setSize(400, 500);
        frame.setResizable(false);

        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(5, 1));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        program1 = new JButton("Program 1 - exe");
        program2 = new JButton("Program 2 - exe");
        program3 = new JButton("Program 3 - java");
        program4 = new JButton("Program 4 - exe");
        program5 = new JButton("Program 5 - exe");

        buttons[0] = program1;
        buttons[1] = program2;
        buttons[2] = program3;
        buttons[3] = program4;
        buttons[4] = program5;

        for (int i = 0; i < 5; i++) {
            buttons[i].setFont(myfont);
            buttons[i].addActionListener(this);
            frame.add(buttons[i]);
        }

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == program1) {
            executeProgram(1);
        }
        if (e.getSource() == program2) {
            executeProgram(2);
        }
        if (e.getSource() == program3) {
            executeProgram(3);
        }
        if (e.getSource() == program4) {
            executeProgram(4);
        }
        if (e.getSource() == program5) {
            executeProgram(5);
        }
    }

    private void executeProgram(int number) {
        try {
            String currentDir = new File(".").getCanonicalPath();  // get the directory in which the app is running
            String folder;
            String command;
            String name;

            switch (number) {
                case 1 -> {
                    folder = "program 1";
                    name = "test1.exe";
                }
                case 2 -> {
                    folder = "program 2";
                    name = "test2.exe";
                }
                case 3 -> {
                    folder = "program 3";
                    name = "Main.java";
                }
                case 4 -> {
                    folder = "program 4";
                    name = "test4.exe";
                }
                case 5 -> {
                    folder = "program 5";
                    name = "test5.exe";
                }
                default ->
                    throw new AssertionError();
            }

            String path = currentDir + File.separator + "programs" + File.separator + folder;

            if (number == 3) {
                // Für Java-Programme
                command = "java -jar " + path + File.separator + name;
            } else {
                // Für .exe-Dateien
                command = "cmd.exe /c " + path + File.separator + name;
            }

            System.out.println(command);

            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            processBuilder.start();

            // JOptionPane.showMessageDialog(this, "Program " + number + " executed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to open: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Portfolio();
    }
}
