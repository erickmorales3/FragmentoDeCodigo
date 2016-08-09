def leerContenidoArchivo(){

	def archivo = new File("archivo.txt")
	println archivo.text

	//Especificando la codificación de caracteres
	println archivo.getText("UTF-8")

}


def leerArchivoPorLinea(){
 
    def archivo = new File("archivo.txt")
	archivo.eachLine { linea ->
		println linea
	}

}


println "== Leyendo todo el contenido del archivo =="
leerContenidoArchivo()

println "\n\n== Leyendo el contenido linea por linea == "
leerArchivoPorLinea()
