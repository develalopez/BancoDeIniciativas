

# BancoDeIniciativas
Banco de iniciativas de la Oficina de Proyectos de la ECI

## Reglas para push de cambios

Todos los cambios deben ser pusheados a ramas con el nombre de usuario del autor. Se hace un Pull Request después de haber pasado la prueba del CircleCI, de lo contrario no se hara merge de master (la rama principal). Los Pull Request sólo pueden tener un commit asociado a ellos.

# Manual de Git

## Configuración inicial

Para que los commits tengan la firma del usuario que los realizó, es necesario configurar dos campos del archivo global de configuración de Git, esto se hace con los siguientes comandos:

    git config --global user.name "Full name"
    git config --global user.email email@domain.com

Personalmente les recomiendo cambiar el editor de texto de Git tenga asignado, en especial si es Vim, porque puede llegar a ser complejo de manejar. Si desean cambiarlo a Visual Studio Code -como es mi caso- usen el siguiente comando:

    git config --global core.editor "code --wait"

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

Para clonar este repositorio de manera local:
	`git clone https://github.com/develalopez/BancoDeIniciativas.git`

Debido a las reglas de control de calidad, es necesario que cada uno use una rama que indique en su nombre que es de su autoría, para esto se usan los siguientes comandos de control de ramas:

* Para crear una rama: `git checkout -b <branch-name>`
* Para transportarse entre ramas existentes: `git checkout <branch-name>`
* Para actualizar la rama con respecto a la rama principal se ejecuta (desde su rama) `git pull --rebase origin master`, este comando toma el trabajo realizado por ustedes, lo guarda, actualiza los cambios de la rama master y coloca su trabajo encima de este.

Todos los comandos de confirmación de cambios se realizan desde su rama, y para enviarlos al repostorio remoto se usan los siguientes comandos:
* Si es un commit al que no se le ha hecho push: `git push origin <branch-name>`
* Si es un commit al que se le hizo una modificación (`amend`) y al que ya se le hizo push: 
	`git push origin +<branch-name>`
	El simbolo `+` al inicio del nombre de la rama fuerza a empujar los cambios y sobreescribir las referencias.
