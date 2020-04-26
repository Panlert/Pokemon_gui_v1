import javax.swing.*;

public class Trainner extends JFrame{
    private BagGUI bag;
    private static final long serialVersionUID = 1L;
    
    public Trainner(){
        this.bag = new BagGUI();
        bag.add(getfirstPOKEMON());
        System.out.println("play");
        play();
    }
    public void setPokeball(Pokemon p){
        bag.add(p);
    }
    
    private void openBag(String cmd){
        bag.openBagGUI(cmd);
    }
    
    private Pokemon getfirstPOKEMON(){
        Pokemon p=null;
        PickballGUI g = new PickballGUI();
        while(!(g.getCmd().equals("close"))){
            System.out.println(g.getCmd());
            delay(2000);
            if(g.getPokeballIndex() == 1 && g.getCmd().equals("close")){
                p = new Charmander("Squirtle");
            }else if(g.getPokeballIndex() == 2 && g.getCmd().equals("close")){
                p = new Squirtle("Charmander");
            }else if(g.getPokeballIndex() == 3 && g.getCmd().equals("close")){
                p = new Pickachu("Pickachu");
            }
        }
        System.out.println(g.getCmd());
        System.out.println(p.toString());
        return p;
    }
    
    public void play(){
        String cmd = "";
        String bagCmd = "";
        GameGUI play = new GameGUI();
        cmd = play.getCmd();
        while(!(cmd.equals("quit"))){
            System.out.println("Frame playing.");
            delay(2000);
            cmd = play.getCmd();
            bagCmd = play.getBagCmd();

            if(bagCmd.equals("openbag")){
                play.setBagCmd("open");
                openBag("open");
            }

            if(cmd.equals("status")){
                choosePokeball(cmd);//.toStringStatus();
                cmd = play.resetCmd();
            }
            else if(cmd.equals("feed")){
                feed(choosePokeball(cmd));
                cmd = play.resetCmd();
            }
            else if(cmd.equals("findPokemon")){
                Pokemon e;
                JOptionPane ms = new JOptionPane();
                e = pokemonSURVAY();
                if(e!=null){
                    if(catchPokeball(e)){
                        if(bag.bagIsNotFull()){
                            e.setName(JOptionPane.showInputDialog( ms, "Enter your new pokemon name." ));
                            setPokeball(e);
                            cmd = play.resetCmd();
                        }
                        else{
                            JOptionPane.showMessageDialog(ms, "Your bag is full.");
                            cmd = play.resetCmd();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog ( ms, "Catch fail.\nYou lose." );
                        cmd = play.resetCmd();
                    }
                }
            }
            else{
                cmd = play.resetCmd();
            }
        }
        System.out.println("quit game");   
    }

    private Pokemon pokemonSURVAY(){
        Pokemon e;
        JOptionPane ms = new JOptionPane();
        Findpokemon f = new Findpokemon();
        int yN=-1;
        while(!(f.getCmd().equals("close"))){
            System.out.println("random...");
            delay(500);
        }
        if(Math.random() >= 0.5){
            e = new PokemonC();
        }
        else if (Math.random() >= 0.2 && Math.random() < 0.5){
            e = new PokemonB();
        }
        else{
            e = new PokemonA();
        }
            
        if(e.toString().equals("A")){
            yN = JOptionPane.showConfirmDialog ( ms, "Your found pokemon rank A.\nYou want to catch it?", "found it!", JOptionPane.YES_NO_OPTION );
            if(yN==0){
                JOptionPane.showMessageDialog ( ms, "Choose your pokeball." );
                return e;
            }
            else
                return null;
        }
        else if(e.toString().equals("B")){
            yN = JOptionPane.showConfirmDialog ( ms, "Your found pokemon rank B.\nYou want to catch it?", "found it!", JOptionPane.YES_NO_OPTION );
            if(yN==0){
                JOptionPane.showMessageDialog ( ms, "Choose your pokeball." );
                return e;
            }
            else 
                return null;   
        }
        else{
            if(JOptionPane.showConfirmDialog ( ms, "Your found pokemon rank C.\nYou want to catch it?", "found it!", JOptionPane.YES_NO_OPTION )==0){
                JOptionPane.showMessageDialog ( ms, "Choose your pokeball." );
                return e;
            }
            else 
                return null;
        }
    }
    
    private void feed(Pokemon p){
        if(p != null){
            JOptionPane ms = new JOptionPane();
            JOptionPane.showMessageDialog ( ms, "You choose "+p.toString()+".");
            System.out.println("Selected");
            int i=-1;
            try{
                i = Integer.parseInt(JOptionPane.showInputDialog( ms, "Enter the amount of berries"));
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(ms, "Pls Enter a number");
                i = Integer.parseInt(JOptionPane.showInputDialog( ms, "Enter the amount of berries"));
            }
            System.out.println("----------------  "+i+"  -------------");
            if( bag.useBerry(i) && i != 0 ){
                    System.out.println("---------*-------  "+i+"  ------*-------");
                    p.lvUp(100*i);
                    JOptionPane.showMessageDialog(ms, p.toStringStatus());
            }else{
                JOptionPane.showMessageDialog(ms, "Not enough berry.");
            }
        }
    }

    public boolean catchPokeball(Pokemon e){
        Pokemon p;
        p = choosePokeball("feed");
        return fight(p, e);
    }

    private Pokemon choosePokeball(String cmd){
        if(cmd.equals("feed"))
            bag.openBagGUI("");
        else
            bag.openBagGUI("open");

        while(!bag.getCmd().equals("close")){
            System.out.println("Selecting");
            delay(1000);
        }
        return bag.getChoose();
    }

    private boolean fight(Pokemon p, Pokemon e){
        String enemy="", player="";
        p.statusSAVE();
        e.statusSAVE();
        
        while(true){
            if(player.equals("zeroHP")){
                System.out.println("You lose");
                resetStatus(p);
                resetStatus(e);
                Duelfield d = new Duelfield(p, e);
                while(!(d.getCmd().equals("close"))){
                    System.out.println("fighting...");
                    delay(2000);
                }
                p.loseExp(e.getExp());
                resetStatus(p);
                resetStatus(e);
                
                return false;
            }
            else if(enemy.equals("zeroHP")){
                System.out.println("You win receive berry");
                bag.setBerry(1);
                resetStatus(p);
                resetStatus(e);
                Duelfield d = new Duelfield(p, e);
                p.lvUp(e.getExp());
                while(!(d.getCmd().equals("close"))){
                    System.out.println("fighting...");
                    delay(2000);
                }
                resetStatus(p);
                resetStatus(e);
                return true;
            }else{
                System.out.println("Enemy hp = "+ e.getHPtoString());
                enemy = e.getAttack(p.attack());
                System.out.println("Your Pokemon hp = "+p.getHPtoString());
                player = p.getAttack(e.attack());
            }
        }
    }

    private void resetStatus(Pokemon p){//after pokemon fight
        int HP=p.getoHP();
        int MP=p.getoMP();
        int Atk=p.getoAtkDmg();
        p.setStatus(HP, MP, Atk);
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
