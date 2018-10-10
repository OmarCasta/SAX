import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;
	
//import java.util.Array;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SAX_Tarea {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);	
		//Get Docuemnt Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		 
		//Build Document
		Document document = builder.parse(new File("books.xml"));
		 
		//Normalize the XML Structure; It's just too important !!
		document.getDocumentElement().normalize();
		 
		//Here comes the root node
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());
		 
		//Get all employees
		NodeList nList = document.getElementsByTagName("book");
		System.out.println("============================");
		char vmenu;
		do{
			menu();
			vmenu=scanner.next().charAt(0);
			switch(vmenu){
				case 'H':
					Horror(nList);
				break;
				case 'F':
					Fantasia(nList);
				break;
				case 'M':
					Microsoft();
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
		//NodeList nList = document.getElementsByTagName("book");
		for (int temp = 0; temp < nLists.getLength(); temp++)
		{
			Node node = nLists.item(temp);
			String var="Horror";
		    Element eElement = (Element) node;	
			if (var.equals(eElement.getElementsByTagName("genre").item(0).getTextContent())){
		    System.out.println("id : "    + eElement.getAttribute("id"));
		    System.out.println("author : "  + eElement.getElementsByTagName("author").item(0).getTextContent());
		    System.out.println("genre : "   + eElement.getElementsByTagName("genre").item(0).getTextContent());
		    System.out.println("price : "    + eElement.getElementsByTagName("price").item(0).getTextContent());
		 	System.out.println("publish_date : "  + eElement.getElementsByTagName("publish_date").item(0).getTextContent());
		    System.out.println("description : "   + eElement.getElementsByTagName("description").item(0).getTextContent());
		    }
		}
	}
	public static void Fantasia(NodeList nLists){
		int Total=0,Total2=0;
		ArrayList<String> datos=new ArrayList<String>();  
		String receptora;
		for (int temp = 0; temp < nLists.getLength(); temp++)
		{
			Node node = nLists.item(temp);
			String var2="Fantasy";
		    Element eElement = (Element) node;	
			if (var2.equals(eElement.getElementsByTagName("genre").item(0).getTextContent())){
		    System.out.println("id : "    + eElement.getAttribute("id"));
		    System.out.println("author : "  + eElement.getElementsByTagName("author").item(0).getTextContent());
		    System.out.println("genre : "   + eElement.getElementsByTagName("genre").item(0).getTextContent());
		    System.out.println("price : "    + eElement.getElementsByTagName("price").item(0).getTextContent());
		 	datos.add(eElement.getElementsByTagName("price").item(0).getTextContent());
			System.out.println("publish_date : "  + eElement.getElementsByTagName("publish_date").item(0).getTextContent());
		    System.out.println("description : "   + eElement.getElementsByTagName("description").item(0).getTextContent());
		    }
		}
		String prueba=datos.get(1);
		System.out.println("Prueba EN STRING: "+prueba);
		String t_men=prueba.substring(0,2);		
		System.out.println("Prueba EN STRING: "+t_men);
    // RECIVE FLOAT INSTEAD OF INT
		float prueba_1=Float.parseFloat(prueba);		
		System.out.println("Prueba EN INT: "+prueba_1);
		
}
	public static void Microsoft(){
		
	}	
}
