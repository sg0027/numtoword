package numtoword;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import numtoword.utils.Constants;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {

	@InjectMocks
	private Application appInstance;

	private final InputStream systemIn = System.in;
	private final PrintStream systemOut = System.out;

	private ByteArrayInputStream testIn;
	private ByteArrayOutputStream testOut;

	@Before
	public void setUpOutput() {
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
	}

	private void provideInput(String data) {
		testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
	}

	private String getOutput() {
		return testOut.toString();
	}

	@After
	public void restoreSystemInputOutput() {
		System.setIn(systemIn);
		System.setOut(systemOut);
	}

	@Test
	public void shouldContainNumberToWord() {
		final String testString = "55";
		provideInput(testString);

		Application.main(new String[0]);

		assertTrue(getOutput().contains("Fifty Five"));

	}

	@Test
	public void shouldPrintExceptionMessage() {
		final String testString = "0.5555555555555555";
		provideInput(testString);

		Application.main(new String[0]);
		assertTrue(getOutput().contains(Constants.CONVERTER_ERR_MESSAGE));
	}
}
