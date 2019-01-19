package DateConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
*
* @author Abdullah
*/
public class DateConversion {
	
	public static LocalDate converttoLocalDate(Date date) {
		LocalDate localdate=LocalDate.of(date.getYear(), date.getMonth(), date.getDate());
		return localdate;
	}
	
	public static Date converttoDate(LocalDate localeDate) {
		Date date =new Date(localeDate.getYear(),localeDate.getMonth().getValue()-1,localeDate.getDayOfMonth());
		return date;
	}
	
	public static LocalTime converttoLocalTime(LocalDateTime localDateTime) {
		LocalTime localTime  = localDateTime.toLocalTime();
		return localTime;
	}
	
	public static Date converttoDate(Calendar cal) {
		Date date = new Date(cal.get(0),cal.get(1),cal.get(2));
		System.out.println(date);
		return date;
	}
	public TimeZone converTimeZone (LocalDateTime date) {
		TimeZone timeZone = null;
		return timeZone;
	}
	public static GregorianCalendar convertCalendar(LocalDateTime localDateTime) {	
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zdt = localDateTime.atZone(zoneId);
		GregorianCalendar calendar = GregorianCalendar.from(zdt);
		return calendar;
	}
	public static Date converttoDate(LocalDateTime localDateTime) {
		Date date = new Date(localDateTime.getYear(),localDateTime.getMonthValue(),localDateTime.getDayOfMonth(),localDateTime.getHour(),localDateTime.getMinute(),localDateTime.getSecond());
		return date;			
	}
	public static LocalDateTime converLocalDateTime(Date date) {
		LocalDateTime localDateTime = LocalDateTime.of(date.getYear(),date.getMonth(),date.getDate(), date.getHours(), date.getMinutes(),date.getSeconds());
		return localDateTime;
	}
	public static LocalDateTime convertToLocalDateTime (ZonedDateTime zonedDateTime) {
		ZoneId currentZoneId = ZoneId.systemDefault();
		ZonedDateTime currentZonedDateTime = zonedDateTime.withZoneSameInstant(currentZoneId);
		LocalDateTime localDateTime = currentZonedDateTime.toLocalDateTime();
		return localDateTime;
	}
}