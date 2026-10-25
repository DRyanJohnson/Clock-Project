/**
*TCSS 305 ~ Fall Quarter 2026
* assignment Clock
* represents a clock that tracks the time hrs,mins,secs
*
* @author Dakota Johnson
 */


public class Clock implements Comparable<Clock> {

    //hr component of the clock
    private int myHour;

    //minute of the clock
    private int myMinute;

    //seconds of the clock
    private int mySecond;

    /*the initialization of the clock
     *
     * @param theHour initial hr.
     * @param theMinute initial min.
     * @param theSecond initial sec.
     */

    public Clock(final int theHour, final int theMinute, final int theSecond) {
        setHour(theHour);
        setMinute(theMinute);
        setSecond(theSecond);
    }

    // compare clocks against each-other
    public int compareTo(final Clock theOtherClock) {
int result = Integer.compare(this.myHour, theOtherClock.myHour);
        if (result == 0){
            result = Integer.compare(this.myMinute, theOtherClock.myMinute);
        }
        if(result == 0){
            result = Integer.compare(this.mySecond, theOtherClock.mySecond);
        }
        return result;
    }

    public boolean equals(final Object theObject) {
        if (this == theObject) {
            return true;
        }
        if (theObject == null || getClass() != theObject.getClass()) {
            return false;
        }
        Clock otherClock = (Clock) theObject;
        return compareTo(otherClock) == 0;
    }

    //Default clock beginning

    public Clock() {
        this(23, 58, 0);
    }

    // gets current hr while returning
    public int getHour() {
        return myHour;
    }

    //gets current minute while returning
    public int getMinute() {

        return myMinute;
    }

    //gets current second while returning
    public int getSecond() {

        return mySecond;
    }


    public String toString() {
        return myHour + ":" + myMinute + ":" + mySecond;
    }

    //sets the hr component of clock
    //checks if time is outside of what our rule is
    public void setHour(final int theHour) {
        if (theHour < 0 || theHour > 23) {
            throw new IllegalArgumentException("Hour out of range [0-23]:" + theHour);
        }
        myHour = theHour;
    }

    public void setMinute(final int theMinute) {
        if (theMinute < 0 || theMinute > 59) {
            throw new IllegalArgumentException("Minute out of range [0-59]:" + theMinute);
        }
        myMinute = theMinute;
    }

    public void setSecond(final int theSecond) {
        if (theSecond < 0 || theSecond > 59) {
            throw new IllegalArgumentException("Second out of range [0-59]:" + theSecond);
        }
        mySecond = theSecond;
    }

    //advances current time by the specified amount
    public void advanceHour(final int theAmount) {
        if (theAmount < 0) {
            throw new IllegalArgumentException("Advance amount can not be negative:" + theAmount);
        }
        myHour = (myHour + theAmount) % 24;
    }

    public void advanceMinute(final int theAmount) {
        if (theAmount < 0) {
            throw new IllegalArgumentException("Advance amount  can not be negative:" + theAmount);
        }
        int totalMinutes = myMinute + theAmount;
        myMinute = totalMinutes % 60;
        advanceHour(totalMinutes / 60);
    }
}