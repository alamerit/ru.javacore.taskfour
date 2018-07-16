package ru.javacor.taskfour;
/**
 * Shafikov Almir
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

    public class Chat extends JDialog {
    private JPanel contentPane;
    private JTextField textField;
    private JButton enterButton;
    private JTextArea textArea;
    private JPanel jPanel;


    public Chat () {

        setMinimumSize(new Dimension(300, 400));
        setContentPane(contentPane);
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
                onCancel(); }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        enterButton.addActionListener(new ActionListener() {
            @Override
    public void actionPerformed(ActionEvent e) {
                ok();
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
    public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) ok();
            }
        });
    }

    private  void ok(){
        textArea.append(getTime() + " " + textField.getText() + "\n");
        textField.setText("");
        textField.grabFocus();

    }

    private void onCancel() {
     //   System.exit(0);
        dispose();
    }

    public String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
}