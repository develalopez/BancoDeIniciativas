

# BancoDeIniciativas
Banco de iniciativas de la Oficina de Proyectos de la ECI

## Visión del producto

La **Plataforma banco de iniciativas de proyectos**, es una herramienta donde la comunidad universitaria de la Escuela Colombiana de Ingeniería Julio Garavito pueden registrar sus iniciativas e ideas de proyectos para ser desarrollados o gestionados por la PMO de la Escuela. El sistema, más allá de facilitar el registro de las iniciativas e ideas de proyectos, es una valiosa base de conocimiento donde los diferentes actores pueden revisar si hay iniciativas, ideas o intereses similares y aunar esfuerzos para la materialización. Adicional a lo anterior, el personal académico puede integrar a los estudiantes de diferentes asignaturas o proyectos de grado para su realización, materializando las iniciativas para el beneficio de toda la comunidad universitaria. La PMO puede priorizar las iniciativas viables, asignar responsables, gestionar la asignación de recursos, llevar métricas e identificar grupos de interés -a través del tiempo- que se van presentando para cada iniciativa. Con esto se espera lograr no solo la realización de los proyectos sino una aplicación práctica de los conocimientos adquiridos por los estudiantes dentro de las asignaturas de la Escuela generando un ambiente de aprendizaje colaborativo.

### Detales provistos por el _Stakeholder_

El objetivo del sistema es permitir el registro y seguimiento de las iniciativas e ideas de proyectos que han sido propuestas por la comunidad universitaria de la Escuela. El banco de iniciativas debe contar con una interfaz de usuario bonita y amigable con los usuarios.

#### Tipos de usuario

* Administrador
* Personal PMO - ODI
* Proponente de iniciativa o idea de proyecto
* Usuarios de consulta

#### Permisos

##### Administrador

* Modificar el Estado de las ideas o iniciativas.
* Agrupamiento de las ideas o iniciativas equivalentes o relacionadas

##### Personal PMO - ODI

* Consultar las iniciativas o ideas de proyectos que los proponentes han publicado.
* Cambiar el estado de las iniciativas

##### Proponente:

* Registrar de una iniciativa o idea: Importante guardar la referencia a los datos del usuario para poder ser contactados, incluyendo su área o dependencia.
* Consultar las ideas o iniciativas que el proponente ha realizado
* Modificar una iniciativa o idea siempre y cuando se encuentre en el estado “propuesta”.

##### Público

* Consultar la información de las diferentes ideas o iniciativas 
* Poder mostrar su interés o afinidad con el desarrollo de una idea o iniciativa de proyecto que se encuentre en el banco y dejar comentarios u observaciones al mismo. 
* Votar (dar like) sobre una idea o iniciativa.
* Indicar la intención de trabajar o apoyar el desarrollo de la iniciativa o idea de proyecto, es decir, que le interesa
* Consultar las ideas o iniciativas de acuerdo a palabras clave
* Entregar estadísticas con base en la información registrada.

# Reglas para push de cambios

Todos los cambios deben ser pusheados a ramas con el nombre de usuario del autor. Se hace un Pull Request después de haber pasado la prueba del CircleCI, de lo contrario no se hara merge de master (la rama principal). Los Pull Request sólo pueden tener un commit asociado a ellos.

# Manual de Git

## Configuración inicial

Para que los commits tengan la firma del usuario que los realizó, es necesario configurar dos campos del archivo global de configuración de Git, esto se hace con los siguientes comandos:

    git config --global user.name "Full name"
    git config --global user.email email@domain.com

Personalmente les recomiendo cambiar el editor de texto de Git tenga asignado, en especial si es Vim, porque puede llegar a ser complejo de manejar. Si desean cambiarlo a Visual Studio Code -como es mi caso- usen el siguiente comando:

    git config --global core.editor "code --wait"

Para cambiar el editor a Nano:

	 git config --global core.editor "nano"

Finalmente, para que el Git Bash no solicite sus credenciales cada vez que quieran pushear los cambios al repositorio remoto, usen el siguiente comando:

    git config --global credential.helper wincred

## Confirmación de cambios

Los archivos en Git manejan dos estados diferentes: untracked y staged. Los archivos en etapa untracked son archivos cambiados a los que no se les hará commit, por el  contrario, los archivos en etapa staged están preparados y se incluirán en el siguiente commit que se realize.

Para verificar el estado de un archivo se usa el comando `git status`, los archivos que aparezcan en rojo están en etapa untracked y los que aparezcan en verde están en etapa staged.

* Para pasar todos los archivos de untracked a staged se usa `git add .`
* Para pasar un archivo especifico se usa `git add <file-name>`
* Para hacer commit se usa `git commit -m "message"`
* Para sobreescribir un commit ya creado con nuevos cambios, y/o cambiar el mensaje del commit, con el fin de mantener los cambios en un solo commit para el Pull Request, se usa `git commit --amend`, en el que se abrirá su editor de texto, para cambiar el mensaje de commit o dejarlo como está, añadiendo más cambios.

## Manejo del repositorio remoto

### Actualizar de manera local

Para clonar este repositorio de manera local:
	`git clone https://github.com/develalopez/BancoDeIniciativas.git`
	
Para actualizar el repositorio desde su rama:
	`git pull --rebase origin master`

Se recomienda ejecutar este comando cada vez que se vaya a trabajar en algo nuevo.

### Enviar cambios al repositorio remoto

Debido a las reglas de control de calidad, es necesario que cada uno use una rama que indique en su nombre que es de su autoría, para esto se usan los siguientes comandos de control de ramas:

* Para crear una rama: `git checkout -b <branch-name>`
* Para transportarse entre ramas existentes: `git checkout <branch-name>`
* Para actualizar la rama con respecto a la rama principal se ejecuta (desde su rama) `git pull --rebase origin master`, este comando toma el trabajo realizado por ustedes, lo guarda, actualiza los cambios de la rama master y coloca su trabajo encima de este.
* Si tienen trabajo realizado en su rama que no han mandado al repositorio remoto, se usa `git checkout -t origin/<branch-name>`, esto permite que se reciba todo el trabajo al que le hayan hecho commit y pusheado a su rama.

Todos los comandos de confirmación de cambios se realizan desde su rama, y para enviarlos al repostorio remoto se usan los siguientes comandos:
* Si es un commit al que no se le ha hecho push: `git push origin <branch-name>`
* Si es un commit al que se le hizo una modificación (`amend`) y al que ya se le hizo push: 
	`git push origin +<branch-name>`
	El simbolo `+` al inicio del nombre de la rama fuerza a empujar los cambios y sobreescribir las referencias.
