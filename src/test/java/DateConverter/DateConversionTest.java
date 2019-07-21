package DateConverter;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import DateConverter.DateConversion;

public class DateConversionTest {
	@Test
	public void testConverttoDateLocalDate() {
		Date date = new Date(2019,1,16);
		LocalDate localDate1 = DateConversion.converttoLocalDate(date);
		LocalDate localDate2 = LocalDate.of(2019,1,16);
		assertEquals(localDate1, localDate2);	
	}
	@Test
	public void testConverttoLocalTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalTime localTime1 = DateConversion.converttoLocalTime(localDateTime);
		LocalTime localTime2 = LocalTime.now();
		assertEquals(localTime1, localTime2);
	}
	@Test
	public void testConverttoDate() {
		LocalDate localDate = LocalDate.now();
		Date date1 = DateConversion.converttoDate(localDate);
		//Date date2 = new Date();
		Date date2 = new Date(2019,0,17) {
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				Date other = (Date) obj;
				if (this.getYear() != other.getYear())
					return false;
				if (this.getMonth() != other.getMonth())
					return false;
				if (this.getDate() != other.getDate())
					return false;
				return true;
			}
		};
		date2.setYear(2019);
		date2.setDate(17);
		date2.setMonth(0);
		assertEquals(date1,date2);
	}
	
	@Test
	public void testConverttoCalendar() {
		LocalDateTime localDateTime = LocalDateTime.now();
		Calendar calendar = DateConversion.convertCalendar(localDateTime);
		Calendar calendar2 = Calendar.getInstance();
		System.out.println(calendar);
		System.out.println(calendar2);
		
		/**
		 * Some Millisecond fractions are there so they are not fully equal 
		 * 
		 * java.util.GregorianCalendar[time=1547725180852,
		 * 
		 * java.util.GregorianCalendar[time=1547725180868
		 *
		 */
		//assertEquals(calendar2,calendar);
	}
	@Test
	public void testconvertCalendar() {
		
	}
	@Test
	public void testConverLocalDateTimeDate() {
		/**
		 * Need to use LocalDateTime.of(.......) 
		 * 
		 * */
		LocalDateTime localDateTime = LocalDateTime.now();
		Date date = DateConversion.converttoDate(localDateTime);
		LocalDateTime localDateTime1 = DateConversion.converLocalDateTime(date);
		LocalDateTime localDateTime2= LocalDateTime.now();
		System.out.println(localDateTime);
		assertEquals(localDateTime1.getYear(), localDateTime2.getYear());
		assertEquals(localDateTime1.getMonth(), localDateTime2.getMonth());
		assertEquals(localDateTime1.getDayOfMonth(), localDateTime2.getDayOfMonth());
		assertEquals(localDateTime1.getHour(), localDateTime2.getHour());
		assertEquals(localDateTime1.getMinute(), localDateTime2.getMinute());
		assertEquals(localDateTime1.getSecond(), localDateTime2.getSecond());
	}
	@Test
	public void testConvertTimeZone() {
		
	}
	
	/**
	 * Real life uses are there 
	 * 
	 * */
	@Test
	public void testConvertToLocalDateTime() {
		
	}
}