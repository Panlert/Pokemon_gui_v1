import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import javax.swing.JRadioButtonMenuItem;
//import javax.swing.event.MouseInputListener;
//import jdk.internal.org.jline.terminal.MouseEvent;
//import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
//import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;

//import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class GameGUI extends JFrame
{
    private Trainner trainner;

    public Trainner getTrainner(){
        return this.trainner;
    }
    public GameGUI(){
        //null
    }
    
    public GameGUI(Trainner trainner){
        this.trainner = trainner;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("pokemon game");
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);

        String[] trainnerOptions = {"findPokemon", "feed", "status"};

        final JPanel comboPanel = new JPanel();
        JLabel combolB = new JLabel("Trainner choice: ");
        JComboBox<String> choice = new JComboBox<String>(trainnerOptions);

        JButton confirm = new JButton(" confirm ");
        confirm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                
                String[] locationFile = {
                    "D:/Game online/PSU file/file.java/giftFile/4GaX.gif",                      //walking
                    "D:/Game online/PSU file/file.java/Pokemon game/ezgif-2-6d0b072c3d3f.gif", //loading
                    "D:/Game online/PSU file/file.java/giftFile/pickachu.gif",                  //pickachu
                    "D:/Game online/PSU file/file.java/giftFile/charmander.gif",                //charmander
                    "D:/Game online/PSU file/file.java/giftFile/squirtle.gif",                  //squirtle
                    "D:/Game online/PSU file/file.java/giftFile/eating.gif"                     //eating
                };

                ImageIcon pic;
                JLabel animation = new JLabel();

                if(choice.getSelectedItem() == "findPokemon"){
                    pic = new ImageIcon(locationFile[0]);
                    animation.setIcon(pic);
                    frame.getContentPane().add(BorderLayout.CENTER, animation);
                    frame.setVisible(true);
                }
                else if(choice.getSelectedItem() == "feed"){
                    pic = new ImageIcon(locationFile[5]);
                    animation.setIcon(pic);
                    frame.getContentPane().add(BorderLayout.CENTER, animation);
                    frame.setVisible(true);
                }
                else if(choice.getSelectedItem() == "status"){
                    JOptionPane ms = new JOptionPane();
                    String userInput = (JOptionPane.showInputDialog( ms, "Choose your pokemon." ));
                    for(Pokemon pokemonNAME: getTrainner().getPokeball()){
                        if(userInput.equals(pokemonNAME.toString()))
                            JOptionPane.showMessageDialog(ms, pokemonNAME.toStringStatus());
                        else
                            JOptionPane.showMessageDialog(ms, "You don't have this pokemon name.");
                    }
                    
                }
                
            }
        });

        comboPanel.add(combolB);
        comboPanel.add(choice);
        comboPanel.add(confirm);
        
        JMenuBar menuBer = new JMenuBar();
        menuBer.setBorderPainted(true);
        JMenu bag = new JMenu(" open pokeball bag ");
        JMenu quit = new JMenu(" quit ");
        menuBer.add(bag);
        menuBer.add(quit);

        frame.getContentPane().add(BorderLayout.NORTH, menuBer);
        frame.getContentPane().add(BorderLayout.SOUTH, comboPanel);
        frame.setVisible(true);
        
    }
}