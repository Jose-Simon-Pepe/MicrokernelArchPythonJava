import jpype
import subprocess
import os
# with this, we can create multiples notes with the same content (new functionality)


print("this python process is running in "+str(os.getpid()))

# Primero compilamos el archivo java

#os.system("cd /home/jose/soft-projects/MicrokernellPluginCore/MicrokernellCore/")
#p = subprocess.Popen("javac /home/jose/soft-projects/MicrokernellPluginCore/MicrokernellCore/src/main/java/api/Api.java", stdout=subprocess.PIPE, shell=True)

#print(p.communicate())

# no se verifica éxito del proceso

# Iniciar una JVM
# wrappear todo el inicio de la jvm para la api en un metodo api.start()
# estándares: start and exit, abren conexión con la api, 
# desde api se importa funcion setup, la cual envia el plugin al dicionar#io de almacen en core, funcion setup toma ruta de plugin actual y nombre. El core recorre cada ruta y carga el plugin.
# puedo usar varios leng para implementar el api 
jpype.startJVM(jpype.getDefaultJVMPath(), "-ea",
               "-Djava.class.path=/home/jose/soft-projects/MicrokernellPluginCore/MicrokernellCore/src/main/java/")

#/home/jose/soft-projects/MicrokernellPluginCore/MicrokernellCore/src/main/java/api/Api.java

# Obtener una referencia a la clase java
MyJavaClass = jpype.JClass("home/jose/soft-projects/MicrokernellPluginCore/MicrokernellCore/out/artifacts/Api/Api") 
# interfaz que usa libreria api

# Crear una instancia de la clase java
api = MyJavaClass()

# llamar a un método de la clase java
result = api.createNote()

print(result)

# Detener la JVM
jpype.shutdownJVM()

# LA FORMA DE IMPLEMENTAR INTERFACE ES USAR @JImplements(JavaInterface)
# el plugin se hace usando lo deseable y connsumiendo api
# por que me limito a un lenguaje en microkernel => 
# ir de a poco con lo que tengo ahora, e ir implementando de a poquito nuevas soluciones como un uevo lenguaje de pro
