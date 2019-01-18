package com.mycompany.makingcustomlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
*
* @author Abdullah
*/
public class FileTest {

	@Test
	void testEqualsObject() {
		File f1=new File("Book", 20.5, LocalDate.of(2015, 3, 20), "pdf");
		File f2 = new File("Book", 20.5, LocalDate.of(2015, 3, 20), "pdf");
		assertEquals(true,f1.equals(f2));
	}

	@Test
	void testCompareByName() {
		File f1=new File("A Java Book", 20.5, LocalDate.of(2015, 3, 20), "pdf");
		File f2 = new File("A Java Book", 20.5, LocalDate.of(2015, 3, 20), "pdf");
		assertEquals(0,f1.compareByName(f2));
	}

	@Test
	void testCompareByNameAndSize() {
		File f1=new File("A Java Book", 20.4, LocalDate.of(2015, 3, 20), "pdf");
		File f2 = new File("A Java Book", 20.5, LocalDate.of(2015, 3, 20), "pdf");
		assertEquals(true,f1.compareByNameAndSize(f2)<0);
	}

	@Test
	void testCompareBySize() {
		File f1=new File("A Java Book", 20.4, LocalDate.of(2015, 3, 20), "pdf");
		File f2=new File("A Java Book", 20.5, LocalDate.of(2015, 3, 20), "pdf");
		assertEquals(true,f1.compareBySize(f2)<0);
	}

	@Test
	void testCompareTo() {
		File f1=new File("Book", 20.5, LocalDate.of(2015, 3, 20), "pdf");
		File f2 = new File("Book", 20.5, LocalDate.of(2015, 3, 20), "pdf");
		assertEquals(0,f1.compareTo(f1));
		
	}
	
	
	@Test 
	void testSortByName(){
		List<File> list = setList();
		Collections.sort(list);
		List<File> list2 = getSortedListByName();
		assertEquals(list, list2);
	}
	
	@Test 
	void testSortByNameAndSize(){
		List<File> list = setList();
		Collections.sort(list,new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				return o1.compareByNameAndSize(o2);
			}
		});
		List<File> list2 = getSortedListByNameAndSze();
		assertEquals(list, list2);
	}
	
	private List<File> setList(){
		List<File> list = new ArrayList<File>();
        list.add(new File("Book", 20.5, LocalDate.of(2015, 3, 20), "pdf"));
        list.add(new File("Video", 60.5, LocalDate.of(2019, 4, 20), "mp4"));
        list.add(new File("Video", 60.4, LocalDate.of(2018, 3, 20), "mp4"));
        list.add(new File("Songs", 30.5, LocalDate.of(2014, 7, 20), "mp3"));
        list.add(new File("HTML", 5.5, LocalDate.of(2013, 10, 20), "html"));
        list.add(new File("HTML", 5.4, LocalDate.of(2019, 8, 20), "html"));
        list.add(new File("Picture", 30.3, LocalDate.of(2016, 12, 20), "jpg"));
        return list;
	}
	
	private List<File> getSortedListByName(){
		List<File> list = new ArrayList<File>();
		list=setList();
		Collections.sort(list);
		return list;
	}
	
	private List<File> getSortedListBySize(){
		List<File> list = new ArrayList<File>();
		list = setList();
        Collections.sort(list, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.compareBySize(o2);
            }
        });
		return list;
	}
	private List<File> getSortedListByNameAndSze(){
		List<File> list = new ArrayList<File>();
		list = setList();
		Collections.sort(list,new Comparator<File>(){
			@Override
			public int compare(File o1, File o2) {
				return o1.compareByNameAndSize(o2);
			}
		});
		return list;
	}
}
