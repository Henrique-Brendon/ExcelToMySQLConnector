package com.system.interfac;

import com.system.model.entities.ProdutoExtends;

public interface ApacheInterface {
    void logo(ProdutoExtends produto);
    void aplicarEstilo(ProdutoExtends obj, int num);
    void estiloSecundario(ProdutoExtends obj, int num);

    
} 
