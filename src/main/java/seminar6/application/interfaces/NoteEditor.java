package seminar6.application.interfaces;

import seminar6.domain.Note;
public interface NoteEditor extends Editor<Note, Integer>{

    boolean add(Note item);

    void printAll();
    void printRecord();

}
