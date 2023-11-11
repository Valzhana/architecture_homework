package seminar6;

import seminar6.application.ConcreteNoteEditor;
import seminar6.application.interfaces.NoteEditor;
import seminar6.application.interfaces.NotesDatabaseContext;
import seminar6.database.NotesDatabase;
import seminar6.infrastructure.persistance.Database;
import seminar6.infrastructure.persistance.DatabaseContext;
import seminar6.presentation.queries.controllers.NotesController;
import seminar6.presentation.queries.views.NotesConsolePresenter;

public class Program {

    /**
     * CQRS
     * @param args
     */
    public static void main(String[] args) {
        Database database = new NotesDatabase();
        NotesDatabaseContext context = new DatabaseContext(database);
        NotesConsolePresenter notesConsolePresenter = new NotesConsolePresenter();
        NoteEditor noteEditor = new ConcreteNoteEditor(notesConsolePresenter, context);

        NotesController notesController = new NotesController(noteEditor);

        notesController.routeGetAll();
        notesController.routeAddNote();
    }

}
