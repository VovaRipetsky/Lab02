package vova;

public class BattleDroid implements Droid {

    private String name;
    private int hpLevel = 100;
    private int mpLevel = 100;
    private int dmgLevel;

    public BattleDroid(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHpLevel() {
        return hpLevel;
    }

    public void setHpLevel(int hpLevel) {
        this.hpLevel = hpLevel;
    }

    public int getMpLevel() {
        return mpLevel;
    }

    public void setMpLevel(int mpLevel) {
        this.mpLevel = mpLevel;
    }

    public int Strike(int dmg, BattleDroid droid){
        this.dmgLevel = dmg;
        droid.setHpLevel(droid.getHpLevel() - this.dmgLevel);
        System.out.println(droid.getName() + " Current HP: " + droid.getHpLevel() + "    Current MP: " + droid.getMpLevel() + "      Attack was completed with DMG : " + dmgLevel);

        return this.dmgLevel;
    }

    public int getDmgLevel(){
        return dmgLevel;
    }

    public void Charging(BattleDroid droid){
        if(droid.getMpLevel() >70 ){
            System.out.println(droid.getName() + " is Charging (+30MP)");
            droid.setMpLevel(100);

        }

        else {
        System.out.println(droid.getName() + " is Charging (+30MP)");
        droid.setMpLevel(getMpLevel() + 30);

        }
        System.out.println(droid.getName() + " Current MP level: " + droid.getMpLevel());
    }

    public void Repair(BattleDroid droid){
        if(getMpLevel()<30){
            System.out.println("Not enough Energy");
        } else if (droid.getHpLevel() > 70){
            droid.setHpLevel(100);

        }
            else {
            System.out.println(droid.getName() + " is Repairing (+30HP)(-30MP)");
            droid.setHpLevel(droid.getHpLevel() + 30);
            droid.setMpLevel(droid.getMpLevel() - 30);
        }
        System.out.println(droid.getName() + " Current MP level: " + droid.getMpLevel() + " Current HP level: " + droid.getHpLevel());
    }

    public void laserAttack(BattleDroid droid1, BattleDroid droid2){
        if(droid1.getMpLevel()<50){
            System.out.println("Not enough Energy");
        } else {
            droid2.setHpLevel(droid2.getHpLevel() - 40);
            droid1.setMpLevel(droid1.getMpLevel() - 50);
            System.out.println("Laser attack is completed (-40HP), " + droid2.getName() + "Current HP: " + droid2.getHpLevel());
            System.out.println(droid1.getName() + " current MP: " +  droid1.getMpLevel());
            System.out.println();
        }

    }


}