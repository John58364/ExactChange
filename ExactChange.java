import java.util.Scanner;

public class ExactChange
{

	public static void main(String[] args)
	{
		// Create massive loop
		boolean loop = true;
		while (loop == true)
		{
			// Create variables
			final double TAX = .05;
			final double MAXPRICE = 600.00;
			final int HUNDRED = 10000;
			final int FIFTY = 5000;
			final int TWENTY = 2000;
			final int TEN = 1000;
			final int FIVE = 500;
			final int ONE = 100;
			final int QUARTER = 25;
			final int DIME = 10;
			final int NICKEL = 5;
			final int PENNY = 1;
			double cost = 601;
			int hundredBill = 0;
			int fiftyBill = 0;
			int twentyBill = 0;
			int tenBill = 0;
			int fiveBill = 0;
			int oneBill = 0;
			int quarterCoin = 0;
			int dimeCoin = 0;
			int nickelCoin = 0;
			int pennyCoin = 0;
			Scanner kb = new Scanner(System.in);
			// Prompt user for price and apply tax
			while (cost > MAXPRICE)
			{
				System.out.print("Cost of transaction (enter 0 or negative to exit; max is $600.00): ");
				cost = kb.nextDouble();
				if (cost <= 0)
				{
					System.out.println("\nDone.");
					loop = false;
				} else if (cost <= MAXPRICE)
				{
					double totalCost = cost + (cost * TAX);

					// Display final price and prompt user for payment value
					System.out.printf("Amount due (with 5 percent tax): $%.2f\n", totalCost);
					System.out.print("Please enter payment amount: ");
					double payment = kb.nextDouble();
					while (payment < totalCost)
					{
						System.out.print("Please enter payment amount: ");
						payment = kb.nextDouble() + payment;
					}

					// Convert double values into integer values
					double change = payment - totalCost;
					totalCost = totalCost * 100;
					payment = payment * 100;
					int newPayment = (int) payment;
					int newCost = (int) totalCost;
					int newChange = newPayment - newCost;

					// Check for change
					if (payment == totalCost)
					{
						System.out.println("Exact Change. Thank you!\n");
					} else
					{
						System.out.printf("Change back: $%.2f\n", change);
					}

					// Determine how much of each monetary value should be distributed
					if (newChange > 0)
					{
						while (newChange / HUNDRED >= 1)
						{
							hundredBill++;
							newChange -= HUNDRED;
						}

						while (newChange / FIFTY >= 1)
						{
							fiftyBill++;
							newChange -= FIFTY;
						}

						while (newChange / TWENTY >= 1)
						{
							twentyBill++;
							newChange -= TWENTY;
						}

						while (newChange / TEN >= 1)
						{
							tenBill++;
							newChange -= TEN;
						}

						while (newChange / FIVE >= 1)
						{
							fiveBill++;
							newChange -= FIVE;
						}

						while (newChange / ONE >= 1)
						{
							oneBill++;
							newChange -= ONE;
						}

						while (newChange / QUARTER >= 1)
						{
							quarterCoin++;
							newChange -= QUARTER;
						}

						while (newChange / DIME >= 1)
						{
							dimeCoin++;
							newChange -= DIME;
						}

						while (newChange / NICKEL >= 1)
						{
							nickelCoin++;
							newChange -= NICKEL;
						}

						while (newChange / PENNY >= 1)
						{
							pennyCoin++;
							newChange -= PENNY;
						}
					}

					// Display results if necessary
					if (payment != totalCost)
					{
						System.out.printf(
								"$100: %d $50: %d $20: %d $10: %d $5: %d $1: %d $0.25: %d $0.10: %d $0.05: %d $0.01: %d\n\n",
								hundredBill, fiftyBill, twentyBill, tenBill, fiveBill, oneBill, quarterCoin, dimeCoin,
								nickelCoin, pennyCoin);
					}
				}
			}
		}
	}
}
