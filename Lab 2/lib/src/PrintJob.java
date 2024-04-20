public class PrintJob{
    private TextFile textFile;
    private String fileType;

    public PrintJob(TextFile textFile, String fileType) {
        this.textFile = textFile;
        this.fileType = fileType;
    }

    public TextFile getContent() {
        return textFile;
    }

    public String getFileType() {
        return fileType;
    }
}