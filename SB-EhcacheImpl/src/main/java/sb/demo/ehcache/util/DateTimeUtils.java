package sb.demo.ehcache.util;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class DateTimeUtils {
	
	public static long getCurrentTime() {
		ZonedDateTime zdtUTC = ZonedDateTime.now(TimeZone.getTimeZone("UTC").toZoneId());
		return Timestamp.valueOf(zdtUTC.toLocalDateTime()).getTime();
	}

}
