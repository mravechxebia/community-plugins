package ext.deployit.community.importer.composite;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xebialabs.deployit.server.api.importer.ImportSource;

public class FileSource implements ImportSource {

	private final String location;
	private final boolean tempFile;

	public FileSource(String location, boolean tempFile) {
		this.location = location;
		this.tempFile = tempFile;
	}

	public FileSource(File archive, boolean tempFile) {
		this.location = archive.getPath();
		this.tempFile = tempFile;
	}

	public String getLocation() {
		return location;
	}

	public boolean isTempFile() {
		return tempFile;
	}

	@Override
	public File getFile() {
		return new File(location);
	}

	@SuppressWarnings("deprecation")
    @Override	
	public void cleanUp() {
		if (isTempFile()) {
			getFile().delete();
		}
	}

	@Override
	public String toString() {
		return "FileSource[" + location + "," + tempFile + "]";
	}

	private static final Logger logger = LoggerFactory.getLogger(FileSource.class);
}