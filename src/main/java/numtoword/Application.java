package numtoword;

import java.util.Scanner;
import numtoword.utils.Constants;
import numtoword.utils.NumToWordConverter;

public class Application {

	public static void main(String[] args) {

		int number;
		NumToWordConverter ntwconverter = new NumToWordConverter();
		Scanner scanner = new Scanner(System.in);
		System.out.println(Constants.WELCOME_MESSAGE);
		try {
			number = scanner.nextInt();
			if (number == 0) {
				System.out.println(Constants.RESULT_MESSAGE + "Zero");
			} else {
				System.out.println(Constants.RESULT_MESSAGE + ntwconverter.convert(number));
			}

		} catch (Exception e) {
			System.out.println(Constants.CONVERTER_ERR_MESSAGE);
		}

		finally {
			scanner.close();
		}

	}

}
