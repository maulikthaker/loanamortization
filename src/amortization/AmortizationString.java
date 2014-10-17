package amortization;

public class AmortizationString {
	
	private String headerFormatString = "%1$-20s%2$-20s%3$-20s%4$-20s%5$-20s%6$-20s\n";
	// output is in dollars
	private String lineItemFormatString = "%1$-20d%2$-20.2f%3$-20.2f%4$-20.2f%5$-20.2f%6$-20.2f\n";
	

	public String getHeaderFormatString() {
		return headerFormatString;
	}

	public void setHeaderFormatString(String headerFormatString) {
		this.headerFormatString = headerFormatString;
	}

	public String getLineItemFormatString() {
		return lineItemFormatString;
	}

	public void setLineItemFormatString(String lineItemFormatString) {
		this.lineItemFormatString = lineItemFormatString;
	}

}
