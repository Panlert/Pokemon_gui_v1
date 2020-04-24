import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CatchGUI extends JFrame{
    
    private boolean result;
    private int attackRound=0;

    public boolean getResult(){
        return this.result;
    }
    private void setResult(boolean x){
        this.result = x;
    }

    public CatchGUI(int attckRound){
        this.attackRound = attackRound;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("fight stage");
        frame.setSize(605, 638);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        PicAndGif g = new PicAndGif();

        Container field = getContentPane();
        ImageIcon p1 = new ImageIcon(g.getPicAndGif(13));
        JLabel background = new JLabel(p1);

        ImageIcon p2 = new ImageIcon(g.getPicAndGif(2));
        JLabel bg1 = new JLabel(p2);
        bg1.setBounds(120, 20, 176, 176);


        frame.setVisible(true);

    }



}






