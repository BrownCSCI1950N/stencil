package debugger;

import debugger.support.Display;

/**
 * Run this to display the debugger window
 */
public class Main {

    public static void main(String[] args) {
        // TODO: change the week number to one of { 2, 3, 5, 6 } to debug more things
        // You can also use the arrow keys left / right to cycle between weeks while running
        Display.setWeek(2);
        Display.main(args);
    }
}
