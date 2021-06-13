package dominio;

//import exceptions.NomeIncompletoException;

public class Professor extends Usuario {

	private float salario;
	
	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	@Override
	public void imprimir() throws Exception {
		
		
		System.out.printf("%d :: %s - %d - R$%.2f \n", 
				this.getId(), 
				this.getNome(), 
				this.getIdade(),
				salario
			);
	}
}
