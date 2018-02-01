import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class Lab8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Batting Average and Slugging Percentage calculator!");
		boolean keepGoing = true;
		while (keepGoing == true) {
			// ask the user for the number of at bats and use that to initialize the array
			// of bases earned with the correct length
			int atBats = Validator.intIsPos(scan, "Please enter the number of at-bats:");
			int[] basesEarned = new int[atBats];

			// for each at-bat, loop through the array and assign the bases earned to the
			// correct index
			for (int i = 0; i < basesEarned.length; i++) {
				basesEarned[i] = Validator.getInt(scan,
						("Please enter the number of bases earned for at-bat #" + (i + 1) + ":\n"), 0, 4);
			}
			
			//run through the array of at-bats and count the number of times the batter got on base as well as the total number of bases earned
			int countBasesEarned = 0;
			int totalBasesEarned = 0;
			for (int i = 0; i < basesEarned.length; i++) {
				if (basesEarned[i] > 0) {
					countBasesEarned += 1;
				}
				totalBasesEarned += basesEarned[i];
			}
			
			//calculate battingAverage and sluggingPercentage and make sure that 3 decimal places are shown
			double battingAverage = (float) countBasesEarned / basesEarned.length;
			battingAverage = BigDecimal.valueOf(battingAverage).setScale(3, RoundingMode.HALF_UP).doubleValue();
			double sluggingPercentage = totalBasesEarned / basesEarned.length;
			sluggingPercentage *= 100;
			sluggingPercentage = BigDecimal.valueOf(sluggingPercentage).setScale(3, RoundingMode.CEILING).doubleValue();

			//print the final output and determine whether or not the user wants to keep going
			System.out.println(sluggingPercentage);
			System.out.println("This player had a batting average of " + battingAverage + "% and a slugging percentage of " + sluggingPercentage + "%");
			keepGoing = Validator.yesOrNo(scan, "Would you like to continue with another player? y/n");
		}
		System.out.println("Goodbye!");
	}

}
