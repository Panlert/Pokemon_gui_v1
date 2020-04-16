//import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.event.MouseInputListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
//import java.beans.PropertyChangeListener;
import java.awt.event.ActionListener;
//import javax.*;

public class PickballGUI extends JFrame
{
    private Trainner trainner = new Trainner();

    public Trainner getTrainner(){
        return this.trainner;
    }

    public PickballGUI(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("pokemon game");
        frame.setSize(400,200);
        //frame.setLocationRelativeTo(null);

        final JPanel comboPanel = new JPanel();
        JLabel headTEXT = new JLabel(" Choose your first Pokemon. ");
        comboPanel.add(headTEXT);
        
        ImageIcon Icon = new ImageIcon("D:/Game online/PSU file/file.java/basicGUI/pokeball.jpg");
        JButton p1 = new JButton();
        JButton p2 = new JButton();
        JButton p3 = new JButton();
        p1.setIcon(Icon);
        p2.setIcon(Icon);
        p3.setIcon(Icon);

        p1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane ms = new JOptionPane();
                JOptionPane.showMessageDialog ( ms, "Your first pokemon is Pickachu." );
                Pokemon pickachu = new Pickachu("Pickachu");
                getTrainner().setPokeball(pickachu);
                new GameGUI(getTrainner());
            }
        });

        p2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane ms = new JOptionPane();
                JOptionPane.showMessageDialog ( ms, "Your first pokemon is Charmander." );
                Pokemon charmander = new Charmander("Charmander");
                getTrainner().setPokeball(charmander);
                new GameGUI(getTrainner());
            }
        });

        p3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane ms = new JOptionPane();
                JOptionPane.showMessageDialog ( ms, "Your first pokemon is Squirtle." );
                Pokemon squirtle = new Squirtle("Squirtle");
                getTrainner().setPokeball(squirtle);
                new GameGUI(getTrainner());
            }
        });

        frame.getContentPane().add(BorderLayout.NORTH, comboPanel);
        frame.getContentPane().add(BorderLayout.EAST, p1);
        frame.getContentPane().add(BorderLayout.CENTER, p2);
        frame.getContentPane().add(BorderLayout.WEST, p3);
        frame.setVisible(true);

    }

}
