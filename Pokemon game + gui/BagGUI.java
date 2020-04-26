import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BagGUI extends JFrame{
    private String cmd="";
    private ArrayList<Pokemon> pokeball;
    private Pokemon choose=null;
    private int berry=0;
    private JButton berryB = new JButton();
    private static final long serialVersionUID = 1L;

    public BagGUI(){
        this.pokeball = new ArrayList<Pokemon>();
    }

    public void add(Pokemon e){
        this.pokeball.add(e);
    }
    public void setBerry(int i){
        this.berry += i;
    }
    public boolean useBerry(int i){
        if(this.berry-i < 0)
            return false;
        else{
            this.berry -= i;
            return true;
        }
    }
    public String getCmd(){
        return this.cmd;
    }
    private void setCmdClose(){
        this.cmd="close";
    }
    public Pokemon getChoose(){
        if(this.choose != null){
            return this.choose;
        }else
            return null;
    }
    private void setChoose(Pokemon x){
        this.choose = x;
    }
    public void resetBagCmd(){
        this.cmd = "";
        this.choose = null;
    }
    public boolean bagIsNotFull(){
        if(pokeball.size()==3)
            return false;
        else 
            return true;
    }

    public void openBagGUI(String cmd){
        this.cmd = cmd;
        setTitle("My pokeball bag");
        setResizable(false);
        setLocationRelativeTo(null);
        PicAndGif g = new PicAndGif();

        Container bContainer = getContentPane();
        ImageIcon bg = new ImageIcon(g.getPicAndGif(10));
        JLabel background = new JLabel(bg);
        JButton[] item = {new JButton(), new JButton(), new JButton()};
        
        int a=0;
        int i=0;

        ImageIcon icon = new ImageIcon(g.getPicAndGif(11));
        for(Pokemon p: pokeball){
            item[i].setText(p.toString());
            item[i].setIcon(icon);
            item[i].setBounds(0, a, 426, 80);
            background.add(item[i]);
            a += 80;
            i++;
        }

        addButtonListener(item, 0);
        addButtonListener(item, 1);
        addButtonListener(item, 2);

        ImageIcon berryImg = new ImageIcon(g.getPicAndGif(12));
        berryB.setBounds(0, a, 426, 80);
        berryB.setText("berry "+ this.berry + "ea");
        berryB.setIcon(berryImg);
        
        background.add(berryB);
        

        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                setCmdClose();
                setVisible(false);
            }
        });

        bContainer.add(background);
        bContainer.add(BorderLayout.SOUTH, close);
        setVisible(true);
        pack();

    }

    public void addButtonListener(JButton item[], int i){
        item[i].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setChoose(pokeball.get(i));
                if(getCmd().equals("close") || getCmd().equals("")){
                    setCmdClose();
                    setVisible(false);
                }else{
                    JOptionPane ms = new JOptionPane();
                    JOptionPane.showMessageDialog ( ms, pokeball.get(i).toStringStatus());
                }
            }
        });
    }

}