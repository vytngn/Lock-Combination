/**VY NGUYEN
 * CSC 263-IN 
 * LAB 2 ADTS - LOCK COMBINATION 
 */

/**Lock Data Structure class**/

public abstract class LockDataStructure implements LockADT{
	
	/**Data fields**/
	//integers x,y,z store the three digits of the combination 
	private int x,y,z;
	
	//store the status of the lock: closed(true), open(false) 
	private boolean isLocked;
	
	//the currrent number the dial points to 
	private int topPosition;
	

	/**Constructors**/
	//default constructor
	public LockDataStructure(){
	 this(0,0,0);
	
	}
	//overloaded constructor 
	public LockDataStructure(int x, int y, int z){
	  this.x = x;
	  this.y = y;
	  this.z = z;
	}
	//copy constructor 
	public LockDataStructure(LockDataStructure lock){
	  this.x = lock.x;
	  this.y = lock.y;
	  this.z = lock.z;
	  this.topPosition = lock.topPosition;
	  this.isLocked = lock.isLocked;
	}

	/** Methods **/ 
	/**Mutator method**/
	//set x
	@Override
	public void setX(int x)throws Exception{
		if (x<0 || x >39) throw new Exception("Invalid input. Enter a number between 0-39.");
		else
			this.x = x;
	}
	//set y
	@Override
	public void setY(int y) throws Exception{
		if (y<0 || y >39) throw new Exception("Invalid input. Enter a number between 0-39.");
		else
			this.y = y;
	}
	//set Z
	@Override
	public void setZ(int z) throws Exception{
		if (z<0 || z >39) throw new Exception("Invalid input. Enter a number between 0-39.");
		else
			this.z = z;
	}
	/**Accessor method**/ 
	//get x 
	public int getX() {
		return x;
	}
	//get y
	public int getY() {
		return y;
	}
	// get z
	public int getZ() {
		return z;
	}
	
	//set new combination for the lock 
	@Override
	public void alter(int newX, int newY, int newZ) throws Exception{
	  setX(newX);
	  setY(newY);
	  setZ(newZ);
	}
	
	/**Methods for closing the lock and opening the lock**/
	//close the lock
	@Override
	public void close(){
	  isLocked = true;
	}
	//open the lock 
	public void open(){
	  isLocked = false;
	}
	
	@Override
	//return the current dial poiting at 
	public int getTopPosition() {
		return this.topPosition;
	}
	
	/**Method for turning the lock**/
	//use for loops to show the dial turning
	//throw exception if the number entered is not between 0-39 
	public int turn(String direction, int attemptNum) throws Exception{
		if (attemptNum<0 || attemptNum >39) throw new Exception("Invalid input. Enter a number between 0-39.");
		
		//use switch for first clockwise, clockwise, second clockwise 
		switch(direction) {
		//case 1 
		case "First clockwise": 
        	int current=topPosition;
			for(int i=0;i<40+(40+current-attemptNum+1);i++){
				if (topPosition==-1)
					topPosition=39;
				if (topPosition== 40)
					topPosition=0;
				System.out.print(topPosition-- + " ");
			}
			topPosition++; 
			break;
		
		//case 2
		case "Counterclockwise":
        	int current1=topPosition;
			if(attemptNum<current1){	
				for(int i=0;i<40+(40+attemptNum-current1+1);i++){
					if (topPosition==-1)
						topPosition=39;
					if (topPosition== 40)
						topPosition=0;
					System.out.print(topPosition++ + " ");
				}
			}
			if(attemptNum>=current1){
				for(int i=0;i<40+(attemptNum-current1+1);i++){
					if (topPosition==-1)
						topPosition=39;
					if (topPosition== 40)
						topPosition=0;
					System.out.print(topPosition++ + " ");
				}
			topPosition--;
			} break;
			
		//case 3	
		case "Second clockwise": 
			int current11=topPosition;
			if(attemptNum<current11){	
				for(int i=0;i<(current11)-attemptNum+1;i++){
					if (topPosition==-1)
						topPosition=39;
					if (topPosition== 40)
						topPosition=0;
					System.out.print(topPosition-- + " ");
				}
			}
			if(attemptNum>=current11){	
				for(int i=0;i<current11+(40-attemptNum+1);i++){
					if (topPosition==-1)
						topPosition=39;
					if (topPosition== 40)
						topPosition=0;
					System.out.print(topPosition-- + " ");
				}
			//has to position++ after for loop because of post processing with position-- from print
			topPosition++;
			} break;
			default: System.out.println("invalid direction");
		}
		topPosition= attemptNum;
		return attemptNum;  
	}//end turn method 

	
	@Override
	public void attempt(int x, int y, int z) throws Exception {
		
		//first clockwise for x
		System.out.print("\nFirst Number(" + x + "):");
		int first= turn("First clockwise", x);
		
		//counterclockwise for y 
		System.out.print("\nSecond("+ y +"): ");
		int second = turn("Counterclockwise",y);
		
		//second clockwise for z
		System.out.print("\nThird("+ z +"): ");
		int third = turn("Second clockwise",z);
		
		if ( first == x && second ==y && third ==z) {
			open();
			System.out.println("\nSucessfully unlocked!");
		}else {
			close();
			System.out.println("\nWrong combination numbers.Try again.");
		}
		
	}//end method 

	@Override
	//return the state of the lock 
	public void inquire(){
		if(isLocked)
			System.out.println("The lock is currently closed");
		if(isLocked==false)
			System.out.println("The lock is currently open");
	}

	// toString describes the object 
	@Override
	public String toString() {
		return "The current lock combination is: " + x + " - " + y + " - " + z;
    }
	
	
	
	
}
