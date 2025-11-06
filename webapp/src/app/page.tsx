import { ShortcutEntry } from "@/lib/shortcuts/ShortcutEntry";
import { ShortcutManager } from "@/lib/shortcuts/ShortcutManager";

export default function Home() {
  const manager = new ShortcutManager();
  const sample = new ShortcutEntry({
    command: "!sc",
    keyword: "hello",
    expansionText: "Hello from ShortcutManager!",
  });
  manager.addShortcut(sample);

  const input = "hello!sc";
  const expansion = manager.findExpansion(input);

  return (
    <div className="flex min-h-screen items-center justify-center bg-zinc-50 font-sans dark:bg-black">
      <main className="flex min-h-screen w-full max-w-2xl flex-col items-start justify-center gap-6 py-16 px-8 bg-white dark:bg-black">
        <h1 className="text-3xl font-semibold tracking-tight text-black dark:text-zinc-50">
          Shortcut Demo
        </h1>
        <div className="rounded-lg border border-zinc-200 dark:border-zinc-800 p-4 w-full">
          <p className="text-zinc-700 dark:text-zinc-300">
            <span className="font-medium">Rule</span>: keyword "hello" + command "!sc"
          </p>
          <p className="text-zinc-700 dark:text-zinc-300">
            <span className="font-medium">Input</span>: {input}
          </p>
          <p className="text-zinc-700 dark:text-zinc-300">
            <span className="font-medium">Expansion</span>: {expansion ?? "No match"}
          </p>
        </div>
      </main>
    </div>
  );
}
