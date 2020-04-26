import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Findpokemon extends JFrame{
    private String cmd="open";
    private static final long serialVersionUID = 1L;

    public String getCmd(){
        return this.cmd;
    }
    private void setCmdClose(){
        this.cmd = "close";
    }

    public Findpokemon(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(" Searching... ");
        frame.setSize(426, 320);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        PicAndGif g = new PicAndGif();

        Container field = getContentPane();
        ImageIcon p1 = new ImageIcon(g.getPicAndGif(10));
        JLabel background = new JLabel(p1);

        ImageIcon p2 = new ImageIcon(g.getPicAndGif(9));
        JLabel bg1 = new JLabel(p2);
        bg1.setBounds(120, 20, 176, 176);

        JButton confirm = new JButton("Continue");
        confirm.setBounds(150, 230, 110, 40);
        confirm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setCmdClose();
                frame.setVisible(false);
            }
        });

    /*    JButton close= new JButton("Exit");
        close.setBounds(210, 230, 110, 40);
        close.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setCmdClose();
                frame.setVisible(false);
            }
        });*/
        
        background.add(bg1);
        background.add(confirm);
        field.add(background);
        frame.add(field);

        frame.setVisible(true);
        //pack();
    }

}