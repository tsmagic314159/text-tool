package cn.KJ.Assignment1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSearch {

	String text, key;
	
	@Before
	public void setUp() throws Exception {
		text = "qwercarqwercarss";
		key = "car";
	}

	@Test
	public void test() {
		assertTrue((TestEditor.searchItem(key, text).get(0)==4)&&(TestEditor.searchItem(key, text).get(1)==11));
	}

}
