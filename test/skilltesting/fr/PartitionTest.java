package skilltesting.positivethinking.fr;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PartitionTest {
	List<Integer> numbers;

	@Before
	public void setUp() throws Exception {
		numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	}

	@After
	public void setDown() throws Exception {
		numbers = null;
	}

	@Test
	public void testSubArrayOfOneElement() {
		assertTrue(Partition.ofSize(numbers, 1).size() == 10);
	}

	@Test
	public void testSubArrayOfTwoElements() {
		assertTrue(Partition.ofSize(numbers, 2).size() == 5);
	}

	@Test
	public void testSubArrayOfThreeElements() {
		assertTrue(Partition.ofSize(numbers, 3).size() == 4);
	}

	@Test
	public void testSubArrayOfFourElements() {
		assertTrue(Partition.ofSize(numbers, 4).size() == 3);
	}

	@Test
	public void testSubArrayOfFiveElements() {
		assertTrue(Partition.ofSize(numbers, 5).size() == 2);
	}

	@Test
	public void testSubArrayOfThreeElementsLastElementContainsOneElement() {
		Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			Partition<Integer> result= Partition.ofSize(numbers, 5);
			result.get(3);
		});

		String expectedMessage = "3 is out of the list range <0,1>";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

}
