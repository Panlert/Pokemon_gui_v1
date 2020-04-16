import java.util.ArrayList;
import java.util.Scanner;

public class Trainner{
    private ArrayList<Pokemon> pokeball;
    private Integer berry=0;
    private Scanner sc = new Scanner(System.in);
    
    public Trainner(){
        pokeball = new ArrayList<Pokemon>();
        //pokeball.add(getfirstPOKEMON(number));
    }
    public void setPokeball(Pokemon pokeball){
        this.pokeball.add(pokeball);
    }
    public ArrayList<Pokemon> getPokeball(){
        return pokeball;
    }

    /*public Pokemon getfirstPOKEMON(int number){
        Pokemon p;
        if(number == 1){
            p = new Charmander("Charmander");
            System.out.printf("   Your first pokemon is ");
            System.out.println(p.getName());
            return p;
        }else if(number == 2){
            p = new Squirtle("Squirtle");
            System.out.printf("   Your first pokemon is ");
            System.out.println(p.getName());
            return p;
        }else if(number == 3){
            p = new Pickachu("Pickachu");
            System.out.printf("   Your first pokemon is ");
            System.out.println(p.getName());
            return p;
        }else{
            System.out.printf("-----------No-choice------------\n");
            System.out.println("system give you a charmander");
            p = new Charmander("Charmander");
            return p;
        }
    }*/
    
    public void play(){
        String cmd = "";
        Pokemon e;
        do{
            System.out.println("--- findPokemon , feed , status, quit ---");
            System.out.print("enter command: ");
            cmd = sc.nextLine();
            if(cmd.equals("findPokemon")){
                e = pokemonSURVAY();
                cmd = sc.nextLine();
                if(cmd.equals("catch")){
                    Catch(e);
                }else if(cmd.equals("run")){
                    play();
                }else{
                    System.out.print("Command not found");
                }
                play();
            }
            else if(cmd.equals("feed")){
                feed(choosePokeball());
            }
            else if(cmd.equals("status")){
                choosePokeball().toStringStatus();
            }

        }while(!cmd.equals("quit"));
        System.out.println("quit game");    
        sc.close();
    }

    private Pokemon pokemonSURVAY(){
        Pokemon e;
        if(Math.random() >= 0.5){
            System.out.println("You found pokemon rank C\n");
            e = new PokemonC();
        }
        else if (Math.random() >= 0.2 && Math.random() < 0.5){
            System.out.println("You found pokemon rank B\n");
            e = new PokemonB();
        }
        else{
            System.out.println("You found pokemon rank A\n");
            e = new PokemonA();
        }
        System.out.printf("catch or run\n");
        return e;
    }
    private  void feed(Pokemon p){
        if(berry > 0){
            berry--;
            p.lvUp(100);
        }
        else
            System.out.println("Not enough berry");
    }

    private void Catch(Pokemon e){
        String name = "";
        if(fight(choosePokeball(), e)){
            System.out.println("receive a new pokemon");
            System.out.println("Enter the new pokemon name");
            name = sc.nextLine();
            e.setName(name);
            pokeball.add(e);
        }else{
            System.out.println("Catch fail");
        }
    }
    private Pokemon choosePokeball(){
        String name="";
        System.out.println("Choose your pokeball");
        for(Pokemon p: pokeball){
            System.out.println(p);
        }
        System.out.print("Enter pokemon name: ");
        name = sc.nextLine();
        for(Pokemon p: pokeball){
            if(name.equals(p.getName()))
                return p;
        }
        System.out.println("Pokeball not found");
        System.out.println("get the first one");
        return pokeball.get(0);
    }
    private boolean fight(Pokemon p, Pokemon e){
        String enemy="",player="";
        while(true){
            if(player.equals("zeroHP")){
                System.out.println("You lose");
                p.loseExp(e.getExp());
                resetStatus(p);
                resetStatus(e);
                return false;
            }
            else if(enemy.equals("zeroHP")){
                System.out.println("You win receive berry");
                this.berry++;
                resetStatus(p);
                resetStatus(e);
                p.lvUp(e.getExp());
                return true;
            }
            System.out.println("Enemy hp = "+ e.getHPtoString());
            enemy = e.getAttack(p.attack());
            System.out.println("Your Pokemon hp = "+p.getHPtoString());
            player = p.getAttack(e.attack());
        }
    }
    private void resetStatus(Pokemon p){//after pokemon fight
        int HP=p.getoHP();
        int MP=p.getoMP();
        int Atk=p.getoAtkDmg();
        p.setStatus(HP, MP, Atk);
    }

}
