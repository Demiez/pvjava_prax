import java.awt.event.*;
import java.io.FileWriter;

public class Controller {
    private GUI UI;
    private FileActions fileActions;

    public Controller(GUI UI, FileActions fileActions) {
        //Доступ контролеру до UI та fileActins
        this.UI = UI;
        this.fileActions = fileActions;

        //Створимо слухачі подій та додамо їх до UI
        this.UI.addNewListener(new NewListener());
        this.UI.addOpenListener(new OpenListener());
        this.UI.addSaveListener(new SaveListener());
        this.UI.addSaveAsListener(new SaveAsListener());
        this.UI.addCopyListener(new CopyListener());
        this.UI.addCutListener(new CutListener());
        this.UI.addPasteListener(new PasteListener());
    }


    private class NewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            fileActions.newTextEditor();
        }
    }

    private class OpenListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String[] data = fileActions.open();

            if(data != null) {
                UI.setTitle(data[0] + " - РедакторТексту");
                UI.setTextArea(data[1]);
                UI.displayMessage(fileActions.getOpenMessage());
            }
            else {
                //Повідомлення про помилку
                UI.displayMessage(fileActions.getOpenErrorMessage());
            }
        }
    }

    private class SaveListener implements ActionListener {
        public void actionPerformed(ActionEvent arg) {

            //FileAction.save() екшен або null
            FileWriter saver = fileActions.save(UI.getText());
            try {

                //Запис тексту з UI до файлу
                UI.getEditorPane().write(saver);
                saver.close();


                UI.setTitle(fileActions.getFileName() + " - РедакторТексту");
                UI.displayMessage(fileActions.getSaveMessage());
            }
            catch (Exception ex) {
                // Нотифікація про помилку
                System.out.println(ex.getMessage());
                UI.displayMessage(fileActions.getSaveErrorMessage());
            }
        }
    }

    private class SaveAsListener implements ActionListener {
        public void actionPerformed(ActionEvent arg) {

            FileWriter saver = fileActions.saveAs(UI.getText());
            try {
                //Запис тексту із UI у файл
                UI.getEditorPane().write(saver);
                saver.close();

                UI.setTitle(fileActions.getFileName() + " - РедакторТексту");
                UI.displayMessage(fileActions.getSaveMessage());
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
                UI.displayMessage(fileActions.getSaveErrorMessage());
            }
        }
    }

    //Копі, паст, кат методи
    private class CopyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            UI.getEditorPane().copy();
        }
    }

    private class CutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            UI.getEditorPane().cut();
        }
    }

    private class PasteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            UI.getEditorPane().paste();
        }
    }

}