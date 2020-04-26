import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PickballGUI extends JFrame
{
    private int pokeballIndex=-1;
    private String cmd="open";
    private static final long serialVersionUID = 1L;

    public int getPokeballIndex(){
        return this.pokeballIndex;
    }
    private void setPokeballIndex(int i){
        this.pokeballIndex = i;
    }
    public String getCmd(){
        return this.cmd;
    }
    private void setCmdClose(){
        this.cmd = "close";
    }

    public PickballGUI(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("pokemon game");
        frame.setResizable(false);
        frame.setSize(400,200);
        //frame.setLocationRelativeTo(null);
        PicAndGif g = new PicAndGif();

        final JPanel comboPanel = new JPanel();
        JLabel headTEXT = new JLabel(" Choose your first Pokemon. ");
        comboPanel.add(headTEXT);
        
        ImageIcon Icon = new ImageIcon(g.getPicAndGif(26));
        JButton p1 = new JButton();
        JButton p2 = new JButton();
        JButton p3 = new JButton();
        p1.setIcon(Icon);
        p2.setIcon(Icon);
        p3.setIcon(Icon);

        frame.getContentPane().add(BorderLayout.NORTH, comboPanel);
        frame.getContentPane().add(BorderLayout.EAST, p1);
        frame.getContentPane().add(BorderLayout.CENTER, p2);
        frame.getContentPane().add(BorderLayout.WEST, p3);
        frame.setVisible(true);

        p1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane ms = new JOptionPane();
                JOptionPane.showMessageDialog ( ms, "Your first pokemon is Pickachu." );
                setPokeballIndex(3);
                setCmdClose();
                frame.setVisible(false);
            }
        });

        p2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane ms = new JOptionPane();
                JOptionPane.showMessageDialog ( ms, "Your first pokemon is Charmander." );
                setPokeballIndex(2);
                setCmdClose();
                frame.setVisible(false);
            }
        });

        p3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane ms = new JOptionPane();
                JOptionPane.showMessageDialog ( ms, "Your first pokemon is Squirtle." );
                setPokeballIndex(1);
                setCmdClose();
                frame.setVisible(false);
            }
        });

    }

}
