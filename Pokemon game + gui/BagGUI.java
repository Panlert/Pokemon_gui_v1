import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BagGUI extends JFrame{
    private JButton[] item = {new JButton(), new JButton(), new JButton() , new JButton()};
    private String cmd="";
    private ArrayList<Pokemon> pokeball;
    private Pokemon choose=null;
    private int berry=0;
    private int check=0;

    public void resetCheck(){
        this.check=0;
    }

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

        Container baggg = getContentPane();
        ImageIcon bg = new ImageIcon(g.getPicAndGif(10));
        JLabel background = new JLabel(bg);
        
        int a=0;
        int i=0;

        /*for(Pokemon p : pokeball){
            i++;
        }
        try{
            ImageIcon icon = new ImageIcon(g.getPicAndGif(11));
            JButton ball = new JButton(" "+pokeball.get(i).toString() ,icon);
            ball.setBounds(0, a, 426, 80);
            background.add(ball);
            a += 80;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Too many pokemon.");
        }

        ImageIcon berryImg = new ImageIcon(g.getPicAndGif(12));
        JButton berryB = new JButton("   Berry "+this.berry+" ea", berryImg);
        berryB.setBounds(0, a, 426, 80);
        background.add(berryB);*/
        ImageIcon icon = new ImageIcon(g.getPicAndGif(11));
        for(Pokemon p: pokeball){
            //this.item[i] = new JButton("  "+p.toString(), icon);
            item[i].setText(p.toString());
            item[i].setIcon(icon);
            item[i].setBounds(0, a, 426, 80);
            background.add(item[i]);
            a += 80;
            i++;
        }

        int j=0;
        for(Pokemon p: pokeball){
            item[j].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    setChoose(p);
                    if(getCmd().equals("close") || getCmd().equals("")){
                        setCmdClose();
                        setVisible(false);
                    }
                    else{
                        if(check == 0){
                            JOptionPane ms = new JOptionPane();
                            JOptionPane.showMessageDialog ( ms, p.toStringStatus());
                        }else
                            resetCheck();
                    }
                }
            });
            j++;
        }

        ImageIcon berryImg = new ImageIcon(g.getPicAndGif(12));
        item[i].setText("berry "+ berry + "ea");
        item[i].setIcon(berryImg);
        item[i].setBounds(0, a, 426, 80);
        background.add(item[i]);
        

        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setCmdClose();
                setVisible(false);
            }
        });

        baggg.add(background);
        baggg.add(BorderLayout.SOUTH, close);
        setVisible(true);
        pack();

    }

}