/*
 * ******************************************************************************************
 * Copyright©
 *
 * Este software foi desenvolvido por Vinicius Chiarotti seguindo a Imersão Java da Alura.
 *
 * Criado em: 03/08/2022
 * Autor: Vinicius Chiarotti
 * Contato: vchiarotti@outlook.com
 *
 * ------------------------------------------------------------------------------------------
 * Portfolio: https://drextar.github.io/Portfolio/
 * Github: https://github.com/drextar
 * ------------------------------------------------------------------------------------------
 * ******************************************************************************************
 */
package main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.Transparency;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
        // leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int adicionarAltura = 200;
        int novaAltura = altura + adicionarAltura;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, Transparency.TRANSLUCENT);

        // copiar a imagem original pra novo imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        var fontSize = 64;
        var fontImpact = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/GODOFWAR.TTF")).deriveFont(Font.LAYOUT_LEFT_TO_RIGHT, fontSize);
        graphics.setFont(fontImpact);
        Color outlineColor = Color.black;
        Color fillColor = Color.yellow;

        // pegar o tamanho da fonte
        String textoImagem = "TOPZERA";
        AffineTransform affinetransform = new AffineTransform();     
        FontRenderContext frc = new FontRenderContext(affinetransform,true,true);     
        int textoLargura = (int)(fontImpact.getStringBounds(textoImagem, frc).getWidth());
        int textoAltura = (int)(fontImpact.getStringBounds(textoImagem, frc).getHeight());

        // escrever uma frase na nova imagem
        int centroLargura = (largura/2) - (textoLargura/2);
        int centroAltura = novaAltura  - textoAltura;
        graphics.setColor(outlineColor);
        for (int i = 1; i <= 5; i++) {
            graphics.drawString(textoImagem, centroLargura + i, centroAltura);
            graphics.drawString(textoImagem, centroLargura - i, centroAltura);
            graphics.drawString(textoImagem, centroLargura, centroAltura + i);
            graphics.drawString(textoImagem, centroLargura, centroAltura - i);
        }
        graphics.setColor(fillColor);
        graphics.drawString(textoImagem, centroLargura, centroAltura);

        // escrever a nova imagem em um arquivo
        File directory = new File("saida/");
        if (!directory.exists()){
            directory.mkdir();
        }
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
}