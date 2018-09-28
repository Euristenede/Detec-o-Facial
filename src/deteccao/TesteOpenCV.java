/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deteccao;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import static org.opencv.imgcodecs.Imgcodecs.CV_LOAD_IMAGE_COLOR;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.COLOR_BGR2GRAY;

/**
 *
 * @author euris
 */
public class TesteOpenCV {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println(Core.VERSION);
        
        Mat imagenColorida = imread("src\\deteccao\\opencv-java.jpg", CV_LOAD_IMAGE_COLOR);
        Utilitarios ut = new Utilitarios();
        ut.mostraImagem(ut.convertMatToImage(imagenColorida)); 
        
        Mat imagenCinza = new Mat();
        Imgproc.cvtColor(imagenColorida, imagenCinza, COLOR_BGR2GRAY);//Passando a imagen para escala de cinza
        ut.mostraImagem(ut.convertMatToImage(imagenCinza));
    }
}
