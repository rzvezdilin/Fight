class Players {
    private int health;
    private int damage;
    private String[] bodyParts = new String[5];

    public Players() {
        this.health = 100;
        this.bodyParts = new String[] {"Голову", "Грудь", "Живот", "Пах", "Ноги"};
        this.damage = 0;
    }

    public int hitMarkers(int hit) {
        if(bodyParts[hit] == "Голову") {
            this.damage = 25;
        } else if(bodyParts[hit] == "Грудь") {
            this.damage = 20;
        } else if(bodyParts[hit] == "Живот") {
            this.damage = 15;
        } else if(bodyParts[hit] == "Пах") {
            this.damage = 10;
        } else {
            this.damage = 5;
        }
        return this.damage;
    }

    public int getHealth() {
        return health;
    }

    public String[] getBodyParts() {
        return bodyParts;
    }
}