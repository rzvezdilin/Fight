class Warrior extends Players{
    
    public Warrior() {
        super();
    }

    public int warriorHit(int hit) { 
        int warriorHit = hit;
        return warriorHit-1;
    }

    public int warriorDamage(int damage) { 
        int hit = warriorHit(damage);
        int warriorDamage = hitMarkers(hit);
        return warriorDamage;
    }

    public int warriorBlock(int block) { 
        int warriorBlock = block;
        return warriorBlock-1;
    }    
}