package br.com.jamesson.request.converters;

public class NumberConverter {

	private NumberConverter() {
	}
	
	public static Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0d;
		String number = strNumber.replace(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number); 
		return 0d;
	}

	public static boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replace(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
}
