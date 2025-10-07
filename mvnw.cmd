@echo off
setlocal

rem --- Maven Wrapper for Windows (simple, sin ^) ---

set "MVNW_BASEDIR=%~dp0"
for %%i in ("%MVNW_BASEDIR:.=.%") do set "MVNW_BASEDIR=%%~fi"

set "WRAPPER_JAR=%MVNW_BASEDIR%.mvn\wrapper\maven-wrapper.jar"
set "WRAPPER_PROPERTIES=%MVNW_BASEDIR%.mvn\wrapper\maven-wrapper.properties"
set "WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain"

if not exist "%WRAPPER_JAR%" (
  echo [ERROR] Wrapper JAR not found: %WRAPPER_JAR%
  exit /b 1
)

if "%JAVA_HOME%"=="" (set "JAVACMD=java") else (set "JAVACMD=%JAVA_HOME%\bin\java.exe")

"%JAVACMD%" -version >NUL 2>&1
if errorlevel 1 (
  echo [ERROR] Java no encontrado. Configura JDK 17 (JAVA_HOME) o agrega Java al PATH.
  exit /b 1
)

set "MAVEN_PROJECTBASEDIR=%MVNW_BASEDIR%"

"%JAVACMD%" -Dmaven.multiModuleProjectDirectory="%MAVEN_PROJECTBASEDIR%" -cp "%WRAPPER_JAR%" %WRAPPER_LAUNCHER% %*

endlocal
