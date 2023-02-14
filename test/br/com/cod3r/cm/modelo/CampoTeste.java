package br.com.cod3r.cm.modelo;

import br.com.cod3r.cm.excessao.ExplosaoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampoTeste {

    private Campo campo;

    @BeforeEach
    void instanciaCampo() {
        campo = new Campo(3, 3);
    }

    @Test
    void testeVizinhoRealDistancia1Esquerda() {
        Campo vizinho = new Campo(3, 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia1Direita() {
        Campo vizinho = new Campo(3, 4);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia1EmCima() {
        Campo vizinho = new Campo(4, 3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoRealDistancia1EmBaixo() {
        Campo vizinho = new Campo(4, 3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeNaoVizinhoDistancia2() {
        Campo vizinho = new Campo(1, 1);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertFalse(resultado);
    }

    @Test
    void testeNaoVizinho() {
        Campo vizinho = new Campo(1, 1);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertFalse(resultado);
    }

    @Test
    void testeValorPadraoAtributoMarcado() {
        assertFalse(campo.isMarcado());
    }

    @Test
    void alternarMarcacao() {
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
    }

    @Test
    void alternarMarcacaoDuasChamadas() {
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado());
    }

    @Test
    void abrirNaoMinadoNaoMarcado() {
        assertTrue(campo.abrir());
    }

    @Test
    void abrirNaoMinadoMarcado() {
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }

    @Test
    void abrirMinadoMarcado() {
        campo.alternarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }

    @Test
    void abrirMinadoNaoMarcado() {
        campo.minar();
        // garatantir que a chamada gerou uma excessão
        assertThrows(ExplosaoException.class, () -> {
            campo.abrir();
        });
    }

    @Test
    void testeComVizinhos1() {
        Campo campo11 = new Campo(1, 1);
        Campo campo22 = new Campo(2, 2);
        campo22.adicionarVizinho(campo11);

        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isAberto());
    }

    @Test
    void testeComVizinhos2() {
        Campo campo11 = new Campo(1, 1);
        Campo campo12 = new Campo(1, 2);
        campo12.minar();

        Campo campo22 = new Campo(2, 2);
        campo22.adicionarVizinho(campo11);
        campo22.adicionarVizinho(campo12);

        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertTrue(campo22.isAberto() && !campo11.isAberto());
    }


}