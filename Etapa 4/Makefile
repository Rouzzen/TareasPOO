JAVA_FILES := $(wildcard *.java)
CLASS_FILES := $(patsubst %.java,%.class,$(JAVA_FILES))
CONFIG_FILE := config.csv

# Regla predeterminada: compilar todos los archivos .java
all: $(CLASS_FILES)

# Regla para compilar los archivos .java en archivos .class
%.class: %.java
	javac $<

# Regla para ejecutar el programa Main con el archivo config.csv
run: all
	java Main $(CONFIG_FILE)

# Regla para limpiar los archivos .class generados
clean:
	rm -f $(CLASS_FILES)

# Regla phony para evitar conflictos con archivos llamados 'clean' u 'all'
.PHONY: all run clean
