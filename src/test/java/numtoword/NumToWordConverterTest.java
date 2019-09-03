package numtoword;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import numtoword.utils.NumToWordConverter;

@RunWith(MockitoJUnitRunner.class)
public class NumToWordConverterTest {
	
	@InjectMocks
	private NumToWordConverter ntwconverter;
	
	@Test
	public void shouldReturnEmptyWhenValueGivenZero() {
		String expectedResult = "";
	    assertEquals(expectedResult, ntwconverter.convert(0));
	}
	
	@Test
	public void shouldReturnWordWhenValidNumberGivenBelowHundred() {
		String expectedResult = "Twenty Five";
	    assertEquals(expectedResult, ntwconverter.convert(25));
	}
	
	@Test
	public void shouldReturnWordWhenValidNumberGivenInHundreds() {
		String expectedResult = "Nine Hundred Eighty Eight";
	    assertEquals(expectedResult, ntwconverter.convert(988));
	}
	
	@Test
	public void shouldReturnWordWhenValidNumberGivenInThousands() {
		String expectedResult = "Six Thousand Five Hundred Fifty Two";
	    assertEquals(expectedResult, ntwconverter.convert(6552));
	}
	
	@Test
	public void shouldReturnWordWhenValidNumberGivenInLakhs() {
		String expectedResult = "Nine Lakh Fifty Five Thousand Five Hundred";
	    assertEquals(expectedResult, ntwconverter.convert(955500));
	}
	
	@Test
	public void shouldReturnWordWhenValidNumberGivenInCrores() {
		String expectedResult = "Eight Crore Fifty Five Lakh Thirty Five Thousand Six Hundred Fifteen";
	    assertEquals(expectedResult, ntwconverter.convert(85535615));
	}
	
	@Test
	public void shouldReturnMinusWordWhenValidMinusNumberGiven() {
		String expectedResult = "Minus Eight";
	    assertEquals(expectedResult, ntwconverter.convert(-8));
	}

}
