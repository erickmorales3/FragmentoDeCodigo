def leerContenidoArchivo():
 
    archivo = open('archivo.txt', 'r')
 
    contenido = archivo.read()
    print contenido


def leerArchivoPorLinea():
 
    archivo = open('archivo.txt', 'r')
 
    for linea in archivo.readlines():
        print linea


print "== Leyendo todo el contenido del archivo =="
leerContenidoArchivo()

print "\n\n== Leyendo el contenido linea por linea == "
leerArchivoPorLinea()
