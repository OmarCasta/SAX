import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Read_XML {
	public static void main(String[] args) throws Exception {
		char vmenu;
		Scanner scanner = new Scanner(System.in);	
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		//Construir Documento
		Document document = builder.parse(new File("books.xml"));
		//Normaliza la estructura XML
		document.getDocumentElement().normalize();
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());
		NodeList nList = document.getElementsByTagName("book");
		System.out.println("============================");
		do{
			menu();
			vmenu=scanner.next().charAt(0);
			switch(vmenu){
				case 'H': case 'h':
					Horror(nList);
				break;
				case 'F': case 'f':
					Fantasia(nList);
				break;
				case 'M': case'm':
					Microsoft(nList);
				break;
			}
		}while(!(vmenu=='S'||vmenu=='s'));
		System.out.println("Haz salido del sistema");
}
	public static void menu(){
		System.out.println("**********************************************************************************");
		System.out.println("****Estas en el Menu Principal****************************************************");
		System.out.println("****Presiona H para buscar las peliculas de Horror********************************");
		System.out.println("****Presiona F para mostrar el total de compras de Fantasia***********************");
		System.out.println("****Presiona M para mostrar todos los libros que tengan que ver con Microsoft*****");
		System.out.println("****Presiona S para poder salir **************************************************");
		System.out.println("**********************************************************************************");		
}
	public static void Horror(NodeList nLists){
		String var="Horror";
		for (int temp = 0; temp < nLists.getLength(); temp++){
			Node node = nLists.item(temp);
		    Element eElement = (Element) node;	
			if (var.equals(eElement.getElementsByTagName("genre").item(0).getTextContent())){
		    		System.out.println("id : "    + eElement.getAttribute("id"));
		    		System.out.println("title : "  + eElement.getElementsByTagName("title").item(0).getTextContent());
		    		System.out.println("author : "  + eElement.getElementsByTagName("author").item(0).getTextContent());
		    		System.out.println("genre : "   + eElement.getElementsByTagName("genre").item(0).getTextContent());
		    		System.out.println("price : "    + eElement.getElementsByTagName("price").item(0).getTextContent());
		 		System.out.println("publish_date : "  + eElement.getElementsByTagName("publish_date").item(0).getTextContent());
		    		System.out.println("description : "   + eElement.getElementsByTagName("description").item(0).getTextContent());
		    }
		}
}
	public static void Fantasia(NodeList nLists){		
		float total=0,precio=0;
		String precio_book,var2="Fantasy";
		for (int temp = 0; temp < nLists.getLength(); temp++)
		{
			Node node = nLists.item(temp);
		    	Element eElement = (Element) node;	
			if (var2.equals(eElement.getElementsByTagName("genre").item(0).getTextContent())){
		    		System.out.println("id : "    + eElement.getAttribute("id"));
		    		System.out.println("title : "  + eElement.getElementsByTagName("title").item(0).getTextContent());
		    		System.out.println("author : "  + eElement.getElementsByTagName("author").item(0).getTextContent());
		    		System.out.println("genre : "   + eElement.getElementsByTagName("genre").item(0).getTextContent());
		    		System.out.println("price : "    + eElement.getElementsByTagName("price").item(0).getTextContent());
		 		precio_book=eElement.getElementsByTagName("price").item(0).getTextContent();
				precio=Float.parseFloat(precio_book);
				total=precio+total;
				System.out.println("publish_date : "  + eElement.getElementsByTagName("publish_date").item(0).getTextContent());
		    		System.out.println("description : "   + eElement.getElementsByTagName("description").item(0).getTextContent());
		    		System.out.println("----------------------------------------------------------------------------------");
			}
		}
		System.out.println("El costo total de los libros de fantasia son: "+total);
		System.out.println("----------------------------------------------------------------------------------");
}
	public static void Microsoft(NodeList nLists){
		String palabra = "Microsoft",texto;
		boolean resultado = false;
		System.out.println("");
		System.out.println("");
		System.out.println("----------------------------------------------------------------------------------");			
		System.out.println("A continuacion el listado de libros que no debes de leer por que son de Microsft: ");
		System.out.println("----------------------------------------------------------------------------------");			
		for (int temp = 0; temp < nLists.getLength(); temp++){
			Node node = nLists.item(temp);
			Element eElement = (Element) node;
			texto=eElement.getElementsByTagName("description").item(0).getTextContent();
			resultado=texto.contains(palabra);
			if(resultado){
				System.out.println("id : "    + eElement.getAttribute("id"));
		   		System.out.println("title : "  + eElement.getElementsByTagName("title").item(0).getTextContent());
		    		System.out.println("author : "  + eElement.getElementsByTagName("author").item(0).getTextContent());
		    		System.out.println("description : "   + eElement.getElementsByTagName("description").item(0).getTextContent());
		    		System.out.println("----------------------------------------------------------------------------------");			
			}
		}
}	
}
