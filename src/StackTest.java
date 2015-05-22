import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

	private StackADT<Integer> stack;

	@Before
	public void setUp() {
		stack = new SingleLinkedDropOutStack<Integer>(2);
		stack.push(1);
		stack.push(10);
		stack.push(100);
	}

	@Test
	public void testPeek() {
		assertTrue(stack.size() == 2);
		assertTrue(stack.peek() == 100);
	}

	@Test
	public void testPop() {
		System.out.println(stack.size());
		assertTrue(stack.pop() == 100);
		System.out.println(stack.size());
		System.out.println(stack.peek());
		assertTrue(stack.pop() == 10);
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testEmpty() {
		stack.clear();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testInsertAgain() {
		stack.push(100);
		stack.push(10);
		assertTrue(stack.peek() == 10);
		assertFalse(stack.isEmpty());
	}

}
