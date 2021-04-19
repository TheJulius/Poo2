package revisao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Funcionario extends Usuario {
	
	private String nome;
	private String email;
	private Date dataNascimento;
	private double[] hrsTrabalhadas;
	private double[] vlrHora;
	
	public Funcionario(String usuario, String senha,String nome, String email, Date dataNascimento, double[] hrsTrabalhadas, double[] vlrHora) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		super();
		this.setUsuario(usuario);
		this.setSenha(senha);
		this.setNome(nome);
		this.setEmail(email);
		this.setDataNascimento(dataNascimento);
		this.setHrsTrabalhadas(hrsTrabalhadas);
		this.setVlrHora(vlrHora);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.length()!=0)
			this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email.length()!=0)
			this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		if(dataNascimento != null)
			this.dataNascimento = dataNascimento;
	}
	public double[] getHrsTrabalhadas() {
		return hrsTrabalhadas;
	}
	public void setHrsTrabalhadas(double[] hrsTrabalhadas) {
		this.hrsTrabalhadas = hrsTrabalhadas;
	}
	public double[] getVlrHora() {
		return vlrHora;
	}
	public void setVlrHora(double[] vlrHora) {
		this.vlrHora = vlrHora;
	}

	public Calendar possivelAposentadoria() { //preciso treinar mais datas, me perdi um pouco
		
		Calendar dateOfBirth = new GregorianCalendar();

		dateOfBirth.setTime(dataNascimento);

		dateOfBirth.add(Calendar.YEAR, 53);

		return dateOfBirth;

	}

	public double anosTrabalhados() {
		
		double anosTrabalhados = 0;
		
		for (int i = 0; i < hrsTrabalhadas.length; i++)
		{
			anosTrabalhados += hrsTrabalhadas[i];
		}
		
		return (anosTrabalhados/2080);
	}
	
	public double mesesTrabalhados() {
		
		double mesesTrabalhados = 0;
		
		for (int i = 0; i < hrsTrabalhadas.length; i++)
		{
			mesesTrabalhados += hrsTrabalhadas[i];
		}
		
		return (mesesTrabalhados/220);
	}
	
	public void maioresSalarios(int numeroDeSalarios) {	
		
		double[] salarios = salarioPorMes();
		
		for (int i = 0; i < salarios.length; i++) {
			salarios[i] = salarios[i] * -1;
		}
		
		Arrays.sort(salarios);
		
		for (int i = 0; i < salarios.length; i++) {
			salarios[i] = salarios[i] * -1;
		}
			
		Arrays.copyOf(salarios, numeroDeSalarios);
		
		for (int i = 0; i < salarios.length; i++) {
			System.out.println(salarios[i]);
		}
	}
	
	public void menoresSalarios(int numeroDeSalarios) {	
		
		double[] salarios = salarioPorMes();
		Arrays.sort(salarios);
			
		Arrays.copyOf(salarios, numeroDeSalarios);
		
		for (int i = 0; i < salarios.length; i++) {
			System.out.println(salarios[i]);
		}
	}
	
	public double mediaDosSalarios() {
		
		int mediaDosSalarios = 0;
		
		double[] salarios = salarioPorMes();
		
		for (int i = 0; i < salarios.length; i++)
		{
			mediaDosSalarios += salarios[i];
		}
		
		return mediaDosSalarios/salarios.length;
	}
	
	public double valorTotalDosSalarios() {
		
		int valorTotalDosSalarios = 0;
		
		double[] salarios = salarioPorMes();
		
		for (int i = 0; i < salarios.length; i++) 
		{
			valorTotalDosSalarios += salarios[i];
		}
		
		return valorTotalDosSalarios;
	}
	
	public double[] salarioPorMes() {
		
		double[] salarioPorMes = new double [hrsTrabalhadas.length];
		
		if(hrsTrabalhadas.length != vlrHora.length) 
		{
			if(hrsTrabalhadas.length < vlrHora.length) 
			{
				System.out.println("Adicione mais horas trabalhadas");
			}
			
			if(vlrHora.length < hrsTrabalhadas.length) 
			{
				System.out.println("Adicione mais valores hora");
			}
			
		} else 
		{
			for (int i = 0; i < salarioPorMes.length; i++) 
			{
				salarioPorMes[i] = hrsTrabalhadas[i] * vlrHora[i];
			}
		}
		
		return salarioPorMes;
	}	
}
