
//package application;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;



public class Camera {

   static {
      System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
   }
   public static boolean isRun = true;
   public static boolean isEnd = false;

   public static void video(MainWindow window, JLabel panel) {
      


      // Подключаемся к камере
      VideoCapture camera = new VideoCapture(0);
      if (!camera.isOpened()) {
    
         isRun = false;
         isEnd = true;
         return;
      }
      try {
         // Задаем размеры кадра
         camera.set(Videoio.CAP_PROP_FRAME_WIDTH, 640);
         camera.set(Videoio.CAP_PROP_FRAME_HEIGHT, 480);
         // Считываем кадры
         Mat frame = new Mat();
         BufferedImage img = null;
         while ( isRun ) {
            if (camera.read(frame)) {
               // Здесь можно вставить код обработки кадра
            	//frame = CvAction.Canny(frame);
            	
            	if (MainWindow.scanFlag == true) QrCode.rotaitingScan(frame);
            	
            	img = CvUtils.MatToBufferedImage(frame);
               
               //QrCode.scan(img);
               
               if (img != null) {
                  ImageIcon imageIcon = new ImageIcon(img);
                panel.setIcon(imageIcon);
                  panel.repaint();
                  window.pack();
               }
               try {
                 Thread.sleep(1); // 10 кадров в секунду
               } catch (InterruptedException e) {}
            }
            else {
               System.out.println("Не удалось захватить кадр");
               break;
            }
         }
      }
     finally {
         camera.release();
         isRun = false;
         isEnd = true;
      }
    //  window.setTitle("Камера отключена");
   }
}
