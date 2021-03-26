import javax.swing.JEditorPane;
import javax.swing.undo.*;


public class UndoRedo {
    private UndoManager undoManager;

    public UndoRedo() {
        undoManager = new UndoManager();
    }

    public void setDocument(JEditorPane editorPane) {
        editorPane.getDocument().addUndoableEditListener(undoManager);
    }

    public void undo() {
        if(undoManager.canUndo()) {
            undoManager.undo();
        }
    }

    public void redo() {
        if (undoManager.canRedo()) {
            undoManager.redo();
        }
    }

}
