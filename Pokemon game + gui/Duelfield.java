import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Duelfield extends JFrame{

    private String cmd = "";
    private JLabel pLabel = new JLabel();
    private JLabel eLabel = new JLabel();
    private JLabel pHP = new JLabel();
    private JLabel eHP = new JLabel();
    private int eDead=0;
    private int pDead=0;
    private static final long serialVersionUID = 1L;

    public void setAlreadyDead(int c){
        if(c == 1)
            this.eDead = c;
        else
            this.pDead = -1;
    }
    public int getAlreadyDead(){
        if(eDead == 1 && pDead == 0)
            return 1;
        else if(pDead == -1 && eDead == 0)
            return -1;
        else
            return 0;
    }
    public void setCmd(String cmd){
        this.cmd = cmd;
    }
    public String getCmd(){
        return this.cmd;
    }
    
    public Duelfield(Pokemon p, Pokemon e){
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
        }else if(p.toString().equals("Charmander")){
            pPic = new ImageIcon(g.getPicAndGif(16));
            pLabel.setIcon(pPic);
        }else if(p.toString().equals("Squirtle")){
            pPic = new ImageIcon(g.getPicAndGif(18));
            pLabel.setIcon(pPic);
        }else{
            pPic = new ImageIcon(g.getPicAndGif(20));
            pLabel.setIcon(pPic);
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

        JToggleButton atk = new JToggleButton(" Attack ");
        atk.setBounds(750, 630, 100, 50);
        atk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent){

                if(atk.isSelected() && !atk.getText().equals("finish duel")){
                    p.getAttack(e.attack());
                    System.out.println("Your Pokemon hp = "+p.getHPtoString());
                    if(getAlreadyDead() == -1)
                        atk.doClick();
                    else
                        e_Reface(pLabel, frame);
                //------------------------------------------------------------------------------

                    if(percentHp(p) > 80){
                        p_getHitface(eLabel, frame, 22, p);
                    }
                    else if(percentHp(p) > 50 && percentHp(p) <= 80){
                        p_getHitface(eLabel, frame, 23, p);
                    }
                    else if(percentHp(p) > 0 && percentHp(p) <= 50){
                        p_getHitface(eLabel, frame, 24, p);
                    }
                    else if(percentHp(p) <= 0){
                        p_deadFace(eLabel, frame, p);
                        atk.setText("finish duel");
                        setAlreadyDead(-1);
                    }
                    else{
                        System.out.println("cmd is close");
                        setCmd("close");
                        frame.setVisible(false);
                    }
                    
                }else if(!atk.isSelected() && !atk.getText().equals("finish duel")){
                    e.getAttack(p.attack());
                    System.out.println("Enemy hp = "+ e.getHPtoString());
                    if(getAlreadyDead() == 1)
                        atk.doClick();
                    else
                        p_Reface(pLabel, frame, p);
                //----------------------------------------------------------------------

                    if(percentHp(e) > 80){
                        e_getHitface(eLabel, frame, 22);
                    }
                    else if(percentHp(e) > 50 && percentHp(e) <= 80){
                        e_getHitface(eLabel, frame, 23);
                    }
                    else if(percentHp(e) > 0 && percentHp(e) <= 50){
                        e_getHitface(eLabel, frame, 24);
                    }
                    else if(percentHp(e) <= 0){
                        e_deadFace(eLabel, frame);
                        atk.setText("finish duel");
                        setAlreadyDead(1);
                    }
                    else{
                        System.out.println("cmd is close");
                        setCmd("close");
                        frame.setVisible(false);
                    }

                    
                }else{
                    System.out.println("cmd is close with alrdead");
                    setCmd("close");
                    frame.setVisible(false);
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
    public float percentHp(Pokemon p){
        return (float)(((float)p.getHP()/(float)p.getoHP())*100);
    }
    public void p_Reface(JLabel p, JFrame frame, Pokemon pR){
        PicAndGif g = new PicAndGif();
        ImageIcon pPic;
        if(pR.toString().equals("Pickachu")){
            pPic = new ImageIcon(g.getPicAndGif(14));
        }else if(pR.toString().equals("Charmander")){
            pPic = new ImageIcon(g.getPicAndGif(16));
        }else if(pR.toString().equals("Squirtle")){
            pPic = new ImageIcon(g.getPicAndGif(18));
        }else{
            pPic = new ImageIcon(g.getPicAndGif(20));
        }
        pLabel.setIcon(pPic);
        SwingUtilities.updateComponentTreeUI(frame);
    }
    public void p_getHitface(JLabel p, JFrame frame, int i,Pokemon pG){
        PicAndGif g = new PicAndGif();
        ImageIcon pPic;
        ImageIcon pPicf;
        if(pG.toString().equals("Pickachu")){
            pPic = new ImageIcon(g.getPicAndGif(15));
            pPicf = new ImageIcon(g.getPicAndGif(i));
        }
        else if(pG.toString().equals("Charmander")){
            pPic = new ImageIcon(g.getPicAndGif(17));
            pPicf = new ImageIcon(g.getPicAndGif(i));
        }
        else if(pG.toString().equals("Squirtle")){
            pPic = new ImageIcon(g.getPicAndGif(19));
            pPicf = new ImageIcon(g.getPicAndGif(i));
        }
        else{
            pPic = new ImageIcon(g.getPicAndGif(21));
            pPicf = new ImageIcon(g.getPicAndGif(i));
        }
        pLabel.setIcon(pPic);
        pHP.setIcon(pPicf);
        SwingUtilities.updateComponentTreeUI(frame);
    }
    public void p_deadFace(JLabel p, JFrame frame, Pokemon pD){
        PicAndGif g = new PicAndGif();
        ImageIcon pPic;
        ImageIcon pPicf = new ImageIcon(g.getPicAndGif(25));
        if(pD.toString().equals("Pickachu")){
            pPic = new ImageIcon(g.getPicAndGif(27));
        }
        else if(pD.toString().equals("Charmander")){
            pPic = new ImageIcon(g.getPicAndGif(28));
        }
        else if(pD.toString().equals("Squirtle")){
            pPic = new ImageIcon(g.getPicAndGif(29));
        }
        else{
            pPic = new ImageIcon(g.getPicAndGif(30));
        }
        pLabel.setIcon(pPic);
        pHP.setIcon(pPicf);
        SwingUtilities.updateComponentTreeUI(frame);
    }
    public void e_Reface(JLabel e, JFrame frame){
        PicAndGif g = new PicAndGif();
        ImageIcon well = new ImageIcon(g.getPicAndGif(20));
        eLabel.setIcon(well);
        SwingUtilities.updateComponentTreeUI(frame);
    }
    public void e_getHitface(JLabel e, JFrame frame, int i){
        PicAndGif g = new PicAndGif();
        ImageIcon img = new ImageIcon(g.getPicAndGif(i));
        ImageIcon imgf = new ImageIcon(g.getPicAndGif(21));
        eLabel.setIcon(imgf);
        eHP.setIcon(img);
        SwingUtilities.updateComponentTreeUI(frame);
    }
    public void e_deadFace(JLabel e, JFrame frame){
        PicAndGif g = new PicAndGif();
        ImageIcon img = new ImageIcon(g.getPicAndGif(25));
        ImageIcon imgf = new ImageIcon(g.getPicAndGif(30));
        eLabel.setIcon(imgf);
        eHP.setIcon(img);
        SwingUtilities.updateComponentTreeUI(frame);
    }
    
    public void delay(int i){
        try{
            Thread.sleep(i);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
    
}
