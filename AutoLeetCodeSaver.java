import java.io.*;
import java.util.Scanner;

public class AutoLeetCodeSaver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter LeetCode problem number (e.g., 267): ");
        String problemNumber = scanner.nextLine();

        System.out.print("Enter problem title (e.g., Palindrome Permutation II): ");
        String title = scanner.nextLine();

        System.out.println("Paste your Java solution (end with 'END' in a new line): ");
        StringBuilder codeBuilder = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) break;
            codeBuilder.append(line).append("\n");
        }

        String className = "LC" + problemNumber;
        String fileName = className + ".java";

        String code = codeBuilder.toString();
        if (!code.contains("class")) {
            code = "public class " + className + " {\n" + indent(code) + "\n}";
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("// " + className + " - " + title + "\n");
            writer.write(code);
            writer.close();
            System.out.println("Saved to: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            runCommand("git add \"" + fileName + "\"");
            runCommand("git commit -m \"Add " + className + " - " + title + "\"");
            runCommand("git push");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    static String indent(String code) {
        StringBuilder indented = new StringBuilder();
        for (String line : code.split("\n")) {
            indented.append("    ").append(line).append("\n");
        }
        return indented.toString();
    }

    static void runCommand(String command) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(command.split(" "));
        pb.inheritIO();
        pb.start().waitFor();
    }
}
