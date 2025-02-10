package design_pattern.structural;

class DecoratorPattern {

    public static void main(String[] args) {
        System.out.println("Decorator Pattern");
        FileManager fileManager = new FileManagerBase();
        fileManager.write("Hello World");
        System.out.println(fileManager.read());

        System.out.println("Encrypted File Decorator");
        fileManager = new EncryptedFileDecorator(fileManager);
        fileManager.write("Hello World");
        System.out.println(fileManager.read());

        System.out.println("Compressed File Decorator");
        fileManager = new CompressedFileDecorator(fileManager);
        fileManager.write("Hello World");
        System.out.println(fileManager.read());

    } 
}

interface FileManager {
    public void write(String data);
    public String read();
}


class FileManagerBase implements FileManager {
    public void write(String data) {
        System.out.println("Writing data to file: "+data);
    }
    public String read() {
        return "Reading data from file";
    }
}

abstract class FileDecorator implements FileManager {
    protected FileManager fileManager;
    public FileDecorator(FileManager fileManager) {
        this.fileManager = fileManager;
    }
    abstract public void write(String data);
    abstract public String read();
}

class EncryptedFileDecorator extends FileDecorator {
    public EncryptedFileDecorator(FileManager fileManager) {
        super(fileManager);
    }
    public void write(String data) {
        System.out.println("Encrypting data before writing to file: "+data);
        fileManager.write(data);
    }
    public String read() {
        return "Decrypting data after reading from file: "+fileManager.read();
    }
}

class CompressedFileDecorator extends FileDecorator {
    public CompressedFileDecorator(FileManager fileManager) {
        super(fileManager);
    }
    public void write(String data) {
        System.out.println("Compressing data before writing to file: "+data);
        fileManager.write(data);
    }
    public String read() {
        return "Decompressing data after reading from file: "+fileManager.read();
    }
}