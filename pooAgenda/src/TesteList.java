import java.util.*;

public class TesteList {

	public static void main(String args[]) {
		List l = new ArrayList();
		
		IF_Contato[] c = new IF_Contato[3];
		
		c[0] = new Contato();
		c[0].setNome("Eduardo");
		c[0].setTelefone("9999-0000");
		
		c[1] = new Contato();
		c[1].setNome("Camila");
		c[1].setTelefone("8888-0000");
		
		c[2] = new Contato();
		c[2].setNome("Edu");
		c[2].setTelefone("9999-0000");
		
		l.add(c[0]);
		l.add(c[1]);
		//l.add(c[2]);
		
		Iterator it = l.iterator();
		
		while(it.hasNext()){
			IF_Contato o = (IF_Contato) it.next();
			System.out.println(o);
		}
		
		System.out.println(l);
		
		int i = l.indexOf(c[2]);
		
		System.out.println(l.get(i));
		
		l.remove(i);
		
		System.out.println(l);
	}

}
