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
        return this.name;
    }
    public void setStatus(int HP, int MP, int atkDMG){
        this.HP = HP;
        this.MP = MP;
        this.atkDMG = atkDMG;
        statusSAVE();
    }
    public void loseExp(int exp){
        this.exp -= exp;
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
        return "Your "+name+"\nHP= "+HP+"\nMP= "+MP+"\nAttackDamage= "+atkDMG+"\nExp= "+exp+"%\n LV= "+lv+"\n";
       /* System.out.println("Your "+name+" lv up!");
        System.out.println("    HP= "+HP);
        System.out.println("    MP= "+MP);
        System.out.println("    AttackDamage= "+atkDMG);
        System.out.println("    Exp= "+exp+"%");
        System.out.println("    LV= "+lv);*/
    }
    public void lvUp(int exp){
        this.exp += exp;
        if(exp >= 100){
            HP += 10;
            MP += 10;
            atkDMG += 10;
            lv++;
            toStringStatus();
            statusSAVE();
        }
        this.exp -= 100;
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