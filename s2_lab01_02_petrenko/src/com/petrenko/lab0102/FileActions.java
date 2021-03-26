import javax.swing.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class FileActions {

    private JFileChooser fileChooser;

    private String fileName;
    private String filePath;
    private Date date;
    private DateFormat dateFormat;

    public FileActions() {
        fileChooser = new JFileChooser();

        //Дата та формат дати використовуються для повідомлень статусу
        date = new Date();
        dateFormat = new SimpleDateFormat("HH:mm:ss");
    }

    //Creates a new text editor
    //Gives new controller a new UI and a new fileActions class
    public void newTextEditor() {
        GUI UI = new GUI();
        FileActions fileActions = new FileActions();
        new Controller(UI, fileActions);
    }


    public String[] open() {
        String fileData[] = new String[2];

        //showOpenDialog повертає int коли юзер клікає зберегти
        //showSaveDialog створює файл експлорер, щоб обрати файл, який відкриваємо
        int option = fileChooser.showOpenDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {

            try {
                File file = fileChooser.getSelectedFile();
                filePath = file.getAbsolutePath();

                //Створення екземпляру Сканер
                Scanner scan = new Scanner(file);

                //Додаємо кожен рядок в масив
                ArrayList<String> fileTextList = new ArrayList<>();
                while (scan.hasNextLine()) {
                    fileTextList.add(scan.nextLine() + "\n");
                }

                fileData[0] = file.getName();
                fileData[1] = String.join("", fileTextList); //Комбінуємо всі fileTextList в масив

                fileName = fileData[0];
            }

            //Ловимо ексепшени
            catch (Exception ex) {
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return fileData;
    }

    public FileWriter save(String text) {

        //Перевірка, чи був файл збережений
        if (fileName != null) {
            try {

                //IСтворення та повертання екземпляру FileWriter з нинішнім файлом
                FileWriter saver = new FileWriter(filePath);
                return saver;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        //якщо нал - треба зберегти
        return saveAs(text);
    }


    public FileWriter saveAs(String text) { //В якості параметру - текст, що зберігаємо

        int option = fileChooser.showSaveDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                
                this.filePath = fileChooser.getSelectedFile().getAbsolutePath();
                this.fileName = fileChooser.getSelectedFile().getName();

                return save(text);
            }
            catch (Exception ex) {
                System.out.println("1");
            }
        }
        return null;
    }

    public String getFileName() {
        return fileName;
    }

    public String getSaveMessage() {
        return this.getFileName() + " збережено " + dateFormat.format(date) + ".";
    }

    public String getSaveErrorMessage() {
        return this.getFileName() + " не збережено " + dateFormat.format(date) + ".";
    }

    public String getOpenMessage() {
        return this.getFileName() + " відкрито " + dateFormat.format(date) + ".";
    }

    public String getOpenErrorMessage() {
        return this.getFileName() + " не відкрито " + dateFormat.format(date) + ".";
    }

}


