package amortization;

import java.io.IOException;

public class AmortizationIO {
	
	public AmortizationInputPars readUserInputFromConsole() {
		String[] userPrompts = {
				"Please enter the amount you would like to borrow: ",
				"Please enter the annual percentage rate used to repay the loan: ",
				"Please enter the term, in years, over which the loan is repaid: " };

		String line = "";
		AmortizationInputPars input = new AmortizationInputPars();
		double amount = 0;
		double apr = 0;
		int years = 0;

		for (int i = 0; i < userPrompts.length;) {
			String userPrompt = userPrompts[i];
			try {
				line = AmortizationConsole.readLine(userPrompt);
			} catch (IOException e) {
				AmortizationConsole.print("An IOException was encountered. Terminating program.\n");
				return input;
			}

			boolean isValidValue = true;
			try {
				switch (i) {
				case 0:
					amount = Double.parseDouble(line);
					if (AmortizationRange.isValidBorrowAmount(amount) == false) {
						isValidValue = false;
						double range[] = AmortizationRange.getBorrowAmountRange();
						AmortizationConsole.print("Please enter a positive value between "
										+ range[0] + " and " + range[1] + ". ");
					}else{
						input.setAmount(amount);
					}
					break;
				case 1:
					apr = Double.parseDouble(line);
					if (AmortizationRange.isValidAPRValue(apr) == false) {
						isValidValue = false;
						double range[] = AmortizationRange.getAPRRange();
						AmortizationConsole.print("Please enter a positive value between "
										+ range[0] + " and " + range[1] + ". ");
					}else{
						input.setApr(apr);
					}
					break;
				case 2:
					years = Integer.parseInt(line);
					if (AmortizationRange.isValidTerm(years) == false) {
						isValidValue = false;
						int range[] = AmortizationRange.getTermRange();
						AmortizationConsole.print("Please enter a positive integer value between "
										+ range[0] + " and " + range[1] + ". ");
					}else{
						input.setYears(years);
					}
					break;
				}
			} catch (NumberFormatException e) {
				isValidValue = false;
			}
			if (isValidValue) {
				i++;
			} else {
				AmortizationConsole.print("An invalid value was entered.\n");
			}
		}
		return input;

	}

}
