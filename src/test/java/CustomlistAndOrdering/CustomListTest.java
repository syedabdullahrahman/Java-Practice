package CustomlistAndOrdering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CustomlistAndOrdering.CustomList;
import CustomlistAndOrdering.File;

/**
*
* @author Abdullah
*/

public class CustomListTest<E> {

	private static final Logger logger = LoggerFactory.getLogger(CustomListTest.class);
	@Test
	public void testAdd() {
		CustomList<File> customList1 = setUpCustomList();
		CustomList<File> customList2 = setUpCustomList();
		assertEquals(customList1, customList2);
	}

	@Test
	public void testGet() {
		CustomList<File> customList = new CustomList<>();
		customList.add(new File("Book", 20.5, LocalDate.of(2015, 3, 20), "pdf"));
		File file = new File("Book", 20.5, LocalDate.of(2015, 3, 20), "pdf");
		assertEquals(file,customList.get(0));
	}

	@Test
	public void testSize() {
		CustomList<File> customList = new CustomList<>();
		customList = setUpCustomList();
		assertEquals(5,customList.size());	
	}

	
	/**
	 * List addAllmethod checking failure 
	 * though every member in these two list is same 
	 * but some empty space is allocated at the end of the array. 
	 * Thats why asserting fails. */
	
	@Test
	public void testAddAll() {
		
		List<File>list = setUpList();
		CustomList<File> customList1 = setUpCustomList();
		CustomList<File> customList2 = new  CustomList<>();
		customList2.addAll(list);
		assertEquals(customList1, customList2);
	}

	@Test
	public void testClear() {
		CustomList<File> customList = setUpCustomList();
		customList.clear();
		assertEquals(0,customList.size());
	}

	@Test
	public void testIsEmpty() {
		CustomList<File> customList = setUpCustomList();
		customList.clear();
		assertEquals(true, customList.isEmpty());	
	}

	@Test
	public void testRemoveObject() {
		CustomList<File> customList = setUpCustomList();
		File f1 = new File("Video", 60.5, LocalDate.of(2019, 4, 20), "mp4");
		customList.remove(f1);
		CustomList<File> customList2=(CustomList<File>) setUpListForRemoveChecking();
		logger.debug(customList.toString());
		logger.debug(customList2.toString());
		assertEquals(customList, customList2);
	}
	
	private CustomList<File> setUpCustomList() {
		CustomList<File> customList = new CustomList<File>();
		customList.add(new File("Book", 20.5, LocalDate.of(2015, 3, 20), "pdf"));
		customList.add(new File("Video", 60.5, LocalDate.of(2019, 4, 20), "mp4"));
		customList.add(new File("Songs", 30.5, LocalDate.of(2014, 7, 20), "mp3"));
		customList.add(new File("HTML", 5.5, LocalDate.of(2013, 10, 20), "html"));
        customList.add(new File("Picture", 30.3, LocalDate.of(2016, 12, 20), "jpg"));
        return customList;
	}
	
	private List<File> setUpList() {
		List<File> customList = new ArrayList<File>();
		customList.add(new File("Book", 20.5, LocalDate.of(2015, 3, 20), "pdf"));
		customList.add(new File("Video", 60.5, LocalDate.of(2019, 4, 20), "mp4"));
		customList.add(new File("Songs", 30.5, LocalDate.of(2014, 7, 20), "mp3"));
		customList.add(new File("HTML", 5.5, LocalDate.of(2013, 10, 20), "html"));
        customList.add(new File("Picture", 30.3, LocalDate.of(2016, 12, 20), "jpg"));
        return customList;
	}
	
	private CustomList<File> setUpListForRemoveChecking() {
		CustomList<File> customList = new CustomList<File>();
		customList.add(new File("Book", 20.5, LocalDate.of(2015, 3, 20), "pdf"));
		customList.add(new File("Songs", 30.5, LocalDate.of(2014, 7, 20), "mp3"));
		customList.add(new File("HTML", 5.5, LocalDate.of(2013, 10, 20), "html"));
		customList.add(new File("Picture", 30.3, LocalDate.of(2016, 12, 20), "jpg"));
        return customList;
	}

}
