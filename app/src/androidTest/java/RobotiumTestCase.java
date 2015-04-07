import android.graphics.PointF;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.Button;

import com.daggerstudio.lunar.MainActivity;
import com.daggerstudio.lunar.R;
import com.robotium.solo.Solo;

import java.util.Random;

/**
 * Created by alex on 15/4/7.
 */
public class RobotiumTestCase extends ActivityInstrumentationTestCase2{
    private Solo solo;
    private static Class<?> launchActivityClass;
    private static String mainActivity = "com.daggerstudio.lunar.MainActivity"; // 启动的类名
    private Button nextBtn = null;


    public RobotiumTestCase(){
        super("com.daggerstudio.lunar.MainActivity", MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }


    @Override
    protected void tearDown() throws Exception{
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testBatch(){
        nextDayButton_test();
    }
    public void nextDayButton_test(){
        if(solo == null){
            solo = new Solo(getInstrumentation(), getActivity());
        }
        Random random = new Random();
        random.setSeed(45897678);
        for(int i = 0;i<4;i++){
            solo.clickOnButton("计算下一天");
            boolean toast = false;
            toast = solo.searchText("计算完成");
            assertEquals(true, toast);
            solo.sleep(1000);
            PointF p1 = new PointF(260, 640);
            PointF p2 = new PointF(260, 300);
            solo.swipe(p1, p1, p2, p2);
            solo.sleep(500);
            solo.clickOnScreen(random.nextFloat()*250+370, random.nextFloat()*380+400);
            solo.sleep(500);
        }
    }
}
