import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Duelfield extends JFrame{

    private String cmd ="",player="",enemy="";
    //private final Pokemon p;
   // private final Pokemon e;
    private JLabel pLabel = new JLabel();
    private JLabel eLabel = new JLabel();
    private JLabel pHP = new JLabel();
    private JLabel eHP = new JLabel();
    private int j;

    public void setJ(int i){
        this.j = i;
    }

    public void setCmd(String cmd){
        this.cmd = cmd;
    }
    public String getCmd(){
        return this.cmd;
    }
    
    public Duelfield(Pokemon p, Pokemon e){
        //this.p = p;
        //this.e = e;
        JFrame frame = new JFrame();
        frame.setTitle("  Duel field");
        frame.setSize(900, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        PicAndGif g = new PicAndGif();

        Container field = getContentPane();
        ImageIcon bg = new ImageIcon(g.getPicAndGif(13));
        JLabel background = new JLabel(bg);
        
        ImageIcon pPic;
        if(p.toString().equals("Pickachu")){
            pPic = new ImageIcon(g.getPicAndGif(14));
            pLabel.setIcon(pPic);
            setJ(14);
        }else if(p.toString().equals("charmander")){
            pPic = new ImageIcon(g.getPicAndGif(16));
            pLabel.setIcon(pPic);
            setJ(16);
        }else if(p.toString().equals("squirtle")){
            pPic = new ImageIcon(g.getPicAndGif(18));
            pLabel.setIcon(pPic);
            setJ(18);
        }else{
            pPic = new ImageIcon(g.getPicAndGif(20));
            pLabel.setIcon(pPic);
            setJ(20);
        }
        pLabel.setBounds(50, 350, 300, 300);
            
        ImageIcon ePic = new ImageIcon(g.getPicAndGif(20));
        eLabel.setIcon(ePic);
        eLabel.setBounds(500, 350, 300, 300);

        ImageIcon HPbar = new ImageIcon(g.getPicAndGif(22));
        pHP.setIcon(HPbar);
        pHP.setBounds(50,250, 300, 100);

        ImageIcon eHPbar = new ImageIcon(g.getPicAndGif(22));
        eHP.setIcon(eHPbar);
        eHP.setBounds(500,250, 300, 100);

        JButton atk = new JButton(" Attack ");
        atk.setBounds(550, 700, 100, 50);
        atk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                PicAndGif g = new PicAndGif();
                if(player.equals("zeroHP")){
                    System.out.println("You lose");
                    ImageIcon img = new ImageIcon(g.getPicAndGif(25));
                    pHP.setIcon(img);
                    try{
                        Thread.sleep(3000);
                    }
                    catch(InterruptedException ex){
                        Thread.currentThread().interrupt();
                    }
                    setCmd("close");
                    frame.setVisible(false);
                }
                else if(enemy.equals("zeroHP")){
                    System.out.println("You win receive berry");
                    ImageIcon img = new ImageIcon(g.getPicAndGif(25));
                    eHP.setIcon(img);
                    try{
                        Thread.sleep(2500);
                    }
                    catch(InterruptedException ex){
                        Thread.currentThread().interrupt();
                    }
                    setCmd("close");
                    frame.setVisible(false);
                }
                System.out.println("Enemy hp = "+ e.getHPtoString());
                enemy = e.getAttack(p.attack());
                System.out.println("Your Pokemon hp = "+p.getHPtoString());
                player = p.getAttack(e.attack());
                if((e.getHP() / e.getoHP()*100 > 80)){
                    ImageIcon img = new ImageIcon(g.getPicAndGif(22));
                    eHP.setIcon(img);
                    eHP.repaint();
                }else if(e.getHP() / e.getoHP()*100 > 50 && e.getHP() / e.getoHP()*100 <= 80){
                    ImageIcon img = new ImageIcon(g.getPicAndGif(23));
                    eHP.setIcon(img);
                    eHP.repaint();
                }else if(e.getHP() / e.getoHP()*100 > 20 && e.getHP() / e.getoHP()*100 <= 50){
                    ImageIcon img = new ImageIcon(g.getPicAndGif(24));
                    eHP.setIcon(img);
                    eHP.repaint();
                }else{
                    ImageIcon img = new ImageIcon(g.getPicAndGif(25));
                    eHP.setIcon(img);
                    eHP.repaint();
                }
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
            }
        });

        background.add(atk);
        background.add(pHP);
        background.add(eHP);
        background.add(pLabel);
        background.add(eLabel);
        field.add(background);
        frame.add(field);
        frame.pack();
        frame.setVisible(true);
    }

}