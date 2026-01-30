package entities;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class Summary {
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    private File inputFilePath;
    private File outputFilePath;
    private Product product

    public Summary(File inputFilePath) throws IOException {
        super();
        this.inputFilePath = inputFilePath;
        String subdirectoryPath = inputFilePath.getParent() + "\\out";
        boolean success = new File(subdirectoryPath).mkdir();
        if(!success) throw new IIOException("The subdirectory \"out\" could not be created");
        outputFilePath = new File(subdirectoryPath + "\\summary.csv");
    }

    public File getInputFilePath() {
        return inputFilePath;
    }

    public File getOutputFilePath() {
        return outputFilePath;
    }

    public String generate() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath));
        List<String> result = bufferedReader
                .lines()
                .map(line -> {
                    String[] strs = line.split(",");

                })

        return outputFilePath.toString();
    }
}
