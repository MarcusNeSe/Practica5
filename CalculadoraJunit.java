public class CalculadoraJunit {

public String sumar (String a, String b) {
String respuesta = "";
respuesta = (Double.parseDouble(a)+ Double.parseDouble(b))+"";
return respuesta;

}
public String resta (String a, String b) {
String respuesta = "";
respuesta = (Double.parseDouble(a)- Double.parseDouble(b))+"";
return respuesta;

}
public String multiplicar (String a, String b) {
String respuesta = "";
respuesta = (Double.parseDouble(a)* Double.parseDouble(b))+"";
return respuesta;

/* vemos que en cada metodo es una forma diferente de hacer un cálculo, como por ejemplo sumar, dividdir, restar, dividir...  */

}
public String dividir (String a, String b) {
String respuesta = "";
try {
respuesta = (Double.parseDouble(a)/ Double.parseDouble(b))+"";
}
catch (Exception e) {
respuesta ="Error al dividir por cero";
}
return respuesta;

}

}
