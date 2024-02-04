package com.system.gui;

import com.system.services.ApacheServices;

public class ApacheGui {
    
    public static void iniciar(String path){
        if(!ApacheServices.xlExists(path)){
            Object object = null;
            ApacheServices.creatDocument(path, object);
        }
    }
}

