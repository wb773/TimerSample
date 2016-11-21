import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";

	public static void main(String[] args) throws Exception {

		//Timer��AtFixedRate������
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(new SampleTask(Calendar.getInstance()), 0, 5000);

		//�������i����������
		while (true) {}
	}

}

class SampleTask extends TimerTask {

	//�X�P�W���[���J�n����
	Calendar start = null;

	SampleTask(Calendar start) {
		this.start = start;
	}

	public void run() {
		String output = "Starttime:";

		// �J�n���Ԃ��擾
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		output += sdf.format(c.getTime());

		// �d�������i�����_���񐔏������s���j
		Random rnd = new Random();
		int ran = rnd.nextInt(50000);
		String str = "";
		for (int i = 0; i < ran; i++) {
			str += String.valueOf(i);
		}

		//���ʂ��o��
		Calendar c2 = Calendar.getInstance();
		output += "�@�@Endtime:" + sdf.format(c2.getTime()) + "  Rand:" + String.valueOf(ran) 
				+ "  �o�ߎ��ԁF" + String.valueOf(c2.getTimeInMillis() - c.getTimeInMillis()) 
				+ "    �J�n����̌o�ߎ��ԁF" + String.valueOf(c.getTimeInMillis() - start.getTimeInMillis());

		System.out.println(output);

	}
}
