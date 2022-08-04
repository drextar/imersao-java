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

import java.util.List;

public interface ExtratorDeConteudo {

    List<Conteudo> extraiConteudos(String json);

}