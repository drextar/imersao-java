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

public enum API {
    NASA("https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope", new ExtratorDeConteudoDaNasa()),
    IMDB("https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060", new ExtratorDeConteudoDoIMDB());

    private String url;
    private ExtratorDeConteudo extrator;
    API(String url, ExtratorDeConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }
    public String url() {
        return url;
    }
    public ExtratorDeConteudo extrator() {
        return extrator;
    }
}