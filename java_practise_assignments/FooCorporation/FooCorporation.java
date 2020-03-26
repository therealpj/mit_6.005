public class FooCorporation {

    public void calculatePay(double basePay, int hours) {
        // No employee shall work more than 60 hours.
        if (hours > 60) {
            System.out.println("Hour* rules broken by working more than 60 hours. You're fired.");
            System.err.println("\n* - No wordplay intended.");
            return;
        }

        // base pay must not be less than minimum wage. We're not animals.
        if (basePay < 8) {
            System.err.println("Base Pay less than minimum wage. Goodbye, FooCorporation.");
            return;
        }

        double totalPay = (basePay * hours);
        double overtime = 0d;

        if (hours > 40) {
            // Calculating overtime according to US Department of Labor
            overtime = 1.5 * basePay * (hours - 40);
        }

        System.out.println(totalPay + overtime);
    }

    public static void main(String[] args) {
        FooCorporation foo = new FooCorporation();
        foo.calculatePay(7.50, 35);
        foo.calculatePay(8.20, 47);
        foo.calculatePay(10, 73);
    }
}
