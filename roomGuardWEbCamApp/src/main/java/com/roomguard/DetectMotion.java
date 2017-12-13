package com.roomguard;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamMotionDetector;
import com.github.sarxos.webcam.WebcamMotionEvent;
import com.github.sarxos.webcam.WebcamMotionListener;

import javax.imageio.ImageIO;


/**
 * Detect motion. This example demonstrates how to use build-in motion detector
 * and motion listener to fire motion events.
 *
 * @author Bartosz Firyn (SarXos)
 */
public class DetectMotion implements WebcamMotionListener  {

    public DetectMotion() {
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(640, 480));
        WebcamMotionDetector detector = new WebcamMotionDetector(webcam);
        detector.setInterval(500); // one check per 500 ms
        detector.addMotionListener(this);
        detector.start();
    }

    @Override
    public void motionDetected(WebcamMotionEvent wme){
        System.out.println("Detected motion, Alarm turned on...");
        try {

            ImageIO.write(wme.getCurrentImage(), "PNG", new File("currentImage.png"));

            ImageIO.write(wme.getPreviousImage(), "PNG", new File("previousImage.png"));

            Thread.sleep(2000);

            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new DetectMotion();
        System.in.read(); // keep program open
    }
}