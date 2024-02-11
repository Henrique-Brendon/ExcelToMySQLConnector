package com.system.interfac;

import com.system.entities.ProdutoExtends;

public interface ApacheInterface {
    void logo(ProdutoExtends produto);
    void aplicarEstilo(ProdutoExtends obj, int num);
    void estiloSecundario(ProdutoExtends obj, int num);

    
} 
