/**
*   Compute displacement of a body.
*   Print out the displacement correct to 2 decimal places
**/

public class GravityCalculator {
    public static void main(String[] args) {
        double gravity = -9.81; // Earth's gravity in m/s^2
        double initialVelocity = 0.0;
        double fallingTime = 10.0;
        double initialPosition = 0.0;
        double finalPosition = 0.5 * gravity * fallingTime * fallingTime + initialPosition + initialVelocity * fallingTime;
        System.out.printf("The objects position after %.0f seconds is %.2f m.",
        fallingTime, finalPosition);
    }
}
