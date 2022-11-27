package WorkingWithAbstractionLab3;

public class StudentSystem {
    private CommandHandler handler;
    private boolean isWorking;

    public StudentSystem() {
        this.handler = new CommandHandler();
    }

    public void start(){
        this.isWorking = true;
        while (isWorking) {
            String result = handler.handleCommand(Reader.readStringArray("\\s+"));

            if(result != null && !result.equals("Exit")){
                ConsolePrinter.printLine(result);
            }
            isWorking = !"Exit".equals(result);
        }
    }
}
