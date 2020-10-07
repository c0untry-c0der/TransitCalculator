import java.util.Arrays;

// A simple program to calculate the best option to ride the transit in NYC based on cost per ride.
public class TransitCalculator {
    int days;
    int rides;
    double[] prices = {2.75, 33, 127};
    String[] options = {"Pay Per Ride", "7-Day Unlimited", "30-Day Unlimited"};

        // The constructor method for the class
        public TransitCalculator(int numDays, int numRides) {
            days = numDays;
            rides = numRides;
    }

    // A method to determine the cost per ride from a weekly pass purchase
    public double unlimited7Price() {

        int passes = days / 7;
        if (days < 7) {
            passes = 1;
        }
        if (days % 7 > 0) {
            passes++;
        }
        double total = passes * prices[1];
        double weekPass = total / rides;
        return weekPass;
    }

    // A method to determine the cost per ride for all passes available
    public double[] getRidePrices() {
        double single = prices[0];
        double weeklyCost = unlimited7Price();
        double monthlyCost = prices[2] / rides;
        System.out.println("[" + single + " " + weeklyCost + " " + monthlyCost + "]");
        
        // System.out.println(single);
        // System.out.println(weeklyCost);
        // System.out.println(monthlyCost);
        // For some reason I can't figure out, this method will not return the values stored in the array.
        // However, when called from the getBestFare method the values seem to return?
        // Uncomment out the println statements above to see the values stored in the cost array....
        // The only way that I could get it to work was with the hacked around 'Sys.out.print[ my pieced together array ]'
        // I'm very lost here as it only references memory but works when called from a later method.
        // Experienced help is welcome, lol!
        return new double[] {single, weeklyCost, monthlyCost};
    }

    // A method that shows you the cheapest pass for the alloted amount of days and rides you plan to take.
    public String getBestFare() {
        int low = 0;
        String opt = null;
        String bestOption;
        double deal = prices[0];
        double[] bestPrice = getRidePrices();
        for (int i = 1; i < bestPrice.length; i++) {
            if (deal > bestPrice[i]) {
                deal = bestPrice[i];
                low = i;
            }
            opt = options[i];
        }
        String fare = opt;
        bestOption = ("You should get the " + fare + " option at $" + deal + " per ride.");
        return bestOption;
    }

    // The infamous main method....
    public static void main(String[] args) {
        TransitCalculator calc = new TransitCalculator(26, 54);

        // System.out.println(calc.unlimited7Price());
        // System.out.println();
        System.out.println(calc.getRidePrices());
        // System.out.println();
        System.out.println(calc.getBestFare());
    }
}
