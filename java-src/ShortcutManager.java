import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class ShortcutManager {
    private final List<ShortcutEntry> entries = new ArrayList<>();

    public List<ShortcutEntry> getAll() {
        return new ArrayList<>(entries);
    }

    public void addShortcut(ShortcutEntry entry) {
        // Replace if same id exists, else add
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getId().equals(entry.getId())) {
                entries.set(i, entry);
                return;
            }
        }
        entries.add(entry);
    }

    public void updateShortcut(ShortcutEntry entry) {
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getId().equals(entry.getId())) {
                entries.set(i, entry);
                return;
            }
        }
    }

    public void deleteShortcut(UUID id) {
        Iterator<ShortcutEntry> it = entries.iterator();
        while (it.hasNext()) {
            ShortcutEntry e = it.next();
            if (e.getId().equals(id)) {
                it.remove();
                return;
            }
        }
    }

    public String findExpansion(String textToMatch) {
        if (textToMatch == null) return null;
        for (ShortcutEntry entry : entries) {
            String command = entry.getCommand();
            if (command == null || command.isEmpty()) continue;
            if (textToMatch.endsWith(command)) {
                String prefix = textToMatch.substring(0, textToMatch.length() - command.length());
                if (prefix.equals(entry.getKeyword())) {
                    return entry.getExpansionText();
                }
            }
        }
        return null;
    }
}
