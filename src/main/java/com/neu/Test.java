package com.neu;




import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.VideoInputFrameGrabber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import static org.bytedeco.javacpp.opencv_core.IplImage;
import static org.bytedeco.javacpp.opencv_core.cvFlip;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;

@EnableAutoConfiguration
@Component
@ComponentScan
public class Test implements Runnable{
	
	 final int INTERVAL = 100;///you may use interval
	    CanvasFrame canvas = new CanvasFrame("Web Cam");
	
	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(Test.class,
				args);

		Test mainObj = ctx.getBean(Test.class);

		mainObj.init();

		System.out.println("Application exited");
	}
	public Test() {
        canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }
	 public void run() {

	        FrameGrabber grabber = new VideoInputFrameGrabber(0); // 1 for next camera
	        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
	        IplImage img;
	        int i = 0;
	        try {
	            grabber.start();
	            while (true) {
	                Frame frame = grabber.grab();

	                img = converter.convert(frame);

	                //the grabbed frame will be flipped, re-flip to make it right
	                cvFlip(img, img, 1);// l-r = 90_degrees_steps_anti_clockwise

	                //save
	                cvSaveImage((i++) + "-aa.jpg", img);

	                canvas.showImage(converter.convert(img));

	                Thread.sleep(INTERVAL);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	public void init() {
		System.out.println("inside init method");
		 Test gs = new Test();
	        Thread th = new Thread(gs);
	        th.start();
	}

}
