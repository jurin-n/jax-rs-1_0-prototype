import static org.junit.Assert.*;

import org.junit.Test;

public class TestSample extends ParentTestWatcher {

	@Test
	public void test成功するテスト() {
		System.out.println("test!");
	}
	
	@Test
	public void test失敗するテスト() {
		System.out.println("test!");
		fail();
	}

}
