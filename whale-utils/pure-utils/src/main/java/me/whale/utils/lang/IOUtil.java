package me.whale.utils.lang;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class IOUtil {

//    public static Stream<Path> listFiles(Path path) throws IOException {
//        return Files.walk(path).filter(Files::isRegularFile);
//    }

    public static Stream<Path> listFiles(Path path) throws IOException {
        return Files.find(path, Integer.MAX_VALUE, ((filePath, fileAttributes) -> fileAttributes.isRegularFile()));
    }

    public static Stream<Path> listFiles(Path path, Predicate<Path> predicate) throws IOException {
        return listFiles(path).filter(predicate);
    }

    public static String getNameWithoutExtension(String fileName) {
        Objects.requireNonNull(fileName);
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
    }

    public static String getFileExtension(String fileName) {
        Objects.requireNonNull(fileName);
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    public static void zipFile(Path zipPath, Path sourcePath) throws IOException {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipPath))) {
            Files.walk(sourcePath)
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        ZipEntry zipEntry = new ZipEntry(sourcePath.relativize(path).toString());
                        try {
                            zipOutputStream.putNextEntry(zipEntry);
                            Files.copy(path, zipOutputStream);
                            zipOutputStream.closeEntry();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}
