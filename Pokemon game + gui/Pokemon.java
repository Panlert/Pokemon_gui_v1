public abstract class Pokemon{
    
    private String name;
    private int lv,HP,MP,atkDMG,exp;
    private int olv,oHP,oMP,oatkDMG,oExp;
    
    public Pokemon(String name){
        this.name = name;
        lv = 1;
        exp = 0;
    }
    public Pokemon(){

    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public String toString(){
        return this.name+"";
    }
    public void setStatus(int HP, int MP, int atkDMG){
        this.HP = HP;
        this.MP = MP;
        this.atkDMG = atkDMG;
        statusSAVE();
    }
    public void loseExp(int exp){
        this.exp -= exp;
        if(this.exp < 0 && this.lv == 1)
            this.exp += exp;
        
        statusSAVE();
    }
    public int getExp(){
        return this.exp;
    }
    public int getHP(){
        return this.HP;
    }
    public String getHPtoString(){
        return ""+HP;
    }
    public int getMP(){
        return this.MP;
    }
    public int getAtkDMG(){
        return this.atkDMG;
    }
    public String toStringStatus(){
        return "Your "+this.name+"\nHP= "+this.HP+"\nMP= "+this.MP+"\nAttackDamage= "+this.atkDMG+"\nExp= "+this.exp+"%\n LV= "+this.lv+"\n";
    }
    public void lvUp(int exp){
        this.exp += exp;
        int i = exp/100;
        if(i >= 1){
            for(int j=0;j<i;j++){
                this.HP += 10;
                this.MP += 10;
                this.atkDMG += 10;                 
                this.lv++;
                this.exp -= 100;
            }
            System.out.println("exp = "+exp);
            statusSAVE();
        }else{
            System.out.println("exp incread");
        }
    }
    public int attack(){
        this.MP-=5;
        if(this.MP > 40)
            return atkDMG;
        else if(this.MP > 0 && this.MP < 40)
            return atkDMG-10;
        else
            return 0;
    }
    public String getAttack(int dmg){
        if(HP <= 0)
            return "zeroHP";
        else{
            this.HP -= dmg;
            return "";
        }
    }
    public void statusSAVE(){
        this.olv = this.lv;
        this.oHP = this.HP;
        this.oMP = this.MP;
        this.oatkDMG = this.atkDMG;
        this.oExp = this.exp;
    }
    public int getoHP(){
        return this.oHP;
    }
    public int getoMP(){
        return this.oMP;
    }
    public int getoAtkDmg(){
        return this.oatkDMG;
    }
    public int getoLv(){
        return this.olv;
    }
    public int getoExp(){
        return this.oExp;
    }
}