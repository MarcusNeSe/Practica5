# Practica-5 | Adrià Juan & Marc Negre

___
- Código de creación de Calculadora.
___

Aquí vamos a implementar los metodos de la calculadora y posteriormente el código de la interfaz gráfica.
```
public class Calculadora {

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
```

A continuación la interfaz de la misma:

```
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigo.Calculadora;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCalculadora extends JFrame {

private JPanel contentPane;
private Calculadora codigo;
private JTextField textField;
private JTextField textField_1;


?Launch the application.?

public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
VentanaCalculadora frame = new VentanaCalculadora();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the frame.
*/
public VentanaCalculadora() {
codigo = new Calculadora();
setTitle("Calculadora");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 450, 300);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
contentPane.setLayout(new BorderLayout(0, 0));
setContentPane(contentPane);

JLabel labelRespuesta = new JLabel("0");
contentPane.add(labelRespuesta, BorderLayout.NORTH);

JPanel panel = new JPanel();
contentPane.add(panel, BorderLayout.CENTER);
panel.setLayout(new GridLayout(0, 2, 0, 0));

textField = new JTextField();
panel.add(textField);
textField.setColumns(10);

textField_1 = new JTextField();
panel.add(textField_1);
textField_1.setColumns(10);

JButton btnSuma = new JButton("Suma");
btnSuma.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
labelRespuesta.setText(codigo.sumar(textField.getText(), textField_1.getText()));
}
});
panel.add(btnSuma);

JButton btnResta = new JButton("Resta");
btnResta.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
labelRespuesta.setText(codigo.resta(textField.getText(), textField_1.getText()));
}
});
panel.add(btnResta);

JButton btnMultiplicacion = new JButton("Multiplicacion");
btnMultiplicacion.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
labelRespuesta.setText(codigo.multiplicar(textField.getText(), textField_1.getText()));
}
});
panel.add(btnMultiplicacion);

JButton btnDivision = new JButton("Division");
btnDivision.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
labelRespuesta.setText(codigo.dividir(textField.getText(), textField_1.getText()));
}
});
panel.add(btnDivision);
}
}
```

___
- Primer Commit de la Calculadora:
___

Una vez hemos creado el códgio lo que hemos hecho ha sido entar en la carpeta de la practica y he usado un `git init`, luego hemos hecho un `git add .`, para poner todos los archivos en el área de ensayo, luego creamos el primero commit con `git commit -m "Interfaz y Clase"`.

Cuando lo tengamos crearemos la rama Master para subir este commit ahí pero todavía hay que crear la rama Master y el tag.
Para hacer la rama Master usaremos el comando `git branch master`, ahora nos posicionamos en ella con `git checkout master` y ahora subiremos el primer commit a GitHub con `git remote add origin URLdeTuProyectoEnGithub` y lo subimos con un `git push origin master`.

Ahora crearemos el tag `v.1.0.0` primero hay que saber el código del commit usando `git log --oneline` y nos saldrán todos los registros nosotors cogeremos el que tiene nombre de "Interfaz y Clase" (hay que coger su código) y usaremos el siguiente comando `git tag -a v1.0.0 -m "Primer commit" código`.

Luego subimos el tag con `git push origin v1.0.0`.

