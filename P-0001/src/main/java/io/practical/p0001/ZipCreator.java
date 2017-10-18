package io.practical.p0001;

import static java.nio.file.Paths.get;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class ZipCreator {

	final String zipPath = "R:/_Work/Projects/JAVA-EXO/java-exo-1/Zipfolder";
	final String srcPath = "R:/_Work/Projects/JAVA-EXO/java-exo-1/SrcFileFolder";
	final String targetPath = "R:/_Work/Projects/JAVA-EXO/java-exo-1/TargetFolder";

	public void createZip(String zipName) {
		Map<String, String> env = new HashMap<>();
		env.put("create", "true");
		URI zipfileUri = URI.create("jar:file:/" + zipPath + "/" + zipName);
		try (FileSystem zipfs = FileSystems.newFileSystem(zipfileUri, env)) {
			try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(srcPath))) {
				for (Path path : directoryStream) {
					Files.copy(path, zipfs.getPath("/" + path.getFileName()), StandardCopyOption.REPLACE_EXISTING);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			Path tempDir = Files.createTempDirectory("tempPath");
			final Path root = zipfs.getPath("/");
			//walk the zip file tree and copy files to the destination    
			Files.walkFileTree(root, new SimpleFileVisitor<Path>(){
				@Override     
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException { 
					Path tempFile = Files.createTempFile(tempDir, file.getFileName().toString(), ".tmp");
					Files.copy(file, tempFile, StandardCopyOption.REPLACE_EXISTING); 
					return FileVisitResult.CONTINUE;     
					}       
				});
			Path targetDir = get(targetPath);
			try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(tempDir)) {
				for (Path path : directoryStream) {
					Files.copy(path, targetDir.resolve(path.getFileName()), StandardCopyOption.REPLACE_EXISTING);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}


}
