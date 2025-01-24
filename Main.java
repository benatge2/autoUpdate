import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        restartApplication();
        /*try {
            // Ruta al script .bat dentro del repositorio
            String scriptPath = "..\\actualizar_repositorio.bat";
            
            // Crear el proceso usando ProcessBuilder
            ProcessBuilder processBuilder = new ProcessBuilder(scriptPath);
            processBuilder.redirectErrorStream(true);

            // Iniciar el proceso
            Process process = processBuilder.start();

            // Leer la salida del script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar a que el proceso termine y obtener el código de salida
            int exitCode = process.waitFor();
            System.out.println("Código de salida: " + exitCode);

            // Verificar el código de salida para reiniciar la aplicación si se realizó un git pull
            if (exitCode == 0) {
                System.out.println("El repositorio está al día.");
            } else if (exitCode == 1) {
                System.out.println("El repositorio se actualizó. Reiniciando la aplicación...");
                // Reiniciar la aplicación ejecutando la clase Main nuevamente
                restartApplication();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    private static void restartApplication() {
        try {
            // Ejecutar la clase Main nuevamente
            ProcessBuilder processBuilder = new ProcessBuilder("java", "Main");
            processBuilder.directory(new java.io.File(".\\"));
            processBuilder.start();
            System.exit(0); // Cerrar la aplicación actual
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
