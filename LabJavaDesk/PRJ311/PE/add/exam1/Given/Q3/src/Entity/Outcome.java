
package Entity;

public class Outcome {
        String shipName, battleName, result;

    public Outcome() {
    }

    public Outcome(String shipName, String battleName, String result) {
        this.shipName = shipName;
        this.battleName = battleName;
        this.result = result;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getBattleName() {
        return battleName;
    }

    public void setBattleName(String battleName) {
        this.battleName = battleName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return shipName;
    }
        
}
