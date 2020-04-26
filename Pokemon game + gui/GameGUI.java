import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame
{
    private String cmd ="";
    private String bagCmd ="";
    private static final long serialVersionUID = 1L;
    
    public String getCmd(){
        return this.cmd;
    }
    private void setCmd(String cmd){
        this.cmd = cmd;
    }
    public String getBagCmd(){
        return this.bagCmd;
    }
    public void setBagCmd(String cmd){
        this.bagCmd = cmd;
    }
    public String resetCmd(){
        this.cmd="";
        this.bagCmd="close";
        return "";
    }

    public GameGUI(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("pokemon game");
        frame.setSize(605, 638);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        PicAndGif g = new PicAndGif();
        
        /*setSize(800,600);
        setLocationRelativeTo(null);*/


//-------------background--------------------------------------------------

        Container c = getContentPane();
        ImageIcon field = new ImageIcon(g.getPicAndGif(6));
        JLabel pic = new JLabel(field);

    //------bag--------------------------------------------------
        ImageIcon ImgBag = new ImageIcon(g.getPicAndGif(7));
        JToggleButton bag = new JToggleButton(ImgBag);
        bag.setBounds(10, 10, 80, 80);
        bag.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){

                if(bag.isSelected()){
                    setBagCmd("openbag");
                    bag.setIcon(new ImageIcon(g.getPicAndGif(8)));
                    SwingUtilities.updateComponentTreeUI(frame);
                }
                else{
                    setBagCmd("close");
                    bag.setIcon(new ImageIcon(g.getPicAndGif(7)));
                    SwingUtilities.updateComponentTreeUI(frame);
                }
            
            }
        });
    //-----------------------------------------------------------


//--------------dropdown-------------------------------------------------------

        String[] trainnerOptions = {"findPokemon", "feed", "status", "quit"};

        final JPanel comboPanel = new JPanel();
        JLabel combolB = new JLabel("Trainner choice: ");
        JComboBox<String> choice = new JComboBox<String>(trainnerOptions);

//-------------confirm button---------------------------------------------------

        JButton confirm = new JButton(" confirm ");
        confirm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){

                if(choice.getSelectedItem() == "findPokemon"){
                    setCmd("findPokemon");
                    System.out.println("FINDPOKEMON");
                }
                else if(choice.getSelectedItem() == "feed"){
                    setCmd("feed");
                    System.out.println("FEED");
                }
                else if(choice.getSelectedItem() == "status"){
                   setCmd("status");
                   System.out.println("STATUS");
                }
                else if(choice.getSelectedItem() == "quit"){
                    setCmd("quit");
                    frame.setVisible(false);
                }
                
            }
        });

        comboPanel.add(combolB);
        comboPanel.add(choice);
        comboPanel.add(confirm);
        
        pic.add(bag);
        c.add(pic);
        frame.add(c);
        frame.setVisible(true);
        pack();
        frame.getContentPane().add(BorderLayout.SOUTH, comboPanel);
        
    }

}