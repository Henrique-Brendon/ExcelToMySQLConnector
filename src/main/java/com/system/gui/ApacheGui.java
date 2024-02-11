package com.system.gui;

import java.util.Scanner;
////import com.system.apacheException.ApacheException;

import com.system.apacheException.ApacheException;
import com.system.entities.entitiesProduto.Amd;
import com.system.entities.entitiesProduto.Intel;
import com.system.entities.entitiesProduto.Nvidia;
import com.system.services.ApacheServices;

public class ApacheGui {

	public static void iniciar(String path) {
		if (!ApacheServices.xlExists(path)) {
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println(" --Escolha a estrutura da planilha-- ");
				System.out.println("Nvidia[1]");
				System.out.println("AMD[2]");
				System.out.println("Intel[3]");
				System.out.println("Samsung[4]");

				int infoNum = sc.nextInt();
				switch (infoNum) {
				case 1:
					ApacheServices.criarDocumento(path, new Nvidia());
					break;
				case 2:
					ApacheServices.criarDocumento(path, new Amd());
					break;
				case 3:
					ApacheServices.criarDocumento(path, new Intel());
					break;
				default:
					throw new ApacheException("Erro, nenhuma das opções foram escolhidas");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
