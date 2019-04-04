package nameInverter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class nameInverterTest {

	private NameInverter nameInverter = new NameInverter();
	
	private void assertInverted(String originalName, String invertedName) {
		assertEquals(invertedName, invertName(originalName));
	}
	
	private String invertName(String name) {
		return nameInverter.invertName(name);
	}

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void givenEmptyString_returnEmptyString() {
		assertInverted("", "");
	}

	@Test
	public void giveNull_returnsEmptyString() {
		assertInverted(null, "");
	}

	@Test
	public void givenSimpleName_returnSimpleName() {
		assertInverted("Name", "Name");
	}
	
	@Test 
	public void givenFirstLast_returnLastFirst(){
		assertInverted("First Last", "Last, First");
	}

	@Test
	public void givenASimpleNameWithSpaces_returnSimpleNameWithoutSpaces() {
		assertInverted(" Name ", "Name");
	}
	
	@Test
	public void givenFirstLastWithExtraSpaces_returnLastFirst() {
		assertInverted("  First  Last  ", "Last, First");
	}
	
	@Test
	public void ignoreHonorific() {
		assertInverted("Mr. First Last", "Last, First");
		assertInverted("Mrs. First Last", "Last, First");
	}
	
	@Test
	public void postNominals_stayAtEnd() {
		assertInverted("First Last Sr.", "Last, First Sr.");
		assertInverted("First Last BS. Phd.", "Last, First BS. Phd.");
	}
	
	@Test
	public void integration() {
		assertInverted("  Robert  Martin  III  esq.", "Martin, Robert III esq.");
	}
}
