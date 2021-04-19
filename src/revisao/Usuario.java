package revisao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario {
	
	private String usuario;
	private String senha;
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		if(usuario.length() != 0)
			this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if(senha == usuario)
			System.out.println("A senha nao pode ser igual ao usuario");
		
		MessageDigest algorithm = MessageDigest.getInstance("SHA-1");
	       byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

	       StringBuilder hexString = new StringBuilder();
	       for (byte b : messageDigest) {
	         hexString.append(String.format("%02X", 0xFF & b));
	       }
	       String senhahex = hexString.toString();
	       
		this.senha = senhahex;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [usuario=");
		builder.append(usuario);
		builder.append(", senha=");
		builder.append(senha);
		builder.append("]");
		return builder.toString();
	} 
	
	
}
