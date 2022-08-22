# Inicio_con_adroidStudio

Crear un Activity
```
 * Clic secundario sobre la carpeta "app" 
 * New 
 * Activity 
 * Empty Activity
 * Luego ingresar el "Activity Name"
 * Clic en "finish"
    
    (Con esto se agrega el .java, .xlm y se agrega en el "AndroidManifest.xml")
    
```
LoginExtraActivity.java
```
(Archivo agregado en el commit "Extra - Práctica 2. A hecho implementando interfaz (ver README.md)")

El código de este archivo hace lo mismo que el del LoginActivity.java, pero la diferncia 
es que en este (LoginExtraActivity.java) lo hago como implementación de la interfaz 
View.OnClickListener, de esta manera no hay que repetir la función onclick por cada botón
```

Refactoring del uso de botones de todo hasta la Práctica 2. B
```
[commit "Refactoring del uso de botones hasta la Práctica 2. B de la master (ver README.md)"]

En este refactoring dejo los botones funcionando con el atributo onClic de los 
botones en el .xml, de esta forma: 
* En el .xml, en cada botón, agrego una linea para el atributo onClic, pero puedo 
  sacar la línea del id ya que no se necesita
* En el .java el código se reduce y no se tienen que repetir funciones (onClic, por ejemplo)
  funciones por cada botón
* Por lo dicho ya no es necesario tener como alternativa lo hecho en el "LoginExtraActivity.java"  
```