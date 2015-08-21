import static org.junit.Assert.*;

import javax.ws.rs.core.MultivaluedMap;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.stub;
import static org.hamcrest.core.Is.is;

import java.util.LinkedList;

public class MockTest extends ParentTestWatcher{

	@Test
	public void testMockLinkedListTest(){
		//You can mock concrete classes, not only interfaces
		 LinkedList mockedList = mock(LinkedList.class);
		 
		 //stubbing
		 stub(mockedList.get(0)).toReturn("first");
		 stub(mockedList.get(1)).toThrow(new RuntimeException());
		 assertThat(mockedList.get(0),is("first"));
	}
	
	@Test
	public void testMockMultivaluedMapTest() {
		
		@SuppressWarnings("rawtypes")
		MultivaluedMap stub = mock(MultivaluedMap.class);
		
		when(stub.get("Authorization")).thenReturn("test");		
		//((List<String>) Mockito.doReturn("test").when(stub)).get(0);

		assertThat(stub.get("Authorization"),is("test"));
	}

}
