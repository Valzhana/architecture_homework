package seminar6.application;

import seminar6.application.interfaces.NoteEditor;
import seminar6.application.interfaces.NotesDatabaseContext;
import seminar6.application.interfaces.NotesPresenter;
import seminar6.domain.Note;

import java.util.Collection;
import java.util.Optional;

public class ConcreteNoteEditor implements NoteEditor {

    private final NotesDatabaseContext dbContext;
    private final NotesPresenter presenter;

    public ConcreteNoteEditor(
            NotesPresenter presenter,
            NotesDatabaseContext dbContext) {
        this.dbContext = dbContext;
        this.presenter = presenter;
    }

    @Override
    public boolean add(Note item) {
        dbContext.getAll().add(item);
        return dbContext.saveChanges();
    }

    @Override
    public boolean edit(Note item) {
        if (item == null)
            return false;
        Optional<Note> note = getById(item.getId());
        if (note.isEmpty())
            return false;
        note.get().setTitle(item.getTitle());
        note.get().setDetails(item.getDetails());
        return dbContext.saveChanges();
    }

    @Override
    public boolean remove(Note item) {
        dbContext.getAll().remove(item);
        return dbContext.saveChanges();
    }

    @Override
    public Optional<Note> getById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Collection<Note> getAll() {
        return dbContext.getAll();
    }

    @Override
    public void printAll() {
        presenter.printAll(getAll());
    }

    @Override
    public void printRecord() {
        presenter.printRecord();
    }
}
