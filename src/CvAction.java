



import java.util.ArrayList;


import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;

import org.opencv.imgproc.Imgproc;


public class CvAction {

	
	public static Mat Canny (Mat inImg) {
		
		//Отрисовка границ


		Mat imgGray = new Mat();
		Imgproc.cvtColor(inImg, imgGray, Imgproc.COLOR_BGR2GRAY);
		Mat edges = new Mat();
		Imgproc.Canny(imgGray, edges, 80, 200);
		//CvUtilsFX.showImage(edges, "Canny");
		return edges;
		/*
		Mat edgesCopy = edges.clone(); // Создаем копию
		ArrayList<MatOfPoint> contours = new ArrayList<MatOfPoint>();
		Mat hierarchy = new Mat();
		Imgproc.findContours(edgesCopy, contours, hierarchy,
		                     Imgproc.RETR_TREE,
		                     Imgproc.CHAIN_APPROX_SIMPLE);
		System.out.println(contours.size());
		System.out.println(hierarchy.size());
		System.out.println(hierarchy.dump());
		Imgproc.drawContours(img, contours, -1, CvUtils.COLOR_WHITE);
		CvUtilsFX.showImage(img, "drawContours");
		img.release();   imgGray.release();
		edges.release(); edgesCopy.release();
		hierarchy.release();

		*/
		
	}
	
	public static Mat Contours (Mat inImg) {
	
		Mat edges = inImg.clone(); 
		Mat edges1 = inImg.clone(); 
		Imgproc.cvtColor(inImg, edges, Imgproc.COLOR_BGR2GRAY);
		
		ArrayList<MatOfPoint> contours = new ArrayList<MatOfPoint>();
		Mat hierarchy = new Mat();
		Imgproc.findContours(edges, contours, hierarchy,
		                     Imgproc.RETR_LIST,
		                     Imgproc.CHAIN_APPROX_SIMPLE);
		Imgproc.drawContours(edges1, contours, -1, CvUtils.COLOR_WHITE);
		
	 
	
		
		return edges1;
		/*
		System.out.println(contours.size());
		System.out.println(hierarchy.size());
		System.out.println(hierarchy.dump());
		
		//CvUtilsFX.showImage(img, "drawContours");

		hierarchy.release();*/
		
	}
	
	
	
	
	
	
	
	
	
}
