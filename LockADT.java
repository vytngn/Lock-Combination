/**VY NGUYEN
 * CSC 263-IN 
 * LAB 2 ADTS - LOCK COMBINATION 
 */
public abstract interface LockADT{
	
	//sets 1st number of lock
	//Precondition: newX is between 0-39 inclusive
	public void setX(int newX) throws Exception;

	
	//sets 2nd number of lock
	//Precondition: newY is between 0-39 inclusive
	public void setY(int newY) throws Exception;

	
	//sets 3rd number of lock
	//Precondition: newZ is between 0-39 inclusive
	public void setZ(int newZ)throws Exception;
	
	//alter combo of lock
	//Precondition: newX, newY, and newZ are between 0-39 inclusive
	public void alter(int newX, int newY, int newZ) throws Exception;
	

	//turn the clock to the attemptNum while show each number the lock is dialing 
	//Precondition: attemptNum is between 0-39 inclusive
	public int turn(String direction, int attemptNum) throws Exception;

	//close the lock
	public void close();
	public void open();
	
	//attempt to open the lock
	//Precondition: x, y, z are between 0-39 inclusive 
	public void attempt(int x, int y, int z) throws Exception;
	
	//check whether lock is close
	public void inquire();
	
	//check what the number the dial is at currently
	public int getTopPosition();
	
	//return the description of the lock 
	public String toString();
	
}