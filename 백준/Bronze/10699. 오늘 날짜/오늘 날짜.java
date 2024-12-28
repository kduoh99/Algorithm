import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Main {
	public static void main(String[] args) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		System.out.println(sdf.format(d));
	}
}
