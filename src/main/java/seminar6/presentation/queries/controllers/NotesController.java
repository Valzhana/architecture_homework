package seminar6.presentation.queries.controllers;

import seminar6.application.interfaces.NoteEditor;
import seminar6.domain.Note;

public class NotesController extends Controller {

    private final NoteEditor noteEditor;

    public NotesController(NoteEditor noteEditor) {
        this.noteEditor = noteEditor;
    }

    //TODO: \notes\all
    public void routeGetAll(){
        noteEditor.printAll();
    }
    public void routeAddNote(){
        this.noteEditor.printRecord();
    }

    public void routeRemoveNote(Note note){
        this.noteEditor.remove(note);
    }

}

