package dice;

public class Dice {

	private int faceValue;

	// Roll the dices	
	public void roll() {
		faceValue = (int)(Math.random()*6+1);
	}

	//Compare faceValue
	public boolean isEqual(Dice d) {
		if(d.getFaceValue()==this.faceValue){
			return true;
		}
		else {
			return false;
		}
	}



	//Getters and settes
	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}


}
