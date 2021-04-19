package revisao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
		
		String dataNascimento = "15/02/1997";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataFormatada = formato.parse(dataNascimento);
		
		double[] horasTrabalhadas = {8,8,8,8,8};
		double[] vlrHora = {10,15,12,15,20};
		
		Funcionario f = new Funcionario("Julio","1132465","Julio Cesar de Sousa", "juliocswin@gmail.com", dataFormatada, horasTrabalhadas, vlrHora);
		
		System.out.println("Salario por mes: ");
		
		for (int i = 0; i < f.salarioPorMes().length; i++) {
			System.out.println(f.salarioPorMes()[i]);
		}
		
		System.out.println("Menores Salarios: ");
		f.menoresSalarios(3);
		
		System.out.println("Maiores Salarios");
		f.maioresSalarios(3);
		
		System.out.println("Media dos Salarios: " + f.mediaDosSalarios());
		System.out.println("Valor Total dos Salarios: " + f.valorTotalDosSalarios());
		System.out.println("Meses Trabalhados em Horas / Ano: " + f.mesesTrabalhados());
		System.out.println("Anos Trabalhados em Horas / Ano: " + f.anosTrabalhados());
		System.out.println();
		System.out.println("Possivel Aposentadoria (nao esta funcionando direito)" + f.possivelAposentadoria());
	}

}
