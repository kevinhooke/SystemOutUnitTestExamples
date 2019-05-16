package kh.systemout;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test example for asserting writing output to System.out.
 * 
 * @author kevinhooke
 *
 */
public class SystemOutExamplesTest {

	private PrintStream originalSystemOut;
	private ByteArrayOutputStream baos;
	private PrintStream ps;
	
	/**
	 * Take copy of original System.out, and replace with a ByteArrayOutputStream
	 * to capture the output from the Class under test when it calls System.out. 
	 */
	@Before
	public void setup() {
		this.originalSystemOut = System.out;
		this.baos = new ByteArrayOutputStream();
		this.ps = new PrintStream(baos);
		
		System.setOut(ps);
	}
	
	/**
	 * Restore original System.out.
	 */
	@After
	public void tearDown() {
		System.setOut(this.originalSystemOut);
	}
	
	@Test
	public void testExampleSystemOut1() {
		SystemOutExamples examples = new SystemOutExamples();
		examples.exampleSystemOut1();
		assertEquals("example1\n", this.baos.toString());
	}

	@Test
	public void testExampleSystemOutFromMain() {
		SystemOutExamples.main(null);
		assertEquals("example system out from main method\n", this.baos.toString());
	}

	
}
