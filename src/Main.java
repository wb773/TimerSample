import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";

	public static void main(String[] args) throws Exception {

		//TimerのAtFixedRateを試す
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(new SampleTask(Calendar.getInstance()), 0, 5000);

		//処理を永続化させる
		while (true) {}
	}

}

class SampleTask extends TimerTask {

	//スケジュール開始時間
	Calendar start = null;

	SampleTask(Calendar start) {
		this.start = start;
	}

	public void run() {
		String output = "Starttime:";

		// 開始時間を取得
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		output += sdf.format(c.getTime());

		// 重い処理（ランダム回数処理を行う）
		Random rnd = new Random();
		int ran = rnd.nextInt(50000);
		String str = "";
		for (int i = 0; i < ran; i++) {
			str += String.valueOf(i);
		}

		//結果を出力
		Calendar c2 = Calendar.getInstance();
		output += "　　Endtime:" + sdf.format(c2.getTime()) + "  Rand:" + String.valueOf(ran) 
				+ "  経過時間：" + String.valueOf(c2.getTimeInMillis() - c.getTimeInMillis()) 
				+ "    開始からの経過時間：" + String.valueOf(c.getTimeInMillis() - start.getTimeInMillis());

		System.out.println(output);

	}
}
