package testingPackage;

import org.testng.annotations.DataProvider;

public class testData {

	@DataProvider(name = "correctEmail")
	public Object[][]correctEmail() {
		return new Object[][] {
			{ "adi@adi.com" }

		};

	}

	@DataProvider(name = "correctPasswordAndEmail")
	public Object[][] correctPassword() {
		return new Object[][] {
			{ "12345" , "adi@adi.com"  }

		};
		
	}
	
	@DataProvider(name = "inCorrectEmailInputList")
	public Object[][] inCorrectEmailInputList() {
		return new Object[][] {
			{ "adi.adi.com" },
			{ "1234567890adi.com" },
			{ "adinkahersonski&adi.com" },
			{ "@adi.com" }
			

		};

	}
		
}