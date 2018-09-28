/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deteccaoCarros;

import deteccao.*;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.COLOR_BGR2GRAY;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author euris
 */
public class DeteccaoCarros {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat imagemColorida = imread("src\\outros\\carro2.jpg");
        Mat imagemCinza = new Mat();
        Imgproc.cvtColor(imagemColorida, imagemCinza,COLOR_BGR2GRAY);
        
        CascadeClassifier classificador = new CascadeClassifier("src\\cascades\\cars.xml");
        MatOfRect facesDetectadas = new MatOfRect();
        classificador.detectMultiScale(imagemCinza, facesDetectadas, 
                1.01,//scale factor
                8,// minNeighbors
                0,// flags
                new Size(30, 30), //minSize
                new Size(400,400)); //maxSize
        System.out.println(facesDetectadas.toArray().length);
    
        for(Rect rect : facesDetectadas.toArray()){
            System.out.println(rect.x + " " + rect.y + " " + rect.width + " " + rect.height );
            Imgproc.rectangle(imagemColorida, new Point(rect.x , rect.y) , new Point(rect.x + rect.width , rect.y + rect.height), new Scalar(27, 129, 29), 2);//Imprimindo um retângulo em volta da face detectada
        }
        Utilitarios ut = new Utilitarios();
        ut.mostraImagem(ut.convertMatToImage(imagemColorida));
        
    }
}
