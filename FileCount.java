import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileCount {
    private File file;

    public FileCount(String path) {
        this.file = new File(path);
    }

    public FileCount(File file) {
        this.file = file;
    }

    public int countDigits() {
        return file.getName().length();
    }

    public int countWhiteMarks() {
        int count = 0;
        boolean space;
        boolean tab;
        boolean endLine;

        for(int i = 0; i < file.getName().length(); i++) {
            space = file.getName().substring(i, i+1).compareTo(" ") == 0;
            tab = file.getName().substring(i, i+1).compareTo("\t") == 0;
            endLine = file.getName().substring(i, i+1).compareTo("\n") == 0;
            if(space || tab || endLine)
                count++;
        }

        return count;
    }

    public int countWords() {
        if (file.getName().split(" ").length > 0)
            return file.getName().split(" ").length;
        else
            return 1;
    }

    public static void Search(String fileIn, String fileOut, String word) throws Exception {
        var fileReader = new FileReader(fileIn);
        var scanner = new Scanner(fileReader);
        var fileWriter = new FileWriter(fileOut, false);
        var list = new ArrayList<String>();

        while(scanner.hasNextLine())
            list.add(scanner.nextLine());
        fileReader.close();

        int minIndex = 0;
        int maxIndex = 0;
        int countDots = 0;
        int[] dotIndex;
        int n;
        int index = 0;
        for(int i = 0; i < list.toArray().length; i++) {
            if(list.get(i).toLowerCase().indexOf(word.toLowerCase()) >= 0) {
                for(int j = list.get(i).toLowerCase().indexOf(word.toLowerCase()) - 1; j >= 0; j--) {
                    if(list.get(i).substring(j, j+1).compareTo(".") == 0) {
                        if(list.get(i).substring(j+1, j+2).compareTo(" ") == 0)
                            minIndex = j + 2;
                        else
                            minIndex = j + 1;
                        break;
                    } else
                        minIndex = 0;
                }
                for(int j = list.get(i).toLowerCase().indexOf(word.toLowerCase()) + word.length(); j < list.get(i).length(); j++) {
                    if(list.get(i).substring(j, j+1).compareTo(".") == 0) {
                        maxIndex = j;
                        break;
                    } else
                        maxIndex = list.get(i).length() - 1;
                }

                for(int j = 0; j < list.get(i).length(); j++) {
                    if(list.get(i).substring(j, j+1).compareTo(".") == 0) {
                        countDots++;
                    }
                }
                dotIndex = new int[countDots];
                n = 0;
                for(int j = 0; j < list.get(i).length(); j++) {
                    if(list.get(i).substring(j, j+1).compareTo(".") == 0) {
                        dotIndex[n] = j;
                        n++;
                    }
                }
                for(int j = 0; j < dotIndex.length; j++) {
                    if(minIndex < dotIndex[j]) {
                        n = j + 1;
                        break;
                    } else
                        n = 1;
                }
                index += n;

                fileWriter.write((index) + ": " + list.get(i).substring(minIndex, maxIndex + 1));
                fileWriter.write(System.lineSeparator());

                countDots = 0;
            }
        }

        fileWriter.close();
    }
}
