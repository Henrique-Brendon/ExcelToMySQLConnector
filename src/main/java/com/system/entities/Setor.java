package com.system.entities;

import java.util.HashMap;
import java.util.Map;

import com.system.typeEnum.EnumProduto;

public class Setor {
	private EnumProduto nomemClaEnumProduto;

	public Setor(EnumProduto enumP) {
		this.nomemClaEnumProduto = enumP;
	}

	public EnumProduto getNomemClaEnumProduto() {
		return nomemClaEnumProduto;
	}

	public void setNomemClaEnumProduto(EnumProduto nomemClaEnumProduto) {
		this.nomemClaEnumProduto = nomemClaEnumProduto;
	}

	public static Setor mapSetor(String aux) {
		Map<String, Setor> map = new HashMap<>();
		// NVIDIA
		map.put("GTX 960", new Setor(EnumProduto.HARDWARE));
		map.put("GTX 970", new Setor(EnumProduto.HARDWARE));
		map.put("GTX 980", new Setor(EnumProduto.HARDWARE));
		map.put("GTX 1060", new Setor(EnumProduto.HARDWARE));
		map.put("GTX 1070", new Setor(EnumProduto.HARDWARE));
		map.put("GTX 1080", new Setor(EnumProduto.HARDWARE));
		map.put("GTX 1080 TI", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 2060", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 2060 SUPER", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 2070", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 2070 TI", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 2080", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 2080 TI", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 3060", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 3060 TI", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 3070", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 3070 TI", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 3080", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 3080 TI", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 4060", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 4060 TI", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 4070", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 4070 TI", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 4080", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 4080 TI", new Setor(EnumProduto.HARDWARE));
		map.put("RTX 4090 TI", new Setor(EnumProduto.HARDWARE));
		//
		// AMD
		map.put("RYZEN 3 3200G", new Setor(EnumProduto.HARDWARE));
		map.put("RYZEN 5 3500", new Setor(EnumProduto.HARDWARE));
		map.put("RYZEN 5 3600", new Setor(EnumProduto.HARDWARE));
		map.put("RYZEN 5 3600X", new Setor(EnumProduto.HARDWARE));
		map.put("RYZEN 5 5500", new Setor(EnumProduto.HARDWARE));
		map.put("RYZEN 5 5600", new Setor(EnumProduto.HARDWARE));
		map.put("RYZEN 5600G", new Setor(EnumProduto.HARDWARE));
		map.put("RYZEN 5 5700", new Setor(EnumProduto.HARDWARE));
		map.put("RYZEN 5 5800", new Setor(EnumProduto.HARDWARE));
		map.put("RYZEN 5 5800X", new Setor(EnumProduto.HARDWARE));
		map.put("RX 550", new Setor(EnumProduto.HARDWARE));
		map.put("RX 560", new Setor(EnumProduto.HARDWARE));
		map.put("RX 570", new Setor(EnumProduto.HARDWARE));
		map.put("RX 580", new Setor(EnumProduto.HARDWARE));
		//
		// INTEL
		map.put("Intel Core i3-8100", new Setor(EnumProduto.HARDWARE));
		map.put("Intel Core i5-6400", new Setor(EnumProduto.HARDWARE));
		map.put("Intel Core i5-8500", new Setor(EnumProduto.HARDWARE));
		map.put("Intel Core i5-8400", new Setor(EnumProduto.HARDWARE));
		map.put("Intel Core i5-500", new Setor(EnumProduto.HARDWARE));
		map.put("Intel Core i7-500", new Setor(EnumProduto.HARDWARE));
		map.put("Intel Core i3-6400", new Setor(EnumProduto.HARDWARE));
		Setor sec = new Setor(EnumProduto.DEFAULT);

		if (map.get(aux) != null) {
			sec = map.get(aux);
		}
		return sec;
	}

}
