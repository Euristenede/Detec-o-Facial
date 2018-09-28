/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deteccao;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Mat;

/**
 *
 * @author euris
 */
public class Utilitarios {

    public BufferedImage convertMatToImage(Mat mat) {//Recebe um objeto do tipo Mat e converte em um BufferedImage
        int type = BufferedImage.TYPE_BYTE_GRAY;// Indica o tipo da imagen -> começa em escala de cinza
        if (mat.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;// Se os canais da imagen for maios que 1, passa para RGB
        }

        int bufferSize = mat.channels() * mat.cols() * mat.rows();//Multiplica o num de canais pelas colunas e pelas linhas
        byte[] bytes = new byte[bufferSize];//Cria um array de bytes do tamanho bufferSize
        mat.get(0, 0, bytes);// Pega todos os bytes da imagen
        BufferedImage imagem = new BufferedImage(mat.cols(), mat.rows(), type);// O buffer recebe a quantidade de linhas, colunas e o tipo -> Gray ou RGB
        byte[] targetPixels = ((DataBufferByte) imagem.getRaster().getDataBuffer()).getData();// Pega todas as informações da imagem
        System.arraycopy(bytes, 0, targetPixels, 0, bytes.length);//Copia o vetor de bytes da imagen original para o novo formato targetPixels, nova imagen no formato bufferimage
        return imagem;
    }

    public void mostraImagem(BufferedImage imagem) {
        ImageIcon icon = new ImageIcon(imagem);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(imagem.getWidth() + 50, imagem.getHeight() + 50);
        JLabel lbl = new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