![image](https://user-images.githubusercontent.com/101186662/168579977-63f26c36-29db-4540-9fe0-1812cb7ad2d7.png)
![image](https://user-images.githubusercontent.com/101186662/168580194-8f7644d3-c0f6-4cdb-8545-fff6acdb532f.png)

Lo de crear la rama master sale como que ya la tengo creada porque ya estaba creada cuando se hace el repositorio.

___
- Pruebas Junit.
___

Vamos a hacer un par de pruebas, una clase Suma.java y otra clase Resta.java. Ambas tienen dos métodos, la primera getSuma() e incrementa(), la segunda getDiferencia() y decrementa(). En los enlaces puedes ver el código completo de estas clases.

Vamos a usar JUnit para hacer los test de estas clases y de sus métodos. Las versiones 3.8.1 y 4.5 de JUnit sirven para lo mismo y hacen lo mismo, pero de distinta manera, así que empezaremos con JUnit 3.8.1 y luego contaremos las diferencias con la 4.5.

- En el caso de JUnit 3.8.1, debemos hacer que estas clases de prueba hereden de la clase TestCase de JUnit. Para JUnit un TestCase es una clase de test. Tenemos entonces, dos clases TestSuma y TestResta, que van a heredar ambas de TestCase

```

import junit.framework.TestCase
...
public class TestSuma extends TestCase {
   ...
}
```

Ahora tenemos que hacer los métodos de test. Cada método probará alguna cosa de la clase. JUnit 3.8.1 requiere que estos métodos empiecen por test. En el caso de TestSuma, vamos a hacer dos métodos de test, de forma que cada uno pruebe uno de los métodos de la clase Suma.

Por ejemplo, para probar el método getSuma() de la clase Suma, vamos a hacer un método de prueba testGetSuma(). Este método sólo tiene que instanciar la clase Suma, llamar al método getSuma() con algunos parámetros y comprobar que el resultado es el esperado.

```
import junit.framework.TestCase
...
public class TestSuma extends TestCase {
   Suma suma = new Suma();
   double resultado = suma.getSuma(1.0, 1.0);
   // Aqui debemos comprobar el resultado
}
```

El ejemplo es muy tonto, porque vamos a sumar 1 más 1, que ya sabemos que a veces devuelve 2. ¿Cómo comprobamos ahora que el resultado es el esperado?. Al heredar de TestCase, tenemos disponibles de esta clase padre un montón de métodos assert***. Esto métodos son los que nos permiten comprobar que el resultado obtenido es igual al esperado. 

Uno de los métodos más usados es assertEquals(), que en general admite dos parámetros: El primero es el valor esperado y el segundo el valor que hemos obtenido. Así, por encima, la comprobación del resultado podría ser tan simple como esto:

```
import junit.framework.TestCase
public String sumar (String a, String b) {
String respuesta = "";
respuesta = (Double.parseDouble(a)+ Double.parseDouble(b))+"";
return respuesta;

}
public class TestSuma extends TestCase {
   Suma suma = new Suma();
   double resultado = suma.getSuma(1.0, 1.0);
   assertEquals(2.0, resultado);
}
```

Finalmente, indicar que hay muchos más métodos assert*** para otras cosas, como assertNotNull() que indica que el resultado esperado no debe ser null, assertTrue(), que indica que el resultado esperado debe ser true, etc. 
Estos, por supuesto, no necesitan que se introduzca por parámetro el resultado esperado, es decir, assertTrue() no necesita que le pasemos un parámetro con true.

```
assertTrue(resultado); // correcto
assertTrue(true, resultado); // innecesario.
```

A continuación veremos el código con Junit y version de pruebas:
```
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraJunitTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
```
Para crear este Junit le damos a click derecho en el java -> new -> junit testcase

A continuación algunas anotaciones de Junit que te pueden ser útiles:
```
@Before: Se ejecuta siempre antes de cada método del test. 

@After: El método se ejecutará después de cada método del test. 

@BeforeEach: Marca los métodos que se ejecutarán antes de cualquier método del test.

@AfterEach: Marca métodos que se ejecutarán en cualquier test.

@TestInstance: Se usa para configurar el ciclo de vida de las instancias de prueba para la clase de prueba anotada o la interfaz de prueba.

@BeforeAll: Marca el método que se ejecutará una única vez antes que cualquier método de prueba.

@AfterAll: Se utiliza para señalar que el método anotado debe ejecutarse después de todas las pruebas en la clase de prueba actual.
```
___
- Creamos la rama develop y fusionamos, en la cual añadimos las otras clases y el tag 1.1.0.
___

Primero creamos la rama develop con `git branch develop`, luego la fusionamos con `git merge develop` y por último la subimos con `git push origin develop`.

Ahora añadimos el código en nuestra carpeta y haremos un commit todo junto poniendo un tag v1.1.0 y lo subiremos a la rama develop.

Primero haremos un `git add .`, `git commit -m "Métodos"`, ahora lo subiremos con `git push origin develop`.

Ahora lo que haremos será crear el tag y ponerselo a ese commit priemro hay que saber el código así que lo que haremos será usar `git log --oneline` y cogeremos el código de nuestro commit una vez lo tengamos haremos el tag con `git tag -a v1.1.0 -m "Nombre que queramos" código`
 y ahora lo subimos con un `git push origin v1.1.0`.
 
 ![image](https://user-images.githubusercontent.com/101186662/168581232-4e8ad24d-82ed-4452-b6a4-6b470a6ec6d9.png)
 
___
- Pruebas de Código.
___
Debido a que el código lo teniamos creado de otro instituto, no tuvimos ningún problema con el código, éste siempre nos ha funcionado y todas las pruebas realizadas han dado resultados perfectos.

Es verdad que puede que nuestra calculadora pueda dar números enteros menos cuando realizamos las divisiones:

![image](https://user-images.githubusercontent.com/98842240/168569358-51a916ef-0907-4821-9c6b-628f5a4f457f.png)

![image](https://user-images.githubusercontent.com/98842240/168569421-562d0ac6-6e08-47f8-9870-47446396309e.png)

![image](https://user-images.githubusercontent.com/98842240/168569477-96587f20-06ff-428a-8bae-29291ddebcb0.png)

![image](https://user-images.githubusercontent.com/98842240/168569522-e8acbdb6-ee5f-41a0-89eb-066dfe24e1e1.png)

En la siguiente imagen podemos ver los problemas que da el código este quiere decir que de los items utilizados para crear la calculadora dan error 100 de estos.
(no se porque puede dar esto si funciona correctamente todo).

![image](https://user-images.githubusercontent.com/98842240/168567013-579e79a2-3437-417c-9396-40712df27529.png)

___
- Utilidades usadas en el proyecto.
___
Hemos usado el uso de Problemas, JavaDoc, las Declaraciones, la Consola y Git for Windows.

![image](https://user-images.githubusercontent.com/98842240/168569844-b8b72efb-a61c-4895-88c8-f8930216a881.png)

___
