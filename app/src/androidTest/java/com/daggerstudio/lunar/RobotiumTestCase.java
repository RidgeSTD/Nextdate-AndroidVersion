package com.daggerstudio.lunar;

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

    public void testNextDayButtonBySwipeOnDate(){
        if(solo == null){
            solo = new Solo(getInstrumentation(), getActivity());
        }
        Random random = new Random();
        random.setSeed(45897678);
        for(int i = 0;i<4;i++){
            PointF p1 = new PointF(260, 960);
            PointF p2 = new PointF(260, 560);
            solo.swipe(p1, p1, p2, p2);
            solo.clickOnScreen(random.nextFloat()*420+58, random.nextFloat()*300+720);
            solo.clickOnButton("计算下一天");
            boolean toast;
            toast = solo.waitForText("计算完成", 1, 300);
            assertTrue("Calculate Fail", toast);
            //Takes a screenshot and saves it in "/sdcard/Robotium-Screenshots/".
            solo.takeScreenshot();
        }
    }

    public void testNextDateButtonBySwipeOnYear(){
        if(solo == null){
            solo = new Solo(getInstrumentation(), getActivity());
        }
        Random random = new Random(84348765);
        for(int i = 0; i<4;i++) {
            solo.clickOnScreen(326, 235);
            solo.sleep(300);
            for(int j=0;j<random.nextInt(3)+1;j++) {
                PointF p1 = new PointF(310, 910);
                PointF p2 = new PointF(310, 600);
                solo.swipe(p1, p1, p2, p2);
            }
            solo.clickOnScreen(random.nextFloat()*430+58, random.nextFloat()*370+600);
            solo.clickOnScreen(random.nextFloat()*420+58, random.nextFloat()*300+720);
            solo.clickOnButton("计算下一天");
            boolean toast;
            toast = solo.waitForText("计算完成", 1, 300);
            assertTrue("Calculate Fail", toast);
            //Takes a screenshot and saves it in "/sdcard/Robotium-Screenshots/".
            solo.takeScreenshot();
        }

    }

}
