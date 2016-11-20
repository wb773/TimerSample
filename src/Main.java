import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
	static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
	 
	public static void main(String[] args) throws Exception {

    	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
    	
    	
    	//ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    	Timer timer = new Timer(true);
    	
    	timer.scheduleAtFixedRate(new SampleTask(Calendar.getInstance()),  0, 5000);

    	
    	while(true){
    		
    	}
    }
	

}

class SampleTask extends TimerTask {
	 
	Calendar start = null;
	SampleTask(Calendar start){
		this.start = start;
	}
	
    public void run() {
    	//System.out.println("(�R�L��`)");
        String output = "Starttime:";
    	
    	//���ݓ����擾
        Calendar c = Calendar.getInstance();

        //�t�H�[�}�b�g���w��
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        output += sdf.format(c.getTime());
        
        Random rnd = new Random();

        int ran = rnd.nextInt(50000);
        //�d������
        String str = "";
        for(int i = 0; i < ran; i++){
        	str += String.valueOf(i);
        }
        
    	//���ݓ����擾
        Calendar c2 = Calendar.getInstance();
        output += "�@�@Endtime:" + sdf.format(c2.getTime()) + "  Rand:" + String.valueOf(ran) + "  �o�ߎ��ԁF" + String.valueOf(c2.getTimeInMillis() - c.getTimeInMillis()) + "    �J�n����̌o�ߎ��ԁF" + String.valueOf(c.getTimeInMillis() - start.getTimeInMillis()) ;

        System.out.println(output);
    	
    }
}
