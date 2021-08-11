class Monster extends Players{
    private int monsterHit;
    
    public Monster() {
        super();
    }

    public int monsterHit() {
        String[] hits = getBodyParts();
        this.monsterHit = (int)(Math.random()*hits.length);
        return this.monsterHit;
    }

    public int monsterDamage() { 
        int monsterDamage = hitMarkers(this.monsterHit);
        return monsterDamage;
    }

    public int monsterBlock() {
        String[] blocks = getBodyParts();
        int monsterBlock = (int)(Math.random()*blocks.length);
        return monsterBlock;
    }
}