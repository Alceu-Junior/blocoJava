package dominio;

public class Aluno extends Usuario {

	private int anoIngresso;
	

	public void setAnoIngresso(int anoIngresso) {
		this.anoIngresso = anoIngresso;
	}
	public float getAnoIngresso() {
		return anoIngresso;
	}
	
	@Override
	public void imprimir() throws Exception {
		
		System.out.printf("%d :: %s - %d - %d \n", 
				this.getId(), 
				this.getNome(), 
				this.getIdade(),
				anoIngresso
			);
		
	}

}