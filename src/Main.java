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
    	//System.out.println("(ヽ´ω`)");
        String output = "Starttime:";
    	
    	//現在日時取得
        Calendar c = Calendar.getInstance();

        //フォーマットを指定
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        output += sdf.format(c.getTime());
        
        Random rnd = new Random();

        int ran = rnd.nextInt(50000);
        //重い処理
        String str = "";
        for(int i = 0; i < ran; i++){
        	str += String.valueOf(i);
        }
        
    	//現在日時取得
        Calendar c2 = Calendar.getInstance();
        output += "　　Endtime:" + sdf.format(c2.getTime()) + "  Rand:" + String.valueOf(ran) + "  経過時間：" + String.valueOf(c2.getTimeInMillis() - c.getTimeInMillis()) + "    開始からの経過時間：" + String.valueOf(c.getTimeInMillis() - start.getTimeInMillis()) ;

        System.out.println(output);
    	
    }
}
