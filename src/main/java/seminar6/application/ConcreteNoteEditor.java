package seminar6.application;

import seminar6.application.interfaces.NoteEditor;
import seminar6.application.interfaces.NotesDatabaseContext;
import seminar6.application.interfaces.NotesPresenter;
import seminar6.domain.Note;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
    public void save(List<Note> notes) {
        List<String> lines = new ArrayList<>();

        for (Note note: notes) lines.add(presenter.toOutput(note));

        try (FileWriter writer = new FileWriter(connector.uri, false)) {
            for (String line: lines) writer.write(line + "\n");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void add() {

    }

    @Override
    public void remove() {

    }
}
