package seminar6.application.interfaces;

import seminar6.domain.Note;

import java.util.List;

public interface NoteEditor extends Editor<Note, Integer>{

    void printAll();

    void save(List<Note> notes);
    void add();
    void remove();
}
