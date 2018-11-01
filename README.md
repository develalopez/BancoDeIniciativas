
# BancoDeIniciativas
Banco de iniciativas de la Oficina de Proyectos de la ECI

## Reglas para push de cambios

Todos los cambios deben ser pusheados a branches con el nombre de usuario del autor. Se hace la solicitud de pull request después de haber pasado la prueba del CircleCI, de lo contrario no se hara merge de la rama a master (la rama principal). Los pull request sólo pueden tener un commit.

## Manejo de ramas

Para clonar un repositorio: `git clone <url>`

Para crear una rama se usa el siguiente comando: `git checkout -b <branch-name>`

Si la rama ya está creada se usa: `git checkout <branch-name>`

Para actualizar la rama con respecto a la rama principal se ejecuta el siguiente comando desde su rama: `git pull --rebase origin master`

Para actualizar el último commit realizado por ustedes en vez de crear uno nuevo: `git commit --amend`
