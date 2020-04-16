public class PokemonB extends Pokemon{
    private int exp=50;
    public PokemonB(){
        super("");
        setStatus(120, 100, 30);
    }
    public int getExp(){
        return exp;
    }
}