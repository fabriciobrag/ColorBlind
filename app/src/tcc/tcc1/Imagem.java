package tcc.tcc1;

public class Imagem {

	
	private int valor, id, grupoId, indiceGrupo, resourceId;
	private String simbolo;
	


	public Imagem(int valor, int id, int grupoId, int indiceGrupo,
			int resourceId, String simbolo) {
		super();
		this.valor = valor;
		this.id = id;
		this.grupoId = grupoId;
		this.indiceGrupo = indiceGrupo;
		this.resourceId = resourceId;
		this.simbolo = simbolo;
	}
	
	public Imagem(int id) {
		super();
		this.id = id;
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	
	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}

	public int getIndiceGrupo() {
		return indiceGrupo;
	}

	public void setIndiceGrupo(int indiceGrupo) {
		this.indiceGrupo = indiceGrupo;
	}
	
	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
		
	}
	
	public boolean isIgualId(String simbolo){
		return (this.simbolo.compareToIgnoreCase(simbolo) ==0);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imagem other = (Imagem) obj;
		if (id != other.id)
			return false;
		return true;
	}	
}
