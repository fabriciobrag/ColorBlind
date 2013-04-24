package tcc.tcc1;

import java.util.ArrayList;

public abstract class GerenciaTeste {
	private static int idImagemCorrente = 0;
	private static int quantidadeTelasPorGrupo = 0;
	private static int quantidadeGruposTeste = 0;
	private static int quantidadeTentativasPorImagem = 0;
	private static ArrayList<Imagem> imagens = new ArrayList<Imagem>();
	private static ArrayList<Integer> respostas = new ArrayList<Integer>();
	
	
	public static void setResposta (int valor){
		respostas.add(new Integer(valor));
	}
	
	public static int getResposta (int indiceGrupo){
		return (respostas.get(indiceGrupo).intValue());
	}
	
	/**
	 * Retorna o resultado geral do teste, de acordo com os resultado
	 * parciais obtidos.
	 * @return a média aritimética simples dos resultados parciais
	 */
	public static int getResultado (){
		int soma = 0;
		for (int i=0; i<respostas.size();i++){
			soma += respostas.get(i);
		}
		return Math.round(soma/respostas.size());
	}
	
	public static Imagem getImagemCorrente(){
		return imagens.get(idImagemCorrente);
	}
	
	public static int getIdImagemCorrente() {
		return idImagemCorrente;
	}

	public static void setIdImagemCorrente(int idImagemCorrente) {
		GerenciaTeste.idImagemCorrente = idImagemCorrente;
	}

	public static int getquantidadeTelasPorGrupo() {
		return quantidadeTelasPorGrupo;
	}

	public static void setquantidadeTelasPorGrupo(
			int quantTelasPorGrupo) {
		quantidadeTelasPorGrupo = quantTelasPorGrupo;
	}

	public static int getquantidadeGruposTeste() {
		return quantidadeGruposTeste;
	}

	public static void setquantidadeGruposTeste(
			int quantGruposTeste) {
		quantidadeGruposTeste = quantGruposTeste;
	}

	public static int getquantidadeTentativasPorImagem() {
		return quantidadeTentativasPorImagem;
	}

	public static void setquantidadeTentativasPorImagem(
			int quantTentativasPorImagem) {
		quantidadeTentativasPorImagem = quantTentativasPorImagem;
	}

	public static ArrayList<Imagem> getImagens() {
		return imagens;
	}

	public static void setImagens(ArrayList<Imagem> imagens) {
		GerenciaTeste.imagens = imagens;
	}
	
	public static void setImagens(Imagem imagem) {
		imagens.add(imagem);
	}
}
