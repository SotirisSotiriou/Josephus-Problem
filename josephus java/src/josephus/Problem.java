package josephus;

public class Problem {
	private int firstkiller;
	private int jump;
	private int[] soldiers; //if soldiers[i] is equal to 1, soldier in this place is alive
	
	public Problem(int firstkiller, int jump, int numberOfSoldiers) {
		this.firstkiller = firstkiller;
		this.jump = jump;
		this.soldiers = new int[numberOfSoldiers];
		for(int i=0; i<numberOfSoldiers; i++) {
			this.soldiers[i] = 1;
		}
	}

	public int getFirstkiller() {
		return firstkiller;
	}

	public int getJump() {
		return jump;
	}

	public int[] getSoldiers() {
		return soldiers;
	}
	
	public int solve() {
		int joseph = -1;
		int found = -1;
		int[] copy = soldiers;
		int killer = firstkiller;
		int lastdeath = kill(firstkiller, copy);
		killer = getNextKiller(lastdeath, copy);
		
		do {
			lastdeath = kill(killer, copy);
			killer = getNextKiller(lastdeath, copy);
			found = josephFound(copy);
		} while(found == -1);
		
		joseph = found;
		
		return joseph;
	}
	
	private int josephFound(int[] table) {
		int count = 0;
		int index = -1;
		for(int i=0; i<table.length; i++) {
			if(table[i] == 1) {
				count++;
				index = i;
			}
			if(count > 1) return -1;
			else continue;
		}
		if(count == 1) return index;
		else return -1;
	}
	
	
	//returns the dead soldier
	private int kill(int killer, int[] table) {
		int count = 0;
		int i = killer+1;
		int index = -1;
		while(true) {
			index = i%table.length;
			if(table[index] == 1) {
				count++;
				if(count==jump) {
					table[index] = 0;
					return index;
				}
			}
			i++;
		}
	}
	
	private int getNextKiller(int lastdeath, int[] table) {
		int i = lastdeath+1;
		while(true) {
			int index = i%table.length;
			if(table[index] == 1) return index;
			i++;
		}
	}
}
