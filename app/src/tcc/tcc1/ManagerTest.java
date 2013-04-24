package tcc.tcc1;

import java.util.ArrayList;

public abstract class ManagerTest {
	private static int idImagemCorrente = 0;
	private static int quantidadeTelasPorGrupo = 0;
	private static int quantidadeGruposTeste = 0;
	private static int quantidadeTentativasPorImagem = 0;
	private static ArrayList<Image> imagens = new ArrayList<Image>();
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
	 * @return a m�dia aritim�tica simples dos resultados parciais
	 */
	public static int getResultado (){
		int soma = 0;
		for (int i=0; i<respostas.size();i++){
			soma += respostas.get(i);
		}
		return Math.round(soma/respostas.size());
	}
	
	public static Image getImagemCorrente(){
		return imagens.get(idImagemCorrente);
	}
	
	public static int getIdImagemCorrente() {
		return idImagemCorrente;
	}

	public static void setIdImagemCorrente(int idImagemCorrente) {
		ManagerTest.idImagemCorrente = idImagemCorrente;
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

	public static ArrayList<Image> getImagens() {
		return imagens;
	}

	public static void setImagens(ArrayList<Image> imagens) {
		ManagerTest.imagens = imagens;
	}
	
	public static void setImagens(Image imagem) {
		imagens.add(imagem);
	}
}
