import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Fermi{

	private Set<String> numberArray;
	private Random randNum;
	private List<String> numberStrList;
	private String hint;
	
	public Fermi() {
		numberArray = new LinkedHashSet<String>();
		randNum = new Random();
		numberStrList = new ArrayList<>();
		hint = "";
	}
	
	public String getHint() {
		return hint;
	}

	public List<String> getRandomNumberList() {
		return numberStrList;
	}
	
	// 
	public List<String> setRandomNumList(int num, int max, int min) {
		// LinkedHashSet will check whether the element exist or not
		numberArray = new LinkedHashSet<String>();
		randNum = new Random();
	    while (numberArray.size() < num) {
	    	numberArray.add((Integer.toString(randNum.nextInt(max) + min)));
	    }
	    numberStrList = new ArrayList<>(numberArray);
	    return numberStrList;
    }
	
	public String generateHint(String[] inputArray, List<String> numberStrList) {
		hint = "";
		for (int i = 0; i < 3; i++) {
    		if ((numberStrList.get(i)).equals(inputArray[i])) {
    			hint = hint + "Fermi" + " ";
    			// do the validation for duplicate input 
    			if (inputArray[i] == inputArray[1]) {
    				if (inputArray[i].equals(inputArray[i-1])) {
    					inputArray[i-1] = "duplicate";
    				}
    				if (inputArray[i].equals(inputArray[i+1])) {
    					inputArray[i+1] = "duplicate";
    				}
    			}
				else if (inputArray[i] == inputArray[0]) {
    				if (inputArray[i].equals(inputArray[i+1])) {
    					inputArray[i+1] = "duplicate";
    				}
    				if (inputArray[i].equals(inputArray[i+2])) {
    					inputArray[i+2] = "duplicate";
    				}
				}
			
				else if (inputArray[i] == inputArray[2]) {
    				if (inputArray[i].equals(inputArray[i-1])) {
    					inputArray[i-1] = "duplicate";
    				}
    				if (inputArray[i].equals(inputArray[i-2])) {
    					inputArray[i-2] = "duplicate";
    				}
				}
    		}
    	}
    	
    	for (int j = 0; j < 3; j++) {
    		if (!((numberStrList.get(j)).equals(inputArray[j])) && 
    				numberStrList.contains(inputArray[j]) ) {
    			hint = hint + "Pico" + " ";	
    			// do the validation for duplicate input 
    			if (inputArray[j] == inputArray[1]) {
    				if (inputArray[j].equals(inputArray[j-1])) {
    					inputArray[j-1] = "duplicate";
    				}
    				if (inputArray[j].equals(inputArray[j+1])) {
    					inputArray[j+1] = "duplicate";
    				}
    			}
				else if (inputArray[j] == inputArray[0]) {
    				if (inputArray[j].equals(inputArray[j+1])) {
    					inputArray[j+1] = "duplicate";
    				}
    				if (inputArray[j].equals(inputArray[j+2])) {
    					inputArray[j+2] = "duplicate";
    				}
				}
			
				else if (inputArray[j] == inputArray[2]) {
    				if (inputArray[j].equals(inputArray[j-1])) {
    					inputArray[j-1] = "duplicate";
    				}
    				if (inputArray[j].equals(inputArray[j-2])) {
    					inputArray[j-2] = "duplicate";
    				}
				}
        	}
    	}

    	for (int k = 0; k < 3; k++) {
    		if (!(numberStrList.contains(inputArray[k])) == true && !((numberStrList.get(k)).equals(inputArray[k])) ){
    			hint = hint + "Nano" + " ";
        	}
    	}
    	
    	return hint;
	}
	
	
	

}
