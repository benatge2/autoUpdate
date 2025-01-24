@echo off
REM Cambia al directorio del repositorio
cd /d "%~dp0"

REM Fetch para obtener la información más reciente del servidor
git fetch

REM Obtener los hash de commits locales y remotos
for /f %%i in ('git rev-parse @') do set LOCAL=%%i
for /f %%i in ('git rev-parse @{u}') do set REMOTE=%%i
for /f %%i in ('git merge-base @ @{u}') do set BASE=%%i

REM Comparar los commits y realizar la acción apropiada
if "%LOCAL%"=="%REMOTE%" (
    echo El repositorio está al día.
    exit /b 0
) else if "%LOCAL%"=="%BASE%" (
    echo El repositorio local está desactualizado. Haciendo git pull...
    git pull
    exit /b 1
) else if "%REMOTE%"=="%BASE%" (
    echo El repositorio local tiene commits no subidos.
    exit /b 2
) else (
    echo El repositorio tiene divergencias.
    exit /b 3
)
